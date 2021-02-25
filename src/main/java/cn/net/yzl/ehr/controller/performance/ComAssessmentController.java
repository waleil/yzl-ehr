package cn.net.yzl.ehr.controller.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.performance.ComAssessmentFeginService;
import cn.net.yzl.staff.dto.achievements.StaffArchiveDto;
import cn.net.yzl.staff.dto.salaryRule.PerforProConfDepartTreeDto;
import cn.net.yzl.staff.vo.BiStaffTargetTaskVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 职能管理-绩效
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/assessment")
@Api(value = "提成考核", tags = {"提成考核"})
public class ComAssessmentController {


    @Autowired
    private ComAssessmentFeginService comAssessmentFeginService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "undertakStaffCode", value = "承接任务员工编号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "taskCycleTime", value = "任务周期yyyy-MM", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "isPerformance", value = "是否作为绩效考核  (1:是 0:否)", dataType = "String", paramType = "query"),
    })
    @ApiOperation(value = "获取员工完成任务目标情况列表", notes = "获取员工完成任务目标情况列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getBiStaffTargetTaskSettingList", method = RequestMethod.GET)
    ComResponse<BiStaffTargetTaskVO> getBiStaffTargetTaskSettingList(@RequestParam(name = "undertakStaffCode") String undertakStaffCode,
                                                                     @RequestParam(name = "taskCycleTime") String taskCycleTime,
                                                                     @RequestParam(name = "isPerformance",required = false) Integer isPerformance){
        return  comAssessmentFeginService.getBiStaffTargetTaskSettingList(undertakStaffCode, taskCycleTime, isPerformance);


    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "考核时间(yyyy-MM)", dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "提成考核-组织架构树", notes = "提成考核-组织架构树", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPerforProConfDepartTree", method = RequestMethod.GET)
    ComResponse<PerforProConfDepartTreeDto> getPerforProConfDepartTree(@CurrentStaffNo @ApiIgnore String staffNo,
                                                                       @RequestParam(name = "time")  String time) throws ParseException {

        return comAssessmentFeginService.getPerforProConfDepartTree(staffNo,time);

    }

    @RequestMapping(value = "/getStaffArchievementsByDepartId", method = RequestMethod.GET)
    ComResponse<List<StaffArchiveDto>> getStaffArchievementsByDepartId(@RequestParam(name = "departId") Integer departId,
                                                                       @RequestParam(name = "time") String time) throws ParseException {

        return comAssessmentFeginService.getStaffArchievementsByDepartId(departId,time);

    }

}
