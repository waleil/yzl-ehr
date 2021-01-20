package cn.net.yzl.ehr.fegin.robbedRule;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.robbedRule.NoRobbedConfDto;
import cn.net.yzl.staff.vo.robbedRule.NoRobbedConfVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@FeignClient(value = "noRobbedConfFeginMapper",url = "${fegin.db.url}")
@Repository
public interface NoRobbedConfFeginMapper {

    @RequestMapping(value = "/noRobbedConf/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody NoRobbedConfVO noRobbedConfVO);
    @RequestMapping(value = "/noRobbedConf/getNoRobbedConfList", method = RequestMethod.GET)
    ComResponse<List<NoRobbedConfDto>> getNoRobbedConfList(@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,@RequestParam("enable") Integer enable);
    @RequestMapping(value = "/noRobbedConf/stop", method = RequestMethod.GET)
    ComResponse<String> stop(@RequestParam("id") Integer id);
}
