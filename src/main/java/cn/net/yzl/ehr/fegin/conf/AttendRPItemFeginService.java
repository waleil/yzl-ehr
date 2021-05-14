package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import cn.net.yzl.ehr.vo.DepartAttendRpVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface AttendRPItemFeginService {


    @RequestMapping(value = "/conf/attendRP/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody Map<Integer, Double> map);

    @RequestMapping(value = "/conf/attendRP/add", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> add(@RequestBody @Validated List<DepartAttendRpVO> departAttendRpVO);


    @RequestMapping(value = "/conf/attendRP/getByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(@RequestParam("departId") Integer departId, @RequestParam("enable") Integer enable);
}
