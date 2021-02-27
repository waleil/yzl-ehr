package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.processActiveService.saveProcessService;
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

        return saveProcessService.saveProcessInviteInfo(approveInviteDTO);
    }
    @ApiOperation(value = "保存转正申请",notes = "转正申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/savePositiveApplay", method = RequestMethod.POST)
    ComResponse<Boolean> savePositiveApplay (@RequestBody @Validated ApprovePostInfoListDTO approvePostInfoListDTO){

        return saveProcessService.savePositiveApplay(approvePostInfoListDTO);
    }
    @ApiOperation(value = "保存离职申请",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveDimissionApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveDimissionApplay (@RequestBody @Validated ApproveDimissionInfoListDTO approveDimissionInfoListDTO){

        return saveProcessService.saveDimissionApplay(approveDimissionInfoListDTO);
    }
}
