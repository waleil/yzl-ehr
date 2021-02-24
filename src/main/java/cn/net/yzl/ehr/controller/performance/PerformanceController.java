package cn.net.yzl.ehr.controller.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.performance.PerformanceFeignService;
import cn.net.yzl.staff.dto.performance.FillPerformanceDepartDto;
import cn.net.yzl.staff.dto.performance.MyPerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceRaterDto;
import cn.net.yzl.staff.dto.performance.RaterPerformanceDepartDto;
import cn.net.yzl.staff.vo.performance.PerformanceApproveVo;
import cn.net.yzl.staff.vo.performance.PerformanceCreateVo;
import cn.net.yzl.staff.vo.performance.PerformanceReturnVo;
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
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 职能管理-绩效
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/performance")
@Api(value = "绩效", tags = {"绩效"})
public class PerformanceController {

    @Autowired
    private PerformanceFeignService performanceFeignService;

    /**
     * 获取填报周期列表
     *
     * @param staffNo 用户编号
     * @return 填报周期
     */
    @ApiOperation(value = "职能管理-填报绩效-查询周期列表", notes = "职能管理-填报绩效-查询周期列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillTimes", method = RequestMethod.GET)
    public ComResponse<List<String>> queryFillTimes(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.queryFillTimes(staffNo);
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
    public ComResponse<List<FillPerformanceDepartDto>> queryFillPerformanceDepartList(PerformanceVo performanceVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceVo.setStaffNo(staffNo);
        return performanceFeignService.queryFillPerformanceDepartList(performanceVo);
    }

    /**
     * 绩效考核-组织架构
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
    @ApiOperation(value = "职能管理-绩效考核-组织架构", notes = "职能管理-绩效考核-组织架构", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryRaterPerformanceDepartList", method = RequestMethod.GET)
    public ComResponse<List<RaterPerformanceDepartDto>> queryRaterPerformanceDepartList(PerformanceVo performanceVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceVo.setStaffNo(staffNo);
        return performanceFeignService.queryRaterPerformanceDepartList(performanceVo);
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
    @ApiOperation(value = "职能管理-填报绩效-查询绩效信息", notes = "职能管理-填报绩效-查询绩效信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    public ComResponse<PerformanceDto> queryPerformanceByNo(@RequestParam("performanceNo") Long performanceNo) {
        return performanceFeignService.queryPerformanceByNo(performanceNo);
    }

    /**
     * 提交绩效
     *
     * @param performanceCreateVo 绩效
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-提交绩效", notes = "职能管理-填报绩效-提交绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submitPerformance", method = RequestMethod.POST)
    public ComResponse<Integer> submitPerformance(@RequestBody @Validated PerformanceCreateVo performanceCreateVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceCreateVo.setCreator(staffNo);
        return performanceFeignService.submitPerformance(performanceCreateVo);
    }

    /**
     * 审核绩效
     *
     * @param approvePerformanceVo 审核结果
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-审核绩效", notes = "职能管理-填报绩效-审核绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/approvePerformance", method = RequestMethod.POST)
    public ComResponse<Integer> approvePerformance(@RequestBody @Validated PerformanceApproveVo approvePerformanceVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        approvePerformanceVo.setApproverNo(staffNo);
        return performanceFeignService.approvePerformance(approvePerformanceVo);
    }

    /**
     * 新增绩效评分
     *
     * @param performanceRaterDto 绩效评分
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-绩效考核-提交绩效", notes = "职能管理-绩效考核-提交绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPerformanceRater", method = RequestMethod.POST)
    public ComResponse<Integer> insertPerformanceRater(@RequestBody PerformanceRaterDto performanceRaterDto, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceRaterDto.setRaterNo(staffNo);
        return performanceFeignService.insertPerformanceRater(performanceRaterDto);
    }

    /**
     * 获取绩效评分列表
     *
     * @param performanceNo 绩效编号
     * @return 绩效评分集合
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "performanceNo", value = "绩效编号", required = true, dataType = "Long", paramType = "query")
    })
    @ApiOperation(value = "职能管理-绩效考核-查询评分列表", notes = "职能管理-绩效考核-查询评分列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceRaterList", method = RequestMethod.GET)
    public ComResponse<List<PerformanceRaterDto>> queryPerformanceRaterList(@RequestParam("performanceNo") Long performanceNo) {
        return performanceFeignService.queryPerformanceRaterList(performanceNo);
    }

    /**
     * 打回绩效
     *
     * @param performanceReturnVo 打回结果
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-绩效考核-打回绩效", notes = "职能管理-绩效考核-打回绩效", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/returnPerformance", method = RequestMethod.POST)
    public ComResponse<Integer> returnPerformance(@RequestBody PerformanceReturnVo performanceReturnVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceReturnVo.setApproverNo(staffNo);
        return performanceFeignService.returnPerformance(performanceReturnVo);
    }

    /**
     * 查询个人绩效
     *
     * @param fillTime 填报时间
     * @param staffNo  人员编号
     * @return 绩效信息
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fillTime", value = "填报周期", required = true, dataType = "String", paramType = "query"),
    })
    @ApiOperation(value = "个人中心-我的绩效-查询个人绩效", notes = "个人中心-我的绩效-查询个人绩效", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryMyPerformance", method = RequestMethod.GET)
    public ComResponse<MyPerformanceDto> queryMyPerformance(String fillTime, @ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.queryMyPerformance(fillTime, staffNo);
    }

}
