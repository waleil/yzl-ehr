package cn.net.yzl.ehr.fegin.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.achievements.StaffArchiveDto;
import cn.net.yzl.staff.dto.salaryRule.PerforProConfDepartTreeDto;
import cn.net.yzl.staff.vo.BiStaffTargetTaskVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 职能管理-绩效
 *
 * @author biebaojie
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/assessment")
public interface ComAssessmentFeginService {


    @RequestMapping(value = "/getBiStaffTargetTaskSettingList", method = RequestMethod.GET)
    ComResponse<BiStaffTargetTaskVO> getBiStaffTargetTaskSettingList(@RequestParam(name = "undertakStaffCode") String undertakStaffCode,
                                                                     @RequestParam(name = "taskCycleTime") String taskCycleTime,
                                                                     @RequestParam(name = "isPerformance", required = false) Integer isPerformance,
                                                                     @RequestParam(name = "fromPage", required = false) String fromPage,
                                                                     @RequestParam(name = "staffNo") String staffNo);

    @RequestMapping(value = "/getPerforProConfDepartTree", method = RequestMethod.GET)
    ComResponse<PerforProConfDepartTreeDto> getPerforProConfDepartTree(@RequestParam("staffNo") String staffNo,
                                                                       @RequestParam(name = "time") String time);

    @RequestMapping(value = "/getStaffArchievementsByDepartId", method = RequestMethod.GET)
    ComResponse<List<StaffArchiveDto>> getStaffArchievementsByDepartId(@RequestParam("departId") Integer departId, @RequestParam("time") String time);
}
