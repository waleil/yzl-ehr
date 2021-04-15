package cn.net.yzl.ehr.controller.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salaryRule.SalaryFrontLineRuleFeignService;
import cn.net.yzl.staff.dto.salaryFrontLineRule.RulePostDto;
import cn.net.yzl.staff.dto.salaryFrontLineRule.RuleTypeDto;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto1;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto10;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto11;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto12;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto13;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto14;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto15;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto16;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto17;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto18;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto19;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto2;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto3;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto4;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto5;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto6;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto7;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleDto9;
import cn.net.yzl.staff.vo.salaryRule.SalaryRuleSwitch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 一线管理-薪酬核算规则配置
 */
@RestController
@RequestMapping("/salaryFrontLineRuleNew")
@Api(value = "一线管理-薪酬核算规则配置-新版", tags = {"一线管理-薪酬核算规则配置-新版"})
public class SalaryFrontLineRuleNewController {
    @Autowired
    private SalaryFrontLineRuleFeignService salaryFrontLineService;

    @ApiOperation(value = "一线管理-薪酬核算规则-规则列表", notes = "一线管理-薪酬核算规则-规则列表")
    @PostMapping("/getSalaryRuleTypeList")
    public ComResponse<List<RuleTypeDto>> getSalaryRuleTypeList() {
        return salaryFrontLineService.getRuleTypeList();
    }

