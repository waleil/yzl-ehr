package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.Interceptor.AuthorizationInterceptor;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.service.AttendRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/conf/attendRule")
@Api(value = "配置模块", tags = {"配置模块"})
public class AttendRuleController {

    @Autowired
    private AttendRuleService attendRuleService;


//    @ApiOperation(value = "考勤配置-更新", notes = "考勤配置-更新", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
//    ComResponse<Integer> update(@RequestBody DepartAttendRuleDto departAttendRuleDto) {
//        return attendRuleService.update(departAttendRuleDto);
//    }

    @ApiOperation(value = "考勤配置-创建或者更新考勤规则", notes = "考勤配置-创建考勤规则", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> add(@RequestBody  List<DepartAttendRuleDto> departAttendRuleDto, @ApiIgnore @CurrentStaffNo String staffNo) {
        return attendRuleService.addOrUpdate(departAttendRuleDto,staffNo);
    }



    @ApiOperation(value = "考勤配置-根据部门和日期获取考勤规则列表", notes = "考勤配置-根据部门和日期获取考勤规则列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartIdAndTime", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "第几页",defaultValue ="1",required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页数量", defaultValue ="20",required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "time", value = "时间(年-月)", required = true, dataType = "String", paramType = "query")
    })
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartIdAndTime(@Min(1) Integer departId, @Min(1) Integer pageNo,
                                                                       @Min(1) Integer pageSize, String time) {
        return attendRuleService.getByDepartIdAndTime(departId,pageNo,pageSize,time);
    }




    @ApiOperation(value = "考勤配置-根据部门,日期,岗位id,岗位类型获取考勤规则列表", notes = "考勤配置-根据部门,日期,岗位id,岗位类型获取考勤规则列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByParams", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "time", value = "时间(年-月)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "postId", value = "岗位id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "typeId", value = "岗位类型id", required = false, dataType = "Int", paramType = "query")
    })
    public ComResponse<DepartAttendRuleDto> getByParams(@Min(1) Integer departId,
                                                        @DateTimeFormat(pattern="yyyy-MM") String time
            ,@Min(1) Integer postId,@Min(1) Integer typeId) {
        return attendRuleService.getByParams(departId,time,postId,typeId);
    }

    @ApiOperation(value = "考勤配置-获取岗位列表", notes = "考勤配置-获取岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPostList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")

    })
    public ComResponse<List<PostDto>> getPostList(@Min(1) Integer departId) {
        return attendRuleService.getPostList(departId);
    }


}
