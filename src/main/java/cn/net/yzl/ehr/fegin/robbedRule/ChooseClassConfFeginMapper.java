package cn.net.yzl.ehr.fegin.robbedRule;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.robbedRule.ChooseClassConfDto;
import cn.net.yzl.staff.vo.robbedRule.ChooseClassConfVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface ChooseClassConfFeginMapper {

    @RequestMapping(value = "/chooseClassConf/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody ChooseClassConfVO chooseClassConfVO);

    @RequestMapping(value = "/chooseClassConf/getChooseClassConfList", method = RequestMethod.GET)
    ComResponse<List<ChooseClassConfDto>> getChooseClassConfList(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime, @RequestParam("enable") Integer enable);

    @RequestMapping(value = "/chooseClassConf/stop", method = RequestMethod.GET)
    ComResponse<String> stop(@RequestParam("id") Integer id);
}
