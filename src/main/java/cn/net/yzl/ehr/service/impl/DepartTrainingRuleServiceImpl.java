package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.fegin.depart.DepartTrainingRuleFeignService;
import cn.net.yzl.ehr.pojo.DepartTrainingRulePo;
import cn.net.yzl.ehr.pojo.DepartTrainingRuleUpdatePo;
import cn.net.yzl.ehr.service.DepartTrainingRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartTrainingRuleServiceImpl implements DepartTrainingRuleService {
    @Autowired
    private DepartTrainingRuleFeignService departTrainingRuleFeignService;
    @Override
    public ComResponse<Integer> add(DepartTrainingRulePo departTrainingRulePo) {
      return departTrainingRuleFeignService.add(departTrainingRulePo);
    }

    @Override
    public ComResponse<List<DepartTrainingRuleDto>> getDepartTraininRuleById(Integer departId) {
        return  departTrainingRuleFeignService.getDepartTraininRuleById((departId));
    }

    @Override
    public ComResponse<Integer> deleteDepartTrainingRuleById(Integer id) {
        return departTrainingRuleFeignService.deleteDepartTrainingRuleById((id));
    }

    @Override
    public ComResponse<DepartTrainingRuleDto> getPostById(Integer id) {
      return departTrainingRuleFeignService.getPostById(id);
       // return     ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
    }

    @Override
    public ComResponse<Integer> updatePost(DepartTrainingRuleUpdatePo departTrainingRulePo) {
        return departTrainingRuleFeignService.updatePost(departTrainingRulePo);
    }
}
