package cn.net.yzl.ehr.service.impl.appClock;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.appClock.AppClockFeginService;
import cn.net.yzl.ehr.service.appClock.AppStaffClockLogService;
import cn.net.yzl.staff.app.clock.dto.*;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockLogVO;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author
 * @Date 2021/4/8
 * @Description
 */
@Service
@Slf4j
public class AppStaffClockLogServiceImpl implements AppStaffClockLogService {

    @Autowired
    private AppClockFeginService appClockFeginService;


    @Override
    public ComResponse<List<AppStaffClockLogBetweenDTO>> staffClockLog(AppStaffClockLogVO appStaffClockLogVO) {
        ComResponse<List<AppStaffClockLogBetweenDTO>> result = appClockFeginService.staffClockLog(appStaffClockLogVO);
        return result;
    }

    @Override
    public ComResponse<AppStaffClockLogDTO> initStaffClock(String staffNo) {
        ComResponse<AppStaffClockLogDTO> result = appClockFeginService.initStaffClock(staffNo);
        return result;
    }

    @Override
    public ComResponse<Date> staffClock(AppStaffClockVO appStaffClockVO) {
        ComResponse<Date> result = appClockFeginService.staffClock(appStaffClockVO);
        return result;
    }

    @Override
    public ComResponse<AppStaffClockDayStatisticsDTO> staffClockLogDay(AppStaffClockLogVO appStaffClockLogVO) {
        ComResponse<AppStaffClockDayStatisticsDTO> result = appClockFeginService.staffClockLogDay(appStaffClockLogVO);
        return result;
    }

    @Override
    public ComResponse<AppStaffAttendStatisticsDTO> staffClockStatistics(AppStaffClockLogVO appStaffClockLogVO) {
        ComResponse<AppStaffAttendStatisticsDTO> result = appClockFeginService.staffClockStatistics(appStaffClockLogVO);
        return result;
    }

    @Override
    public ComResponse<AppStaffClockTimeStatusDTO> getClockStatus(AppStaffClockLogVO appStaffClockLogVO) {
        ComResponse<AppStaffClockTimeStatusDTO> result = appClockFeginService.getClockStatus(appStaffClockLogVO);
        return result;
    }
}
