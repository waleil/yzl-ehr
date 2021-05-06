package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 流程发起-出勤休假
 *
 */

@Repository
@FeignClient(value = "ProcessInitiateFeign",url = "${fegin.db.url}/process")
//@RefreshScope
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
    ComResponse<Integer> countProcessStaffAttendApproval (@RequestParam("staffNo") String staffNo);

}
