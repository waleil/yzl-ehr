package cn.net.yzl.ehr.fegin.processActiveService;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.personApprove.ApproveAbsentInfoListDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveDimissionInfoListDTO;
import cn.net.yzl.staff.dto.personApprove.ApproveInviteDTO;
import cn.net.yzl.staff.dto.personApprove.ApprovePostInfoListDTO;
import cn.net.yzl.staff.vo.process.ProcessStaffDimissionVo;
import cn.net.yzl.staff.vo.process.ProcessStaffPositiveVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(name="processsInvite",url="${fegin.db.url}/processsInvite")
//@FeignClient(name="processsInvite",url="localhost:38080/processsInvite")
public interface saveProcessService {
    @PostMapping("v1/saveProcessInviteInfo")
    @ApiOperation(value = "保存招聘信息")
    ComResponse<Boolean> saveProcessInviteInfo(@RequestBody @Validated ApproveInviteDTO approveInviteDTO);
    @ApiOperation(value = "保存转正申请",notes = "转正申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/savePositiveApplay", method = RequestMethod.POST)
    ComResponse<Boolean> savePositiveApplay(@RequestBody @Validated ApprovePostInfoListDTO approvePostInfoListDTO);
    @ApiOperation(value = "保存离职申请",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveDimissionApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveDimissionApplay(@RequestBody @Validated ApproveDimissionInfoListDTO approveDimissionInfoListDTO);
    @ApiOperation(value = "保存旷工申请",notes = "离职申请添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "v1/saveAbsentApplay", method = RequestMethod.POST)
    ComResponse<Boolean> saveAbsentApplay(@RequestBody ApproveAbsentInfoListDTO approveAbsentInfoListDTO);
}
