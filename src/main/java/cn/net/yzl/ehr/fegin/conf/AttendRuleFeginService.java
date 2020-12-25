package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yzl-staff-db")
public interface AttendRuleFeginService {



    @ApiOperation(value = "考勤配置-更新", notes = "考勤配置-更新", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody DepartAttendRuleDto departAttendRuleDto);

    @ApiOperation(value = "考勤配置-创建考勤规则", notes = "考勤配置-创建考勤规则", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/add", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> add(@RequestBody DepartAttendRuleDto departAttendRuleDto);

    @ApiOperation(value = "考勤配置-根据部门获取考勤规则列表", notes = "考勤配置-根据部门获取考勤规则列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/conf/attendRule/getByDepartId", method = RequestMethod.GET)
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(@RequestParam("departId") Integer departId, @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                                                @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize) ;
}
