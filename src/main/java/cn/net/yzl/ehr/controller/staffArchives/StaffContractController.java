package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffContartListDto;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffContractService;
import cn.net.yzl.ehr.service.StaffWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff/staffcontract")
@Api(value = "合同信息", tags = {"员工档案"})
public class StaffContractController {
    @Autowired
    private StaffWorkService staffWorkService;

    @Autowired
    private StaffContractService staffContartService;

    @ApiOperation(value = "合同信息-查询员工合同信息",notes = "查询员工合同信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/findByStringNo", method = RequestMethod.GET)
    ComResponse<List<StaffContartListDto>> list(@RequestParam String staffNo) {
        return staffContartService.findByStringNo(staffNo);
    }

    @ApiOperation(value = "合同信息-新建员工合同信息",notes = "新建员工合同信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody StaffCFInsertPo staffCFInsertPo) {
        return staffContartService.insert(staffCFInsertPo);
    }


}
