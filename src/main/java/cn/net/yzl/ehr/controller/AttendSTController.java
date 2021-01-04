package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendStDto;
import cn.net.yzl.ehr.service.AttendSTService;
import cn.net.yzl.ehr.vo.DepartAttendStVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/conf/attendST")
@Api(value = "配置模块", tags = {"配置模块"})
@Validated
public class AttendSTController {
    @Autowired
    private AttendSTService attendSTService;
    @ApiOperation(value = "考勤配置-创建考勤结算日", notes = "考勤配置-创建考勤结算日", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody @Validated DepartAttendStVO departAttendStVO) {
        return attendSTService.add(departAttendStVO);
    }
    @ApiOperation(value = "考勤配置-根据部门id修改考勤结算日", notes = "考勤配置-根据主键修改考勤结算日", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody @Validated DepartAttendStVO departAttendStVO) {
        return attendSTService.update(departAttendStVO);
    }
    @ApiOperation(value = "考勤配置-根据部门id考勤结算日", notes = "考勤配置-根据部门id考勤结算日", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    ComResponse<DepartAttendStDto> getByDepartId(@Min(1) @NotNull Integer departId) {
        return attendSTService.getByDepartId(departId);
    }
}
