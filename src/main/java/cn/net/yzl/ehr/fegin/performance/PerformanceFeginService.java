package cn.net.yzl.ehr.fegin.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.performance.PerformanceDepartDto;
import cn.net.yzl.staff.dto.performance.PerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceOrgStaffDto;
import cn.net.yzl.staff.pojo.performance.PerformanceOrgTargetPo;
import cn.net.yzl.staff.pojo.performance.PerformancePersonTargetPo;
import cn.net.yzl.staff.vo.performance.PerformanceApproveVo;
import cn.net.yzl.staff.vo.performance.PerformanceNoVo;
import cn.net.yzl.staff.vo.performance.PerformanceVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 职能部门-绩效服务
 *
 * @author biebaojie
 */
@FeignClient(value = "PerformanceFeginService", url = "${fegin.db.url}/performance")
@RefreshScope
public interface PerformanceFeginService {

    @ApiOperation(value = "职能管理-填报绩效-周期列表", notes = "职能管理-填报绩效-周期列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillTimes", method = RequestMethod.GET)
    ComResponse<List<String>> queryFillTimes(@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "职能管理-填报绩效-组织架构", notes = "职能管理-填报绩效-组织架构", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillPerformanceDepartList", method = RequestMethod.GET)
    ComResponse<List<PerformanceDepartDto>> queryFillPerformanceDepartList(@SpringQueryMap PerformanceVo performanceVo);

    @ApiOperation(value = "职能管理-绩效考核-组织架构", notes = "职能管理-绩效考核-组织架构", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    ComResponse<List<PerformanceOrgStaffDto>> queryApprovePerformanceOrgStaff(@SpringQueryMap PerformanceVo performanceVo);

    @ApiOperation(value = "职能管理-填报绩效-获取绩效信息", notes = "职能管理-填报绩效-获取绩效信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    ComResponse<PerformanceDto> queryPerformanceByNo(@RequestParam("performanceNo") Long performanceNo);

    @ApiOperation(value = "职能管理-填报绩效-新增组织绩效", notes = "职能管理-填报绩效-新增组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformanceOrgTarget", method = RequestMethod.POST)
    ComResponse<Integer> insertPerformanceOrgTarget(@RequestBody PerformanceOrgTargetPo performanceOrgTarget);

    @ApiOperation(value = "职能管理-填报绩效-修改组织绩效", notes = "职能管理-填报绩效-修改组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformanceOrgTarget", method = RequestMethod.POST)
    ComResponse<Integer> updatePerformanceOrgTarget(@RequestBody PerformanceOrgTargetPo performanceOrgTarget);

    @ApiOperation(value = "职能管理-填报绩效-删除组织绩效", notes = "职能管理-填报绩效-删除组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByOrgPerformanceNo", method = RequestMethod.POST)
    ComResponse<Integer> deleteByOrgPerformanceNo(@RequestBody PerformanceNoVo performanceNoVo);

    @ApiOperation(value = "职能管理-填报绩效-新增个人绩效", notes = "职能管理-填报绩效-新增个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPerformancePersonTarget", method = RequestMethod.POST)
    ComResponse<Integer> insertPerformancePersonTarget(@RequestBody PerformancePersonTargetPo performancePersonTarget);

    @ApiOperation(value = "职能管理-填报绩效-修改个人绩效", notes = "职能管理-填报绩效-修改个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformancePersonTarget", method = RequestMethod.POST)
    ComResponse<Integer> updatePerformancePersonTarget(@RequestBody PerformancePersonTargetPo performancePersonTarget);

    @ApiOperation(value = "职能管理-填报绩效-删除个人绩效", notes = "职能管理-填报绩效-删除个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPersonPerformanceNo", method = RequestMethod.POST)
    ComResponse<Integer> deleteByPersonPerformanceNo(@RequestBody PerformanceNoVo performanceNoVo);

    @ApiOperation(value = "职能管理-填报绩效-提交绩效", notes = "职能管理-填报绩效-提交绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submitPerformance", method = RequestMethod.POST)
    ComResponse<Integer> submitPerformance(@RequestBody PerformanceNoVo performanceNoVo);

    @ApiOperation(value = "职能管理-填报绩效-审核绩效", notes = "职能管理-填报绩效-审核绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/approvePerformance", method = RequestMethod.POST)
    ComResponse<Integer> approvePerformance(@RequestBody PerformanceApproveVo approvePerformanceVo);

}