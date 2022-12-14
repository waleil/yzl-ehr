package cn.net.yzl.ehr.fegin.attend;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.attend.StaffAttendAccountDto;
import cn.net.yzl.staff.dto.attend.StaffAttendDayDto;
import cn.net.yzl.staff.dto.attend.StaffAttendImportResultDto;
import cn.net.yzl.staff.dto.attend.StaffAttendListDto;
import cn.net.yzl.staff.dto.attend.StaffAttendScheduleDto;
import cn.net.yzl.staff.vo.attend.StaffAttendParamsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/saffAttend")
public interface StaffAttendFeginService {


    @RequestMapping(value = "/getStaffAttendDayList", method = RequestMethod.GET)
    ComResponse<List<StaffAttendDayDto>> getStaffAttendDayList(@RequestParam("time") String time, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/getStaffAttendScheduleDto", method = RequestMethod.GET)
    ComResponse<StaffAttendScheduleDto> getStaffAttendScheduleDto(@RequestParam("time") String time, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/importStaffAttend", method = RequestMethod.GET)
    ComResponse<List<StaffAttendImportResultDto>> importStaffAttend(@RequestParam("url") String url);

    @RequestMapping(value = "/getStaffAttendListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffAttendListDto>> getStaffAttendListByParams(@RequestBody StaffAttendParamsVO staffAttendParamsVO);

    @RequestMapping(value = "/getStaffAttendAccountDto", method = RequestMethod.GET)
    ComResponse<StaffAttendAccountDto> getStaffAttendAccountDto(@RequestParam("staffNo") String staffNo);
}
