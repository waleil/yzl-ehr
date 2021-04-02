package cn.net.yzl.ehr.controller.attend;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.attend.StaffAttendExportDto;
import cn.net.yzl.ehr.fegin.attend.StaffAttendFeginService;
import cn.net.yzl.pm.model.dto.MenuDTO;
import cn.net.yzl.pm.service.RoleMenuService;
import cn.net.yzl.staff.dto.attend.*;
import cn.net.yzl.staff.util.DateStaffUtils;
import cn.net.yzl.staff.vo.attend.StaffAttendParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/saffAttend")
@Api(value = "一线/职能-考勤", tags = {"一线/职能-考勤"})
public class StaffAttendController {

    @Autowired
    private StaffAttendFeginService staffAttendFeginService;


    @Autowired
    private RoleMenuService roleMenuService;


    @ApiOperation(value = "查看考勤-考勤列表", notes = "查看考勤-考勤列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStaffAttendListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffAttendListDto>> getStaffAttendListByParams(@RequestBody @Validated StaffAttendParamsVO staffAttendParamsVO, HttpServletRequest request) throws ParseException, IllegalAccessException {
        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        Integer isAdmin = menuDTO.getIsAdmin();
        staffAttendParamsVO.setStaffNo(userNo);
        if(0 == isAdmin){
            staffAttendParamsVO.setFlag(1);
        }
        return staffAttendFeginService.getStaffAttendListByParams(staffAttendParamsVO);
    }

    @ApiOperation(value = "考勤详情-获取每天的考勤信息", notes = "考勤详情-获取每天的考勤信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getStaffAttendDayList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间 年-月(格式:yyyy-MM)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "员工工号(如果不传 查询是当前登录的用户的)", required = false, dataType = "String", paramType = "query")
    })
    ComResponse<List<StaffAttendDayDto>> getStaffAttendDayList(String time, String staffNo, @ApiIgnore @CurrentStaffNo String currentStaffNo) throws ParseException {
        if(StrUtil.isBlank(staffNo)){
            staffNo=currentStaffNo;
        }
        return staffAttendFeginService.getStaffAttendDayList(time,staffNo);
    }

    @ApiOperation(value = "考勤详情-获取每个月的统计", notes = "考勤详情-获取每个月的统计", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStaffAttendScheduleDto", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间 年-月(格式:yyyy-MM)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "staffNo", value = "员工工号(如果不传 查询是当前登录的用户的)", required = false, dataType = "String", paramType = "query")
    })
    ComResponse<StaffAttendScheduleDto> getStaffAttendScheduleDto(String time,String staffNo,@ApiIgnore @CurrentStaffNo String currentStaffNo) {
        if(StrUtil.isBlank(staffNo)){
            staffNo=currentStaffNo;
        }
        return staffAttendFeginService.getStaffAttendScheduleDto(time,staffNo);
    }


    @ApiOperation(value = "查看考勤-导入", notes = "查看考勤-导入", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/importStaffAttend", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "文件路径(相对路径)", required = true, dataType = "String", paramType = "query"),
    })
    void importStaffAttend(String url, HttpServletResponse response) {
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.renameSheet("考勤结果");     //甚至sheet的名称
        ComResponse<List<StaffAttendImportResultDto>> result =  staffAttendFeginService.importStaffAttend(url);
        List<StaffAttendImportResultDto> list = result.getData();
        try {
            writer.addHeaderAlias("staffNo", "员工工号");
            writer.addHeaderAlias("result", "导入结果");
            writer.addHeaderAlias("resultDesc", "结果描述");
            writer.addHeaderAlias("time", "时间");
            writer.setOnlyAlias(true);
            if(null != list) {
                writer.write(list, true);
            }else{
                writer.write(Arrays.asList("导入模板错误"), true);
            }
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("考勤导入结果", "UTF-8") + ".xlsx");   //中文名称需要特殊处理
            writer.autoSizeColumnAll();
            writer.flush(response.getOutputStream());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "考勤详情-考勤账户信息", notes = "考勤详情-考勤账户信息", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStaffAttendAccountDto", method = RequestMethod.GET)
    ComResponse<StaffAttendAccountDto> getStaffAttendAccountDto(@ApiIgnore @CurrentStaffNo String staffNo) {
        return staffAttendFeginService.getStaffAttendAccountDto(staffNo);
    }


    @ApiOperation(value = "查看考勤-导出", notes = "查看考勤-导出", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/exportStaffAttend", method = RequestMethod.POST)
    void importStaffAttend(@RequestBody @Validated StaffAttendParamsVO staffAttendParamsVO, HttpServletResponse response,HttpServletRequest request) throws ParseException, IOException {
        ExcelWriter writer = ExcelUtil.getWriter();
        Date time = staffAttendParamsVO.getTime();
        int daysOfMonth = DateStaffUtils.getDaysOfMonth(time);
        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        Integer isAdmin = menuDTO.getIsAdmin();
        staffAttendParamsVO.setStaffNo(userNo);
        if(0 == isAdmin){
            staffAttendParamsVO.setFlag(1);
        }

        writer.renameSheet("考勤列表");     //甚至sheet的名称
        staffAttendParamsVO.setPageSize(100000);
        ComResponse<Page<StaffAttendListDto>> result = staffAttendFeginService.getStaffAttendListByParams(staffAttendParamsVO);
        List<StaffAttendListDto> list = new ArrayList<>();
        if(result.getData()!=null){
            list=result.getData().getItems();}
        List<StaffAttendExportDto> objects = new ArrayList<>();
        if (list!=null && list.size()>0){
            for (StaffAttendListDto staffAttendListDto : list) {
                StaffAttendExportDto staffAttendExportDto = new StaffAttendExportDto();
                BeanUtil.copyProperties(staffAttendListDto,staffAttendExportDto);
                objects.add(staffAttendExportDto);
            }
        }
        try {
            writer.addHeaderAlias("staffName", "姓名");
            writer.addHeaderAlias("attendGroupName", "考勤组");
            writer.addHeaderAlias("departNames", "部门");
            writer.addHeaderAlias("staffNo", "工号");
            writer.addHeaderAlias("postName", "职位");
            writer.addHeaderAlias("shouldAttendDays", "应出勤天数");
            writer.addHeaderAlias("attendDays", "出勤天数");
            writer.addHeaderAlias("restDays", "休息天数");
            writer.addHeaderAlias("workTime", "工作时长(分钟)");
            for (int i = 1; i < daysOfMonth+1; i++) {
                writer.addHeaderAlias("v"+i, i+"");
            }

            writer.setOnlyAlias(true);
            writer.write(objects, true);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("考勤"+DateStaffUtils.dateToDateStr(time,"yyyy-MM"), "UTF-8") + ".xlsx");   //中文名称需要特殊处理
            writer.autoSizeColumnAll();
            writer.flush(response.getOutputStream());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
