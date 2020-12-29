package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendFtDto;
import cn.net.yzl.ehr.pojo.DepartAttendFtPo;
import cn.net.yzl.ehr.vo.DepartAttendVo;

import java.util.List;

public interface DepartAttendFtService {

    ComResponse<Integer> add(DepartAttendFtPo departAttendFtPo);

    ComResponse<List<DepartAttendFtDto>> getDepartAttendFtList();

    ComResponse<Integer> deleteDepartAttendFt(Integer id);


    ComResponse<Integer> update(DepartAttendFtPo departAttendFtPo);

    ComResponse<List<DepartAttendVo>> getByDepartId(Integer departId);
}
