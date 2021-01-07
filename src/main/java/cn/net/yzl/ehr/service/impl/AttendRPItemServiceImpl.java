package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.fegin.conf.AttendRPItemFeginService;
import cn.net.yzl.ehr.service.AttendRPItemService;
import cn.net.yzl.ehr.vo.DepartAttendRpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AttendRPItemServiceImpl implements AttendRPItemService {

    @Autowired
    private AttendRPItemFeginService attendRPItemFeginService;

    @Override
    public ComResponse<Integer> update(List<Map<String, Double>> list) {
        HashMap<Integer, Double> mapParams = new HashMap<>();
        // 修改前端参数
        if(list!=null && list.size()>0){
            for (Map<String, Double> map : list) {
                Double key = map.get("key");
                Double value = map.get("value");
                mapParams.put(key.intValue(),value);
            }

        }

        return attendRPItemFeginService.update(mapParams);
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
