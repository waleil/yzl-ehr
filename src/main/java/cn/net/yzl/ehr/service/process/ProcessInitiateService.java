package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.*;

public interface ProcessInitiateService {
    //外出添加
    ComResponse<Integer> insertProcessStaffOut(StaffOutVo staffOutVo,String staffNo);

    //出差添加
    ComResponse<Integer> insertProcessStaffTravel(StaffTravelVo staffTravelVo,String staffNo);

    //考勤补卡
    ComResponse<Integer> insertProcessStaffAttendApproval(StaffAttendApprovalVo staffAttendApprovalVo,String staffNo);

    //车位申请添加
    ComResponse<Integer> insertProcessStaffParkingSpace(StaffParkingSpaceVo staffParkingSpaceVo, String staffNo);

    //查询车位申请通道信息
    ComResponse<Boolean> selectProcessStaffParkingSpace();

    //物品领用添加
    ComResponse<Integer> insertProcessStaffItemRequisition(StaffItemRequisitionVo staffItemRequisitionVo, String staffNo);

    //物品加班兑换
    ComResponse<Integer> insertProcessAttendExchange(StaffAttendExchangeVo staffAttendExchangeVo, String staffNo);

}
