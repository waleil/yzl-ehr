package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.vo.DepartAttendRpVO;

import java.util.List;
import java.util.Map;


public interface AttendRPItemService {

    ComResponse<Integer> update(List<Map<String, Double>> map);

    ComResponse<Integer> add(List<DepartAttendRpVO> departAttendRpVO);

    ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(Integer departId, Integer enable);
}