    @ApiOperation(value = "一线管理-薪酬核算规则开关", notes = "一线管理-薪酬核算规则开关")
    @PostMapping("/ruleSwitch")
    public ComResponse<Void> ruleSwitch(@RequestBody SalaryRuleSwitch salaryRuleSwitch) {
        return salaryFrontLineService.ruleSwitch(salaryRuleSwitch);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则开关查询", notes = "一线管理-薪酬核算规则开关查询")
    @GetMapping("/ruleOnStatus")
    public ComResponse<Integer> ruleOnStatus() {
        return salaryFrontLineService.ruleOnStatus();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "ruleType", value = "规则类型", required = true, dataType = "Integer", paramType = "query")
    })
    @ApiOperation(value = "一线管理-薪酬核算规则配置-查看", notes = "一线管理-薪酬核算规则配置-查看")
    @GetMapping("/getRule")
    public ComResponse getRule(@RequestParam("ruleType") Integer ruleType) {
        return salaryFrontLineService.getRule(ruleType);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "staffType", value = "员工类型(1:一线；2:职能)", required = true, dataType = "Integer", paramType = "query")
    })
    @ApiOperation(value = "查询部门下所有岗位", notes = "查询部门下所有岗位")
    @RequestMapping(value = "/getPostByDepartId", method = RequestMethod.GET)
    public ComResponse<List<RulePostDto>> getPostByDepartId(@RequestParam("departId") Integer departId,
                                                            @RequestParam("staffType") Integer staffType) {
        return salaryFrontLineService.getPostByDepartId(departId, staffType);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则一", notes = "一线管理-薪酬核算规则配置-规则一")
    @PostMapping("/rule1")
    public ComResponse<Boolean> rule1(@RequestBody SalaryFrontLineRuleDto1 salaryFrontLineRuleDto1, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleDto1.setStaffNo(staffNo);
        return salaryFrontLineService.rule1(salaryFrontLineRuleDto1);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则二", notes = "一线管理-薪酬核算规则配置-规则二")
    @PostMapping("/rule2")
    public ComResponse<Boolean> rule2(@RequestBody SalaryFrontLineRuleDto2 salaryFrontLineRuleDto2, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleDto2.setStaffNo(staffNo);
        return salaryFrontLineService.rule2(salaryFrontLineRuleDto2);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则三", notes = "一线管理-薪酬核算规则配置-规则三")
    @PostMapping("/rule3")
    public ComResponse<Boolean> rule2(@RequestBody SalaryFrontLineRuleDto3 salaryFrontLineRuleDto3, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleDto3.setStaffNo(staffNo);
        return salaryFrontLineService.rule3(salaryFrontLineRuleDto3);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则四", notes = "一线管理-薪酬核算规则配置-规则四")
    @PostMapping("/rule4")
    public ComResponse<Boolean> rule4(@RequestBody SalaryFrontLineRuleDto4 salaryFrontLineRuleDto4, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleDto4.setStaffNo(staffNo);
        return salaryFrontLineService.rule4(salaryFrontLineRuleDto4);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则五", notes = "一线管理-薪酬核算规则配置-规则五")
    @PostMapping("/rule5")
    public ComResponse<Boolean> rule5(@RequestBody SalaryFrontLineRuleDto5 ruleDto5, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto5.setStaffNo(staffNo);
        return salaryFrontLineService.rule5(ruleDto5);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则六", notes = "一线管理-薪酬核算规则配置-规则六")
    @PostMapping("/rule6")
    public ComResponse<Boolean> rule6(@RequestBody SalaryFrontLineRuleDto6 ruleDto6, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto6.setStaffNo(staffNo);
        return salaryFrontLineService.rule6(ruleDto6);
    }


    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则七", notes = "一线管理-薪酬核算规则配置-规则七")
    @PostMapping("/rule7")
    public ComResponse<Boolean> rule7(@RequestBody SalaryFrontLineRuleDto7 ruleDto7, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto7.setStaffNo(staffNo);
        return salaryFrontLineService.rule7(ruleDto7);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则八", notes = "一线管理-薪酬核算规则配置-规则八")
    @PostMapping("/rule8")
    public ComResponse<Boolean> rule8(@RequestBody SalaryFrontLineRuleDto7 ruleDto7, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto7.setStaffNo(staffNo);
        return salaryFrontLineService.rule8(ruleDto7);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则九", notes = "一线管理-薪酬核算规则配置-规则九")
    @PostMapping("/rule9")
    public ComResponse<Boolean> rule9(@RequestBody SalaryFrontLineRuleDto9 ruleDto9, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto9.setStaffNo(staffNo);
        return salaryFrontLineService.rule9(ruleDto9);
    }


    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十", notes = "一线管理-薪酬核算规则配置-规则十")
    @PostMapping("/rule10")
    public ComResponse<Boolean> rule10(@RequestBody SalaryFrontLineRuleDto10 ruleDto10, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto10.setStaffNo(staffNo);
        return salaryFrontLineService.rule10(ruleDto10);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十一", notes = "一线管理-薪酬核算规则配置-规则十一")
    @PostMapping("/rule11")
    public ComResponse<Boolean> rule11(@RequestBody SalaryFrontLineRuleDto11 ruleDto11, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto11.setStaffNo(staffNo);
        return salaryFrontLineService.rule11(ruleDto11);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十二", notes = "一线管理-薪酬核算规则配置-规则十二")
    @PostMapping("/rule12")
    public ComResponse<Boolean> rule12(@RequestBody SalaryFrontLineRuleDto12 ruleDto12, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto12.setStaffNo(staffNo);
        return salaryFrontLineService.rule12(ruleDto12);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十三", notes = "一线管理-薪酬核算规则配置-规则十三")
    @PostMapping("/rule13")
    public ComResponse<Boolean> rule13(@RequestBody SalaryFrontLineRuleDto13 ruleDto13, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto13.setStaffNo(staffNo);
        return salaryFrontLineService.rule13(ruleDto13);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十四", notes = "一线管理-薪酬核算规则配置-规则十四")
    @PostMapping("/rule14")
    public ComResponse<Boolean> rule14(@RequestBody SalaryFrontLineRuleDto14 ruleDto14, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto14.setStaffNo(staffNo);
        return salaryFrontLineService.rule14(ruleDto14);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十五", notes = "一线管理-薪酬核算规则配置-规则十五")
    @PostMapping("/rule15")
    public ComResponse<Boolean> rule15(@RequestBody SalaryFrontLineRuleDto15 ruleDto15, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto15.setStaffNo(staffNo);
        return salaryFrontLineService.rule15(ruleDto15);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十六", notes = "一线管理-薪酬核算规则配置-规则十六")
    @PostMapping("/rule16")
    public ComResponse<Boolean> rule16(@RequestBody SalaryFrontLineRuleDto16 ruleDto16, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto16.setStaffNo(staffNo);
        return salaryFrontLineService.rule16(ruleDto16);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十七", notes = "一线管理-薪酬核算规则配置-规则十七")
    @PostMapping("/rule17")
    public ComResponse<Boolean> rule17(@RequestBody SalaryFrontLineRuleDto17 ruleDto17, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto17.setStaffNo(staffNo);
        return salaryFrontLineService.rule17(ruleDto17);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十八", notes = "一线管理-薪酬核算规则配置-规则十八")
    @PostMapping("/rule18")
    public ComResponse<Boolean> rule18(@RequestBody SalaryFrontLineRuleDto18 ruleDto18, @ApiIgnore @CurrentStaffNo String staffNo) {
        ruleDto18.setStaffNo(staffNo);
        return salaryFrontLineService.rule18(ruleDto18);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则十九", notes = "一线管理-薪酬核算规则配置-规则十九")
    @PostMapping("/rule19")
    public ComResponse<Boolean> rule19(@RequestBody SalaryFrontLineRuleDto19 ruleDto19) {
        return salaryFrontLineService.rule19(ruleDto19);
    }
}
