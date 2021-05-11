package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffAttendAbnormalApprovalVo;
import cn.net.yzl.staff.vo.process.StaffAttendApprovalVo;
import cn.net.yzl.staff.vo.process.StaffAttendExchangeVo;
import cn.net.yzl.staff.vo.process.StaffItemRequisitionVo;
import cn.net.yzl.staff.vo.process.StaffOutVo;
import cn.net.yzl.staff.vo.process.StaffParkingSpaceVo;
import cn.net.yzl.staff.vo.process.StaffTravelVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 流程发起-出勤休假
 */

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/process")
public interface ProcessInitiateFeignService {

    @PostMapping("/out/insert")
    ComResponse<ProcessApproveNode> insertProcessStaffOut(@RequestBody @Validated StaffOutVo staffOutVo);

    @PostMapping("/travel/insert")
    ComResponse<ProcessApproveNode> insertProcessStaffTravel(@RequestBody @Validated StaffTravelVo staffTravelVo);

    @PostMapping("/attend/approval/insert")
    ComResponse<ProcessApproveNode> insertProcessStaffAttendApproval(@RequestBody @Validated StaffAttendApprovalVo staffAttendApprovalVo);

    @PostMapping("/abnormal/attend/approval/insert")
    ComResponse<ProcessApproveNode> insertProcessStaffAttendAbnormalApproval(@RequestBody @Validated StaffAttendAbnormalApprovalVo staffAttendAbnormalApprovalVo);

    @PostMapping("/parking/space/insert")
    ComResponse<ProcessApproveNode> insertProcessStaffParkingSpace(@RequestBody @Validated StaffParkingSpaceVo staffParkingSpaceVo);

    @GetMapping("/parking/space/select")
    ComResponse<Boolean> selectProcessStaffParkingSpace();

    @PostMapping("/item/requisition/insert")
    ComResponse<ProcessApproveNode> insertProcessStaffItemRequisition(@RequestBody @Validated StaffItemRequisitionVo staffItemRequisitionVo);

    @PostMapping("/attend/exchange/insert")
    ComResponse<ProcessApproveNode> insertProcessAttendExchange(@RequestBody @Validated StaffAttendExchangeVo staffAttendExchangeVo);

    @GetMapping(value = "/attend/approval/count")
    ComResponse<Integer> countProcessStaffAttendApproval(@RequestParam("staffNo") String staffNo);

}
