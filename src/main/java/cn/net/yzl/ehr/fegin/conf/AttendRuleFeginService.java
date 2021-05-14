package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleElasticVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleFrontLineVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleNoPunchVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleNormalVO;
import cn.net.yzl.ehr.vo.attendRule.DepartAttendRuleRobbedVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface AttendRuleFeginService {


    @RequestMapping(value = "/conf/attendRule/normal/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateNormal(@RequestBody DepartAttendRuleNormalVO departAttendRuleNormalVO);

    @RequestMapping(value = "/conf/attendRule/robbed/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateRobbed(@RequestBody DepartAttendRuleRobbedVO departAttendRuleRobbedVO);

    @RequestMapping(value = "/conf/attendRule/elastic/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateElastic(@RequestBody DepartAttendRuleElasticVO departAttendRuleElasticVO);

    @RequestMapping(value = "/conf/attendRule/punch/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdatePunch(@RequestBody DepartAttendRuleNoPunchVO departAttendRuleNoPunchVO);

    @RequestMapping(value = "/conf/attendRule/getByDepartId", method = RequestMethod.GET)
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(@RequestParam("departId") Integer departId,
                                                                @RequestParam("pageNo") Integer pageNo,
                                                                @RequestParam("pageSize") Integer pageSize);


    @RequestMapping(value = "/conf/attendRule/getPostList", method = RequestMethod.GET)
    public ComResponse<List<DepartPostDto>> getPostList(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/conf/attendRule/getByDepartPostIdAndEnable", method = RequestMethod.GET)
    ComResponse<DepartAttendRuleDto> getByDepartPostIdAndEnable(@RequestParam("departPostId") Integer departPostId, @RequestParam("enable") Integer enable);


    @RequestMapping(value = "/conf/attendRule/del", method = RequestMethod.GET)
    ComResponse<Integer> del(@RequestParam("attendRuleId") Integer attendRuleId);

    @RequestMapping(value = "/conf/attendRule/frontline/addOrUpdate", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> addOrUpdateFrontline(@RequestBody DepartAttendRuleFrontLineVO departAttendRuleFrontLineVO);
}
