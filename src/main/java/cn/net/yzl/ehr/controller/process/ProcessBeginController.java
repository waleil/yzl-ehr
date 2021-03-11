package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.processActiveService.saveProcessService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.personApprove.ApproveDimissionInfoListDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveInviteDTO;
import cn.net.yzl.staff.dto.personApprove.ApprovePostInfoListDTO;
import cn.net.yzl.staff.exception.BaseParamsException;
import cn.net.yzl.staff.vo.process.ProcessStaffDimissionVo;
import cn.net.yzl.staff.vo.process.ProcessStaffPositiveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/processsInvite")
@Api(tags = "招聘流程")
public class ProcessBeginController {

    @Autowired
    private saveProcessService saveProcessService;

    @PostMapping("v1/saveProcessInviteInfo")
    @ApiOperation(value = "保存招聘信息")
    public ComResponse<Boolean> saveProcessLeaveInfo(@RequestBody @Valid ApproveInviteDTO approveInviteDTO) {
        ComResponse<Boolean> flag = saveProcessService.saveProcessInviteInfo(approveInviteDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveInviteDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveInviteDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveInviteDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveInviteDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveInviteDTO.getProcessNodeDTOList().get(0).getStaffName(),
                        approveInviteDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
    @ApiOperation(value = "保存转正申请",notes = "转正申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/savePositiveApplay", method = RequestMethod.POST)
    ComResponse<Boolean> savePositiveApplay (@RequestBody @Validated ApprovePostInfoListDTO approvePostInfoListDTO){
        ComResponse<Boolean> flag = saveProcessService.savePositiveApplay(approvePostInfoListDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approvePostInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approvePostInfoListDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(0).getStaffName(),
                        approvePostInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
    @ApiOperation(value = "保存离职申请",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveDimissionApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveDimissionApplay (@RequestBody @Validated ApproveDimissionInfoListDTO approveDimissionInfoListDTO){
        ComResponse<Boolean> flag = saveProcessService.saveDimissionApplay(approveDimissionInfoListDTO);
        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getStaffNo(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(1).getStaffNo(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
                MessageRemandAPI.processSendMessage(approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getProcessId(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getStaffName(),
                        approveDimissionInfoListDTO.getProcessNodeDTOList().get(0).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }
}
