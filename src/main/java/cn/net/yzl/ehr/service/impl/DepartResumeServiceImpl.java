package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.departResume.DepartResumeFeignService;
import cn.net.yzl.ehr.dto.DepartResumeItemDto;
import cn.net.yzl.ehr.pojo.DepartResumeInsertListPo;
import cn.net.yzl.ehr.service.DepartResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartResumeServiceImpl implements DepartResumeService {
    @Autowired
    private DepartResumeFeignService departResumeFeginService;


    @Override
    public ComResponse<String> add(DepartResumeInsertListPo departResumePo) {
        ComResponse<Integer> addResult = departResumeFeginService.add(departResumePo);
        if(addResult==null){
        return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(addResult.getCode()!=200 ){
        return ComResponse.fail(addResult.getCode(),addResult.getMessage());
        }
        return  ComResponse.success();
    }

    @Override
    public ComResponse<Integer> saveUpdate(DepartResumeInsertListPo itemUpdatePo) {
        ComResponse<Integer> addResult = departResumeFeginService.saveUpdate(itemUpdatePo);
        if(addResult==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(addResult.getCode()!=200 ){
            return ComResponse.fail(addResult.getCode(),addResult.getMessage());
        }
        return  ComResponse.success();
    }

    @Override
    public ComResponse<Page<DepartResumeItemDto>> getByDepartId(Integer departId, Integer pageNo, Integer pageSize) {
        ComResponse<Page<DepartResumeItemDto>> byDepartId = departResumeFeginService.getByDepartId(departId, pageNo, pageSize);
        if(byDepartId==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(byDepartId.getCode()!=200 ){
            return ComResponse.fail(byDepartId.getCode(),byDepartId.getMessage());
        }else if(byDepartId.getCode()==200 &&  byDepartId.getData()==null ){
            return ComResponse.nodata();
        }
      //  Page<DepartResumeItemDto> departResumeDtoPage = AssemblerResultUtil.resultAssembler(byDepartId.);
        return  byDepartId;
    }

    @Override
    public ComResponse<DepartResumeDto> getByPostId(Integer departId, Integer postId) {
        ComResponse<DepartResumeDto> byPostId = departResumeFeginService.getByPostId(departId, postId);
        if(byPostId==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(byPostId.getCode()!=200 ){
            return ComResponse.fail(byPostId.getCode(),byPostId.getMessage());
        }else if(byPostId.getCode()==200 && byPostId.getData()==null){
            return ComResponse.nodata();
        }
        return  byPostId;
    }

    @Override
    public ComResponse<DepartResumeDto> getByResumeId(Integer resumeId) {
        ComResponse<DepartResumeDto> byPostId = departResumeFeginService.getByResumeId(resumeId);
        if(byPostId==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(byPostId.getCode()!=200 ){
            return ComResponse.fail(byPostId.getCode(),byPostId.getMessage());
        }else if(byPostId.getCode()==200 && byPostId.getData()==null){
            return ComResponse.nodata();
        }
        return  byPostId;
    }

    @Override
    public ComResponse<Integer> deleteByResumeId(Integer resumeId, String updator) {
        ComResponse<Integer> integerComResponse = departResumeFeginService.deleteByResumeId(resumeId, updator);
        if(integerComResponse==null || integerComResponse.getData()==null ){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(integerComResponse.getCode()!=200 ){
            return ComResponse.fail(integerComResponse.getCode(),integerComResponse.getMessage());
        }else if(integerComResponse.getCode()==200 && integerComResponse.getData()==0){
            return ComResponse.nodata();
        }
        return  ComResponse.success();
    }
}
