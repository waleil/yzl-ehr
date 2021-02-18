package cn.net.yzl.ehr.service.achievements;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.achievements.AchievementsConfigureDto;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureListVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureSaveVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureUpdateVo;

import java.util.List;

public interface AchievementsConfigureService {

    ComResponse<Page<AchievementsConfigureDto>> list(AchievementsConfigureListVo achievementsConfigureListVo);

    ComResponse<Boolean> save(List<AchievementsConfigureSaveVo> request,String currentStaffNo);

    ComResponse<Boolean> update(List<AchievementsConfigureUpdateVo> request,String currentStaffNo);
}
