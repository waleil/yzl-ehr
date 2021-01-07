package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpDto;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.service.AttendRPItemService;
import cn.net.yzl.ehr.vo.DepartAttendRpVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conf/attendRP")
@Api(value = "配置模块", tags = {"配置模块"})
@Validated
public class AttendRPItemController {

    @Autowired
    private AttendRPItemService attendRPItemService;


    @ApiOperation(value = "考勤配置-考勤奖惩项-修改", notes = "考勤配置-考勤奖惩项-修改", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key为考勤奖惩项id(attendRpId)", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "value", value = "奖惩金额(money)", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "enable", value = "1:立即执行,0:几日后生效", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "days", value = "几天后生效", required = false, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<Integer> update(@RequestBody List<Map<String, Double>> map) {
        return attendRPItemService.update(map);
    }

    @ApiOperation(value = "考勤配置-考勤奖惩项-添加奖惩项信息", notes = "考勤配置-考勤奖惩项-添加奖惩项信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> add(@RequestBody @Validated List<DepartAttendRpVO> departAttendRpVO) throws Exception {
        return attendRPItemService.add(departAttendRpVO);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "enable", value = "0:否,1:是(1:也表示立即生效的)", required = true, dataType = "Int", paramType = "query")
    })
    @ApiOperation(value = "考勤配置-考勤奖惩项-根据部门和启用状态获取考勤奖惩项信息", notes = "考勤配置-考勤奖惩项-根据部门和启用状态获取考勤奖惩项信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(@Min(1) @NotNull Integer departId, @Min(0) @Max(1) @NotNull Integer enable) {
        return attendRPItemService.getByDepartId(departId, enable);
    }








}
