package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendRpDto;
import cn.net.yzl.ehr.dto.DepartAttendRpItemInfoDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
public interface AttendRPItemFeginService {


    @RequestMapping(value = "/conf/attendRP/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody Map<Integer,Double> map);

    @RequestMapping(value = "/conf/attendRP/getByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartAttendRpItemInfoDto>> getByDepartId(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/conf/attendRP/getByAttendRpId", method = RequestMethod.GET)
    public ComResponse<DepartAttendRpDto> getByAttendRpId(@RequestParam("attendRpId") Integer attendRpId);

}
