package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.conf.DepartResumeFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.pojo.DepartResumeItemPo;
import cn.net.yzl.ehr.pojo.DepartResumePo;
import cn.net.yzl.ehr.service.DepartResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DepartResumeServiceImpl implements DepartResumeService {
    @Autowired
    private DepartResumeFeginService departResumeFeginService;
    @Autowired
    private DepartFeginService departFeginService;

    @Override
    public ComResponse<List<DepartResumeDto>> getByDepartId(Integer departId) {
        ComResponse<List<DepartResumeDto>>  result =  departResumeFeginService.getByDepartId(departId);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if( result.getCode()==200 && result.getData().size()<1){
            return ComResponse.nodata();
        }
        return result;
    }



    @Override
    public ComResponse<DepartResumeDto> getByPostId(Integer departId,Integer postId) {
        ComResponse<DepartResumeDto>  result =  departResumeFeginService.getByPostId(departId,postId);
        if(result==null ){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if( result.getCode()==200 && result.getData()==null){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<DepartResumeDto> getByResumeId(Integer resumeId) {
        ComResponse<DepartResumeDto>  result =  departResumeFeginService.getByResumeId(resumeId);
        if(result==null ){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if( result.getCode()==200 && result.getData()==null){
            return ComResponse.nodata();
        }
        return result;
    }


    @Override
    public ComResponse<String> add(DepartResumePo departResumePo,String staffNo) {
        Integer departId = departResumePo.getDepartId();
        Integer postId = departResumePo.getPostId();
        departResumePo.setCreator(staffNo);
        // 部门判断
        ComResponse<DepartDto> departById = departFeginService.getById(departId);
        if(departById==null ){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if( departById.getCode()!=200 || departById.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }
        //岗位判断 待增加
        ComResponse<DepartResumeDto> resumeResult= departResumeFeginService.getByPostId(departId,postId);
        if(resumeResult==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if( departById.getCode()!=200 || departById.getData()==null ){
            return ComResponse.fail(ResponseCodeEnums.RESUME_EXIST_ERROR_CODE.getCode(),ResponseCodeEnums.RESUME_EXIST_ERROR_CODE.getMessage());
        }

        ComResponse<Integer> result = departResumeFeginService.add(departResumePo);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }else if(result.getData()==0){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }
        return ComResponse.success();

    }



    @Override
    public ComResponse<String> update(DepartResumeItemPo departResumeItemPo, String staffNo) {
        departResumeItemPo.setUpdator(staffNo);
        // 部门判断
        ComResponse<DepartResumeDto> byResumeId = departResumeFeginService.getByResumeId(departResumeItemPo.getResumeId());
        if(byResumeId==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (byResumeId.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getCode(),ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getMessage());
        }
        //岗位判断

        ComResponse<Integer> departById = departResumeFeginService.update(departResumeItemPo);
        if(departById.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }
        if(departById == null || departById.getData()==null ){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(departById.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getCode(),ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getMessage());
        }


        return ComResponse.success();
    }

    public ComResponse<String> deleteByResumeId(Integer resumeId,String updator) {
        ComResponse<Integer> result = departResumeFeginService.deleteByResumeId(resumeId,updator);
        if (result == null ) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }else if(  result.getCode()==200 && result.getData()<1 ){
            return ComResponse.fail(ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }
}
