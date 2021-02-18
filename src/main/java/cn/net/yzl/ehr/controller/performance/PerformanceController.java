package cn.net.yzl.ehr.controller.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.performance.PerformanceFeginService;
import cn.net.yzl.staff.dto.perfomance.PerformanceDepartDto;
import cn.net.yzl.staff.dto.perfomance.PerformanceDto;
import cn.net.yzl.staff.pojo.performance.PerformanceOrgTargetPo;
import cn.net.yzl.staff.pojo.performance.PerformancePersonTargetPo;
import cn.net.yzl.staff.vo.performance.PerformanceApproveVo;
import cn.net.yzl.staff.vo.performance.PerformanceNoVo;
import cn.net.yzl.staff.vo.performance.PerformanceVo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 职能管理-绩效
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/func/performance")
@Api(value = "职能管理-绩效", tags = {"职能管理-绩效"})
public class PerformanceController {

    @Autowired
    private PerformanceFeginService performanceFeginService;

    /**
     * 获取填报周期列表
     *
     * @param staffNo 用户编号
     * @return 填报周期
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "员工编号", required = true, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "职能管理-填报绩效-周期列表", notes = "职能管理-填报绩效-周期列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillTimes", method = RequestMethod.GET)
    public ComResponse<List<String>> queryFillTimes(String staffNo) {
        return performanceFeginService.queryFillTimes(staffNo);
    }

    /**
     * 获取绩效填报组织架构
     *
     * @param performanceVo 请求参数
     * @return 绩效组织架构
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fillTime", value = "填报周期", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "approveStatus", value = "审核状态(0:未审批,1:已审批,2:已驳回)", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "submitStatus", value = "提交状态(0:未提交,1:已提交)", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "nameOrNo", value = "姓名或工号", dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "职能管理-填报绩效-组织架构", notes = "职能管理-填报绩效-组织架构", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillPerformanceDepartList", method = RequestMethod.GET)
    public ComResponse<List<PerformanceDepartDto>> queryFillPerformanceDepartList(PerformanceVo performanceVo) {
        return performanceFeginService.queryFillPerformanceDepartList(performanceVo);
    }


    /**
     * 通过绩效编号查询绩效信息
     *
     * @param performanceNo 绩效编号
     * @return 绩效信息
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "performanceNo", value = "绩效编号", required = true, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "职能管理-填报绩效-获取绩效信息", notes = "职能管理-填报绩效-获取绩效信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    public ComResponse<PerformanceDto> queryPerformanceByNo(@RequestParam("performanceNo") Long performanceNo) {
        return performanceFeginService.queryPerformanceByNo(performanceNo);
    }

    /**
     * 新增组织绩效
     *
     * @param performanceOrgTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-新增组织绩效", notes = "职能管理-填报绩效-新增组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPerformanceOrgTarget", method = RequestMethod.POST)
    public ComResponse<Integer> insertPerformanceOrgTarget(@RequestBody @Validated PerformanceOrgTargetPo performanceOrgTarget) {
        return performanceFeginService.insertPerformanceOrgTarget(performanceOrgTarget);
    }

    /**
     * 编辑组织绩效
     *
     * @param performanceOrgTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-编辑组织绩效", notes = "职能管理-填报绩效-编辑组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformanceOrgTarget", method = RequestMethod.POST)
    public ComResponse<Integer> updatePerformanceOrgTarget(@RequestBody @Validated PerformanceOrgTargetPo performanceOrgTarget) {
        return performanceFeginService.updatePerformanceOrgTarget(performanceOrgTarget);
    }

    /**
     * 删除组织绩效
     *
     * @param performanceNoVo 组织绩效编号
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-删除组织绩效", notes = "职能管理-填报绩效-删除组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByOrgPerformanceNo", method = RequestMethod.POST)
    public ComResponse<Integer> deleteByOrgPerformanceNo(@RequestBody @Validated PerformanceNoVo performanceNoVo) {
        return performanceFeginService.deleteByOrgPerformanceNo(performanceNoVo.getNo());
    }

    /**
     * 新增个人绩效
     *
     * @param performancePersonTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-新增个人绩效", notes = "职能管理-填报绩效-新增个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPerformancePersonTarget", method = RequestMethod.POST)
    public ComResponse<Integer> insertPerformancePersonTarget(@RequestBody @Validated PerformancePersonTargetPo performancePersonTarget) {
        return performanceFeginService.insertPerformancePersonTarget(performancePersonTarget);
    }

    /**
     * 修改个人绩效
     *
     * @param performancePersonTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-修改个人绩效", notes = "职能管理-填报绩效-修改个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformancePersonTarget", method = RequestMethod.POST)
    public ComResponse<Integer> updatePerformancePersonTarget(@RequestBody @Validated PerformancePersonTargetPo performancePersonTarget) {
        return performanceFeginService.updatePerformancePersonTarget(performancePersonTarget);
    }

    /**
     * 删除个人绩效
     *
     * @param performanceNoVo 个人绩效编号
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-删除个人绩效", notes = "职能管理-填报绩效-删除个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPersonPerformanceNo", method = RequestMethod.POST)
    public ComResponse<Integer> deleteByPersonPerformanceNo(@RequestBody @Validated PerformanceNoVo performanceNoVo) {
        return performanceFeginService.deleteByPersonPerformanceNo(performanceNoVo.getNo());
    }

    /**
     * 提交绩效
     *
     * @param performanceNoVo 绩效编号
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-提交绩效", notes = "职能管理-填报绩效-提交绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submitPerformance", method = RequestMethod.POST)
    public ComResponse<Integer> submitPerformance(@RequestBody @Validated PerformanceNoVo performanceNoVo) {
        return performanceFeginService.submitPerformance(performanceNoVo.getNo());
    }

    /**
     * 审核绩效
     *
     * @param approvePerformanceVo 审核结果
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-审核绩效", notes = "职能管理-填报绩效-审核绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/approvePerformance", method = RequestMethod.POST)
    public ComResponse<Integer> approvePerformance(@RequestBody @Validated PerformanceApproveVo approvePerformanceVo) {
        return performanceFeginService.approvePerformance(approvePerformanceVo);
    }
}
