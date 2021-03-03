package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 流程发起-出勤休假
 *
 */

@Repository
@FeignClient(value = "ProcessInitiateFeign",url = "${fegin.db.url}/process")
//@RefreshScope
public interface ProcessInitiateFeignService {

    @PostMapping("/out/insert")
    ComResponse<Integer> insertProcessStaffOut(@RequestBody @Validated StaffOutVo staffOutVo);

    @PostMapping("/travel/insert")
    ComResponse<Integer> insertProcessStaffTravel(@RequestBody @Validated StaffTravelVo staffTravelVo);

    @PostMapping("/attend/approval/insert")
    ComResponse<Integer> insertProcessStaffAttendApproval(@RequestBody @Validated StaffAttendApprovalVo staffAttendApprovalVo);

    @PostMapping("/parking/space/insert")
    public ComResponse<Integer> insertProcessStaffParkingSpace(@RequestBody @Validated StaffParkingSpaceVo staffParkingSpaceVo);

    @PostMapping("/item/requisition/insert")
    public ComResponse<Integer> insertProcessStaffItemRequisition(@RequestBody @Validated StaffItemRequisitionVo staffItemRequisitionVo);

    @PostMapping("/attend/exchange/insert")
    ComResponse<Integer> insertProcessAttendExchange(@RequestBody @Validated StaffAttendExchangeVo staffAttendExchangeVo);

}
