package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.service.DepartTrainingRuleService;
import cn.net.yzl.ehr.vo.DepartTrainingRulePo;
import cn.net.yzl.ehr.vo.DepartTrainingRuleUpdatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/conf/training")
@Api(value = "配置模块", tags = {"配置模块-岗位培训"})
public class DepartTrainingRuleController {
    @Autowired
    private DepartTrainingRuleService departTrainingRuleService;



    @ApiOperation(value = "新增岗位培训配置", notes = "新增岗位培训配置", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody @Validated DepartTrainingRulePo departTrainingRulePo, @CurrentStaffNo @ApiIgnore String staffNo) {
        departTrainingRulePo.setCreator(staffNo);
        return departTrainingRuleService.add(departTrainingRulePo);
    }


    @ApiOperation(value = "获取部门的培训配置列表", notes = "获取部门的培训配置列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true,  paramType = "query")
    })
    public ComResponse<List<DepartTrainingRuleDto>> getDepartTraininRuleById(@RequestBody @NotNull @Min(0) Integer departId){
        return   departTrainingRuleService.getByDepartId(departId);
    }


    @ApiOperation(value = "删除培训配置", notes = "删除培训配置", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "配置id", required = true,  paramType = "query"),
    })
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    ComResponse<Integer> deleteById( @NotNull @Min(0) Integer id,@CurrentStaffNo @ApiIgnore String updator) {
        return departTrainingRuleService.deleteById(id,updator);
    }

    @ApiOperation(value = "用配置id获取培训信息", notes = "获取培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "配置id", required = true, paramType ="query")
    })
    public ComResponse<DepartTrainingRuleDto> getById( @NotNull @Min(0) Integer id) {
        return  departTrainingRuleService.getById(id);
    }

    @ApiOperation(value = "更新培训信息", notes = "更新培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody @Validated DepartTrainingRuleUpdatePo departTrainingRulePo, @CurrentStaffNo @ApiIgnore String staffNo) {
        departTrainingRulePo.setUpdator(staffNo);
        return departTrainingRuleService.update(departTrainingRulePo);
    }
}
