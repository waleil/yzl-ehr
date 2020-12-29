package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendFtDto;
import cn.net.yzl.ehr.pojo.DepartAttendFtPo;
import cn.net.yzl.ehr.service.DepartAttendFtService;
import cn.net.yzl.ehr.vo.DepartAttendVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departAttendFt")
@Api(value = "假勤类型服务", tags = {"假勤类型服务"})
public class DepartAttendFtController {

    @Autowired
    private DepartAttendFtService departAttendFtService;

    @ApiOperation(value = "创建假勤类型", notes = "创建假勤类型", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody DepartAttendFtPo departAttendFtPo) {
        return departAttendFtService.add(departAttendFtPo);
    }

    @ApiOperation(value = "获取假勤类型", notes = "获取假勤类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getDepartAttendFtList", method = RequestMethod.GET)
    ComResponse<List<DepartAttendFtDto>> getDepartAttendFtList() {
        return departAttendFtService.getDepartAttendFtList();
    }

    @ApiOperation(value = "删除假勤类型", notes = "删除假勤类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteDepartAttendFt", method = RequestMethod.POST)
    ComResponse<Integer> deleteDepartAttendFt(Integer id) {
        return departAttendFtService.deleteDepartAttendFt(id);
    }

    @ApiOperation(value = "根据主键更新假勤类型", notes = "根据主键更新假勤类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody @Validated DepartAttendFtPo departAttendFtPo) {
        return departAttendFtService.update(departAttendFtPo);
    }

    @ApiOperation(value = "获取部门下的假勤配置信息", notes = "获取部门下的假勤配置信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartAttendVo>> getByDepartId(@RequestParam("departId") Integer departId) {
        return departAttendFtService.getByDepartId(departId);
    }
}
