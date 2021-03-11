package cn.net.yzl.ehr.controller.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.process.ProcessConfigFeignService;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.ehr.service.deduct.DeductReocrdService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.deduct.*;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.pojo.deduct.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/deductRecord")
@Api(value = "扣款记录", tags = {"奖惩管理"})
public class DeductRecordController {
    @Autowired
    private DeductReocrdService deductReocrdService;

    @Autowired
    private ProcessConfigFeignService processConfigFeignService;
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
    ComResponse<ApproveDeductDto> queryById(@RequestParam ("appNo") String appNo) {
        return deductReocrdService.queryById(appNo);
    }
    @ApiOperation(value = "催审", notes = "催审",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/examine", method = RequestMethod.GET)
    ComResponse examine(@CurrentStaffNo @ApiIgnore String staffNo,@RequestParam("approveNo") String approveNo, @RequestParam("approveName") String approveName,@RequestParam("processId") Integer processId){
        ComResponse<ProcessDto> processDtoComResponse = deductReocrdService.queryByName(processId);
        if (processDtoComResponse.getData()==null){
            return ComResponse.fail(20110,"此名称不存在");
        }
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0002");
        templateVo.setCreator(staffNo);
        templateVo.setUserCode(approveNo);
        templateVo.setSystemCode(2);
        templateVo.setSendName(approveName);
        templateVo.setTitle(processDtoComResponse.getData().getName());
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = (calendar.get(Calendar.MONTH)) + 1;
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        Integer minute = calendar.get(Calendar.MINUTE);
        Integer second = calendar.get(Calendar.SECOND);
        String s = year.toString()+"年"+month.toString()+"月"+day.toString()+"日"+hour.toString()+"时"+minute.toString()+"分"+second.toString()+"秒";
        String format = String.format("%s%s%s%s", approveName, "(", approveNo,")");
        String[] str = {format,s};
        templateVo.setParams(str);
        return ymsgInfoService.sendSysMsgInfo(templateVo);

    }

    @ApiOperation(value = "新建停止扣款申请", notes = "新建停止扣款申请",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insertStopDeductRecord", method = RequestMethod.POST)
    ComResponse<Integer> insertStopDeductRecord(@RequestBody DeductProcessDTO deductProcessDTO , @CurrentStaffNo @ApiIgnore String staffNo){
        return deductReocrdService.insertStopDeductRecord(deductProcessDTO,staffNo);
    }
    @ApiOperation(value = "查询扣款列表详情", notes = "查询扣款列表详情",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryStopByNo", method = RequestMethod.GET)
    ComResponse<DeductRecordDto> queryStopByNo(@RequestParam ("appNo")String appNo) {
        return deductReocrdService.queryStopByNo(appNo);
    }

}
