package cn.net.yzl.ehr.controller.appClock;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.appClock.AppStaffClockLogService;
import cn.net.yzl.staff.app.clock.dto.*;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockLogVO;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/appStaffClockLog")
@Api(value = "移动OA-打卡", tags = {"移动OA-打卡"})
public class AppStaffClockLogController {

    @Autowired
    private AppStaffClockLogService appStaffClockLogService;

    @ApiOperation(value = "初始化打卡页面", notes = "初始化打卡页面")
    @GetMapping("/initStaffClock")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "员工工号", required = true, dataType = "String", paramType = "query")
    })
    ComResponse<AppStaffClockLogDTO> initStaffClock(@RequestParam("staffNo") String staffNo) {
        return appStaffClockLogService.initStaffClock(staffNo);
    }

    @ApiOperation(value = "打卡", notes = "打卡")
    @PostMapping("/staffClock")
    ComResponse<Date> staffClock(@RequestBody AppStaffClockVO appStaffClockVO) {
        return appStaffClockLogService.staffClock(appStaffClockVO);
    }

    @ApiOperation(value = "指定日期内的打卡状态点", notes = "指定日期内的打卡状态点")
    @PostMapping("/staffClockLog")
    ComResponse<List<AppStaffClockLogBetweenDTO>> staffClockLog(@RequestBody AppStaffClockLogVO appStaffClockLogVO) {
        return appStaffClockLogService.staffClockLog(appStaffClockLogVO);
    }

    @ApiOperation(value = "指定日期打卡记录", notes = "指定日期打卡记录")
    @PostMapping("/staffClockLogDay")
    ComResponse<AppStaffClockDayStatisticsDTO> staffClockLogDay(@RequestBody AppStaffClockLogVO appStaffClockLogVO) {
        return appStaffClockLogService.staffClockLogDay(appStaffClockLogVO);
    }

    @ApiOperation(value = "考勤统计", notes = "考勤统计")
    @PostMapping("/staffClockStatistics")
    ComResponse<AppStaffAttendStatisticsDTO> staffClockStatistics(@RequestBody AppStaffClockLogVO appStaffClockLogVO){
        return appStaffClockLogService.staffClockStatistics(appStaffClockLogVO);
    }
    @ApiOperation(value = "查询当前状态接口", notes = "查询当前状态接口")
    @PostMapping("/getClockStatus")
    ComResponse<AppStaffClockTimeStatusDTO> getClockStatus(@RequestBody AppStaffClockLogVO appStaffClockLogVO){
        return appStaffClockLogService.getClockStatus(appStaffClockLogVO);
    }

}
