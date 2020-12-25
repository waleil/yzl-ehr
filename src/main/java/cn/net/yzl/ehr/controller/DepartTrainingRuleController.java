package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.pojo.DepartTrainingRulePo;
import cn.net.yzl.ehr.pojo.DepartTrainingRuleUpdatePo;
import cn.net.yzl.ehr.service.DepartTrainingRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conf/training")
@Api(value = "培训配置服务", tags = {"培训配置服务"})
public class DepartTrainingRuleController {
    @Autowired
    private DepartTrainingRuleService departTrainingRuleService;


    @ApiOperation(value = "新增培训", notes = "新增培训", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody @Validated DepartTrainingRulePo departTrainingRulePo) {
        return departTrainingRuleService.add(departTrainingRulePo);
    }

    @ApiOperation(value = "展示培训配置", notes = "展示培训配置", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getDepartTraininRuleById", method = RequestMethod.GET)
     ComResponse<List<DepartTrainingRuleDto>> getDepartTraininRuleById(Integer departId){
        return   departTrainingRuleService.getDepartTraininRuleById(departId);
    }


    @ApiOperation(value = "删除培训", notes = "删除培训", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    ComResponse<Integer> deleteDepartTrainingRuleById(Integer id) {
        return departTrainingRuleService.deleteDepartTrainingRuleById(id);
    }

    @ApiOperation(value = "获取培训信息", notes = "获取培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
     ComResponse<DepartTrainingRuleDto> getPostById(Integer id) {
        return  departTrainingRuleService.getPostById(id);
    }

    @ApiOperation(value = "更新培训信息", notes = "更新培训信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> updatePost(@RequestBody @Validated DepartTrainingRuleUpdatePo departTrainingRulePo) {
        return departTrainingRuleService.updatePost(departTrainingRulePo);
    }
}
