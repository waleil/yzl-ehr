package cn.net.yzl.ehr.fegin.departAttend;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.AttendFalsePunishDto;
import cn.net.yzl.ehr.pojo.AttendFalsePunishPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "yzl-staff-db")
@Repository
public interface AttendFalsePunishFeginService {

    @RequestMapping(value = "/attendFalseP/add", method = RequestMethod.POST)
    ComResponse<Integer> add(AttendFalsePunishPo attendFalsePunishPo);

    @RequestMapping(value = "/attendFalseP/getPunishList", method = RequestMethod.GET)
    ComResponse<List<AttendFalsePunishDto>>  getPunishList();
}
