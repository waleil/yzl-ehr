package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.processActiveService.saveProcessService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.ProcessProfession.ProcessStaffDimissionDTO;
import cn.net.yzl.staff.dto.ProcessProfession.ProcessStaffPositiveDTO;
import cn.net.yzl.staff.dto.ProcessProfession.ProcessStaffTransferDTO;
import cn.net.yzl.staff.dto.personApprove.*;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.exception.BaseParamsException;
import cn.net.yzl.staff.vo.process.ProcessStaffDimissionVo;
import cn.net.yzl.staff.vo.process.ProcessStaffPositiveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/processsInvite")
@Api(tags = "招聘流程")
public class ProcessBeginController {

    @Autowired
    private saveProcessService saveProcessService;

    @PostMapping("v1/saveProcessInviteInfo")
    @ApiOperation(value = "保存招聘信息")
    public ComResponse<ProcessApproveNode> saveProcessLeaveInfo(@RequestBody @Valid ApproveInviteDTO approveInviteDTO, @CurrentStaffNo @NotNull String staffNo) {
        approveInviteDTO.getProcessStaffInviteDTO().setStaffNo(staffNo);
        ComResponse<ProcessApproveNode> flag = saveProcessService.saveProcessInviteInfo(approveInviteDTO);
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
    @ApiOperation(value = "保存转正申请",notes = "转正申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/savePositiveApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> savePositiveApplay (@RequestBody @Validated ProcessStaffPositiveDTO processStaffPositiveDTO, @CurrentStaffNo @NotNull String staffNo){
        ComResponse<ProcessApproveNode> flag = saveProcessService.savePositiveApplay(processStaffPositiveDTO);
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
    @ApiOperation(value = "保存离职申请",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveDimissionApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveDimissionApplay (@RequestBody @Validated ProcessStaffDimissionDTO processStaffDimissionDTO, @CurrentStaffNo @NotNull String staffNo){
        ComResponse<ProcessApproveNode> flag = saveProcessService.saveDimissionApplay(processStaffDimissionDTO);
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

     @ApiOperation(value = "保存旷工申请",notes = "旷工申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveAbsentApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveAbsentApplay (@RequestBody @Validated ProcessAbsentDTO processAbsentDTO, @CurrentStaffNo @NotNull String staffNo){
         processAbsentDTO.setStaffNo(staffNo);
        ComResponse<ProcessApproveNode> flag = saveProcessService.saveAbsentApplay(processAbsentDTO);
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
    @ApiOperation(value = "检查当前日期是否超过结算日期",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/checkAccountDay", method = RequestMethod.GET)
    ComResponse<Boolean> checkAccountDay (@RequestParam("departId") @NotNull Integer departId){

        ComResponse<Boolean> flag=saveProcessService.checkAccountDay(departId);
        return flag;
    }
    @ApiOperation(value = "保存取消请假申请",notes = "取消请假申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveCancelLeaveApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveCancelLeaveApplay (@RequestBody @Validated ApproveCancelLeaveDTO approveCancelLeaveDTO, @CurrentStaffNo @NotNull String staffNo){
        approveCancelLeaveDTO.getProcessCancelLeaveDTO().setStaffNo(staffNo);
        ComResponse<ProcessApproveNode> flag = saveProcessService.saveCancelLeaveApplay(approveCancelLeaveDTO);
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
    @GetMapping("v1/findProcessCancelLeaveList")
    @ApiOperation(value = "获取取消请假申请审批节点和请假信息")
    public ComResponse<ApproveCancelDetailsDTO> findProcessCancelLeaveList(@RequestParam("processAuditId") @NotNull String processAuditId,
                                                                           @RequestParam("appNo") @NotNull String appNo) {

        return saveProcessService.findProcessCancelLeaveList(processAuditId,appNo);
    }
    @ApiOperation(value = "保存调动申请",notes = "保存调动申请",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveTransferApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveTransferApplay (@RequestBody @Validated ProcessStaffTransferDTO processStaffTransferDTO, @CurrentStaffNo @NotNull String staffNo){
        processStaffTransferDTO.setAppStaffNo(staffNo);
        ComResponse<ProcessApproveNode> flag = saveProcessService.saveTransferApplay(processStaffTransferDTO);
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
