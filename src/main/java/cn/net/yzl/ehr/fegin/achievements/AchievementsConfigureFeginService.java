package cn.net.yzl.ehr.fegin.achievements;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;

import cn.net.yzl.staff.dto.achievements.AchievementsConfigureDto;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureListVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureSaveVo;
import cn.net.yzl.staff.vo.achievements.AchievementsConfigureUpdateVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "AchievementsConfigureFeginService",url = "${fegin.db.url}/achievementsConfigure")
//@FeignClient(value = "AchievementsConfigureFeginService",url = "http://127.0.0.1:38080/achievementsConfigure")
public interface AchievementsConfigureFeginService {

    @PostMapping("/list")
    ComResponse<Page<AchievementsConfigureDto>> list(AchievementsConfigureListVo achievementsConfigureListVo);
    @PostMapping("/save")
    ComResponse<Boolean> save(List<AchievementsConfigureSaveVo> request);

    @PostMapping("/update")
    ComResponse<Boolean> update(List<AchievementsConfigureUpdateVo> request);
}
