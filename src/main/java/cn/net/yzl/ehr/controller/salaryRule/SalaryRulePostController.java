package cn.net.yzl.ehr.controller.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salaryRule.SalaryRulePostFeignService;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryFrontLineRuleElement;
import cn.net.yzl.staff.dto.salaryFrontLineRule.SalaryRulePostListDto;
import cn.net.yzl.staff.dto.salaryRule.SalaryRuleDepartPostDto;
import cn.net.yzl.staff.util.ValidList;
import cn.net.yzl.staff.vo.salaryRule.AddSalaryRulePostVo;
import cn.net.yzl.staff.vo.salaryRule.DeleteSalaryRulePostVo;
import cn.net.yzl.staff.vo.salaryRule.SalaryRulePostQueryVo;
import cn.net.yzl.staff.vo.salaryRule.SalaryRulePostVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
 * 岗位薪酬规则配置
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/salaryRulePost")
@Api(value = "一线管理-薪酬核算规则-岗位薪酬规则配置", tags = {"一线管理-薪酬核算规则-岗位薪酬规则配置"})
public class SalaryRulePostController {

    @Autowired
    private SalaryRulePostFeignService salaryRulePostFeignService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Integer", paramType = "query")
    })
    @ApiOperation(value = "查询部门下所有岗位（是否已选中）", notes = "查询部门下所有岗位（是否已选中）")
    @RequestMapping(value = "/getSelectedPostByDepartId", method = RequestMethod.GET)
    public ComResponse<List<SalaryRuleDepartPostDto>> getSelectedPostByDepartId(@RequestParam("departId") Integer departId) {
        return salaryRulePostFeignService.getSelectedPostByDepartId(departId);
    }


    @ApiOperation(value = "添加岗位", notes = "添加岗位")
    @PostMapping("/add")
    public ComResponse<Boolean> add(@RequestBody @Validated ValidList<SalaryRulePostVo> rulePostList) {
        return salaryRulePostFeignService.addDepartPost(rulePostList);
    }

    @ApiOperation(value = "岗位规则列表", notes = "岗位规则列表")
    @GetMapping("/getSalaryRulePostList")
    public ComResponse<Page<SalaryRulePostListDto>> getSalaryRulePostList(SalaryRulePostQueryVo ruleVo) {
        if (ruleVo.getPageNo() == null) {
            return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "pageNo不能为空");
        }
        if (ruleVo.getPageSize() == null) {
            return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), "pageSize不能为空");
        }
        return salaryRulePostFeignService.getSalaryRulePostList(ruleVo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "busNo", value = "业务编号", required = true, dataType = "Long", paramType = "query")
    })
    @ApiOperation(value = "薪酬规则详情", notes = "薪酬规则详情")
    @GetMapping("/getSalaryRulePostContent")
    public ComResponse getSalaryRulePostContent(@RequestParam("busNo") Long busNo) {
        return salaryRulePostFeignService.getPostSalaryRuleContent(busNo);
    }

    @ApiOperation(value = "配置规则", notes = "配置规则")
    @PostMapping("/addPostSalaryRule")
    public ComResponse<Boolean> addSalaryRulePost(@RequestBody @Validated AddSalaryRulePostVo salaryRulePostVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryRulePostVo.setStaffNo(staffNo);
        return salaryRulePostFeignService.addSalaryRulePost(salaryRulePostVo);
    }

    @ApiOperation(value = "编辑规则", notes = "编辑规则")
    @PostMapping("/updateSalaryRulePost")
    public ComResponse<Boolean> updateSalaryRulePost(@RequestBody @Validated AddSalaryRulePostVo salaryRulePostVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryRulePostVo.setStaffNo(staffNo);
        return salaryRulePostFeignService.updateSalaryRulePost(salaryRulePostVo);
    }

    @ApiOperation(value = "删除岗位规则", notes = "删除岗位规则")
    @PostMapping("/deletePostSalaryRule")
    public ComResponse<Boolean> deleteSalaryRulePost(@RequestBody @Validated DeleteSalaryRulePostVo deleteSalaryRulePostVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        deleteSalaryRulePostVo.setStaffNo(staffNo);
        return salaryRulePostFeignService.deleteSalaryRulePost(deleteSalaryRulePostVo);
    }
}
