package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.staff.dto.StaffScheduleDetailDto;
import cn.net.yzl.staff.dto.StaffScheduleDto;

import cn.net.yzl.staff.vo.ImportResultVo;
import cn.net.yzl.staff.vo.StaffScheduleParamsVO;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.text.ParseException;
import java.util.Date;


@FeignClient(value = "staff",url = "${fegin.db.url}/attend/schedule")
public interface StaffScheduleFeginService {

    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffScheduleDto>> getListByParams(@RequestBody  StaffScheduleParamsVO staffScheduleParamsVO);

    @RequestMapping(value = "/getDetailByStaffNoAndTime", method = RequestMethod.GET)
    ComResponse<StaffScheduleDetailDto> getDetailByStaffNoAndTime(@RequestParam("staffNo") String staffNo, @RequestParam("time") String time);

    @RequestMapping(value = "/importUpdateStaffScheduleInfo", method = RequestMethod.GET)
    ComResponse<ImportResultVo> importUpdateStaffScheduleInfo(@RequestParam("url") String url,@RequestParam("updator") String updator) throws ParseException;
}
