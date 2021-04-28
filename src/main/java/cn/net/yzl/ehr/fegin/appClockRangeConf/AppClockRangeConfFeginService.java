package cn.net.yzl.ehr.fegin.appClockRangeConf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.pojo.AppClockRangeConfPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface AppClockRangeConfFeginService {

    @ApiOperation(value = "考勤范围设置", notes = "考勤范围设置", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/appClockRangeConf/saveUpDateAddress", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDateAddress(@RequestBody AppClockRangeConfPo appClockRangeConfPo);
}
