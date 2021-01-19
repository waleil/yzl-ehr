package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffService;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {


    @Autowired
    private StaffFeginService staffFeginService;

    @Override
    public ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo) {
        return staffFeginService.getDetailsByNo(staffNo);
    }

    @Override
    public ComResponse<List<StaffBaseDto>> getByParams(String params) {
        return staffFeginService.getByParams(params);
    }

    @Override
    public ComResponse<Page<StaffListDto>> getListByParams(StaffParamsVO staffParamsVO) {
        return staffFeginService.getListByParams(staffParamsVO);
    }

    @Override
    public ComResponse<Integer> swtichStaffTalentPoolAccount(StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,String staffNo) {
        staffSwitchTalentPoolPo.setUpdator(staffNo);
        return staffFeginService.swtichStaffTalentPoolAccount(staffSwitchTalentPoolPo);
    }

    @Override
    public ComResponse<Integer> switchAccount(StaffSwitchStatePo staffSwitchStatePo,String staffNo) {
        staffSwitchStatePo.setUpdator(staffNo);
        return staffFeginService.switchAccount(staffSwitchStatePo);
    }

    @Override
    public ComResponse<String> resetPassword(String userNo, String creator) {
        return staffFeginService.resetPassword(userNo,creator);
    }

    @Override
    public ComResponse<StaffDto> find(String staffNO) {
        ComResponse<StaffDto>  result = staffFeginService.findByStaffNo(staffNO);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData() == null){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result =  staffFeginService.deleteById(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> insert(List<StaffInsertPo> insertPos) {
        ComResponse<Integer> result =  staffFeginService.insert(insertPos);
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
    public ComResponse<Integer> update(StaffUpdatePo updatePo) {
        ComResponse<Integer> result =  staffFeginService.update(updatePo);
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
    public ComResponse<Integer> saveUpDate(StaffItemPo staffItemPo) {
        ComResponse<Integer> result =  staffFeginService.saveUpDate(staffItemPo);
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
