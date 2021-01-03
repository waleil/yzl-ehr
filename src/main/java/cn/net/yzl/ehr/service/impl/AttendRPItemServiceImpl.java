package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.fegin.conf.AttendRPItemFeginService;
import cn.net.yzl.ehr.service.AttendRPItemService;
import cn.net.yzl.ehr.vo.DepartAttendRpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AttendRPItemServiceImpl implements AttendRPItemService {

    @Autowired
    private AttendRPItemFeginService attendRPItemFeginService;

    @Override
    public ComResponse<Integer> update(Map<Integer, Double> map) {
        return attendRPItemFeginService.update(map);
    }

    @Override
    public ComResponse<Integer> add(List<DepartAttendRpVO> departAttendRpVO) {
        return attendRPItemFeginService.add(departAttendRpVO);
    }

    @Override
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(Integer departId, Integer enable) {
        return attendRPItemFeginService.getByDepartId(departId,enable);
    }
}
