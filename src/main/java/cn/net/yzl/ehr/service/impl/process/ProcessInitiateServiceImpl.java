package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.ProcessInitiateFeignService;
import cn.net.yzl.ehr.service.process.ProcessInitiateService;
import cn.net.yzl.staff.vo.process.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessInitiateServiceImpl implements ProcessInitiateService {

    private static final Logger logger = LoggerFactory.getLogger(ProcessInitiateServiceImpl.class);

    @Autowired
    private ProcessInitiateFeignService processInitiateFeignService;


    @Override
    public ComResponse<Integer> insertProcessStaffOut(StaffOutVo staffOutVo,String staffNo) {
        staffOutVo.setCreator(staffNo);
        return processInitiateFeignService.insertProcessStaffOut(staffOutVo);
    }

    @Override
    public ComResponse<Integer> insertProcessStaffTravel(StaffTravelVo staffTravelVo,String staffNo) {
        staffTravelVo.setCreator(staffNo);
        return processInitiateFeignService.insertProcessStaffTravel(staffTravelVo);
    }

    @Override
    public ComResponse<Integer> insertProcessStaffAttendApproval(StaffAttendApprovalVo staffAttendApprovalVo,String staffNo) {
        staffAttendApprovalVo.setCreator(staffNo);
        return processInitiateFeignService.insertProcessStaffAttendApproval(staffAttendApprovalVo);
    }
}