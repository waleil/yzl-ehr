package cn.net.yzl.ehr.fegin.appClock;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.app.clock.dto.*;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockLogVO;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockVO;
import cn.net.yzl.staff.pojo.AppClockRangeConfPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface AppClockFeginService {

    @ApiOperation(value = "初始化打卡页面", notes = "初始化打卡页面", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/appStaffClockLog/initStaffClock", method = RequestMethod.GET)
    ComResponse<AppStaffClockLogDTO> initStaffClock(@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "打卡", notes = "打卡", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/appStaffClockLog/staffClock", method = RequestMethod.POST)
    ComResponse<Date> staffClock(@RequestBody AppStaffClockVO appStaffClockVO);

    @ApiOperation(value = "指定日期内的打卡状态点", notes = "指定日期内的打卡状态点", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/appStaffClockLog/staffClockLog", method = RequestMethod.POST)
    ComResponse<List<AppStaffClockLogBetweenDTO>> staffClockLog(@RequestBody AppStaffClockLogVO appStaffClockLogVO);

    @ApiOperation(value = "指定日期打卡记录", notes = "指定日期打卡记录")
    @RequestMapping(value = "/appStaffClockLog/staffClockLogDay", method = RequestMethod.POST)
    ComResponse<AppStaffClockDayStatisticsDTO> staffClockLogDay(@RequestBody AppStaffClockLogVO appStaffClockLogVO);

    @ApiOperation(value = "考勤统计", notes = "考勤统计")
    @RequestMapping(value = "/appStaffClockLog/staffClockStatistics", method = RequestMethod.POST)
    ComResponse<AppStaffAttendStatisticsDTO> staffClockStatistics(@RequestBody AppStaffClockLogVO appStaffClockLogVO);

    @ApiOperation(value = "查询当前状态接口", notes = "查询当前状态接口")
    @RequestMapping(value = "/appStaffClockLog/getClockStatus", method = RequestMethod.POST)
    ComResponse<AppStaffClockTimeStatusDTO> getClockStatus(@RequestBody AppStaffClockLogVO appStaffClockLogVO);
}
