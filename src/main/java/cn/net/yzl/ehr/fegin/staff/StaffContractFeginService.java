package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffContartListDto;
import cn.net.yzl.ehr.pojo.StaffCFInsertPo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface StaffContractFeginService {

    @ApiOperation(value = "查询员工合同信息", notes = "查询员工合同信息")
    @RequestMapping(value = "/contract/findByStringNo", method = RequestMethod.GET)
    ComResponse<List<StaffContartListDto>> findByStringNo(@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "新建员工合同信息", notes = "新建员工合同信息")
    @RequestMapping(value = "/contract/insert", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> insert(@RequestBody StaffCFInsertPo staffCFInsertPo);


}
