package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.StaffAttendApprovalVo;
import cn.net.yzl.staff.vo.process.StaffOutVo;
import cn.net.yzl.staff.vo.process.StaffTravelVo;

public interface ProcessInitiateService {
    //外出添加
    ComResponse<Integer> insertProcessStaffOut(StaffOutVo staffOutVo,String staffNo);

    //出差添加
    ComResponse<Integer> insertProcessStaffTravel(StaffTravelVo staffTravelVo,String staffNo);

    //出差考勤补卡
    ComResponse<Integer> insertProcessStaffAttendApproval(StaffAttendApprovalVo staffAttendApprovalVo,String staffNo);

}
