package cn.net.yzl.ehr.controller.appClockRangeConf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.appClockRangeConf.AppClockRangeConfService;
import cn.net.yzl.staff.pojo.AppClockRangeConfPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/appClockRangeConf")
@Api(value = "考勤范围设置", tags = {"考勤范围设置"})
public class AppClockRangeConfController {

    @Autowired
    private AppClockRangeConfService appClockRangeConfService;

    /**
     * 考勤范围设置
     * @param appClockRangeConfPo
     * @return 设置考勤范围
     */
    @ApiOperation(value = "考勤范围设置", notes = "考勤范围设置", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/saveUpDateAddress", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDateAddress(@RequestBody AppClockRangeConfPo appClockRangeConfPo,@ApiIgnore @CurrentStaffNo String staffNo) {
        return appClockRangeConfService.saveUpDateAddress(appClockRangeConfPo,staffNo);
    }
}
