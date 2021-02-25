package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.process.ProcessInitiateService;
import cn.net.yzl.staff.vo.process.StaffAttendApprovalVo;
import cn.net.yzl.staff.vo.process.StaffOutVo;
import cn.net.yzl.staff.vo.process.StaffTravelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 流程发起-出勤休假
 *
 */

@RestController
@RequestMapping("/process")
@Api(value = "流程发起-出勤休假",tags = "流程发起-出勤休假")
public class ProcessInitiateController {

    @Autowired
    private ProcessInitiateService processInitiateService;

    @ApiOperation(value = "添加外出申请",notes = "添加外出申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "out/insert")
    public ComResponse<Integer> insertProcessStaffOut(@RequestBody @Validated StaffOutVo staffOutVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processInitiateService.insertProcessStaffOut(staffOutVo,staffNo);
    }

    @ApiOperation(value = "添加出差申请",notes = "添加出差申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("travel/insert")
    public ComResponse<Integer> insertProcessStaffTravel(@RequestBody @Validated StaffTravelVo staffTravelVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processInitiateService.insertProcessStaffTravel(staffTravelVo,staffNo);
    }

    @ApiOperation(value = "添加考勤补卡申请",notes = "添加考勤补卡申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("attend/approval/insert")
    public ComResponse<Integer> insertProcessStaffAttendApproval(@RequestBody @Validated StaffAttendApprovalVo staffAttendApprovalVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processInitiateService.insertProcessStaffAttendApproval(staffAttendApprovalVo,staffNo);
    }
}
