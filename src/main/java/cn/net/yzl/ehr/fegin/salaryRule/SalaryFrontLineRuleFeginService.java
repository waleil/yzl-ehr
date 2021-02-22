package cn.net.yzl.ehr.fegin.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.salaryRule.SalaryFrontLineRuleDto;
import cn.net.yzl.staff.dto.salaryRule.SalaryRuleDepartPostDto;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleDetailVo;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo1;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo2;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo3;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo4;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo5;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo6;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo7;
import cn.net.yzl.staff.vo.salaryRule.SalaryFrontLineRuleEditVo9;
import cn.net.yzl.staff.vo.salaryRule.SalaryRulePostVo;
import cn.net.yzl.staff.vo.salaryRule.SalaryRuleSwitch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "SalaryFrontLineRuleFeginService",url = "${fegin.db.url}/salaryFrontLineRule")
//@FeignClient(value = "SalaryFrontLineRuleFeginService",url = "http://localhost:38080/salaryFrontLineRule")
public interface SalaryFrontLineRuleFeginService {


    @PostMapping("/ruleList")
    ComResponse<SalaryFrontLineRuleDto> ruleList(@RequestBody SalaryFrontLineRuleDetailVo salaryFrontLineRuleDetailVo);

    @PostMapping("/rule1")
    ComResponse<Boolean> rule1(@RequestBody SalaryFrontLineRuleEditVo1 salaryFrontLineRuleEditVo1);

    @PostMapping("/rule2")
    ComResponse<Boolean> rule2(@RequestBody SalaryFrontLineRuleEditVo2 salaryFrontLineRuleEditVo2);

    @PostMapping("/rule3")
    ComResponse<Boolean> rule3(@RequestBody SalaryFrontLineRuleEditVo3 salaryFrontLineRuleEditVo3);

    @PostMapping("/rule4")
    ComResponse<Boolean> rule4(@RequestBody SalaryFrontLineRuleEditVo4 salaryFrontLineRuleEditVo4);

    @PostMapping("/rule6")
    ComResponse<Boolean> rule6(@RequestBody SalaryFrontLineRuleEditVo6 salaryFrontLineRuleEditVo6);

    @PostMapping("/rule7")
    ComResponse<Boolean> rule7(@RequestBody SalaryFrontLineRuleEditVo7 salaryFrontLineRuleEditVo7);

    @PostMapping("/rule8")
    ComResponse<Boolean> rule8(@RequestBody SalaryFrontLineRuleEditVo7 salaryFrontLineRuleEditVo7);

    @PostMapping("/rule9")
    ComResponse<Boolean> rule9(@RequestBody SalaryFrontLineRuleEditVo9 salaryFrontLineRuleEditVo9);

    @RequestMapping(value = "/getListByDepartId", method = RequestMethod.GET)
    ComResponse<List<SalaryRuleDepartPostDto>> getListByDepartId(@RequestParam("departId") Integer departId, @RequestParam("ruleType") Integer ruleType);

    @PostMapping("/ruleDepartPostConfig")
    ComResponse<Boolean> ruleDepartPostConfig(@RequestBody SalaryRulePostVo salaryRulePostVo);


    @PostMapping("/ruleSwitch")
    ComResponse<Void> ruleSwitch(@RequestBody SalaryRuleSwitch salaryRuleSwitch);

    @PostMapping("/rule5")
    ComResponse<Boolean> rule5(SalaryFrontLineRuleEditVo5 salaryFrontLineRuleEditVo5);
}
