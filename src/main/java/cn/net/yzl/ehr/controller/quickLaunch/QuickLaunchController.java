package cn.net.yzl.ehr.controller.quickLaunch;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.quickLaunch.QuickLaunchService;
import cn.net.yzl.staff.dto.quickLaunch.QuickLaunchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/work")
@Api(tags = "工作台")
public class QuickLaunchController {
    @Autowired
    private QuickLaunchService quickLaunchService;
    @ApiOperation(value = "根据员工展示前8个常用流程", notes = "根据员工展示前8个常用流程", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryByNo", method = RequestMethod.GET)
    ComResponse<List<QuickLaunchDto>> queryByNo( @ApiIgnore @CurrentStaffNo String staffNo) {
        return quickLaunchService.queryByNo(staffNo);
    }
}
