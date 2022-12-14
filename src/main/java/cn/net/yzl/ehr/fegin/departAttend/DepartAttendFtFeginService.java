package cn.net.yzl.ehr.fegin.departAttend;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartAttendFtDto;
import cn.net.yzl.ehr.pojo.DepartAttendFtPo;
import cn.net.yzl.ehr.vo.DepartAttendVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface DepartAttendFtFeginService {

    @RequestMapping(value = "/departAttendFt/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody DepartAttendFtPo departAttendFtPo);

    @RequestMapping(value = "/departAttendFt/getDepartAttendFtList", method = RequestMethod.GET)
    ComResponse<List<DepartAttendFtDto>> getDepartAttendFtList();

    @RequestMapping(value = "/departAttendFt/deleteDepartAttendFt", method = RequestMethod.POST)
    ComResponse<Integer> deleteDepartAttendFt(Integer id);

    @RequestMapping(value = "/departAttendFt/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody DepartAttendFtPo departAttendFtPo);

    @RequestMapping(value = "/departAttendFt/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartAttendVo>> getByDepartId(@RequestParam("departId") Integer departId);
}
