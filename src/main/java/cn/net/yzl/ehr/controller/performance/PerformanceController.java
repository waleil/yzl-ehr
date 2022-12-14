package cn.net.yzl.ehr.controller.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.performance.PerformanceFeignService;
import cn.net.yzl.staff.dto.performance.FillPerformanceOrgDto;
import cn.net.yzl.staff.dto.performance.MyPerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceApproveCountDto;
import cn.net.yzl.staff.dto.performance.PerformanceDepartDto;
import cn.net.yzl.staff.dto.performance.PerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceRaterDto;
import cn.net.yzl.staff.dto.performance.RaterPerformanceOrgDto;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门Id", dataType = "Integer", paramType = "query")
    })
    @ApiOperation(value = "职能管理-绩效填报-查询周期列表", notes = "职能管理-绩效填报-查询周期列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillTimes", method = RequestMethod.GET)
    public ComResponse<List<String>> queryFillTimes(@ApiIgnore @CurrentStaffNo String staffNo, @RequestParam(value = "departId", required = false) Integer departId) {
        return performanceFeignService.queryFillTimes(staffNo, departId);
    }


    /**
     * 查询填报部门负责
     *
     * @param staffNo 人员编号
     * @return 部门信息
     */
    @ApiOperation(value = "职能管理-绩效填报-查询负责部门", notes = "职能管理-绩效填报-查询负责部门", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillPerformanceDepart", method = RequestMethod.GET)
    public ComResponse<List<PerformanceDepartDto>> queryFillPerformanceDepart(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.queryFillPerformanceDepart(staffNo);
    }

    /**
     * 查询考核负责部门
     *
     * @param staffNo 人员编号
     * @return 部门信息
     */
    @ApiOperation(value = "职能管理-绩效考核-查询负责部门", notes = "职能管理-绩效考核-查询负责部门", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryRaterPerformanceDepart", method = RequestMethod.GET)
    public ComResponse<List<PerformanceDepartDto>> queryRaterPerformanceDepart(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.queryRaterPerformanceDepart(staffNo);
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
    @ApiOperation(value = "职能管理-绩效填报-组织架构", notes = "职能管理-绩效填报-组织架构", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillPerformanceDepartList", method = RequestMethod.GET)
    public ComResponse<FillPerformanceOrgDto> queryFillPerformanceDepartList(PerformanceVo performanceVo, @ApiIgnore @CurrentStaffNo String staffNo) {
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
    public ComResponse<RaterPerformanceOrgDto> queryRaterPerformanceDepartList(PerformanceVo performanceVo, @ApiIgnore @CurrentStaffNo String staffNo) {
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
    @ApiOperation(value = "职能管理-绩效填报-查询绩效信息", notes = "职能管理-绩效填报-查询绩效信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    public ComResponse<PerformanceDto> queryPerformanceByNo(@RequestParam("performanceNo") Long performanceNo, @ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.queryPerformanceByNo(performanceNo, staffNo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "performanceNo", value = "绩效编号", required = true, dataType = "String", paramType = "query")
    })
    @ApiOperation(value = "职能管理-绩效考核-查询绩效信息", notes = "职能管理-绩效考核-查询绩效信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryRaterPerformanceByNo", method = RequestMethod.GET)
    public ComResponse<MyPerformanceDto> queryRaterPerformanceByNo(@RequestParam("performanceNo") Long performanceNo, @ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.queryRaterPerformanceByNo(new PerformanceVo(performanceNo, staffNo));
    }


    /**
     * 提交绩效
     *
     * @param performanceCreateVo 绩效
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-绩效填报-提交绩效", notes = "职能管理-绩效填报-提交绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
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
    @ApiOperation(value = "职能管理-绩效填报-审核绩效", notes = "职能管理-绩效填报-审核绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
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

//    /**
//     * 获取绩效评分列表
//     *
//     * @param performanceNo 绩效编号
//     * @return 绩效评分集合
//     */
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "performanceNo", value = "绩效编号", required = true, dataType = "Long", paramType = "query")
//    })
//    @ApiOperation(value = "职能管理-绩效考核-查询评分列表", notes = "职能管理-绩效考核-查询评分列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    @RequestMapping(value = "/queryPerformanceRaterList", method = RequestMethod.GET)
//    public ComResponse<List<PerformanceRaterDto>> queryPerformanceRaterList(@RequestParam("performanceNo") Long performanceNo) {
//        return performanceFeignService.queryPerformanceRaterList(performanceNo);
//    }

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

    @ApiImplicitParams({
            @ApiImplicitParam(name = "fillTime", value = "填报周期", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "departId", value = "部门Id", required = true, dataType = "Integer", paramType = "query")
    })
    @ApiOperation(value = "职能管理-绩效考核-考核统计", notes = "职能管理-绩效考核-考核统计", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceApproveCount", method = RequestMethod.GET)
    public ComResponse<PerformanceApproveCountDto> queryPerformanceApproveCount(@RequestParam("fillTime") String fillTime,
                                                                                @ApiIgnore @CurrentStaffNo String staffNo,
                                                                                @RequestParam("departId") Integer departId) {
        return performanceFeignService.queryPerformanceApproveCount(fillTime, staffNo,departId);
    }

    @ApiOperation(value = "职能管理-绩效填报-是否负责人", notes = "职能管理-绩效填报-是否负责人", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/isLeader", method = RequestMethod.GET)
    public ComResponse<Boolean> isLeader(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.isLeader(staffNo);
    }


    @ApiOperation(value = "职能管理-绩效考核-是否负责人", notes = "职能管理-绩效考核-是否负责人", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/isRaterLeader", method = RequestMethod.GET)
    public ComResponse<Boolean> isRaterLeader(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceFeignService.isRaterLeader(staffNo);
    }

}
