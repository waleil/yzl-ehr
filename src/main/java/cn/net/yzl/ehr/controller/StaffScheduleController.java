package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.staff.StaffScheduleFeginService;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import cn.net.yzl.pm.model.dto.MenuDTO;
import cn.net.yzl.pm.service.RoleMenuService;
import cn.net.yzl.staff.dto.StaffScheduleDetailDto;
import cn.net.yzl.staff.dto.StaffScheduleDto;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.ImportResultVo;
import cn.net.yzl.staff.vo.StaffScheduleParamsVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private FastDFSClientWrapper client;


    @ApiOperation(value = "查看排班-获取排班信息列表", notes = "查看排班-获取排班信息列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffScheduleDto>> getListByParams(@RequestBody @Validated StaffScheduleParamsVO staffScheduleParamsVO, HttpServletRequest request) throws ParseException, IllegalAccessException {
        staffScheduleParamsVO = StaffBeanUtils.setNullValue(staffScheduleParamsVO);

        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        Integer isAdmin = menuDTO.getIsAdmin();
        staffScheduleParamsVO.setStaffNo(userNo);
        if(0 == isAdmin){
            staffScheduleParamsVO.setFlag(1);
        }
        return staffScheduleFeginService.getListByParams(staffScheduleParamsVO);
    }

    @ApiOperation(value = "个人中心-时间获取排班详情", notes = "个人中心-根据员工工号和时间获取排班详情", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间(yyyy-mm)", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getDetailByStaffNoAndTime", method = RequestMethod.GET)
    ComResponse<StaffScheduleDetailDto> getDetailByStaffNoAndTime(@ApiIgnore @CurrentStaffNo String staffNo, String time) throws ParseException {
        return staffScheduleFeginService.getDetailByStaffNoAndTime(staffNo,time);
    }

    @ApiOperation(value = "排班-导入更新下月排班信息", notes = "排班-导入更新下月排班信息", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/importUpdateStaffScheduleInfo", method = RequestMethod.GET)
    ComResponse<ImportResultVo> importUpdateStaffScheduleInfo(@RequestParam("url") String url, @CurrentStaffNo @ApiIgnore String updator) throws ParseException {
        ComResponse<ImportResultVo> importResultVoComResponse = staffScheduleFeginService.importUpdateStaffScheduleInfo(url, updator);
        client.deleteFile(url);
        return importResultVoComResponse;
    }


}
