package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;

import java.util.List;
import java.util.Map;


public interface AttendRPItemService {
    ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(Integer departId);
    ComResponse<Integer> update(Map<Integer, Double> map);
}
