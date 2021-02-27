package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.StaffContractApprovalVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/26 22:20
 */
@FeignClient(value = "staffContractApproval",url = "${fegin.db.url}/staffContractApproval")
public interface StaffContractApprovalFeignService {


    @PostMapping("v1/insertStaffContractApproval")
    ComResponse<Integer> insertStaffContractApproval(@RequestBody StaffContractApprovalVo staffContractApprovalVo);
}
