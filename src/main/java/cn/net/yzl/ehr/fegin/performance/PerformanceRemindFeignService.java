package cn.net.yzl.ehr.fegin.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.performance.PerformanceApproveRemindDto;
import cn.net.yzl.staff.dto.performance.PerformanceRemindDepartDto;
import cn.net.yzl.staff.dto.performance.PerformanceRemindDto;
import cn.net.yzl.staff.pojo.performance.PerformanceRemindPo;
import cn.net.yzl.staff.vo.performance.PerformanceNoVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 职能部门-考评填报提醒服务
 *
 * @author biebaojie
 */
@FeignClient(value = "PerformanceFeignService", url = "${fegin.db.url}/performance")
//@FeignClient(value = "PerformanceFeignService", url = "http://localhost:38080/performance")
@RefreshScope
public interface PerformanceRemindFeignService {

    /**
     * 查询填报提醒详情
     */
    @RequestMapping(value = "/queryFillRemind", method = RequestMethod.GET)
    ComResponse<PerformanceRemindPo> queryFillRemind(@RequestParam("remindNo") Long remindNo);

    /**
     * 查询填报提醒列表
     */
    @RequestMapping(value = "/queryFillRemindAll", method = RequestMethod.GET)
    ComResponse<Page<PerformanceRemindDto>> queryFillRemindAll(@RequestParam(value = "pageNum") Integer pageNum,
                                                               @RequestParam(value = "pageSize") Integer pageSize);

    /**
     * 新增填报提醒
     */
    @RequestMapping(value = "/insertFillRemind", method = RequestMethod.POST)
    ComResponse<Integer> insertFillRemind(@RequestBody PerformanceRemindPo performanceRemind);

    /**
     * 修改填报提醒
     */
    @RequestMapping(value = "/updateFillRemind", method = RequestMethod.POST)
    ComResponse<Integer> updateFillRemind(@RequestBody PerformanceRemindPo performanceRemind);

    /**
     * 删除填报提醒
     */
    @RequestMapping(value = "/deleteByRemindNo", method = RequestMethod.POST)
    ComResponse<Integer> deleteByRemindNo(@RequestBody PerformanceNoVo performanceNoVo);

    /**
     * 查询考核提醒
     */
    @RequestMapping(value = "/queryApproveRemind", method = RequestMethod.GET)
    ComResponse<PerformanceApproveRemindDto> queryApproveRemind(@RequestParam("staffNo") String staffNo);

    /**
     * 修改考核提醒
     */
    @RequestMapping(value = "/updateApproveRemind", method = RequestMethod.POST)
    ComResponse<Integer> updateApproveRemind(@RequestBody PerformanceApproveRemindDto approveRemindDto);

    /**
     * 发送绩效提醒(每小时执行一次)
     */
    @RequestMapping(value = "/sendPerformanceRemind", method = RequestMethod.GET)
    ComResponse<List<PerformanceRemindDepartDto>> sendPerformanceRemind();

    /**
     * 更新系统时间
     */
    @RequestMapping(value = "/updateSystemDate", method = RequestMethod.GET)
    ComResponse<Boolean> updateSystemDate(String systemDate);
}
