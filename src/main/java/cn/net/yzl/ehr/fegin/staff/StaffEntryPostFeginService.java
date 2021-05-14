package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.pojo.StaffEntryPostConfirmPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface StaffEntryPostFeginService {


    @RequestMapping(value = "/entrypost/insert", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> insert(@RequestBody @Validated StaffEntryPostConfirmPo confirmPo) throws ParseException;

    @RequestMapping(value = "/entrypost/updateAutomaticEntryDays", method = RequestMethod.GET)
    ComResponse<Integer> updateAutomaticEntryDays(@RequestParam("days") Integer days, @RequestParam("staffNo") String staffNo);

}
