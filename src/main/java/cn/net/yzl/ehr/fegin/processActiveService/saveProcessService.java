package cn.net.yzl.ehr.fegin.processActiveService;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.ProcessProfession.ProcessStaffDimissionDTO;
import cn.net.yzl.staff.dto.ProcessProfession.ProcessStaffPositiveDTO;
import cn.net.yzl.staff.dto.ProcessProfession.ProcessStaffTransferDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveCancelDetailsDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveCancelLeaveDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveInviteDTO;
import cn.net.yzl.staff.dto.personApprove.ProcessAbsentDTO;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}/processsInvite")
public interface saveProcessService {
    @PostMapping("v1/saveProcessInviteInfo")
    @ApiOperation(value = "保存招聘信息")
    ComResponse<ProcessApproveNode> saveProcessInviteInfo(@RequestBody @Validated ApproveInviteDTO approveInviteDTO);

    @ApiOperation(value = "保存转正申请", notes = "转正申请添加", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/savePositiveApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> savePositiveApplay(@RequestBody @Validated ProcessStaffPositiveDTO processStaffPositiveDTO);

    @ApiOperation(value = "保存离职申请", notes = "离职申请添加", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveDimissionApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveDimissionApplay(@RequestBody @Validated ProcessStaffDimissionDTO processStaffDimissionDTO);

    @ApiOperation(value = "保存旷工申请", notes = "离职申请添加", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveAbsentApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveAbsentApplay(@RequestBody ProcessAbsentDTO processAbsentDTO);

    @ApiOperation(value = "检查当前日期是否超过结算日期", notes = "离职申请添加", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/checkAccountDay", method = RequestMethod.GET)
    ComResponse<Boolean> checkAccountDay(@RequestParam("departId") Integer departId);

    @GetMapping("v1/findProcessCancelLeaveList")
    ComResponse<ApproveCancelDetailsDTO> findProcessCancelLeaveList(@RequestParam("processAuditId") @NotNull String processAuditId,
                                                                    @RequestParam("appNo") @NotNull String appNo);

    @ApiOperation(value = "保存取消请假申请", notes = "取消请假申请添加", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveCancelLeaveApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveCancelLeaveApplay(@RequestBody ApproveCancelLeaveDTO approveCancelLeaveDTO);

    @ApiOperation(value = "保存调动申请", notes = "保存调动申请", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveTransferApplay", method = RequestMethod.POST)
    ComResponse<ProcessApproveNode> saveTransferApplay(@RequestBody ProcessStaffTransferDTO processStaffTransferDTO);
}
