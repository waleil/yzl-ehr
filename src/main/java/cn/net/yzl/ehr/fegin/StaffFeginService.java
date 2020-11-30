package cn.net.yzl.ehr.fegin;

import cn.net.yzl.common.entity.ResultDto;
import cn.net.yzl.ehr.pojo.StaffPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yzl-staff-service",fallback = StaffFeginServiceFallBack.class)
public interface StaffFeginService {


    @RequestMapping(value = "/staff/getById", method = RequestMethod.GET)
    ResultDto<String> getByPrimaryKey( @RequestParam("id") int id);
}
