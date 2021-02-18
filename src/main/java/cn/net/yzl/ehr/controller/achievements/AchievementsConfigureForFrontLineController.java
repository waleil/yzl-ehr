package cn.net.yzl.ehr.controller.achievements;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.achievements.AchievementsConfigureService;
import cn.net.yzl.staff.dto.achievements.AchievementsConfigureDto;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureListVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureSaveVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureUpdateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


@RequestMapping(value="/AchievementsConfigureForFrontLine")
@RestController
@Api(value = "一线管理-绩效系数配置", tags = {"一线管理-绩效系数配置"})
public class AchievementsConfigureForFrontLineController {

    @Autowired
    private AchievementsConfigureService achievementsConfigureService;


    //列表页
    @ApiOperation(value = "绩效系数配置-列表", notes = "绩效系数配置-列表")
    @PostMapping("/list")
    ComResponse<Page<AchievementsConfigureDto>> list(@RequestBody AchievementsConfigureListVo request) {
        return achievementsConfigureService.list(request);
    }

    //保存
    @ApiOperation(value = "绩效系数配置-保存", notes = "绩效系数配置-保存")
    @PostMapping("/save")
    ComResponse<Boolean> save(@ApiIgnore @CurrentStaffNo String currentStaffNo,@RequestBody List<AchievementsConfigureSaveVo> request) {
        request.stream().forEach(vo->{
            vo.setStaffType(1);
        });
        return achievementsConfigureService.save(request,currentStaffNo);
    }
    //更新
    @ApiOperation(value = "绩效系数配置-更新", notes = "绩效系数配置-更新")
    @PostMapping("/update")
    ComResponse<Boolean> update(@ApiIgnore @CurrentStaffNo String currentStaffNo,@RequestBody List<AchievementsConfigureUpdateVo> request) {
        request.stream().forEach(vo->{
            vo.setStaffType(1);
        });
        return achievementsConfigureService.update(request,currentStaffNo);
    }
}
