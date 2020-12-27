package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.fegin.conf.AttendRPItemFeginService;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.service.AttendRPItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AttendRPItemServiceImpl implements AttendRPItemService {

    @Autowired
    private AttendRPItemFeginService attendRPItemFeginService;

    @Autowired
    private DepartFeginService departFeginService;

    @Override
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(Integer departId) {
        // 判断部门存在不
        ComResponse<DepartDto> departDto = departFeginService.getById(departId);
        if(departDto.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getCode(),ResponseCodeEnums.DEPART_NOEXIT_ERROR_CODE.getMessage());
        }

        return attendRPItemFeginService.getByDepartId(departId);
    }

    @Override
    public ComResponse<Integer> update(Map<Integer, Double> map) {

        // 判断attendRpId是否存在
        return attendRPItemFeginService.update(map);
    }
}
