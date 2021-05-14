package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffContractApprovalVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/26 22:20
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/staffContractApproval")
public interface StaffContractApprovalFeignService {


    @PostMapping("v1/insertStaffContractApproval")
    ComResponse<ProcessApproveNode> insertStaffContractApproval(@RequestBody StaffContractApprovalVo staffContractApprovalVo);
}
