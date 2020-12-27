package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.service.StaffService;
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
    public ComResponse<List<StaffDetailsDto>> getByParams(String params) {
        return staffFeginService.getByParams(params);
    }

}
