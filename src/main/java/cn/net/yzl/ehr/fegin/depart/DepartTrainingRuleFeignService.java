package cn.net.yzl.ehr.fegin.depart;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.pojo.DepartTrainingRulePo;
import cn.net.yzl.ehr.pojo.DepartTrainingRuleUpdatePo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db")
@Repository
public interface DepartTrainingRuleFeignService {

    @RequestMapping(value = "/conf/training/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody @Validated DepartTrainingRulePo departTrainingRulePo);

    @RequestMapping(value = "/conf/training/getDepartTraininRuleById", method = RequestMethod.GET)
    public ComResponse<List<DepartTrainingRuleDto>> getDepartTraininRuleById(@RequestParam("departId")Integer departId);


    @RequestMapping(value = "/conf/training/deletePost", method = RequestMethod.POST)
    ComResponse<Integer> deleteDepartTrainingRuleById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/conf/training/getPostById", method = RequestMethod.GET)
    public ComResponse<DepartTrainingRuleDto> getPostById(@RequestParam("id")Integer id);

    @RequestMapping(value = "/conf/training/updatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> updatePost(@RequestBody @Validated DepartTrainingRuleUpdatePo departTrainingRulePo);
}
