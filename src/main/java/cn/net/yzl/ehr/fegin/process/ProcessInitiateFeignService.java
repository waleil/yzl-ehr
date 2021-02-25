package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.StaffAttendApprovalVo;
import cn.net.yzl.staff.vo.process.StaffOutVo;
import cn.net.yzl.staff.vo.process.StaffTravelVo;
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
@FeignClient(value = "staff",url = "${fegin.db.url}/process")
@RefreshScope
public interface ProcessInitiateFeignService {

    @PostMapping("out/insert")
    ComResponse<Integer> insertProcessStaffOut(@RequestBody @Validated StaffOutVo staffOutVo);

    @PostMapping("travel/insert")
    ComResponse<Integer> insertProcessStaffTravel(@RequestBody @Validated StaffTravelVo staffTravelVo);

    @PostMapping("attend/approval/insert")
    ComResponse<Integer> insertProcessStaffAttendApproval(@RequestBody @Validated StaffAttendApprovalVo staffAttendApprovalVo);

}
