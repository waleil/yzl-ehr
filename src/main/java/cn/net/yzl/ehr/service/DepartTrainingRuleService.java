package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.pojo.DepartTrainingRulePo;
import cn.net.yzl.ehr.pojo.DepartTrainingRuleUpdatePo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartTrainingRuleService {

    ComResponse<Integer> add(@RequestBody @Validated DepartTrainingRulePo departTrainingRulePo);

    public ComResponse<List<DepartTrainingRuleDto>> getDepartTraininRuleById(Integer departId);


    ComResponse<Integer> deleteDepartTrainingRuleById(Integer id);

    public ComResponse<DepartTrainingRuleDto> getPostById(Integer id);

    ComResponse<Integer> updatePost(@RequestBody @Validated DepartTrainingRuleUpdatePo departTrainingRulePo);
}
