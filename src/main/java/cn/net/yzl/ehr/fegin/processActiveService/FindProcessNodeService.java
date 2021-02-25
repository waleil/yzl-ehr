package cn.net.yzl.ehr.fegin.processActiveService;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveProcessListDTO;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
//@FeignClient(name="personApprove",url="${fegin.db.url}/processActive")
@FeignClient(name="processActive",url="localhost:38080/processActive")
public interface FindProcessNodeService {
    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "获取流程展示信息")
    ComResponse<List<ProcessNodeDTO>> findProcessInfoList(@RequestParam("processId") Integer processId, @RequestParam("staffNo") String staffNo);

    @PostMapping("v1/saveProcessLeaveInfo")
    @ApiOperation(value = "保存请假信息")
    ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid ApproveLeaveDTO approveLeaveDTO);

}
