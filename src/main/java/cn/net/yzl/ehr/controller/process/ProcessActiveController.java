package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.processActiveService.FindProcessNodeService;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDayDTO;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;

import com.alibaba.nacos.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/processActive")
@Api(tags = "发起流程")
public class ProcessActiveController {
    @Autowired
    private FindProcessNodeService findProcessNodeService;

    @Autowired
    private FastDFSClientWrapper client;

    @GetMapping("v1/findProcessInfoList")
    @ApiOperation(value = "获取流程每个节点信息")
    public ComResponse<StaffDetailsDto> findProcessInfoList(@RequestParam @NotNull @CurrentStaffNo String staffNo) {
        return findProcessNodeService.findProcessInfoList(staffNo);
    }

    @PostMapping("v1/saveProcessLeaveInfo")
    @ApiOperation(value = "保存请假信息")
    public ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid ApproveLeaveDTO approveLeaveDTO) {
        ComResponse<Boolean> flag = findProcessNodeService.saveProcessLeaveInfo(approveLeaveDTO);
        //if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveLeaveDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveLeaveDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveLeaveDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveLeaveDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveLeaveDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveLeaveDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
       // }
        return ComResponse.success();
    }

    @GetMapping("v1/getLeaveNumInfo")
    @ApiOperation(value = "获得年假信息")
    public ComResponse<ApproveLeaveDayDTO> getLeaveNumInfo(@RequestParam @NotNull Integer departId,
                                                           @RequestParam @NotNull Integer sysDictDataId,
                                                           @CurrentStaffNo @ApiIgnore String staffNo) {

        return findProcessNodeService.getLeaveNumInfo(departId,sysDictDataId,staffNo);
    }

}
