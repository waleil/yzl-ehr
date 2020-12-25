package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.service.AttendRPItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conf/attendRP")
@Api(value = "配置模块", tags = {"配置模块"})
@Valid
public class AttendRPItemController {

    @Autowired
    private AttendRPItemService attendRPItemService;


    @ApiOperation(value = "考勤配置-根据考勤奖惩项进行修改", notes = "考勤配置-根据考勤奖惩项进行修改", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody Map<Integer,Double> map) {
        return attendRPItemService.update(map);
    }

    @ApiOperation(value = "考勤配置-根据部门获取考勤奖惩项信息", notes = "考勤配置-根据部门获取考勤奖惩项信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(@RequestParam("departId") @NotNull @Min(1) Integer departId) {
        return attendRPItemService.getByDepartId(departId);
    }







}
