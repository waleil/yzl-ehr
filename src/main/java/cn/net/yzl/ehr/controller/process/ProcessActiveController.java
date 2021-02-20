package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.processActiveService.FindProcessNodeService;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/processActive")
@Api(tags = "流程相关操作")
public class ProcessActiveController {
    @Autowired
    private FindProcessNodeService findProcessNodeService;

    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "获取流程展示信息")
    public ComResponse<List<ProcessNodeDTO>> findProcessInfoList(@RequestParam @NotNull Integer processId,
                                                                 @RequestParam @NotNull @CurrentStaffNo String staffNo) {

        return findProcessNodeService.findProcessInfoList(processId,staffNo);
    }

    @PostMapping("v1/saveProcessLeaveInfo")
    @ApiOperation(value = "保存请假信息")
    public ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid StaffLeaveDTO staffLeaveDTO) {


        return findProcessNodeService.saveProcessLeaveInfo(staffLeaveDTO);
    }


}
