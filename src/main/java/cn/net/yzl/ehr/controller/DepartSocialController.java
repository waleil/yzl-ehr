package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.departSocial.DepartSocialService;
import cn.net.yzl.ehr.pojo.DepartSalarySettlePo;
import cn.net.yzl.ehr.vo.DepartSocialTypeVo;
import cn.net.yzl.ehr.vo.DepartSocialVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departSocial")
@Api(value = "工资发放与社保服务", tags = {"工资发放与社保服务"})
public class DepartSocialController {


    @Autowired
    private DepartSocialService departSocialService;

    @ApiOperation(value = "根据部门id获取社保项目列表", notes = "根据部门id获取社保项目列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId",value = "部门id",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "checkFlag",value = "是否选中(0代表否,1代表不是,不赋值查询所有)",required = true,dataType = "Integer")
    })
    @GetMapping("selectDepartSocialType")
    public ComResponse<DepartSocialTypeDto> selectDepartSocialType(@RequestParam("departId") Integer departId, @RequestParam(value = "checkFlag", required = false) Integer checkFlag) {
        return departSocialService.selectDepartSocialType(departId, checkFlag);
    }


    @ApiOperation(value = "新增社保项目", notes = "新增社保项目", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("insertDepartSocialType")
    public ComResponse insertDepartSocialType(@RequestBody @Validated DepartSocialTypeVo departSocialTypeVo) {
        return departSocialService.insertDepartSocialType(departSocialTypeVo);
    }

    ;

    @ApiOperation(value = "删除社保项目", notes = "删除社保项目", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParam(name = "ids",value = "ids",required = true,dataType = "Integer[]")
    @GetMapping("deleteDepartSocialType")
    public ComResponse deleteDepartSocialType(@RequestParam("ids") Integer[] ids) {
        return departSocialService.deleteDepartSocialType(ids);
    }

    ;

    @ApiOperation(value = "修改社保项目", notes = "修改社保项目", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("updateDepartSocialType")
    public ComResponse updateDepartSocialType(@RequestBody @Validated DepartSocialTypeVo departSocialTypeVo) {
        return departSocialService.updateDepartSocialType(departSocialTypeVo);
    }


    @ApiOperation(value = "新增社保", notes = "新增社保", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("insertDepartSocial")
    public ComResponse insertDepartSocial(@RequestBody @Validated DepartSocialVo departSocialVo) {
        return departSocialService.insertDepartSocial(departSocialVo);
    }

    @ApiOperation(value = "查询社保", notes = "查询社保", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParam(name = "departId",value = "departId",required = true,dataType = "Integer")
    @GetMapping("selectDepartSocialList")
    public ComResponse<DepartSocialDto> selectDepartSocialList(@RequestParam Integer departId){
        return departSocialService.selectDepartSocialList(departId);

    }

    @ApiOperation(value = "查询缴纳地区和岗位名称", notes = "查询缴纳地区和岗位名称")
    @GetMapping("selectPaymentAreaPostName")
    public ComResponse<AreaPostDto> selectPaymentAreaPostName(@RequestParam Integer departId){
        return departSocialService.selectPaymentAreaPostName(departId);
    }

    @ApiOperation(value = "根据部门id和社保id查询社保详情", notes = "根据部门id和社保id查询社保详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId",value = "部门id",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "id",value = "社保",required = true,dataType = "Integer")
    })
    @GetMapping("selectDepartSocialInfo")
    public ComResponse<DepartSocialInfoDto> selectDepartSocialInfo(@RequestParam Integer departId, @RequestParam Integer id){
        return departSocialService.selectDepartSocialInfo(departId,id);
    }


    @ApiOperation(value = "修改社保信息", notes = "修改社保信息", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("updateDepartSocial")
    public ComResponse updateDepartSocial(@RequestBody DepartSocialVo departSocialVo) {
        return departSocialService.updateDepartSocial(departSocialVo);
    }

    @ApiOperation(value = "删除社保信息", notes = "删除社保信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId",value = "部门id",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "departSocialId",value = "社保id",required = true,dataType = "Integer")
    })
    @GetMapping("deleteDepartSocial")
    public ComResponse deleteDepartSocial(@RequestParam Integer departId,@RequestParam Integer departSocialId) {
        return departSocialService.deleteDepartSocial(departId,departSocialId);
    }

    @ApiOperation(value = "新增工资发放日与结算日", notes = "新增工资发放日与结算日")
    @PostMapping("insertDepartSalarySettle")
    public ComResponse insertDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo) {
        return departSocialService.insertDepartSalarySettle(departSalarySettlePo);
    }

    @ApiOperation(value = "根据部门id查询工资发放日与结算日", notes = "根据部门id查询工资发放日与结算日")
    @ApiImplicitParam(name = "departId",value = "部门id",required = true,dataType = "Integer")
    @PostMapping("selectDepartSalarySettle")
    public ComResponse<DepartSalarySettlePo> selectDepartSalarySettle(@RequestParam Integer departId) {
        return departSocialService.selectDepartSalarySettle(departId);
    }


    @ApiOperation(value = "修改工资发放日与结算日", notes = "修改工资发放日与结算日")
    @PostMapping("updateDepartSalarySettle")
    public ComResponse updateDepartSalarySettle(@RequestBody @Validated DepartSalarySettlePo departSalarySettlePo) {
        return departSocialService.updateDepartSalarySettle(departSalarySettlePo);
    }


}
