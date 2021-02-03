package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.StaffScheduleDto;

import cn.net.yzl.staff.vo.StaffScheduleParamsVO;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.*;


@FeignClient(value = "staff",url = "${fegin.db.url}/attend/schedule")
public interface StaffScheduleFeginService {



    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffScheduleDto>> getListByParams(@RequestBody  StaffScheduleParamsVO staffScheduleParamsVO);



}
