package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffLoanVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/26 22:25
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/staffLoan")
public interface StaffLoanFeignService {


    @PostMapping("v1/insertStaffLoan")
    public ComResponse<ProcessApproveNode> insertStaffLoan(@RequestBody StaffLoanVo staffLoanVo);
}
