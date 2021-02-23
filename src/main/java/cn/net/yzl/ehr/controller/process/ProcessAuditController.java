package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.process.ProcessAuditService;
import cn.net.yzl.staff.vo.process.ProcessAuditVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/process")
@Api(value = "审批申请实例",tags = {"审批申请实例"})
public class ProcessAuditController {

    @Autowired
    private ProcessAuditService processAuditService;

    @ApiOperation(value = "审批申请实例修改",notes = "审批申请实例修改",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/audit/update/state", method = RequestMethod.POST)
    ComResponse<Integer> updateProcessAuditState (@RequestBody @Validated ProcessAuditVo processAuditVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processAuditService.updateProcessAuditState(processAuditVo,staffNo);
    }

}
