package cn.net.yzl.ehr.fegin.quickLaunch;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.staff.dto.quickLaunch.QuickLaunchDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface QuickLaunchFeginService {
    @ApiOperation(value = "根据员工展示前8个常用流程", notes = "根据员工展示前8个常用流程", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/work/queryByNo", method = RequestMethod.GET)
    ComResponse<List<QuickLaunchDto>> queryByNo(@RequestParam("staffNo") String staffNo);
}
