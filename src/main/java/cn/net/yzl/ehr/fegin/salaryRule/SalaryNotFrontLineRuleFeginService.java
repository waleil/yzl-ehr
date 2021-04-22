package cn.net.yzl.ehr.fegin.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.salaryRule.SalaryFrontLineRuleDto;
import cn.net.yzl.staff.dto.salaryRule.SalaryRuleDepartPostDto;
import cn.net.yzl.staff.vo.salaryRule.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "yzl-staff-db",url = "${fegin.db.url}/salaryNotFrontLineRule")
public interface SalaryNotFrontLineRuleFeginService {


    @RequestMapping(value = "/getListByDepartId", method = RequestMethod.GET)
    ComResponse<List<SalaryRuleDepartPostDto>> getListByDepartId(@RequestParam("departId") Integer departId, @RequestParam("ruleType") Integer ruleType);

    @PostMapping("/ruleDepartPostConfig")
    ComResponse<Boolean> ruleDepartPostConfig(@RequestBody SalaryRulePostVo salaryRulePostVo);
}
