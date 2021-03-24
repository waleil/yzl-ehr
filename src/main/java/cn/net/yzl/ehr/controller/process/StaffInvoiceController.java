package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.process.StaffInvoiceFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffInvoiceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "审批流程-开票审批", tags = "审批流程-开票审批")
@RequestMapping("staffInvoice")
public class StaffInvoiceController {

    @Autowired
    private StaffInvoiceFeignService staffInvoiceFeignService;

    @ApiOperation(value = "保存开票流程数据",notes = "保存开票流程数据")
    @PostMapping("v1/insertStaffInvoice")
    public ComResponse<Integer> insertStaffInvoice(@RequestBody StaffInvoiceVo staffInvoiceVo, @CurrentStaffNo @ApiIgnore String staffNo) {
        ComResponse<ProcessApproveNode> flag = staffInvoiceFeignService.insertStaffInvoice(staffInvoiceVo);
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
        return ComResponse.success();
    }


}