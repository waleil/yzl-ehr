package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendFtDto;
import cn.net.yzl.ehr.fegin.departAttend.DepartAttendFtFeginService;
import cn.net.yzl.ehr.pojo.DepartAttendFtPo;
import cn.net.yzl.ehr.service.DepartAttendFtService;
import cn.net.yzl.ehr.vo.DepartAttendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartAttendFtServiceImpl implements DepartAttendFtService {

    @Autowired
    private DepartAttendFtFeginService departAttendFtFeginService;

    @Override
    public ComResponse<Integer> add(DepartAttendFtPo departAttendFtPo) {
        return departAttendFtFeginService.add(departAttendFtPo);
    }

    @Override
    public ComResponse<List<DepartAttendFtDto>> getDepartAttendFtList() {
        return departAttendFtFeginService.getDepartAttendFtList();
    }

    @Override
    public ComResponse<Integer> deleteDepartAttendFt(Integer id) {
        return departAttendFtFeginService.deleteDepartAttendFt(id);
    }

    @Override
    public ComResponse<Integer> update(DepartAttendFtPo departAttendFtPo) {
        return departAttendFtFeginService.update(departAttendFtPo);
    }

    @Override
    public ComResponse<List<DepartAttendVo>> getByDepartId(Integer departId) {
        return departAttendFtFeginService.getByDepartId(departId);
    }

}
