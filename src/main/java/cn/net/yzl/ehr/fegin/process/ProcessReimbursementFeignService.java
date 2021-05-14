package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffReimbursementVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 财务审批-报销
 *
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/23 18:45
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/processReimbursement")
public interface ProcessReimbursementFeignService {


    @ApiOperation(value = "保存报销流程", notes = "保存报销流程")
    @PostMapping("v1/insertProcessReimbursement")
    public ComResponse<ProcessApproveNode> insertProcessReimbursement(@RequestBody StaffReimbursementVo staffReimbursementVo);


}
