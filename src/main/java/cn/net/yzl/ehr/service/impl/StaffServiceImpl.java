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
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result =  staffFeginService.deleteById(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }






}
