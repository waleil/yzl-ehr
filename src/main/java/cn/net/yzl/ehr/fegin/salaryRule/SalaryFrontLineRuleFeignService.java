package cn.net.yzl.ehr.fegin.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
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
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 一线管理-薪酬核算规则配置
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/salaryFrontLineRuleNew")
//@FeignClient(value = "yzl-staff-db", url = "http://localhost:38080/salaryFrontLineRuleNew")
public interface SalaryFrontLineRuleFeignService {


    //薪酬规则是否开启（1开启，0关闭）
    @PostMapping("/ruleSwitch")
    ComResponse<Void> ruleSwitch(@RequestBody SalaryRuleSwitch salaryRuleSwitch);

    //查询薪酬规则开关开启状态
    @GetMapping("/ruleOnStatus")
    ComResponse<Integer> ruleOnStatus();

    // 一线管理-薪酬核算规则-规则列表
    @PostMapping("/getSalaryRuleTypeList")
    ComResponse<List<RuleTypeDto>> getRuleTypeList();

    // 查询部门下所有岗位
    @RequestMapping(value = "/getPostByDepartId", method = RequestMethod.GET)
    ComResponse<List<RulePostDto>> getPostByDepartId(@RequestParam("departId") Integer departId,
                                                     @RequestParam("staffType") Integer staffType);

    // 一线管理-薪酬核算规则配置-查看
    @GetMapping("/getRule")
    ComResponse getRule(@RequestParam("ruleType") Integer ruleType);

    // 薪酬规则一
    @PostMapping("/rule1")
    ComResponse<Boolean> rule1(@RequestBody SalaryFrontLineRuleDto1 ruleDto1);

    // 薪酬规则二
    @PostMapping("/rule2")
    ComResponse<Boolean> rule2(@RequestBody SalaryFrontLineRuleDto2 ruleDto2);

    // 薪酬规则三
    @PostMapping("/rule3")
    ComResponse<Boolean> rule3(@RequestBody SalaryFrontLineRuleDto3 ruleDto3);

    // 薪酬规则四
    @PostMapping("/rule4")
    ComResponse<Boolean> rule4(@RequestBody SalaryFrontLineRuleDto4 ruleDto4);

    //核算规则五
    @PostMapping("/rule5")
    ComResponse<Boolean> rule5(@RequestBody SalaryFrontLineRuleDto5 ruleDto5);

    // 薪酬规则六
    @PostMapping("/rule6")
    ComResponse<Boolean> rule6(@RequestBody SalaryFrontLineRuleDto6 ruleDto6);

    //薪酬规则七
    @PostMapping("/rule7")
    ComResponse<Boolean> rule7(@RequestBody SalaryFrontLineRuleDto7 ruleDto7);

    //薪酬规则八
    @PostMapping("/rule8")
    ComResponse<Boolean> rule8(@RequestBody SalaryFrontLineRuleDto7 ruleDto7);

    //薪酬规则九
    @PostMapping("/rule9")
    ComResponse<Boolean> rule9(@RequestBody SalaryFrontLineRuleDto9 ruleDto9);

    //薪酬规则十
    @PostMapping("/rule10")
    ComResponse<Boolean> rule10(@RequestBody SalaryFrontLineRuleDto10 ruleDto10);

    //薪酬规则十一
    @PostMapping("/rule11")
    ComResponse<Boolean> rule11(@RequestBody SalaryFrontLineRuleDto11 ruleDto11);

    //薪酬规则十二
    @PostMapping("/rule12")
    ComResponse<Boolean> rule12(@RequestBody SalaryFrontLineRuleDto12 ruleDto12);

    //薪酬规则十三
    @PostMapping("/rule13")
    ComResponse<Boolean> rule13(@RequestBody SalaryFrontLineRuleDto13 ruleDto13);

    //薪酬规则十四
    @PostMapping("/rule14")
    ComResponse<Boolean> rule14(@RequestBody SalaryFrontLineRuleDto14 ruleDto14);

    //薪酬规则十五
    @PostMapping("/rule15")
    ComResponse<Boolean> rule15(@RequestBody SalaryFrontLineRuleDto15 ruleDto15);

    //薪酬规则十六
    @PostMapping("/rule16")
    ComResponse<Boolean> rule16(@RequestBody SalaryFrontLineRuleDto16 ruleDto16);

    //薪酬规则十七
    @PostMapping("/rule17")
    ComResponse<Boolean> rule17(@RequestBody SalaryFrontLineRuleDto17 ruleDto17);

    //薪酬规则十八
    @PostMapping("/rule18")
    ComResponse<Boolean> rule18(@RequestBody SalaryFrontLineRuleDto18 ruleDto18);

    //薪酬规则十九
    @PostMapping("/rule19")
    ComResponse<Boolean> rule19(@RequestBody SalaryFrontLineRuleDto19 ruleDto19);
}
