package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;

import cn.net.yzl.ehr.dto.AttendFalsePunishDto;
import cn.net.yzl.ehr.pojo.AttendFalsePunishPo;
import cn.net.yzl.ehr.service.AttendFalsePunishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attendFalseP")
@Api(value = "假勤配置惩罚规则服务", tags = {"假勤配置惩罚规则服务"})
public class AttendFalsePunishController {

    @Autowired
    private AttendFalsePunishService attendFalsePunishService;

    @ApiOperation(value = "创建假勤配置惩罚规则", notes = "创建假勤配置惩罚规则", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody @Validated AttendFalsePunishPo attendFalsePunishPo) {
        return attendFalsePunishService.add(attendFalsePunishPo);
    }

    @ApiOperation(value = "获取假勤惩罚规则", notes = "获取假勤惩罚规则", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPunishList", method = RequestMethod.GET)
    ComResponse<List<AttendFalsePunishDto>> getPunishList() {
        return attendFalsePunishService.getPunishList();
    }
}
