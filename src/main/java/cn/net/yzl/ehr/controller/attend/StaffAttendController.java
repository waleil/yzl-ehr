package cn.net.yzl.ehr.controller.attend;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.attend.StaffAttendFeginService;
import cn.net.yzl.staff.dto.attend.*;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.attend.StaffAttendParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/saffAttend")
@Api(value = "一线/职能-考勤", tags = {"一线/职能-考勤"})
public class StaffAttendController {

    @Autowired
    private StaffAttendFeginService staffAttendFeginService;

    @ApiOperation(value = "查看考勤-考勤列表", notes = "查看考勤-考勤列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStaffAttendListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffAttendListDto>> getStaffAttendListByParams(@RequestBody @Validated StaffAttendParamsVO staffAttendParamsVO) throws ParseException, IllegalAccessException {
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
    @RequestMapping(value = "/getStaffAttendScheduleDto", method = RequestMethod.POST)
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
            writer.addHeaderAlias("resultDesc", "resultDesc");
            writer.addHeaderAlias("time", "时间");
            writer.setOnlyAlias(true);
            writer.write(list, true);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
//            response.setContentType("application/octet-stream");
//            execName = new String(execName.getBytes("UTF-8"),"ISO8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("attend_result", "UTF-8") + ".xlsx");   //中文名称需要特殊处理
//            response.setHeader("Content-Disposition", "attachment; filename="+ execName+".xlsx");   //中文名称需要特殊处理
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
}
