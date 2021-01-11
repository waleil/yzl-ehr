package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.fegin.staff.StaffEduFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFamilyFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffEduService;
import cn.net.yzl.ehr.service.StaffFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffEduServiceImpl implements StaffEduService {

    @Autowired
    private StaffEduFeginService  staffEduFeginService;


    @Override
    public ComResponse<List<StaffEduListDto>> findByStaffNo(String staffNO) {
        ComResponse<List<StaffEduListDto>>  result = staffEduFeginService.findByStaffNo(staffNO);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData().size()<1){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator){
        ComResponse<Integer> result =  staffEduFeginService.deleteById(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }



    @Override
    public ComResponse<Integer> add(List<StaffEduInsertPo> staff) {
        ComResponse<Integer> result =  staffEduFeginService.insert(staff);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()>0){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> update(StaffEduUpdatePo eduPo) {
        ComResponse<Integer> result =  staffEduFeginService.update(eduPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> saveUpDate(StaffEduItemPo staffEduItemPo) {
        ComResponse<Integer> result =  staffEduFeginService.saveUpDate(staffEduItemPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

}
