package cn.net.yzl.ehr.fegin.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleElement;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryRulePostListDto;
import cn.net.yzl.staff.dto.salaryRule.SalaryRuleDepartPostDto;
import cn.net.yzl.staff.util.ValidList;
import cn.net.yzl.staff.vo.salaryRule.AddSalaryRulePostVo;
import cn.net.yzl.staff.vo.salaryRule.DeleteSalaryRulePostVo;
import cn.net.yzl.staff.vo.salaryRule.SalaryRulePostQueryVo;
import cn.net.yzl.staff.vo.salaryRule.SalaryRulePostVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 岗位薪酬规则配置服务
 *
 * @author biebaojie
 */
//@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/salaryRulePost")
@FeignClient(value = "yzl-staff-db", url = "http://localhost:38080/salaryRulePost")
public interface SalaryRulePostFeignService {

    /**
     * 查询部门下所有岗位（是否已选中）
     */
    @RequestMapping(value = "/getSelectedPostByDepartId", method = RequestMethod.GET)
    ComResponse<List<SalaryRuleDepartPostDto>> getSelectedPostByDepartId(@RequestParam("departId") Integer departId);

    /**
     * 添加岗位
     */
    @PostMapping("/add")
    ComResponse<Boolean> addDepartPost(@RequestBody ValidList<SalaryRulePostVo> rulePostList);

    /**
     * 岗位规则列表
     */
    @GetMapping("/getSalaryRulePostList")
    ComResponse<Page<SalaryRulePostListDto>> getSalaryRulePostList(@SpringQueryMap SalaryRulePostQueryVo ruleVo);

    /**
     * 薪酬规则详情
     */
    @GetMapping("/getSalaryRulePostContent")
    ComResponse<SalaryFrontLineRuleElement> getPostSalaryRuleContent(@RequestParam("busNo") Long busNo);

    /**
     * 配置规则
     */
    @PostMapping("/addPostSalaryRule")
    ComResponse<Boolean> addSalaryRulePost(@RequestBody AddSalaryRulePostVo salaryRulePostVo);

    /**
     * 编辑规则
     */
    @PostMapping("/updateSalaryRulePost")
    ComResponse<Boolean> updateSalaryRulePost(@RequestBody AddSalaryRulePostVo salaryRulePostVo);

    /**
     * 删除岗位规则
     */
    @PostMapping("/deletePostSalaryRule")
    ComResponse<Boolean> deleteSalaryRulePost(@RequestBody DeleteSalaryRulePostVo deleteSalaryRulePostVo);
}
