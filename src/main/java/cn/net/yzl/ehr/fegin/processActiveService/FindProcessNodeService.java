package cn.net.yzl.ehr.fegin.processActiveService;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDTO;

import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDayDTO;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
//@FeignClient(name="personApprove",url="${fegin.db.url}/processActive")
@FeignClient(name="processActive",url="localhost:38080/processActive")
public interface FindProcessNodeService {
    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "获取当前当前员工信息")
    ComResponse<StaffDetailsDto> findProcessInfoList(@RequestParam("staffNo") String staffNo);

    @PostMapping("v1/saveProcessLeaveInfo")
    @ApiOperation(value = "保存请假信息")
    ComResponse<ProcessApproveNode> saveProcessLeaveInfo(@RequestBody @Valid StaffLeaveDTO staffLeaveDTO);

    @GetMapping("v1/getLeaveNumInfo")
    @ApiOperation(value = "获得年假信息")
    ComResponse<ApproveLeaveDayDTO> getLeaveNumInfo(@RequestParam("departId") Integer departId,
                                                           @RequestParam("sysDictDataId") Integer sysDictDataId,
                                                           @RequestParam("staffNo") String staffNo);

}
