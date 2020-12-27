package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.service.AttendRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/conf/attendRule")
@Api(value = "配置模块", tags = {"配置模块"})
public class AttendRuleController {

    @Autowired
    private AttendRuleService attendRuleService;


    @ApiOperation(value = "考勤配置-更新", notes = "考勤配置-更新", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody DepartAttendRuleDto departAttendRuleDto) {
        return attendRuleService.update(departAttendRuleDto);
    }

    @ApiOperation(value = "考勤配置-创建考勤规则", notes = "考勤配置-创建考勤规则", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> add(@RequestBody @Validated DepartAttendRuleDto departAttendRuleDto) {
        return attendRuleService.add(departAttendRuleDto);
    }



    @ApiOperation(value = "考勤配置-根据部门获取考勤规则列表", notes = "考勤配置-根据部门获取考勤规则列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(@RequestParam("departId")  @NotNull @Min(1) Integer departId, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize) {
        return attendRuleService.getByDepartId(departId,pageNo,pageSize);
    }







}
