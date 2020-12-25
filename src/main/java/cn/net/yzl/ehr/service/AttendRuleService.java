package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;


public interface AttendRuleService {
    ComResponse<Integer> update(DepartAttendRuleDto departAttendRuleDto);

    ComResponse<Integer> add(DepartAttendRuleDto departAttendRuleDto);

    ComResponse<Page<DepartAttendRuleDto>> getByDepartId(Integer departId, Integer pageNo, Integer pageSize);
}
