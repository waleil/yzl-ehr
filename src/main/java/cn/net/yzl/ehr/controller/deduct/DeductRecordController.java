package cn.net.yzl.ehr.controller.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.ehr.service.deduct.DeductReocrdService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.deduct.*;
import cn.net.yzl.staff.pojo.deduct.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/deductRecord")
@Api(value = "扣款记录", tags = {"奖惩管理"})
public class DeductRecordController {
    @Autowired
    private DeductReocrdService deductReocrdService;

    @Autowired
    private YMsgInfoService ymsgInfoService;

    @ApiOperation(value = "查询扣款列表信息", notes = "查询扣款列表信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    ComResponse<List<DeductRecordDto>> getList(@RequestBody(required = false) DeductRecordListPo deductRecordListPo) {
        return deductReocrdService.getList(deductRecordListPo);
    }


    @ApiOperation(value = "停止扣款", notes = "停止扣款",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateStateById", method = RequestMethod.POST)
    ComResponse<Integer> updateStateById(@RequestBody DeductRecordUpdatePo deductRecordUpdatePo,@CurrentStaffNo @ApiIgnore String staffNo){
        return deductReocrdService.updateStateById(deductRecordUpdatePo,staffNo);
    }

    @ApiOperation(value = "新建扣款申请", notes = "新建扣款申请",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insertDeductRecord", method = RequestMethod.POST)
    ComResponse<Integer> insertDeductRecord(@RequestBody DeductProcessDTO deductProcessDTO, @CurrentStaffNo @ApiIgnore String staffNo){
        return deductReocrdService.insertDeductRecord(deductProcessDTO,staffNo);
    }

    @ApiOperation(value = "根据员工工号或姓名查询员工信息", notes = "根据员工工号或姓名查询员工信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/selectstaff", method = RequestMethod.GET)
    ComResponse<DeductStaffInfoDto> selectstaff(@RequestParam("noOrName")String noOrName){
        return deductReocrdService.selectstaff(noOrName);
    }
    @ApiOperation(value = "修改执行流程", notes = "修改执行流程",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateExecuteState", method = RequestMethod.POST)
    ComResponse<Integer> updateExecuteState(@RequestBody DeductRecordStateUpdatePo deductRecordStateUpdatePo,@CurrentStaffNo @ApiIgnore String staffNo){
        return deductReocrdService.updateExecuteState(deductRecordStateUpdatePo,staffNo);
    }
    @ApiOperation(value = "查询扣款列表详情", notes = "查询扣款列表详情",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    ComResponse<ApproveDeductDto> queryById(@RequestParam ("id") String appNo) {
        return deductReocrdService.queryById(appNo);
    }
    @ApiOperation(value = "催审", notes = "催审",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/examine", method = RequestMethod.POST)
    ComResponse examine(@RequestBody MsgTemplateVo msgTemplateVo){
        return ymsgInfoService.sendSysMsgInfo(msgTemplateVo);

    }

}
