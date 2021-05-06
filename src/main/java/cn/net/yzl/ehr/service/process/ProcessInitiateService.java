package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.*;

public interface ProcessInitiateService {
    //外出添加
    ComResponse<ProcessApproveNode> insertProcessStaffOut(StaffOutVo staffOutVo, String staffNo);

    //出差添加
    ComResponse<ProcessApproveNode> insertProcessStaffTravel(StaffTravelVo staffTravelVo,String staffNo);

    //考勤补卡
    ComResponse<ProcessApproveNode> insertProcessStaffAttendApproval(StaffAttendApprovalVo staffAttendApprovalVo,String staffNo);

    //迟到早退考勤补卡
    ComResponse<ProcessApproveNode> insertProcessStaffAttendAbnormalApproval(StaffAttendAbnormalApprovalVo staffAttendAbnormalApprovalVo,String staffNo);

    //车位申请添加
    ComResponse<ProcessApproveNode> insertProcessStaffParkingSpace(StaffParkingSpaceVo staffParkingSpaceVo, String staffNo);

    //查询车位申请通道信息
    ComResponse<Boolean> selectProcessStaffParkingSpace();

    //物品领用添加
    ComResponse<ProcessApproveNode> insertProcessStaffItemRequisition(StaffItemRequisitionVo staffItemRequisitionVo, String staffNo);

    //物品加班兑换
    ComResponse<ProcessApproveNode> insertProcessAttendExchange(StaffAttendExchangeVo staffAttendExchangeVo, String staffNo);

    //查询员工申请的补卡次数
    ComResponse<Integer> countProcessStaffAttendApproval(String staffNo);

}
