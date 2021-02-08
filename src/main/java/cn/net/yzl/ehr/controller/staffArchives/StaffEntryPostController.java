package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.StaffEntryPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff/entrypost")
@Api(value = "员工入岗", tags = {"员工档案"})
public class StaffEntryPostController {
    @Autowired
    private StaffEntryPostService staffEntryPostService;

    @ApiOperation(value = "员工入岗-员工入岗", notes = "员工入岗",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestParam("staffNo") String staffNo) {
        return staffEntryPostService.insert(staffNo);
    }

}
