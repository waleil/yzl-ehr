package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffEduService;
import cn.net.yzl.ehr.service.StaffEntryPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/staff/entrypost")
@Api(value = "员工入岗", tags = {"员工档案"})
public class StaffEntryPostController {
    @Autowired
    private StaffEntryPostService staffEntryPostService;

    @ApiOperation(value = "员工入岗—入岗",notes = "员工入岗",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "StaffNo", value = "员工工号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ComResponse<Integer> findByStaffNo(@RequestParam("StaffNo") String staffNo) {
        return staffEntryPostService.insert(staffNo);
    }


}
