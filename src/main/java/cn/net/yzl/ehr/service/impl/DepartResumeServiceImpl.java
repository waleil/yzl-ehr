package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.PostBaseDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.fegin.conf.DepartResumeFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.service.DepartResumeService;
import cn.net.yzl.ehr.vo.DepartResumeUpdateVO;
import cn.net.yzl.ehr.vo.DepartResumeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public ComResponse< Map<PostBaseDto, List<DepartResumeDto>>> getByDepartId(Integer departId) {
        ComResponse<List<DepartResumeDto>>  result =  departResumeFeginService.getByDepartId(departId);
        List<DepartResumeDto> list = result.getData();
        if(list==null || list.size()<1){
            return ComResponse.nodata();
        }

        Map<Integer, List<DepartResumeDto>> collect = list.stream().collect(Collectors.groupingBy(DepartResumeDto::getPostId));

        Map<PostBaseDto, List<DepartResumeDto>> data = new HashMap<>();

        collect.keySet().forEach(key ->{
            PostBaseDto postBaseDto = new PostBaseDto();
            postBaseDto.setId(key);
            postBaseDto.setName(collect.get(key).get(0).getPostName());
            data.put(postBaseDto,collect.get(key));
        });


        return ComResponse.success(data);
    }

    @Override
    public ComResponse<Integer> add(DepartResumeVO departResumeVO) {
        Integer departId = departResumeVO.getDepartId();
        // 部门判断
        ComResponse<DepartDto> departById = departFeginService.getById(departId);
        if(departById.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }

        //岗位判断

        ComResponse<Integer> result = departResumeFeginService.add(departResumeVO);
        if(result.getData()==null || result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getMessage());
        }

        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> update(DepartResumeUpdateVO departResumeUpdateVO) {
        return null;
    }
}
