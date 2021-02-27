package cn.net.yzl.ehr.controller.salaryRule;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.salaryRule.PerformanceProportionConfigurationFeginService;
import cn.net.yzl.staff.dto.salaryRule.PerformanceProportionConfigurationListDto;
import cn.net.yzl.staff.pojo.salaryRule.PerformanceProportionConfigurationPo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationDelVo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationListVo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationSaveVo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationUpdateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author
 * @Date 2021/2/22
 * @Description
 */
@RestController
@RequestMapping("/performanceProportionConfiguration")
@Api(value = "职能管理-绩效比例配置", tags = {"职能管理-绩效比例配置"})
public class PerformanceProportionConfigurationController {

    @Autowired
    private PerformanceProportionConfigurationFeginService performanceProportionConfigurationFeginService;


    @ApiOperation(value = "职能管理-绩效比例配置-列表", notes = "职能管理-绩效比例配置-列表")
    @PostMapping("/list")
    ComResponse<Page<PerformanceProportionConfigurationListDto>> list(@RequestBody PerformanceProportionConfigurationListVo request) {
        return performanceProportionConfigurationFeginService.getPerformanceProportionList(request);
    }

    @ApiOperation(value = "职能管理-绩效比例配置-保存", notes = "职能管理-绩效比例配置-保存")
    @PostMapping("/save")
    ComResponse<Boolean> save(@RequestBody PerformanceProportionConfigurationSaveVo request) {
        return performanceProportionConfigurationFeginService.save(request);
    }

    @ApiOperation(value = "职能管理-绩效比例配置-更新", notes = "职能管理-绩效比例配置-更新")
    @PostMapping("/update")
    ComResponse<Boolean> update(@RequestBody PerformanceProportionConfigurationUpdateVo request) {
        return performanceProportionConfigurationFeginService.update(request);
    }

    @ApiOperation(value = "职能管理-绩效比例配置-删除", notes = "职能管理-绩效比例配置-删除")
    @PostMapping("/del")
    ComResponse<Boolean> del(@RequestBody PerformanceProportionConfigurationDelVo request) {
        return performanceProportionConfigurationFeginService.del(request);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Integer", paramType = "query"),
    })
    @ApiOperation(value = "职能管理-绩效比例配置-详情", notes = "职能管理-绩效比例配置-详情")
    @GetMapping("/show")
    ComResponse<PerformanceProportionConfigurationPo> show(Integer departId) {
        return performanceProportionConfigurationFeginService.show(departId);
    }
}
