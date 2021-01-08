package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendDto;
import cn.net.yzl.ehr.dto.DepartAttendFtDto;
import cn.net.yzl.ehr.dto.SysAttendFalsePunishDto;
import cn.net.yzl.ehr.fegin.departAttend.DepartAttendFeginService;
import cn.net.yzl.ehr.pojo.DepartAttendFtPo;
import cn.net.yzl.ehr.vo.DepartAttendAllVo;
import cn.net.yzl.ehr.vo.DepartAttendInsertAllVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departAttendFalse")
@Api(value = "假勤配置服务", tags = {"假勤配置服务"})
public class DepartAttendFalseController {

    @Autowired
    private DepartAttendFeginService departAttendFeginService;


    @ApiOperation(value = "获取部门下的假勤配置信息", notes = "获取部门下的假勤配置信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "isEdit", value = "是否编辑假勤信息按钮标识(0代表否,1代表是)", required = false, dataType = "Int", paramType = "query"),
    })
    @RequestMapping(value = "/getByDepartAttendFalseId", method = RequestMethod.GET)
    ComResponse<DepartAttendDto> getByDepartAttendFalseId(@RequestParam("departId") Integer departId, @RequestParam(value = "isEdit",required = false) Integer isEdit) {
        return departAttendFeginService.getByDepartAttendFalseId(departId,isEdit);
    }

    @ApiOperation(value = "新增修改删除假勤配置信息", notes = "新增修改删除假勤配置信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping("insertUpdateDelDepartAttendFalse")
    public ComResponse insertUpdateDelDepartAttendFalse(@RequestBody @Validated DepartAttendInsertAllVo departAttendInsertAllVo){
        return departAttendFeginService.insertUpdateDelDepartAttendFalse(departAttendInsertAllVo);
    }

    @ApiOperation(value = "获取假勤类型和惩罚规则列表", notes = "获取假勤类型和惩罚规则列表")
    @GetMapping("getSysAttendFalse")
    public ComResponse<SysAttendFalsePunishDto> getSysAttendFalse(){
        return departAttendFeginService.getSysAttendFalse();
    }



}
