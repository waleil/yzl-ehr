package cn.net.yzl.ehr.controller.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.staff.StaffPasswordRuleFeginService;
import cn.net.yzl.staff.dto.staff.StaffPasswordRuleDto;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.staff.StaffPasswordRuleInsertVO;
import cn.net.yzl.staff.vo.staff.StaffPasswordRuleParams;
import cn.net.yzl.staff.vo.staff.StaffPasswordRuleUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/StaffPasswordRule")
@Api(value = "密码规则配置", tags = {"系统管理"})
public class StaffPasswordRuleController {

    @Autowired
    private StaffPasswordRuleFeginService staffPasswordRuleFeginService;

    @ApiOperation(value = "密码规则配置列表", notes = "密码规则配置列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStaffPasswordRulePage", method = RequestMethod.POST)
    ComResponse<Page<StaffPasswordRuleDto>> getStaffPasswordRulePage(@RequestBody
                                                                             StaffPasswordRuleParams staffPasswordRuleParams) throws IllegalAccessException {
        staffPasswordRuleParams = StaffBeanUtils.setNullValue(staffPasswordRuleParams);
        return staffPasswordRuleFeginService.getStaffPasswordRulePage(staffPasswordRuleParams);
    }

    @ApiOperation(value = "密码规则配置-启用/停用", notes = "密码规则配置-启用/停用", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/enable", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "密码规则id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "enable", value = "0:停用,1:开启", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<String> enable(@RequestParam("id") @NotNull Integer id,@RequestParam("enable") @NotNull @Min(0) Integer enable) throws IllegalAccessException {
        return staffPasswordRuleFeginService.enable(id,enable);
    }
    @ApiOperation(value = "密码规则配置-删除", notes = "密码规则配置-删除", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "密码规则id", required = true, dataType = "Int", paramType = "query"),
    })
    ComResponse<String> del(@RequestParam("id") @NotNull Integer id) throws IllegalAccessException {
        return staffPasswordRuleFeginService.del(id);
    }


    @ApiOperation(value = "密码规则配置-新增", notes = "密码规则配置-新增", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/create", method = RequestMethod.POST)

    ComResponse<String> create(@RequestBody StaffPasswordRuleInsertVO staffPasswordRuleInsertVO, @ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        staffPasswordRuleInsertVO.setCreator(staffNo);
        staffPasswordRuleInsertVO.setUpdator(staffNo);
        return staffPasswordRuleFeginService.create(staffPasswordRuleInsertVO);
    }

    @ApiOperation(value = "密码规则配置-编辑", notes = "密码规则配置-编辑", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)

    ComResponse<String> update(@RequestBody StaffPasswordRuleUpdateVO staffPasswordRuleUpdateVO, @ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        staffPasswordRuleUpdateVO.setUpdator(staffNo);
        return staffPasswordRuleFeginService.update(staffPasswordRuleUpdateVO);
    }
}
