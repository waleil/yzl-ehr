package cn.net.yzl.ehr.controller.staffArchives;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.StaffEntryPostService;
import cn.net.yzl.staff.pojo.StaffEntryPostConfirmPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.text.ParseException;

@RestController
@RequestMapping("/staff/entrypost")
@Api(value = "人事管理", tags = {"人事管理"})
public class StaffEntryPostController {
    @Autowired
    private StaffEntryPostService staffEntryPostService;

    @ApiOperation(value = "员工入岗-员工入岗", notes = "员工入岗",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody StaffEntryPostConfirmPo confirmPo) throws ParseException {
        return staffEntryPostService.insert(confirmPo);
    }


    @ApiOperation(value = "员工入岗-更改自动入岗时间",notes = "更改自动入岗时间",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/entrypost/updateAutomaticEntryDays",method = RequestMethod.GET)
    ComResponse<Integer> updateAutomaticEntryDays(@RequestParam("days") Integer days, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> result =  staffEntryPostService.updateAutomaticEntryDays(days,staffNo);
        return result;
    }

}
