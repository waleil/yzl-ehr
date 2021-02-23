package cn.net.yzl.ehr.controller.personApprove;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.personApproveService.FindApproveService;
import cn.net.yzl.staff.dto.personApprove.ApproveInfoListDTO;

import cn.net.yzl.staff.dto.personApprove.ApproveProcessInfo;
import cn.net.yzl.staff.dto.personApprove.ApproveQueryDTO;
import cn.net.yzl.staff.dto.processNode.ApproveInfoDTO;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "人事审批流程展示信息")
    public ComResponse<List<ProcessNodeDTO>> findProcessInfoList(@RequestParam @NotNull Integer processId) {

        return findApproveService.findProcessInfoList(processId);
    }

    @PostMapping("v1/getMyProcessInfoList")
    @ApiOperation(value = "我的流程我的审批展示信息")
    public ComResponse<Page<ApproveInfoListDTO>> getMyProcessInfoList(@RequestBody ApproveQueryDTO approveQueryDTO) {

        return findApproveService.getMyProcessInfoList(approveQueryDTO);
    }
    @GetMapping("v1/getApproveInfoList")
    @ApiOperation(value = "我的流程审批页详情显示")
    public ComResponse<ApproveInfoDTO> getApproveInfoList(@RequestParam @NotNull Integer processId,
                                                          @RequestParam @NotNull String processAuditId,
                                                          @RequestParam @NotNull String leaveNo) {

        return findApproveService.getApproveInfoList(processId,processAuditId,leaveNo);
    }
    @PostMapping("v1/saveApproveInfo")
    @ApiOperation(value = "我的流程审批页保存审批信息，并修改审批状态")
    public ComResponse<Boolean> saveApproveInfo(@RequestBody ApproveProcessInfo approveProcessInfo) {

        return findApproveService.saveApproveInfo(approveProcessInfo);
    }

    @PostMapping("v1/updateCancelApproveInfo")
    @ApiOperation(value = "我的流程我发起的撤销功能")
    public ComResponse<Boolean> updateCancelApproveInfo(@RequestBody ApproveProcessInfo approveProcessInfo) {


        return findApproveService.updateCancelApproveInfo(approveProcessInfo);

    }

    @GetMapping("v1/findCopyApproveInfo")
    @ApiOperation(value = "我的流程抄送我的撤销功能")
    public ComResponse<Page<ApproveInfoListDTO>> findCopyApproveInfo(@RequestBody ApproveQueryDTO approveQueryDTO) {


        return findApproveService.findCopyApproveInfo(approveQueryDTO);

    }

}
