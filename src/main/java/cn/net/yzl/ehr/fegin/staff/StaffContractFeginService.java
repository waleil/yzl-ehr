package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffContartListDto;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Repository
//@FeignClient(value = "staff",url = "${fegin.db.url}")
@FeignClient(name = "yzl-staff-db")
public interface StaffContractFeginService {

    @ApiOperation(value = "查询员工合同信息", notes = "查询员工合同信息")
    @RequestMapping(value = "/contract/findByStringNo", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<List<StaffContartListDto>> findByStringNo(String staffNo);

    @ApiOperation(value = "新建员工合同信息", notes = "新建员工合同信息")
    @RequestMapping(value = "/contract/insert", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<Integer> insert(StaffCFInsertPo staffCFInsertPo);


}
