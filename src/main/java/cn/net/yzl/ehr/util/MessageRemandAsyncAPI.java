package cn.net.yzl.ehr.util;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.process.ProcessConfigFeignService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.exception.BaseParamsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

/**
 * 消息发送接口
 */
@Component
@Slf4j
public class MessageRemandAsyncAPI {
    @Autowired
    private ProcessConfigFeignService processConfigFeignService;
    @Autowired
    private YMsgInfoService ymsgInfoService;
    @Autowired
    private StaffFeginService staffFeginService;

    @Async
    public ComResponse examine(String staffNo,String approveNo,String processName){
        log.info("发起流程时发送消息参数:{},{},{}", staffNo,approveNo,processName);
         //String data = messageRemandAPI.processConfigFeignService.getStaffNodeByStaffNo(processAuditId,stepNo);
        //String data = appNo;

        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0002");

        ComResponse<StaffDetailsDto> detailsByNo = staffFeginService.getDetailsByNo(approveNo);
        String approveName = detailsByNo.getData().getName();
        templateVo.setCreator(staffNo);
        templateVo.setUserCode(approveNo);
        templateVo.setSystemCode(2);
        templateVo.setTitle(processName);
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

    @Async
    public void processSendMessage(Integer processId, String staffNo, String processName){
        log.info("发起流程时发送抄送人消息参数:{},{},{}", processId,staffNo,processName);
        ComResponse<List<StaffLevelDto>> personSend = processConfigFeignService.getPersonSend(processId);

        //List<StaffLevelDto> data = personSend.getData();
        if(0 == personSend.getData().size()){
            throw new BaseParamsException(ResponseCodeEnums.API_ERROR_CODE.getCode(), "没有抄送人！");
        }
        personSend.getData().forEach(map-> {
            MsgTemplateVo templateVo = new MsgTemplateVo();
            templateVo.setCode("EHR0024");
            templateVo.setCreator(staffNo);
            templateVo.setUserCode(map.getStaffNo());
            templateVo.setSystemCode(2);
            templateVo.setTitle(processName);
            Calendar calendar = Calendar.getInstance();
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = (calendar.get(Calendar.MONTH)) + 1;
            Integer day = calendar.get(Calendar.DAY_OF_MONTH);
            Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
            Integer minute = calendar.get(Calendar.MINUTE);
            Integer second = calendar.get(Calendar.SECOND);
            String s = year.toString() + "年" + month.toString() + "月" + day.toString() + "日" + hour.toString() + "时" + minute.toString() + "分" + second.toString() + "秒";
            String format = String.format("%s%s%s%s", map.getName(), "(", map.getStaffNo(),")");
            String[] str = {format, s};
            templateVo.setParams(str);
            ymsgInfoService.sendSysMsgInfo(templateVo);
        });

    }

}
