package cn.net.yzl.ehr.controller.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salaryRule.SalaryNotFrontLineRuleFeginService;
import cn.net.yzl.staff.dto.salaryRule.SalaryRuleDepartPostDto;
import cn.net.yzl.staff.vo.salaryRule.SalaryRulePostVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * 职能管理-薪酬核算规则
 */
@RestController
@RequestMapping("/salaryNotFrontLineRule")
@Api(value = "职能管理-薪酬核算规则", tags = {"职能管理-薪酬核算规则"})
public class SalaryNotFrontLineRuleController {
    @Autowired
    private SalaryNotFrontLineRuleFeginService salaryNotFrontLineRuleFeginService;

    @ApiOperation(value = "获取部门下非一线岗位列表", notes = "获取部门下非一线岗位列表")
    @RequestMapping(value = "/getListByDepartId", method = RequestMethod.GET)
    public ComResponse<List<SalaryRuleDepartPostDto>> getListByDepartId(@RequestParam("departId") Integer departId, @RequestParam("ruleType") Integer ruleType) {
        return salaryNotFrontLineRuleFeginService.getListByDepartId(departId, ruleType);
    }

    @ApiOperation(value = "职能管理-薪酬核算规则配置-设置规则对应岗位", notes = "职能管理-薪酬核算规则配置-设置规则对应岗位")
    @PostMapping("/ruleDepartPostConfig")
    public ComResponse<Boolean> ruleDepartPostConfig(@ApiIgnore @CurrentStaffNo String staffNo, @RequestBody SalaryRulePostVo salaryRulePostVo) {
        salaryRulePostVo.setCreator(staffNo);
        return salaryNotFrontLineRuleFeginService.ruleDepartPostConfig(salaryRulePostVo);
    }
}
