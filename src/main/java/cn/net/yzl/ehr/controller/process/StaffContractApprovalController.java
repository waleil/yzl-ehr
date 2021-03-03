package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.StaffContractApprovalFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.vo.process.StaffContractApprovalVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ComResponse<Integer> insertStaffContractApproval(@RequestBody StaffContractApprovalVo staffContractApprovalVo){

        ComResponse<Integer> integerComResponse = staffContractApprovalFeignService.insertStaffContractApproval(staffContractApprovalVo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffContractApprovalVo.getStaffNo());
                MessageRemandAPI.processSendMessage(staffContractApprovalVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }
}
