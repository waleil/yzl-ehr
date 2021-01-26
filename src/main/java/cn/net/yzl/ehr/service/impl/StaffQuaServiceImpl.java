package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.dto.StaffQuaListDto;
import cn.net.yzl.ehr.fegin.staff.StaffQuaFeginService;
import cn.net.yzl.ehr.pojo.StaffQuaInsertPo;
import cn.net.yzl.ehr.pojo.StaffQuaItemPo;
import cn.net.yzl.ehr.pojo.StaffQuaUpdatePo;
import cn.net.yzl.ehr.service.StaffQuaService;
import cn.net.yzl.staff.dto.StaffQuaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffQuaServiceImpl  implements StaffQuaService {

    @Autowired
    private StaffQuaFeginService staffQuaFeginService;


    @Override
    public ComResponse<StaffQuaDto> findByStaffNo(String staffNO) {
        ComResponse<StaffQuaDto> result = staffQuaFeginService.findByStaffNo(staffNO);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result =  staffQuaFeginService.deleteById(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> insert(StaffQuaInsertPo insertPo) {
        ComResponse<Integer> result =  staffQuaFeginService.insert(insertPo);
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
    public ComResponse<Integer> updateQua(StaffQuaUpdatePo updatePo) {
        ComResponse<Integer> result =  staffQuaFeginService.updateQua(updatePo);
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
    public ComResponse<Integer> saveUpDate(StaffQuaItemPo itemPo) {
        ComResponse<Integer> result =  staffQuaFeginService.saveUpDate(itemPo);
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
