package cn.net.yzl.ehr.fegin;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.StaffPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yzl-staff-service",fallback = StaffFeginServiceFallBack.class)
@Repository
public interface StaffFeginService {


    @RequestMapping(value = "/staff/getById", method = RequestMethod.GET)
    ComResponse<String> getByPrimaryKey( @RequestParam("id") int id);
}
