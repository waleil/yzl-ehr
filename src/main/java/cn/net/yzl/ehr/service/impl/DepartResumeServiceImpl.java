package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.conf.DepartResumeFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import cn.net.yzl.ehr.service.DepartResumeService;
import cn.net.yzl.ehr.vo.DepartResumeInfoVO;
import cn.net.yzl.ehr.vo.DepartResumeUpdateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartResumeServiceImpl implements DepartResumeService {
    @Autowired
    private DepartResumeFeginService departResumeFeginService;
    @Autowired
    private DepartFeginService departFeginService;

    @Override
    public ComResponse<List<DepartResumeInfoDto>> getByDepartId(Integer departId) {
        ComResponse<List<DepartResumeDto>>  result =  departResumeFeginService.getByDepartId(departId);
        List<DepartResumeDto> list = result.getData();
        if(list==null || list.size()<1){
            return ComResponse.nodata();
        }
        Map<Integer, List<DepartResumeDto>> collect = list.stream().collect(Collectors.groupingBy(DepartResumeDto::getPostId));
        List<DepartResumeInfoDto> resultList = new ArrayList<>();
        collect.keySet().forEach(key ->{
            DepartResumeInfoDto departResumeInfoDto = new DepartResumeInfoDto();
            departResumeInfoDto.setId(key);
            departResumeInfoDto.setName(collect.get(key).get(0).getPostName());
            departResumeInfoDto.setDepartResumeList(collect.get(key));
            resultList.add(departResumeInfoDto);
        });
        return ComResponse.success(resultList);
    }

    @Override
    public ComResponse<List<DepartResumeDto>> getByPostId(Integer postId) {
        ComResponse<List<DepartResumeDto>>  result =  departResumeFeginService.getByPostId(postId);
        if(result==null ){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }



    @Override
    public ComResponse<String> add(DepartResumeInfoVO departResumeInfoVO,String staffNo) {
        Integer departId = departResumeInfoVO.getDepartId();
        Integer postId = departResumeInfoVO.getPostId();
        // 部门判断
        ComResponse<DepartDto> departById = departFeginService.getById(departId);
        if(departById.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }

        //岗位判断
        List<DepartResumePo> list = new ArrayList<>();
        departResumeInfoVO.getDepartResumeList().forEach(departResumeVO -> {
            DepartResumePo departResumePo = new DepartResumePo();
            departResumePo.setDepartId(departId);
            departResumePo.setPostId(postId);
            departResumePo.setCreator(staffNo);
            departResumePo.setLeaderNo(departResumeVO.getLeaderNo());
            departResumePo.setStepName(departResumeVO.getStepName());
            list.add(departResumePo);
        });
        String s = JsonUtil.toJsonStr(list);
        ComResponse<Integer> result = departResumeFeginService.add(s);
        if(result.getData()==null || result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getMessage());
        }

        return ComResponse.success();
    }



    @Override
    public ComResponse<String> update(DepartResumeInfoVO departResumeInfoVO,String staffNo) {
        Integer departId = departResumeInfoVO.getDepartId();
        Integer postId = departResumeInfoVO.getPostId();
        // 部门判断
        ComResponse<DepartDto> departById = departFeginService.getById(departId);
        if(departById.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }
        ComResponse<Integer> result=departResumeFeginService.deleteByPostId(postId);
        if(result == null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        List<DepartResumePo> list = new ArrayList<>();
        departResumeInfoVO.getDepartResumeList().forEach(departResumeVO -> {
            DepartResumePo departResumePo = new DepartResumePo();
            departResumePo.setDepartId(departId);
            departResumePo.setPostId(postId);
            departResumePo.setCreator(staffNo);
            departResumePo.setLeaderNo(departResumeVO.getLeaderNo());
            departResumePo.setStepName(departResumeVO.getStepName());
            list.add(departResumePo);
        });
        String s = JsonUtil.toJsonStr(list);
        result = departResumeFeginService.add(s);
        if(result == null || result.getData()==null || result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }
        //岗位判断
        return ComResponse.success();
    }
}
