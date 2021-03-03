package cn.net.yzl.ehr.util;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.process.ProcessConfigFeignService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.exception.BaseParamsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

/**
 * 消息发送接口
 */
@Component
@Slf4j
public class MessageRemandAPI {
    @Autowired
    private ProcessConfigFeignService processConfigFeignService;
    @Autowired
    private YMsgInfoService ymsgInfoService;

    private static MessageRemandAPI messageRemandAPI;

    public void setProcessConfigFeignService(ProcessConfigFeignService processConfigFeignService) {
        this.processConfigFeignService = processConfigFeignService;
    }
    public void setYMsgInfoService(YMsgInfoService ymsgInfoService) {
        this.ymsgInfoService = ymsgInfoService;
    }

    @PostConstruct
    public void init() {
        messageRemandAPI = this;
        messageRemandAPI.processConfigFeignService = this.processConfigFeignService;
    }
    public static ComResponse examine(String staffNo){
        ComResponse<List<StaffLevelDto>> staffLevelByStaffNo = messageRemandAPI.processConfigFeignService.getStaffLevelByStaffNo(staffNo, 1);
        List<StaffLevelDto> data = staffLevelByStaffNo.getData();
        if(null == data){
            throw new BaseParamsException(ResponseCodeEnums.API_ERROR_CODE.getCode(), "没有上级");
        }
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0002");
        templateVo.setCreator(staffNo);
        templateVo.setUserCode(data.get(0).getStaffNo());
        templateVo.setSystemCode(2);
        Calendar calendar = Calendar.getInstance();
        Integer year = calendar.get(Calendar.YEAR);
        Integer month = (calendar.get(Calendar.MONTH)) + 1;
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        Integer minute = calendar.get(Calendar.MINUTE);
        Integer second = calendar.get(Calendar.SECOND);
        String s = year.toString()+"年"+month.toString()+"月"+day.toString()+"日"+hour.toString()+"时"+minute.toString()+"分"+second.toString()+"秒";
        String[] str = {data.get(0).getStaffNo(),s};
        templateVo.setParams(str);
        return messageRemandAPI.ymsgInfoService.sendSysMsgInfo(templateVo);

    }
    public static void processSendMessage(Integer processId){
        ComResponse<List<StaffLevelDto>> personSend = messageRemandAPI.processConfigFeignService.getPersonSend(processId);
        //List<StaffLevelDto> data = personSend.getData();
        if(null == personSend){
            throw new BaseParamsException(ResponseCodeEnums.API_ERROR_CODE.getCode(), "没有上级");
        }
        personSend.getData().forEach(map-> {
            MsgTemplateVo templateVo = new MsgTemplateVo();
            templateVo.setCode("EHR0002");
            templateVo.setCreator(map.getStaffNo());
            templateVo.setUserCode(map.getStaffNo());
            templateVo.setSystemCode(2);
            Calendar calendar = Calendar.getInstance();
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = (calendar.get(Calendar.MONTH)) + 1;
            Integer day = calendar.get(Calendar.DAY_OF_MONTH);
            Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
            Integer minute = calendar.get(Calendar.MINUTE);
            Integer second = calendar.get(Calendar.SECOND);
            String s = year.toString() + "年" + month.toString() + "月" + day.toString() + "日" + hour.toString() + "时" + minute.toString() + "分" + second.toString() + "秒";
            String[] str = {map.getStaffNo(), s};
            templateVo.setParams(str);
            messageRemandAPI.ymsgInfoService.sendSysMsgInfo(templateVo);
        });

    }

}
