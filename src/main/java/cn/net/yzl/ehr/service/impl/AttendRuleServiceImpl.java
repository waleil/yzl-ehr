package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.DepartAttendRuleDto;
import cn.net.yzl.ehr.fegin.conf.AttendRuleFeginService;
import cn.net.yzl.ehr.service.AttendRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendRuleServiceImpl implements AttendRuleService {
    @Autowired
    private AttendRuleFeginService attendRuleFeginService;

    @Override
    public ComResponse<Integer> update(DepartAttendRuleDto departAttendRuleDto) {



        return attendRuleFeginService.update(departAttendRuleDto);
    }

    @Override
    public ComResponse<Integer> add(DepartAttendRuleDto departAttendRuleDto) {


        Byte type = departAttendRuleDto.getType();






        return attendRuleFeginService.add(departAttendRuleDto);
    }

    @Override
    public ComResponse<Page<DepartAttendRuleDto>> getByDepartId(Integer departId, Integer pageNo, Integer pageSize) {
        return attendRuleFeginService.getByDepartId(departId,pageNo,pageSize);
    }
}
