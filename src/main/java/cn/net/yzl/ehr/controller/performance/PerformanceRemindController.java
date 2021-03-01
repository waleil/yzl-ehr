package cn.net.yzl.ehr.controller.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.performance.PerformanceRemindFeignService;
import cn.net.yzl.staff.constant.PerformanceConstant;
import cn.net.yzl.staff.dto.performance.PerformanceApproveRemindDto;
import cn.net.yzl.staff.dto.performance.PerformanceRemindDto;
import cn.net.yzl.staff.pojo.performance.PerformanceRemindPo;
import cn.net.yzl.staff.vo.performance.PerformanceNoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 职能管理-考评填报提醒
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/performance")
@Api(value = "职能管理-考评填报提醒", tags = {"职能管理-考评填报提醒"})
public class PerformanceRemindController {


    @Autowired
    private PerformanceRemindFeignService performanceRemindFeignService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "remindNo", value = "提醒编号", required = true, dataType = "Long", paramType = "query")
    })
    @ApiOperation(value = "查询填报提醒详情", notes = "查询填报提醒详情", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillRemind", method = RequestMethod.GET)
    public ComResponse<PerformanceRemindPo> queryFillRemind(@RequestParam("remindNo") Long remindNo) {
        return performanceRemindFeignService.queryFillRemind(remindNo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Long", paramType = "query")
    })
    @ApiOperation(value = "查询填报提醒列表", notes = "查询填报提醒列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillRemindAll", method = RequestMethod.GET)
    public ComResponse<Page<PerformanceRemindDto>> queryFillRemindAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return performanceRemindFeignService.queryFillRemindAll(pageNum, pageSize);
    }

    @ApiOperation(value = "新增填报提醒", notes = "新增填报提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertFillRemind", method = RequestMethod.POST)
    public ComResponse<Integer> insertFillRemind(@RequestBody PerformanceRemindPo performanceRemind, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceRemind.setCreator(staffNo);
        performanceRemind.setRemindType(PerformanceConstant.REMIND_TYPE_FILL);
        return performanceRemindFeignService.insertFillRemind(performanceRemind);
    }

    @ApiOperation(value = "修改填报提醒", notes = "修改填报提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateFillRemind", method = RequestMethod.POST)
    public ComResponse<Integer> updateFillRemind(@RequestBody PerformanceRemindPo performanceRemind, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceRemind.setUpdator(staffNo);
        return performanceRemindFeignService.updateFillRemind(performanceRemind);
    }

    @ApiOperation(value = "删除填报提醒", notes = "删除填报提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByRemindNo", method = RequestMethod.POST)
    public ComResponse<Integer> deleteByRemindNo(@RequestBody PerformanceNoVo performanceNoVo) {
        return performanceRemindFeignService.deleteByRemindNo(performanceNoVo);
    }

    @ApiOperation(value = "查询考核提醒", notes = "查询考核提醒", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryApproveRemind", method = RequestMethod.GET)
    public ComResponse<PerformanceApproveRemindDto> queryApproveRemind(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceRemindFeignService.queryApproveRemind(staffNo);
    }

    @ApiOperation(value = "修改考核提醒", notes = "修改考核提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateApproveRemind", method = RequestMethod.POST)
    public ComResponse<Integer> updateApproveRemind(@RequestBody PerformanceApproveRemindDto approveRemindDto, @ApiIgnore @CurrentStaffNo String staffNo) {
        approveRemindDto.setUpdator(staffNo);
        return performanceRemindFeignService.updateApproveRemind(approveRemindDto);
    }

    @ApiOperation(value = "发送绩效提醒(每小时执行一次)", notes = "发送绩效提醒(每小时执行一次)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendPerformanceRemind", method = RequestMethod.GET)
    public ComResponse<Boolean> sendPerformanceRemind() {
        return performanceRemindFeignService.sendPerformanceRemind();
    }

}
