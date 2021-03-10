package cn.net.yzl.ehr.controller.personApprove;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.personApproveService.FindApproveService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.ProcessProfession.ApprovePostInfoDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveInfoListDTO;

import cn.net.yzl.staff.dto.personApprove.ApproveProcessInfo;
import cn.net.yzl.staff.dto.personApprove.ApproveQueryDTO;
import cn.net.yzl.staff.dto.processNode.ApproveInfoDTO;
import cn.net.yzl.staff.dto.processNode.ProcessAudit;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/personApprove")
@Api(tags = "审批数据查询")
public class personApproveController {
    @Autowired
    private FindApproveService findApproveService;


    @PostMapping("v1/getApproveInfoListDTOList")
    @ApiOperation(value = "人事审批审批查询")
    public ComResponse<Page<ApproveInfoListDTO>> findApproveInfoList(@RequestBody ApproveQueryDTO approveQueryDTO) {

        return findApproveService.findApproveInfoList(approveQueryDTO);
    }

    @PostMapping("v1/getMyProcessInfoList")
    @ApiOperation(value = "我的流程我的审批展示信息")
    public ComResponse<Page<ApproveInfoListDTO>> getMyProcessInfoList(@RequestBody ApproveQueryDTO approveQueryDTO) {

        return findApproveService.getMyProcessInfoList(approveQueryDTO);
    }
    @PostMapping("v1/getApproveInfoList")
    @ApiOperation(value = "我的流程审批页详情显示")
    public ComResponse<ApproveInfoDTO> getApproveInfoList(@RequestBody @Validated ApprovePostInfoDTO approvePostInfoDTO) {

        return findApproveService.getApproveInfoList(approvePostInfoDTO);
    }
    @PostMapping("v1/saveApproveInfo")
    @ApiOperation(value = "我的流程审批页保存审批信息，并修改审批状态")
    public ComResponse<Boolean> saveApproveInfo(@RequestBody ApproveProcessInfo approveProcessInfo, HttpServletRequest httpServletRequest) {
        String userNo = httpServletRequest.getHeader("userNo");
        ComResponse<Boolean> flag = findApproveService.saveApproveInfo(approveProcessInfo);
        if (flag.getCode().equals(200)){
            try {
                if (approveProcessInfo.getProcessNodeDTO().getAuditResult().equals(3)) {
                    MessageRemandAPI.revocationMessage(userNo,
                            approveProcessInfo.getApproveInfoListDTO().getApplicationNo(),
                            approveProcessInfo.getApproveInfoListDTO().getApplicationName(),
                            approveProcessInfo.getProcessNodeDTO().getProcessName());
                } else {
                    if (approveProcessInfo.getProcessNodeDTO().getTotalNode()>approveProcessInfo.getProcessNodeDTO().getStepNo()) {
                        MessageRemandAPI.examine(userNo,
                                approveProcessInfo.getApproveInfoListDTO().getApproveNo(),
                                approveProcessInfo.getProcessNodeDTO().getProcessName());
                    }else if (approveProcessInfo.getProcessNodeDTO().getTotalNode().equals(approveProcessInfo.getProcessNodeDTO().getStepNo())){
                        MessageRemandAPI.revocationMessage(userNo,
                                approveProcessInfo.getApproveInfoListDTO().getApplicationNo(),
                                approveProcessInfo.getApproveInfoListDTO().getApplicationName(),
                                approveProcessInfo.getProcessNodeDTO().getProcessName());
                    }
                }
                // MessageRemandAPI.processSendMessage(staffReimbursementVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }

    @PostMapping("v1/updateCancelApproveInfo")
    @ApiOperation(value = "我的流程我发起的撤销功能")
    public ComResponse<Boolean> updateCancelApproveInfo(@RequestBody ApproveProcessInfo approveProcessInfo) {


        return findApproveService.updateCancelApproveInfo(approveProcessInfo);

    }

    @PostMapping("v1/findCopyApproveInfo")
    @ApiOperation(value = "我的流程抄送我的功能")
    public ComResponse<Page<ProcessAudit>> findCopyApproveInfo(@RequestBody ApproveQueryDTO approveQueryDTO) {


        return findApproveService.findCopyApproveInfo(approveQueryDTO);

    }
    @PostMapping("v1/getMystartApproveInfo")
    @ApiOperation(value = "我的流程我发起的功能")
    public ComResponse<Page<ProcessAudit>> getMystartApproveInfo(@RequestBody ApproveQueryDTO approveQueryDTO) {


        return findApproveService.getMystartApproveInfo(approveQueryDTO);

    }


}
