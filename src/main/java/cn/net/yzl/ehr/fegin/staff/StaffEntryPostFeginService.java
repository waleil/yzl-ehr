package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.pojo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface StaffEntryPostFeginService {


    @ApiOperation(value = "员工入岗",notes = "员工入岗",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/entrypost/insert",method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> insert(@RequestParam("staffNo")  String staffNo);

}
