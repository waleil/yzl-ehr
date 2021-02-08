package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.fegin.conf.DepartTrainingRuleFeginService;
import cn.net.yzl.ehr.service.DepartTrainingRuleService;
import cn.net.yzl.ehr.vo.DepartTrainingRulePo;
import cn.net.yzl.ehr.vo.DepartTrainingRuleUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartTrainingRuleServiceImpl implements DepartTrainingRuleService {

    @Autowired
    private DepartTrainingRuleFeginService departTrainingRuleService;


    @Override
    public ComResponse<Integer> add(DepartTrainingRulePo departTrainingRulePo) {

        ComResponse<Integer> result=departTrainingRuleService.add(departTrainingRulePo);
        if(result==null ){
         return    ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200 ){
         return   result;
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<List<DepartTrainingRuleDto>> getByDepartId(Integer departId) {
        ComResponse<List<DepartTrainingRuleDto>> result=departTrainingRuleService.getByDepartId(departId);
        if(result==null ){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getData()==null || result.getData().size()<1){
            ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> update(DepartTrainingRuleUpdatePo itemUpdatePo) {
        ComResponse<Integer> result=departTrainingRuleService.update(itemUpdatePo);
        if(result==null ){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200 ){
            ComResponse.fail(result.getCode(),result.getMessage());
        }else if(result.getCode()==200 && result.getData()==0){
            ComResponse.fail(ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getCode(),ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<DepartTrainingRuleDto> getById(Integer postId) {
        ComResponse<DepartTrainingRuleDto> result=departTrainingRuleService.getById(postId);
        if(result==null ){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getData()==null ){
            ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result=departTrainingRuleService.deleteById(id,updator);
        if(result==null ){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getData()==null ){
            ComResponse.fail(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getMessage());
        }else if(result.getData()==0){
            ComResponse.fail(ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getCode(),ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getMessage());
        }
        return ComResponse.success();
    }
}
