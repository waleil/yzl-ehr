package cn.net.yzl.ehr.fegin.personApproveService;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.personApprove.ApproveInfoListDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveProcessInfo;
import cn.net.yzl.staff.dto.personApprove.ApproveQueryDTO;
import cn.net.yzl.staff.dto.processNode.ApproveInfoDTO;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;
//@FeignClient(name="personApprove",url="${fegin.db.url}/personApprove")
@FeignClient(name="personApprove",url="localhost:38080/personApprove")
public interface FindApproveService {
    @PostMapping("v1/getApproveInfoListDTOList")
    @ApiOperation(value = "审批查询")
    ComResponse<Page<ApproveInfoListDTO>> findApproveInfoList(@RequestBody ApproveQueryDTO approveQueryDTO);

    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "获取流程展示信息")
    ComResponse<List<ProcessNodeDTO>> findProcessInfoList(@RequestParam("processId") @NotNull Integer processId);

    @PostMapping("v1/getMyProcessInfoList")
    @ApiOperation(value = "获取我的流程信息")
    ComResponse<Page<ApproveInfoListDTO>> getMyProcessInfoList(@RequestBody ApproveQueryDTO approveQueryDTO);

    @GetMapping("v1/getApproveInfoList")
    @ApiOperation(value = "审批页详情显示")
    ComResponse<ApproveInfoDTO> getApproveInfoList(@RequestParam("processId") @NotNull Integer processId,
                                                   @RequestParam("processAuditId") @NotNull String processAuditId,
                                                   @RequestParam("leaveNo") @NotNull String leaveNo);

    @PostMapping("v1/saveApproveInfo")
    @ApiOperation(value = "保存审批信息，并修改审批状态")
    ComResponse<Boolean> saveApproveInfo(@RequestBody ApproveProcessInfo approveProcessInfo);
}
