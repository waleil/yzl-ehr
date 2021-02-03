package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.staff.StaffScheduleFeginService;
import cn.net.yzl.staff.dto.StaffScheduleDetailDto;
import cn.net.yzl.staff.dto.StaffScheduleDto;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.StaffScheduleParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.util.Date;

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

    @ApiOperation(value = "排班-根据员工工号和时间获取排班详情", notes = "排班-根据员工工号和时间获取排班详情", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间(yyyy-mm)", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getDetailByStaffNoAndTime", method = RequestMethod.GET)
    ComResponse<StaffScheduleDetailDto> getDetailByStaffNoAndTime(@ApiIgnore @CurrentStaffNo String staffNo, @DateTimeFormat(pattern="yyyy-MM") Date time) throws ParseException {
        return staffScheduleFeginService.getDetailByStaffNoAndTime(staffNo,time);
    }

}
