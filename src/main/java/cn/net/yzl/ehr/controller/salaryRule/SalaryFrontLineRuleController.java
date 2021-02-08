package cn.net.yzl.ehr.controller.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salaryRule.SalaryFrontLineRuleFeginService;
import cn.net.yzl.staff.dto.salaryRule.SalaryFrontLineRuleDto;
import cn.net.yzl.staff.dto.salaryRule.SalaryRuleDepartPostDto;
import cn.net.yzl.staff.vo.salaryRule.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Author
 * @Date 2021/2/8
 * @Description
 */
@RestController
@RequestMapping("/salaryFrontLineRule")
@Api(value = "一线管理-薪酬核算规则", tags = {"线管理-薪酬核算规则"})
public class SalaryFrontLineRuleController {
    @Autowired
    private SalaryFrontLineRuleFeginService salaryFrontLineService;

    @ApiOperation(value = "一线管理-薪酬核算规则配置-查看", notes = "一线管理-薪酬核算规则配置-查看")
    @PostMapping("/ruleList")
    ComResponse<SalaryFrontLineRuleDto> ruleList(SalaryFrontLineRuleDetailVo salaryFrontLineRuleDetailVo) {
        return salaryFrontLineService.ruleList(salaryFrontLineRuleDetailVo);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则一", notes = "一线管理-薪酬核算规则配置-规则一")
    @PostMapping("/rule1")
    ComResponse<Boolean> rule1(@RequestBody SalaryFrontLineRuleEditVo1 salaryFrontLineRuleEditVo1,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo1.setStaffNo(staffNo);
        return salaryFrontLineService.rule1(salaryFrontLineRuleEditVo1);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则二", notes = "一线管理-薪酬核算规则配置-规则二")
    @PostMapping("/rule2")
    ComResponse<Boolean> rule2(@RequestBody SalaryFrontLineRuleEditVo2 salaryFrontLineRuleEditVo2,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo2.setStaffNo(staffNo);
        return salaryFrontLineService.rule2(salaryFrontLineRuleEditVo2);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则三", notes = "一线管理-薪酬核算规则配置-规则三")
    @PostMapping("/rule3")
    ComResponse<Boolean> rule3(@RequestBody SalaryFrontLineRuleEditVo3 salaryFrontLineRuleEditVo3,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo3.setStaffNo(staffNo);
        return salaryFrontLineService.rule3(salaryFrontLineRuleEditVo3);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则四", notes = "一线管理-薪酬核算规则配置-规则四")
    @PostMapping("/rule4")
    ComResponse<Boolean> rule4(@RequestBody SalaryFrontLineRuleEditVo4 salaryFrontLineRuleEditVo4,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo4.setStaffNo(staffNo);
        return salaryFrontLineService.rule4(salaryFrontLineRuleEditVo4);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则六", notes = "一线管理-薪酬核算规则配置-规则六")
    @PostMapping("/rule6")
    ComResponse<Boolean> rule6(@RequestBody SalaryFrontLineRuleEditVo6 salaryFrontLineRuleEditVo6,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo6.setStaffNo(staffNo);
        return salaryFrontLineService.rule6(salaryFrontLineRuleEditVo6);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则七/八", notes = "一线管理-薪酬核算规则配置-规则七/八")
    @PostMapping("/rule7")
    ComResponse<Boolean> rule7(@RequestBody SalaryFrontLineRuleEditVo7 salaryFrontLineRuleEditVo7,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo7.setStaffNo(staffNo);
        return salaryFrontLineService.rule7(salaryFrontLineRuleEditVo7);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-规则九", notes = "一线管理-薪酬核算规则配置-规则九")
    @PostMapping("/rule9")
    ComResponse<Boolean> rule9(@RequestBody SalaryFrontLineRuleEditVo9 salaryFrontLineRuleEditVo9,@ApiIgnore @CurrentStaffNo String staffNo) {
        salaryFrontLineRuleEditVo9.setStaffNo(staffNo);
        return salaryFrontLineService.rule9(salaryFrontLineRuleEditVo9);
    }

    @ApiOperation(value = "获取部门下一线岗位列表", notes = "获取部门下一线岗位列表")
    @RequestMapping(value = "/getListByDepartId", method = RequestMethod.GET)
    public ComResponse<List<SalaryRuleDepartPostDto>> getListByDepartId(@RequestParam("departId") Integer departId, @RequestParam("ruleType") Integer ruleType) {
        return salaryFrontLineService.getListByDepartId(departId,ruleType);
    }

    @ApiOperation(value = "一线管理-薪酬核算规则配置-设置规则对应岗位", notes = "一线管理-薪酬核算规则配置-设置规则对应岗位")
    @PostMapping("/ruleDepartPostConfig")
    ComResponse<Boolean> ruleDepartPostConfig(@RequestBody SalaryRulePostVo salaryRulePostVo) {
        return salaryFrontLineService.ruleDepartPostConfig(salaryRulePostVo);
    }
}
