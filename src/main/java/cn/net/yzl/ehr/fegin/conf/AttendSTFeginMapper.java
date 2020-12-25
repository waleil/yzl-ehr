package cn.net.yzl.ehr.fegin.conf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendStDto;
import cn.net.yzl.ehr.vo.DepartAttendStVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
//@FeignClient(value = "staff",url = "${fegin.db.url}")
@FeignClient(name = "yzl-staff-db")
public interface AttendSTFeginMapper {


    @RequestMapping(value = "/conf/attendST/add", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> add(@RequestBody DepartAttendStVO departAttendStVO);

    @RequestMapping(value = "/conf/attendST/update", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> update(@RequestBody DepartAttendStVO departAttendStVO);
    @RequestMapping(value = "/conf/attendST/getByDepartId", method = RequestMethod.GET)
    ComResponse<DepartAttendStDto> getByDepartId(@RequestParam("departId") Integer departId);

}
