package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.processActiveService.FindProcessNodeService;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveLeaveDayDTO;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.dto.processNode.ProcessNodeDTO;
import cn.net.yzl.staff.dto.processNode.StaffLeaveDTO;

import cn.net.yzl.staff.exception.BaseParamsException;
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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
    @ApiOperation(value = "获取当前当前员工信息")
    public ComResponse<StaffDetailsDto> findProcessInfoList(@CurrentStaffNo @NotNull String staffNo) {
        return findProcessNodeService.findProcessInfoList(staffNo);
    }

    @PostMapping("v1/saveProcessLeaveInfo")
    @ApiOperation(value = "保存请假信息")
    public ComResponse<ProcessApproveNode> saveProcessLeaveInfo(@RequestBody @Valid StaffLeaveDTO staffLeaveDTO, @CurrentStaffNo @NotNull String staffNo) {
        staffLeaveDTO.setStaffNo(staffNo);
        Date startTime=staffLeaveDTO.getStartTime();
        Instant instant = startTime.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();

        LocalDate now = LocalDate.now();

        if (now.isAfter(localDate)){
            throw new BaseParamsException(ResponseCodeEnums.API_ERROR_CODE.getCode(), "请假时间不能小于当前时间！");
        }

        ComResponse<ProcessApproveNode> flag = findProcessNodeService.saveProcessLeaveInfo(staffLeaveDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo,
                        flag.getData().getStaffNo(),
                        flag.getData().getProcessName());
                MessageRemandAPI.processSendMessage(flag.getData().getProcessId(),
                        staffNo,
                        flag.getData().getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @GetMapping("v1/getLeaveNumInfo")
    @ApiOperation(value = "获得年假信息")
    public ComResponse<ApproveLeaveDayDTO> getLeaveNumInfo(@RequestParam @NotNull Integer departId,
                                                           @RequestParam @NotNull Integer sysDictDataId,
                                                           @CurrentStaffNo @ApiIgnore String staffNo) {

        return findProcessNodeService.getLeaveNumInfo(departId,sysDictDataId,staffNo);
    }

}
