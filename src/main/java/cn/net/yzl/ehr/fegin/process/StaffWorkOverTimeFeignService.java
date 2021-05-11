package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.process.StaffWorkOvertimeDto;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/3/25 20:54
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/workOverTime")
public interface StaffWorkOverTimeFeignService {


    @PostMapping("v1/insertStaffWorkOverTime")
    ComResponse<ProcessApproveNode> insertStaffWorkOverTime(@RequestBody StaffWorkOvertimeDto staffWorkOvertimeDto);

}
