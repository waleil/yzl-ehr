package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.process.ProcessReimbursementFeignService;

import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffReimbursementVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 财务审批-报销
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/23 18:45
 */

@RestController
@RequestMapping("processReimbursement")
@Api(value = "财务审批-报销",tags = "财务审批-报销")
public class ProcessReimbursementController {


    @Autowired
    private ProcessReimbursementFeignService processReimbursementFeignService;

    @ApiOperation(value = "保存报销流程",notes = "保存报销流程")
    @PostMapping("v1/insertProcessReimbursement")
    public ComResponse<Integer> insertProcessReimbursement(@RequestBody StaffReimbursementVo staffReimbursementVo, @CurrentStaffNo @ApiIgnore String staffNo){

        ComResponse<ProcessApproveNode> flag = processReimbursementFeignService.insertProcessReimbursement(staffReimbursementVo);
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


//    @ApiOperation(value = "查询报销流程数据",notes = "查询报销流程数据")
//    @PostMapping("v1/selectProcessReimbursement")
//    public ComResponse<StaffReimbursementDto> selectProcessReimbursement(@RequestParam("appNo") String appNo){
//        StaffReimbursementDto staffReimbursementDto = processReimbursementService.selectProcessReimbursement(appNo);
//        return ComResponse.success(staffReimbursementDto);
//    };




}
