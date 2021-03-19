package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainInfoDto;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.service.StaffAbnorService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.staff.dto.StaffTrainDto;
import cn.net.yzl.staff.pojo.AbnorRecordPo;
import cn.net.yzl.staff.pojo.RunAbnorRecordPo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.util.Date;
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

    @ApiOperation(value = "员工异动-设定执行异动操作", notes = "员工异动-设定执行异动操作", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/executeStaffChange", method = RequestMethod.POST)
    public ComResponse<Integer> executeStaffChange(@RequestBody @Validated StaffAbnorRecordPo staffChangePo, @CurrentStaffNo @ApiIgnore String staffNo) throws ParseException {


        return staffAbnorService.executeStaffChange(staffChangePo,staffNo);
    }

    @ApiOperation(value = "员工异动-执行即时变动操作", notes = "员工异动-执行即时变动操作", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/runStaffChange", method = RequestMethod.POST)
    public ComResponse<Integer> runStaffChange(@RequestBody RunAbnorRecordPo staffChangePo, @CurrentStaffNo @ApiIgnore String staffNo) throws ParseException{
        return staffAbnorService.runStaffChange(staffChangePo,staffNo);
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
    public ComResponse<List<StaffTrainInfoDto>> find(@RequestParam("staffNo") String staffNo){
        ComResponse<List<StaffTrainInfoDto>>  staffTrain = staffAbnorService.find(staffNo);
        return staffTrain;
    }

    @ApiOperation(value = "员工旅程分页查询", notes = "员工旅程分页查询", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getStaffTrainPage", method = RequestMethod.GET)
    public ComResponse<List<StaffTrainInfoDto>> findPage(@CurrentStaffNo @ApiIgnore String staffNo,@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize){
        ComResponse<List<StaffTrainInfoDto>>  staffTrain = staffAbnorService.findPage(staffNo,pageNum,pageSize);
        return staffTrain;
    }

    @ApiOperation(value = "人事管理-员工调整记录", notes = "人事管理-员工调整记录", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/findRecordsByPageParam", method = RequestMethod.POST)
    public ComResponse<Page<StaffTrainDto>> findRecordsByPageParam(@RequestBody @Validated AbnorRecordPo abnorRecordPo) {
        ComResponse<Page<StaffTrainDto>> recordsByPageParam = staffAbnorService.findRecordsByPageParam(abnorRecordPo);
        return recordsByPageParam;
    }


    @ApiOperation(value = "员工异动-定时更新员工异动信息", notes = "员工异动-定时更新员工异动信息")
    @GetMapping("/timerUpdateStafffAbnorRecord")
    public ComResponse<List<MsgTemplateVo>> timerUpdateAttendFalse(@RequestParam("today") @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                   @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
                                                                           Date date) throws ParseException {
         staffAbnorService.timerUpdateAttendFalse(date);
        return ComResponse.success();
    }
}
