package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.processActiveService.FindProcessNodeService;
import cn.net.yzl.ehr.fegin.processActiveService.saveProcessService;
import cn.net.yzl.staff.dto.personApprove.ApproveProcessListDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/processsInvite")
@Api(tags = "招聘流程")
public class ProcessBeginController {

    @Autowired
    private saveProcessService saveProcessService;

    @PostMapping("v1/saveProcessInviteInfo")
    @ApiOperation(value = "保存招聘信息")
    public ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid ApproveProcessListDTO approveProcessListDTO) {

        return saveProcessService.saveProcessInviteInfo(approveProcessListDTO);
    }

}
