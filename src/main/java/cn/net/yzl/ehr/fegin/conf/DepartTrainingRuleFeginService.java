package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.vo.DepartTrainingRulePo;
import cn.net.yzl.ehr.vo.DepartTrainingRuleUpdatePo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 部门的 fegin client
 */

@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
@Repository
public interface DepartTrainingRuleFeginService {
    @RequestMapping(value = "/conf/training/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody DepartTrainingRulePo departTrainingRulePo);

    @RequestMapping(value = "/conf/training/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartTrainingRuleDto>> getByDepartId(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/conf/training/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody DepartTrainingRuleUpdatePo itemUpdatePo);

    @RequestMapping(value = "/conf/training/getById", method = RequestMethod.GET)
    ComResponse<DepartTrainingRuleDto> getById(@RequestParam("id") Integer id) ;

    @RequestMapping(value = "/conf/training/deleteById", method = RequestMethod.POST)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @RequestParam("updator") String updator) ;

}
