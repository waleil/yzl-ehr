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

    @ApiOperation(value = "新增社保", notes = "新增社保", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("insertDepartSocial")
    public ComResponse insertDepartSocial(@RequestBody DepartSocialVo departSocialVo) {
        return departSocialService.insertDepartSocial(departSocialVo);
    }

    @ApiOperation(value = "查询社保", notes = "查询社保", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    @GetMapping("selectDepartSocialList")
    public ComResponse<DepartSocialDto> selectDepartSocialList(@RequestParam("departId") Integer departId){
        return departSocialService.selectDepartSocialList(departId);

    }

    @ApiOperation(value = "查询缴纳地区和岗位名称", notes = "查询缴纳地区和岗位名称")
    @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    @GetMapping("selectPaymentAreaPostName")
    public ComResponse<AreaPostDto> selectPaymentAreaPostName(@RequestParam("departId") Integer departId){
        return departSocialService.selectPaymentAreaPostName(departId);
    }

    @ApiOperation(value = "查询社保详情", notes = "查询社保详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "salaryStart", value = "薪酬范围下限", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "salaryEnd", value = "薪酬范围上限", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "isEdit", value = "是否编辑按钮(0代表否,1代表是)", required = true, dataType = "Int", paramType = "query")
    })
    @GetMapping("selectDepartSocialInfo")
    public ComResponse<DepartSocialInfoDto> selectDepartSocialInfo(@RequestParam("departId") Integer departId,@RequestParam("salaryStart") Integer salaryStart,@RequestParam("salaryEnd") Integer salaryEnd,@RequestParam("isEdit") Integer isEdit){
        return departSocialService.selectDepartSocialInfo(departId,salaryStart,salaryEnd,isEdit);
    }


    @ApiOperation(value = "新增工资发放日与结算日", notes = "新增工资发放日与结算日")
    @PostMapping("insertDepartSalarySettle")
    public ComResponse insertDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo) {
        return departSocialService.insertDepartSalarySettle(departSalarySettlePo);
    }

    @ApiOperation(value = "查询工资发放日与结算日", notes = "查询工资发放日与结算日")
    @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    @PostMapping("selectDepartSalarySettle")
    public ComResponse<DepartSalarySettlePo> selectDepartSalarySettle(@RequestParam Integer departId) {
        return departSocialService.selectDepartSalarySettle(departId);
    }

    @ApiOperation(value = "修改工资发放日与结算日", notes = "修改工资发放日与结算日")
    @PostMapping("updateDepartSalarySettle")
    public ComResponse updateDepartSalarySettle(@RequestBody DepartSalarySettlePo departSalarySettlePo) {
        return departSocialService.updateDepartSalarySettle(departSalarySettlePo);
    }


}
