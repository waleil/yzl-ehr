package cn.net.yzl.ehr.service.appClock;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.app.clock.dto.*;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockLogVO;
import cn.net.yzl.staff.app.clock.vo.AppStaffClockVO;

import java.util.Date;
import java.util.List;

/**
 * @Author
 * @Date 2021/4/8
 * @Description
 */
public interface AppStaffClockLogService {

    /**
     * 查询指定范围打卡记录
     * @param appStaffClockLogVO
     * @return
     */
    ComResponse<List<AppStaffClockLogBetweenDTO>> staffClockLog(AppStaffClockLogVO appStaffClockLogVO);
    /**
     * 进入打卡页面
     * @param staffNo
     * @return
     */
    ComResponse<AppStaffClockLogDTO> initStaffClock(String staffNo);

    /**
     * 打卡操作
     * @param appStaffClockVO
     * @return
     */
    ComResponse<Date> staffClock(AppStaffClockVO appStaffClockVO);

    /**
     * 指定日期的详细打卡记录
     * @param appStaffClockLogVO
     * @return
     */
    ComResponse<AppStaffClockDayStatisticsDTO> staffClockLogDay(AppStaffClockLogVO appStaffClockLogVO);


    /**
     * 月考勤统计
     * @param appStaffClockLogVO
     * @return
     */
    ComResponse<AppStaffAttendStatisticsDTO> staffClockStatistics(AppStaffClockLogVO appStaffClockLogVO);

    /**
     * 获取打卡状态
     * @param appStaffClockLogVO
     * @return
     */
    ComResponse<AppStaffClockTimeStatusDTO> getClockStatus(AppStaffClockLogVO appStaffClockLogVO);

}
