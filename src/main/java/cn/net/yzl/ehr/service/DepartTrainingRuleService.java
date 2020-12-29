package cn.net.yzl.ehr.service;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartTrainingRuleDto;
import cn.net.yzl.ehr.vo.DepartTrainingRulePo;
import cn.net.yzl.ehr.vo.DepartTrainingRuleUpdatePo;

import java.util.List;

public interface DepartTrainingRuleService {


        ComResponse<Integer> add(DepartTrainingRulePo departTrainingRulePo);


        ComResponse<List<DepartTrainingRuleDto>> getByDepartId(Integer departId);


        ComResponse<Integer> update(DepartTrainingRuleUpdatePo itemUpdatePo);


        ComResponse<DepartTrainingRuleDto> getById(Integer postId) ;


        ComResponse<Integer> deleteById(Integer id, String updator) ;


    }
