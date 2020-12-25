package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendStDto;
import cn.net.yzl.ehr.vo.DepartAttendStVO;

public interface AttendSTService {

    ComResponse<Integer> add(DepartAttendStVO departAttendStVO);

    ComResponse<Integer> update(DepartAttendStVO departAttendStVO);

    ComResponse<DepartAttendStDto> getByDepartId(Integer departId);
}
