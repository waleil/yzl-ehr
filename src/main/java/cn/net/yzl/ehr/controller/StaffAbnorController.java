package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainDto;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.service.StaffAbnorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import java.util.List;


@RestController
@RequestMapping("/staff/abnor")
@Api(value = "员工异动接口", tags = {"员工服务"})
public class StaffAbnorController {

    @Autowired
    private StaffAbnorService staffAbnorService;

    @ApiOperation(value = "员工异动-更改员工异动状态", notes = "更改员工异动状态", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateStaffChangeStatus", method = RequestMethod.POST)
    public ComResponse<Integer> updateStaffChangeStatus(@RequestBody @Validated StaffSwitchStatePo staffSwitchStatePo, @CurrentStaffNo @ApiIgnore String staffNo){
        return staffAbnorService.updateStaffChangeStatus(staffSwitchStatePo,staffNo);
    }


    @ApiOperation(value = "员工异动-执行异动操作", notes = "执行异动操作", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/executeStaffChange", method = RequestMethod.POST)
    public ComResponse<Integer> executeStaffChange(@RequestBody @Validated StaffAbnorRecordPo staffChangePo, @CurrentStaffNo @ApiIgnore String staffNo){
        return staffAbnorService.executeStaffChange(staffChangePo,staffNo);
    }

    @ApiOperation(value = "员工异动-查询员工异动记录", notes = "查询员工异动记录", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "staffNo", value = "员工编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/getStaffAbnorRecord", method = RequestMethod.GET)
    public ComResponse<StaffAbnorRecordListDto> getStaffAbnorRecord(@NotBlank String staffNo) {
        return staffAbnorService.getStaffAbnorRecord(staffNo);
    }

    @ApiOperation(value = "员工旅程查询", notes = "员工旅程查询", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "staffNo", value = "员工编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/getStaffTrain", method = RequestMethod.GET)
    public ComResponse<List<StaffTrainDto>> find(@RequestParam("staffNo") String staffNo){
        ComResponse<List<StaffTrainDto>>  staffTrain = staffAbnorService.find(staffNo);
        return staffTrain;
    }
}
