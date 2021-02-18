package cn.net.yzl.ehr.controller.achievements;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.achievements.PerformanceAuditConfigurationService;
import cn.net.yzl.staff.dto.achievements.PerformanceAuditConfigurationDto;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationDetailVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationSaveVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationUpdateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RequestMapping(value="/performanceAuditConfigurationForFunc")
@RestController
@Api(value = "职能管理-绩效配置审核", tags = {"职能管理-绩效配置审核"})
public class PerformanceAuditConfigurationForFuncController {

    @Autowired
    private PerformanceAuditConfigurationService performanceAuditConfigurationService;


    //保存
    @ApiOperation(value = "绩效配置-保存", notes = "绩效配置-保存")
    @PostMapping("/save")
    ComResponse<Boolean> save(@ApiIgnore @CurrentStaffNo String currentStaffNo, @RequestBody PerformanceAuditConfigurationSaveVo request) {
        request.setCreator(currentStaffNo);
        request.setStaffType(2);
        return performanceAuditConfigurationService.save(request);
    }
    //更新
    @ApiOperation(value = "绩效配置-更新", notes = "绩效配置-更新")
    @PostMapping("/update")
    ComResponse<Boolean> update(@ApiIgnore @CurrentStaffNo String currentStaffNo,@RequestBody PerformanceAuditConfigurationUpdateVo request) {
        request.setCreator(currentStaffNo);
        request.setUpdator(currentStaffNo);
        request.setStaffType(2);
        return performanceAuditConfigurationService.update(request);
    }

    //根据部门ID获取详情
    @ApiOperation(value = "绩效配置详情-根据部门ID获取详情", notes = "绩效配置详情-根据部门ID获取详情")
    @PostMapping("/getByDepartId")
    ComResponse<PerformanceAuditConfigurationDto> getById(@RequestBody PerformanceAuditConfigurationDetailVo request) {
        request.setStaffType(2);
        return performanceAuditConfigurationService.getById(request);
    }
}
