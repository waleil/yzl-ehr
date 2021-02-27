package cn.net.yzl.ehr.fegin.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.performance.FillPerformanceOrgDto;
import cn.net.yzl.staff.dto.performance.MyPerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceApproveCountDto;
import cn.net.yzl.staff.dto.performance.PerformanceDto;
import cn.net.yzl.staff.dto.performance.PerformanceRaterDto;
import cn.net.yzl.staff.dto.performance.RaterPerformanceOrgDto;
import cn.net.yzl.staff.vo.performance.PerformanceApproveVo;
import cn.net.yzl.staff.vo.performance.PerformanceCreateVo;
import cn.net.yzl.staff.vo.performance.PerformanceReturnVo;
import cn.net.yzl.staff.vo.performance.PerformanceVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
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
@FeignClient(value = "PerformanceFeignService", url = "${fegin.db.url}/performance")
//@FeignClient(value = "PerformanceFeignService", url = "http://localhost:38080/performance")
@RefreshScope
public interface PerformanceFeignService {

    /**
     * 职能管理-填报绩效-周期列表
     */
    @RequestMapping(value = "/queryFillTimes", method = RequestMethod.GET)
    ComResponse<List<String>> queryFillTimes(@RequestParam("staffNo") String staffNo);

    /**
     * 职能管理-填报绩效-组织架构
     */
    @RequestMapping(value = "/queryFillPerformanceDepartList", method = RequestMethod.GET)
    ComResponse<FillPerformanceOrgDto> queryFillPerformanceDepartList(@SpringQueryMap PerformanceVo performanceVo);

    /**
     * 职能管理-绩效考核-组织架构
     */
    @RequestMapping(value = "/queryRaterPerformanceDepartList", method = RequestMethod.GET)
    ComResponse<RaterPerformanceOrgDto> queryRaterPerformanceDepartList(@SpringQueryMap PerformanceVo performanceVo);

    /**
     * 职能管理-填报绩效-获取绩效信息
     */
    @RequestMapping(value = "/queryPerformanceByNo", method = RequestMethod.GET)
    ComResponse<PerformanceDto> queryPerformanceByNo(@RequestParam("performanceNo") Long performanceNo, @RequestParam("staffNo") String staffNo);

    /**
     * 职能管理-填报绩效-提交绩效
     */
    @RequestMapping(value = "/submitPerformance", method = RequestMethod.POST)
    ComResponse<Integer> submitPerformance(@RequestBody PerformanceCreateVo performanceCreateVo);

    /**
     * 职能管理-填报绩效-审核绩效
     */
    @RequestMapping(value = "/approvePerformance", method = RequestMethod.POST)
    ComResponse<Integer> approvePerformance(@RequestBody PerformanceApproveVo approvePerformanceVo);

    /**
     * 职能管理-绩效考核-提交绩效
     */
    @RequestMapping(value = "/insertPerformanceRater", method = RequestMethod.POST)
    ComResponse<Integer> insertPerformanceRater(@RequestBody PerformanceRaterDto performanceRaterDto);

    /**
     * 职能管理-绩效考核-查询评分列表
     */
    @RequestMapping(value = "/queryPerformanceRaterList", method = RequestMethod.GET)
    ComResponse<List<PerformanceRaterDto>> queryPerformanceRaterList(@RequestParam("performanceNo") Long performanceNo);

    /**
     * 职能管理-绩效考核-打回绩效
     */
    @RequestMapping(value = "/returnPerformance", method = RequestMethod.POST)
    ComResponse<Integer> returnPerformance(PerformanceReturnVo performanceReturnVo);

    /**
     * 个人中心-我的绩效-查询个人绩效
     */
    @RequestMapping(value = "/queryMyPerformance", method = RequestMethod.GET)
    ComResponse<MyPerformanceDto> queryMyPerformance(@RequestParam("fillTime") String fillTime, @RequestParam("staffNo") String staffNo);

    /**
     * 职能管理-绩效考核-考核统计
     */
    @RequestMapping(value = "/queryPerformanceApproveCount", method = RequestMethod.GET)
    ComResponse<PerformanceApproveCountDto> queryPerformanceApproveCount(@RequestParam("fillTime") String fillTime, @RequestParam("staffNo") String staffNo);

    /**
     * 是否负责人
     *
     * @return true: 负责人
     */
    @RequestMapping(value = "/isLeader", method = RequestMethod.GET)
    ComResponse<Boolean> isLeader(@RequestParam("staffNo") String staffNo);

    /**
     * 职能管理-绩效考核-查询绩效信息
     */
    @RequestMapping(value = "/queryRaterPerformanceByNo", method = RequestMethod.GET)
    ComResponse<MyPerformanceDto> queryRaterPerformanceByNo(@SpringQueryMap PerformanceVo performanceVo);
}
