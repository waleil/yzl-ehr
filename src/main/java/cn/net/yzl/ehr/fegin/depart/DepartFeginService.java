package cn.net.yzl.ehr.fegin.depart;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.DepartPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "yzl-staff-service")
@Repository
public interface DepartFeginService {


    @RequestMapping(value = "/depart/create", method = RequestMethod.POST)
    ComResponse<String> create(@RequestBody DepartPo departPo);

    @RequestMapping(value = "/depart/getByDingDepartId", method = RequestMethod.GET)
    ComResponse<DepartPo> getByDingDepartId(@RequestParam String dingDepartId);
}
