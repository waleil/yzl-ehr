package cn.net.yzl.ehr.service.impl.achievements;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.achievements.AchievementsConfigureFeginService;
import cn.net.yzl.ehr.service.achievements.AchievementsConfigureService;
import cn.net.yzl.staff.dto.achievements.AchievementsConfigureDto;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureListVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureSaveVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureUpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AchievementsConfigureServiceImpl implements AchievementsConfigureService {

    @Autowired
    private AchievementsConfigureFeginService achievementsConfigureFeginService;

    @Override
    public ComResponse<Page<AchievementsConfigureDto>> list(AchievementsConfigureListVo request) {

        return achievementsConfigureFeginService.list(request);
    }

    @Override
    public ComResponse<Boolean> save(List<AchievementsConfigureSaveVo> request ,String currentStaffNo) {
        request.stream().forEach(vo->{
            vo.setCreator(currentStaffNo);
        });
        return achievementsConfigureFeginService.save(request);
    }

    @Override
    public ComResponse<Boolean> update(List<AchievementsConfigureUpdateVo> request ,String currentStaffNo) {
        request.stream().forEach(vo->{
            vo.setCreator(currentStaffNo);
            vo.setUpdator(currentStaffNo);
        });
        return  achievementsConfigureFeginService.update(request);
    }
}
