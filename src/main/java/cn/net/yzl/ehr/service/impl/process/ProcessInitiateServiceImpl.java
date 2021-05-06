package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.ProcessInitiateFeignService;
import cn.net.yzl.ehr.service.process.ProcessInitiateService;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
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
    public ComResponse<ProcessApproveNode> insertProcessStaffOut(StaffOutVo staffOutVo, String staffNo) {
        staffOutVo.setCreator(staffNo);
        staffOutVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessStaffOut(staffOutVo);
    }

    @Override
    public ComResponse<ProcessApproveNode> insertProcessStaffTravel(StaffTravelVo staffTravelVo,String staffNo) {
        staffTravelVo.setCreator(staffNo);
        staffTravelVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessStaffTravel(staffTravelVo);
    }

    @Override
    public ComResponse<ProcessApproveNode> insertProcessStaffAttendApproval(StaffAttendApprovalVo staffAttendApprovalVo,String staffNo) {
        staffAttendApprovalVo.setCreator(staffNo);
        staffAttendApprovalVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessStaffAttendApproval(staffAttendApprovalVo);
    }

    @Override
    public ComResponse<ProcessApproveNode> insertProcessStaffAttendAbnormalApproval(StaffAttendAbnormalApprovalVo staffAttendAbnormalApprovalVo, String staffNo) {
        staffAttendAbnormalApprovalVo.setCreator(staffNo);
        staffAttendAbnormalApprovalVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessStaffAttendAbnormalApproval(staffAttendAbnormalApprovalVo);
    }

    @Override
    public ComResponse<ProcessApproveNode> insertProcessStaffParkingSpace(StaffParkingSpaceVo staffParkingSpaceVo, String staffNo) {
        staffParkingSpaceVo.setCreator(staffNo);
        staffParkingSpaceVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessStaffParkingSpace(staffParkingSpaceVo);
    }

    @Override
    public ComResponse<Boolean> selectProcessStaffParkingSpace() {
        return processInitiateFeignService.selectProcessStaffParkingSpace();
    }

    @Override
    public ComResponse<ProcessApproveNode> insertProcessStaffItemRequisition(StaffItemRequisitionVo staffItemRequisitionVo, String staffNo) {
        staffItemRequisitionVo.setCreator(staffNo);
        staffItemRequisitionVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessStaffItemRequisition(staffItemRequisitionVo);
    }

    @Override
    public ComResponse<ProcessApproveNode> insertProcessAttendExchange(StaffAttendExchangeVo staffAttendExchangeVo, String staffNo) {
        staffAttendExchangeVo.setCreator(staffNo);
        staffAttendExchangeVo.setStaffNo(staffNo);
        return processInitiateFeignService.insertProcessAttendExchange(staffAttendExchangeVo);
    }

    @Override
    public ComResponse<Integer> countProcessStaffAttendApproval(String staffNo) {
        return processInitiateFeignService.countProcessStaffAttendApproval(staffNo);
    }
}
