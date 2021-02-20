package cn.net.yzl.ehr.controller.departConfig;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.service.AttendRuleService;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleElasticVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleNoPunchVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleNormalVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleRobbedVO;
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

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/conf/attendRule")
@Api(value = "配置模块", tags = {"配置模块"})
@Validated
public class AttendRuleController {

    @Autowired
    private AttendRuleService attendRuleService;


    @ApiOperation(value = "考勤配置-考勤规则-定时打卡:正常", notes = "考勤配置-考勤规则-定时打卡:正常", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/normal/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateNormal(@RequestBody @Validated DepartAttendRuleNormalVO departAttendRuleNormalVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        departAttendRuleNormalVO.setCreator(staffNo);
        departAttendRuleNormalVO.setUpdator(staffNo);
        return attendRuleService.addOrUpdateNormal(departAttendRuleNormalVO,staffNo);
    }
    @ApiOperation(value = "考勤配置-考勤规则-定时打卡:可抢", notes = "考勤配置-考勤规则-定时打卡:可抢", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/robbed/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateRobbed(@RequestBody @Validated DepartAttendRuleRobbedVO departAttendRuleRobbedVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        departAttendRuleRobbedVO.setCreator(staffNo);
        departAttendRuleRobbedVO.setUpdator(staffNo);
        return attendRuleService.addOrUpdateRobbed(departAttendRuleRobbedVO,staffNo);
    }
    @ApiOperation(value = "考勤配置-考勤规则-定时打卡:弹性", notes = "考勤配置-考勤规则-定时打卡:弹性", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/elastic/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateElastic(@RequestBody @Validated DepartAttendRuleElasticVO departAttendRuleElasticVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        departAttendRuleElasticVO.setCreator(staffNo);
        departAttendRuleElasticVO.setUpdator(staffNo);
        return attendRuleService.addOrUpdateElastic(departAttendRuleElasticVO,staffNo);
    }

    @ApiOperation(value = "考勤配置-考勤规则-定时打卡:不打卡", notes = "考勤配置-考勤规则-定时打卡:不打卡", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/punch/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")

    ComResponse<Integer> addOrUpdatePunch(@RequestBody @Validated DepartAttendRuleNoPunchVO departAttendRuleNoPunchVO, @ApiIgnore @CurrentStaffNo String staffNo) {
        departAttendRuleNoPunchVO.setCreator(staffNo);
        departAttendRuleNoPunchVO.setUpdator(staffNo);
        return attendRuleService.addOrUpdatePunch(departAttendRuleNoPunchVO,staffNo);
    }

    @ApiOperation(value = "考勤配置-考勤规则-根据部门id获取考勤规则分页信息", notes = "考勤配置-考勤规则-根据部门id获取考勤规则分页信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "第几页",defaultValue ="1",required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页数量", defaultValue ="20",required = true, dataType = "Int", paramType = "query")
    })
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(@Min(1) @NotNull Integer departId, @Min(1) @NotNull Integer pageNo,
                                                                @Min(1) @NotNull Integer pageSize) throws ParseException {
        return attendRuleService.getByDepartId(departId,pageNo,pageSize);
    }



    @ApiOperation(value = "考勤配置-考勤规则-根据部门岗位id获取考勤规则信息", notes = "考勤配置-考勤规则-根据部门id,是否启用状态,岗位id获取考勤规则信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartPostIdAndEnable", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departPostId", value = "部门岗位id", required = true, dataType = "Int", paramType = "query"),
//            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query"),
            @ApiImplicitParam(name = "enable", value = "0:否,1:是(1:也表示立即生效的)",required = true, dataType = "Int", paramType = "query"),
//            @ApiImplicitParam(name = "postId", value = "岗位id",required = true, dataType = "Int", paramType = "query")
    })
    public ComResponse<DepartAttendRuleDto> getByDepartPostIdAndEnable(@Min(1) @NotNull Integer departPostId,@Min(0) @Max(1) @NotNull Integer enable) throws ParseException {
        return attendRuleService.getByDepartPostIdAndEnable(departPostId,enable);
    }




    @ApiOperation(value = "考勤配置-考勤规则-获取岗位列表", notes = "考勤配置-考勤规则-获取岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPostList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")

    })
    public ComResponse<List<DepartPostDto>> getPostList(@Min(1) @NotNull Integer departId) {
        return attendRuleService.getPostList(departId);
    }




}
