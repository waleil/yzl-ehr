package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.process.StaffContractApprovalFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffContractApprovalVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/26 22:20
 */
@RestController
@RequestMapping("staffContractApproval")
@Api(value = "财务审批-合同",tags = "财务审批-合同")
public class StaffContractApprovalController {

    @Autowired
    private StaffContractApprovalFeignService staffContractApprovalFeignService;

    @ApiOperation(value = "保存合同流程数据",notes = "保存合同流程数据")
    @PostMapping("v1/insertStaffContractApproval")
    public ComResponse<ProcessApproveNode> insertStaffContractApproval(@RequestBody StaffContractApprovalVo staffContractApprovalVo, @CurrentStaffNo @ApiIgnore String staffNo){

        ComResponse<ProcessApproveNode> flag = staffContractApprovalFeignService.insertStaffContractApproval(staffContractApprovalVo);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo,
                        flag.getData().getStaffNo(),
                        flag.getData().getProcessName());
                MessageRemandAPI.processSendMessage(flag.getData().getProcessId(),
                        staffNo,
                        flag.getData().getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
