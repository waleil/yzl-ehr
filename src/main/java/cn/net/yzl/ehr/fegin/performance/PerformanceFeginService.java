package cn.net.yzl.ehr.fegin.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.perfomance.PerformanceDepartDto;
import cn.net.yzl.staff.dto.perfomance.PerformanceDto;
import cn.net.yzl.staff.dto.perfomance.PerformanceOrgStaffDto;
import cn.net.yzl.staff.pojo.performance.PerformanceOrgTargetPo;
import cn.net.yzl.staff.pojo.performance.PerformancePersonTargetPo;
import cn.net.yzl.staff.vo.performance.PerformanceApproveVo;
import cn.net.yzl.staff.vo.performance.PerformanceVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 职能部门-绩效服务
 *
 * @author biebaojie
 */
public interface PerformanceFeginService {

    @ApiOperation(value = "职能管理-填报绩效-周期列表", notes = "职能管理-填报绩效-周期列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillTimes", method = RequestMethod.GET)
    ComResponse<List<String>> queryFillTimes(String staffNo);

    /**
     * 绩效填报组织架构
     *
     * @param performanceVo 请求参数
     * @return 绩效组织架构
     */
    @ApiOperation(value = "职能管理-填报绩效-组织架构", notes = "职能管理-填报绩效-组织架构", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillPerformanceDepartList", method = RequestMethod.GET)
    ComResponse<List<PerformanceDepartDto>> queryFillPerformanceDepartList(PerformanceVo performanceVo);

    /**
     * 绩效考核组织架构
     *
     * @param performanceVo 请求参数
     * @return 绩效组织架构
     */
    @ApiOperation(value = "职能管理-填报绩效-获取绩效信息", notes = "职能管理-填报绩效-获取绩效信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    ComResponse<List<PerformanceOrgStaffDto>> queryApprovePerformanceOrgStaff(PerformanceVo performanceVo);

    /**
     * 通过绩效编号查询绩效信息
     *
     * @param performanceNo 绩效编号
     * @return 绩效信息
     */
    @ApiOperation(value = "职能管理-填报绩效-新增组织绩效", notes = "职能管理-填报绩效-新增组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPerformanceOrgTarget", method = RequestMethod.POST)
    ComResponse<PerformanceDto> queryPerformanceByNo(Long performanceNo);

    /**
     * 新增组织绩效
     *
     * @param performanceOrgTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-编辑组织绩效", notes = "职能管理-填报绩效-编辑组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformanceOrgTarget", method = RequestMethod.POST)
    ComResponse<Integer> insertPerformanceOrgTarget(PerformanceOrgTargetPo performanceOrgTarget);

    /**
     * 编辑组织绩效
     *
     * @param performanceOrgTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-编辑组织绩效", notes = "职能管理-填报绩效-编辑组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformanceOrgTarget", method = RequestMethod.POST)
    ComResponse<Integer> updatePerformanceOrgTarget(PerformanceOrgTargetPo performanceOrgTarget);

    /**
     * 删除组织绩效
     *
     * @param orgPerformanceNo 组织绩效编号
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-删除组织绩效", notes = "职能管理-填报绩效-删除组织绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByOrgPerformanceNo", method = RequestMethod.POST)
    ComResponse<Integer> deleteByOrgPerformanceNo(Long orgPerformanceNo);

    /**
     * 新增个人绩效
     *
     * @param performancePersonTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-新增个人绩效", notes = "职能管理-填报绩效-新增个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertPerformancePersonTarget", method = RequestMethod.POST)
    ComResponse<Integer> insertPerformancePersonTarget(PerformancePersonTargetPo performancePersonTarget);

    /**
     * 修改个人绩效
     *
     * @param performancePersonTarget 实例对象
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-修改个人绩效", notes = "职能管理-填报绩效-修改个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePerformancePersonTarget", method = RequestMethod.POST)
    ComResponse<Integer> updatePerformancePersonTarget(PerformancePersonTargetPo performancePersonTarget);

    /**
     * 删除个人绩效
     *
     * @param personPerformanceNo 个人绩效编号
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-删除个人绩效", notes = "职能管理-填报绩效-删除个人绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByPersonPerformanceNo", method = RequestMethod.POST)
    ComResponse<Integer> deleteByPersonPerformanceNo(Long personPerformanceNo);

    /**
     * 提交绩效
     *
     * @param performanceNo 绩效编号
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-提交绩效", notes = "职能管理-填报绩效-提交绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submitPerformance", method = RequestMethod.POST)
    ComResponse<Integer> submitPerformance(Long performanceNo);

    /**
     * 审核绩效
     *
     * @param approvePerformanceVo 审核结果
     * @return 影响行数
     */
    @ApiOperation(value = "职能管理-填报绩效-审核绩效", notes = "职能管理-填报绩效-审核绩效", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/approvePerformance", method = RequestMethod.POST)
    ComResponse<Integer> approvePerformance(PerformanceApproveVo approvePerformanceVo);

}
