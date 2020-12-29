package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.PostDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface AttendRuleFeginService {



    @ApiOperation(value = "考勤配置-更新", notes = "考勤配置-更新", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody DepartAttendRuleDto departAttendRuleDto);

    @ApiOperation(value = "考勤配置-创建考勤规则", notes = "考勤配置-创建考勤规则", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdate(@RequestBody List<DepartAttendRuleDto> departAttendRuleDto);

    @ApiOperation(value = "考勤配置-根据部门获取考勤规则列表", notes = "考勤配置-根据部门获取考勤规则列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/getByDepartIdAndTime", method = RequestMethod.GET)
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartIdAndTime(@RequestParam("departId") Integer departId, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize,@RequestParam("time")String time) ;


    @ApiOperation(value = "考勤配置-根据部门获取考勤规则列表", notes = "考勤配置-根据部门获取考勤规则列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/getByParams", method = RequestMethod.GET)
    ComResponse<DepartAttendRuleDto> getByParams(@RequestParam("departId")Integer departId,@RequestParam("time") String time,@RequestParam("postId") Integer postId, @RequestParam("typeId")Integer typeId);

    @ApiOperation(value = "考勤配置-获取岗位列表", notes = "考勤配置-获取岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/getPostList", method = RequestMethod.GET)
    ComResponse<List<PostDto>> getPostList(@RequestParam("departId") Integer departId);
}
