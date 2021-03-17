package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.processActiveService.saveProcessService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.personApprove.*;
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
    public ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid ApproveInviteDTO approveInviteDTO) {
        ComResponse<Boolean> flag = saveProcessService.saveProcessInviteInfo(approveInviteDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveInviteDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveInviteDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveInviteDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveInviteDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveInviteDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveInviteDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
    @ApiOperation(value = "保存转正申请",notes = "转正申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/savePositiveApplay", method = RequestMethod.POST)
    ComResponse<Boolean> savePositiveApplay (@RequestBody @Validated ApprovePostInfoListDTO approvePostInfoListDTO){
        ComResponse<Boolean> flag = saveProcessService.savePositiveApplay(approvePostInfoListDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approvePostInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approvePostInfoListDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
    @ApiOperation(value = "保存离职申请",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveDimissionApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveDimissionApplay (@RequestBody @Validated ApproveDimissionInfoListDTO approveDimissionInfoListDTO){
        ComResponse<Boolean> flag = saveProcessService.saveDimissionApplay(approveDimissionInfoListDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }

     @ApiOperation(value = "保存旷工申请",notes = "旷工申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveAbsentApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveAbsentApplay (@RequestBody @Validated ApproveAbsentInfoListDTO approveAbsentInfoListDTO){
        ComResponse<Boolean> flag = saveProcessService.saveAbsentApplay(approveAbsentInfoListDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveAbsentInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveAbsentInfoListDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveAbsentInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveAbsentInfoListDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveAbsentInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveAbsentInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
    @ApiOperation(value = "检查当前日期是否超过结算日期",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/checkAccountDay", method = RequestMethod.GET)
    ComResponse<Boolean> checkAccountDay (@RequestParam("departId") @NotNull Integer departId){

        ComResponse<Boolean> flag=saveProcessService.checkAccountDay(departId);
        return flag;
    }
    @ApiOperation(value = "保存取消请假申请",notes = "取消请假申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveCancelLeaveApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveCancelLeaveApplay (@RequestBody @Validated ApproveCancelLeaveDTO approveCancelLeaveDTO){
        ComResponse<Boolean> flag = saveProcessService.saveCancelLeaveApplay(approveCancelLeaveDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveCancelLeaveDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveCancelLeaveDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveCancelLeaveDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveCancelLeaveDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveCancelLeaveDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveCancelLeaveDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
    @GetMapping("v1/findProcessCancelLeaveList")
    @ApiOperation(value = "获取取消请假申请审批节点和请假信息")
    public ComResponse<ApproveCancelDetailsDTO> findProcessCancelLeaveList(@RequestParam("processAuditId") @NotNull String processAuditId,
                                                                           @RequestParam("appNo") @NotNull String appNo) {

        return saveProcessService.findProcessCancelLeaveList(processAuditId,appNo);
    }


}
