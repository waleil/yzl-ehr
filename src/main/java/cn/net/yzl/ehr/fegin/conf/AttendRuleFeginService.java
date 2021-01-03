package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleElasticVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleNoPunchVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleNormalVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleRobbedVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface AttendRuleFeginService {


    @RequestMapping(value = "/conf/attendRule/normal/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateNormal(@RequestBody @Validated DepartAttendRuleNormalVO departAttendRuleNormalVO);
    @RequestMapping(value = "/conf/attendRule/robbed/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateRobbed(@RequestBody @Validated DepartAttendRuleRobbedVO departAttendRuleRobbedVO) ;
    @RequestMapping(value = "/conf/attendRule/elastic/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateElastic(@RequestBody @Validated DepartAttendRuleElasticVO departAttendRuleElasticVO);

    @RequestMapping(value = "/conf/attendRule/punch/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdatePunch(@RequestBody  DepartAttendRuleNoPunchVO departAttendRuleNoPunchVO);

    @RequestMapping(value = "/conf/attendRule/getByDepartId", method = RequestMethod.GET)
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(@RequestParam("departId") Integer departId,
                                                                @RequestParam("pageNo") Integer pageNo,
                                                                @RequestParam("pageSize") Integer pageSize) ;



    @RequestMapping(value = "/conf/attendRule/getByDepartIdAndPostIdAndEnable", method = RequestMethod.GET)
    public ComResponse<DepartAttendRuleDto> getByDepartIdAndPostIdAndEnable(@RequestParam("departId") Integer departId,@RequestParam("postId") Integer postId, @RequestParam("enable")Integer enable);





    @RequestMapping(value = "/conf/attendRule/getPostList", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostList(@RequestParam("departId") Integer departId) ;

}
