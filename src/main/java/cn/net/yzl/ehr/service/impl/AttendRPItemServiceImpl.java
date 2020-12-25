package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.fegin.conf.AttendRPItemFeginService;
import cn.net.yzl.ehr.service.AttendRPItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AttendRPItemServiceImpl implements AttendRPItemService {

    @Autowired
    private AttendRPItemFeginService attendRPItemFeginService;

    @Override
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(Integer departId) {
        return attendRPItemFeginService.getByDepartId(departId);
    }

    @Override
    public ComResponse<Integer> update(Map<Integer, Double> map) {
        return attendRPItemFeginService.update(map);
    }
}
