package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.conf.DepartResumeFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import cn.net.yzl.ehr.service.DepartResumeService;
import cn.net.yzl.ehr.util.ValidList;
import cn.net.yzl.ehr.vo.DepartResumeInfoVO;
import cn.net.yzl.ehr.vo.DepartResumeInsertPo;
import cn.net.yzl.ehr.vo.DepartResumeItemPo;
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
        return result;
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
        ValidList<DepartResumeInsertPo> list = new ValidList<>();
        departResumeInfoVO.getDepartResumeList().forEach(departResumeVO -> {
            DepartResumeInsertPo departResumePo = new DepartResumeInsertPo();
            departResumePo.setDepartId(departResumeInfoVO.getDepartId());
            departResumePo.setPostId(departResumeVO.getPostId());
            departResumePo.setCreator(staffNo);
            departResumePo.setSortNo(departResumeVO.getSortNo());
            departResumePo.setLeaderNo(departResumeVO.getLeaderNo());
            departResumePo.setStepName(departResumeVO.getStepName());
            list.add(departResumePo);
        });

        ComResponse<Integer> result = departResumeFeginService.add(list);
        if(result==null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return ComResponse.success();

    }



    @Override
    public ComResponse<String> update(DepartResumeItemPo departResumeItemPo, String staffNo) {
        Integer departId = departResumeItemPo.getDepartId();
        Integer postId = departResumeItemPo.getPostId();
        // 部门判断
        departResumeItemPo.getInsertList().forEach(x->{
            x.setCreator(staffNo);
        });
        departResumeItemPo.getDeleteList().forEach(x->{
            x.setUpdator(staffNo);
        });
        departResumeItemPo.getUpdateList().forEach(x->{
            x.setUpdator(staffNo);
        });
        ComResponse<DepartDto> departById = departFeginService.getById(departId);
        if(departById.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }
        ComResponse<Integer> result=departResumeFeginService.update(departResumeItemPo);
        if(result == null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getData()==null || result.getData()<1){
            return ComResponse.nodata();
        }

        //岗位判断
        return ComResponse.success();
    }


    public ComResponse<String> deleteByPostId(Integer postId,String updator) {
        ComResponse<Integer> result = departResumeFeginService.deleteByPostId(postId,updator);
        if (result == null || result.getData() == null || result.getData()<1) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }
}
