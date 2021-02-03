package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.staff.StaffScheduleFeginService;
import cn.net.yzl.staff.dto.StaffScheduleDto;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.StaffScheduleParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

@RestController
@RequestMapping("/attend/schedule")
@Api(value = "排班-一线管理", tags = {"一线管理"})
@Validated
public class StaffScheduleController {

    @Autowired
    private StaffScheduleFeginService staffScheduleFeginService;



    @ApiOperation(value = "查看排班-获取排班信息列表", notes = "查看排班-获取排班信息列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffScheduleDto>> getListByParams(@RequestBody @Validated StaffScheduleParamsVO staffScheduleParamsVO) throws ParseException, IllegalAccessException {
        staffScheduleParamsVO = StaffBeanUtils.setNullValue(staffScheduleParamsVO);
        return staffScheduleFeginService.getListByParams(staffScheduleParamsVO);
    }



}
