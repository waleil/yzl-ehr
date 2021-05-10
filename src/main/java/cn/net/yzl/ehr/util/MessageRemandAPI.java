package cn.net.yzl.ehr.util;

import cn.hutool.core.date.DateUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.fegin.process.ProcessConfigFeignService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.salary.SalaryGrantStatusDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息发送接口
 */
@Component
@Slf4j
public class MessageRemandAPI {
    private static ProcessConfigFeignService processConfigFeignService;
    private static YMsgInfoService ymsgInfoService;
    private static StaffFeginService staffFeginService;

    public MessageRemandAPI(ProcessConfigFeignService processConfigFeignService, StaffFeginService staffFeginService, YMsgInfoService ymsgInfoService) {
        MessageRemandAPI.processConfigFeignService = processConfigFeignService;
        MessageRemandAPI.staffFeginService = staffFeginService;
        MessageRemandAPI.ymsgInfoService = ymsgInfoService;
    }

    /**
     * 发工资消息
     *
     * @param staffNo    发送人编号
     * @param salaryList 工资列表
     */
    public static void paySalarys(List<SalaryGrantStatusDto> salaryList, String staffNo) {
        List<MsgTemplateVo> msgList = salaryList.stream().map(item -> {
            String time = DateUtil.format(item.getDuration(), "yyyy年MM月");
            MsgTemplateVo templateVo = new MsgTemplateVo();
            templateVo.setCode("EHR0012");
            templateVo.setCreator(staffNo);
            templateVo.setUserCode(item.getStaffNo());
            templateVo.setSystemCode(2);
            templateVo.setTitle("工资发放提醒");
            String[] str = {item.getStaffName(), time};
            templateVo.setParams(str);
            return templateVo;
        }).collect(Collectors.toList());
        log.info("发工资时发送消息参数: {}", JsonUtil.toJsonStr(msgList));
        ymsgInfoService.insertMsgTemplateBatch(msgList);
    }

    public static ComResponse examine(String staffNo, String approveNo, String processName) {
        log.info("发起流程时发送消息参数:{},{},{}", staffNo, approveNo, processName);
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0002");

        ComResponse<StaffDetailsDto> detailsByNo = staffFeginService.getDetailsByNo(approveNo);
        String approveName = detailsByNo.getData().getName();
        templateVo.setCreator(staffNo);
        templateVo.setUserCode(approveNo);
        templateVo.setSystemCode(2);
        templateVo.setTitle(processName);
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = (calendar.get(Calendar.MONTH)) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
//        String s = year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";
//        String format = String.format("%s%s%s%s", approveName, "(", approveNo, ")");
//        String[] str = {format, s};
//        templateVo.setParams(str);
        String time = DateUtil.format(LocalDateTime.now(), "yyyy年MM月dd日HH时mm分ss秒");
        String format = MessageFormat.format("{0}({1})", approveName, approveNo);
        String[] params = {format, time};
        templateVo.setParams(params);
        return ymsgInfoService.sendSysMsgInfo(templateVo);

    }

    public static String processSendMessage(Integer processId, String staffNo, String processName) {
        log.info("发起流程时发送抄送人消息参数:{},{},{}", processId, staffNo, processName);
        ComResponse<List<StaffLevelDto>> personSend = processConfigFeignService.getPersonSend(processId);

        if (0 == personSend.getData().size()) {
            return "没有抄送人！";
        }
        personSend.getData().forEach(map -> {
            MsgTemplateVo templateVo = new MsgTemplateVo();
            templateVo.setCode("EHR0024");
            templateVo.setCreator(staffNo);
            templateVo.setUserCode(map.getStaffNo());
            templateVo.setSystemCode(2);
            templateVo.setTitle(processName);
//            Calendar calendar = Calendar.getInstance();
//            int year = calendar.get(Calendar.YEAR);
//            int month = (calendar.get(Calendar.MONTH)) + 1;
//            int day = calendar.get(Calendar.DAY_OF_MONTH);
//            int hour = calendar.get(Calendar.HOUR_OF_DAY);
//            int minute = calendar.get(Calendar.MINUTE);
//            int second = calendar.get(Calendar.SECOND);
//            String s = year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";
//            String format = String.format("%s%s%s%s", map.getName(), "(", map.getStaffNo(), ")");
            String time = DateUtil.format(LocalDateTime.now(), "yyyy年MM月dd日HH时mm分ss秒");
            String format = MessageFormat.format("{0}({1})", map.getName(), map.getStaffNo());
            String[] params = {format, time};
            templateVo.setParams(params);
            ymsgInfoService.sendSysMsgInfo(templateVo);
        });
        return "发送成功";
    }

    public static void revocationMessage(String staffNo, String appNo, String appName, String processName) {
        log.info("流程审批通过时发送消息参数:{},{},{},{}", staffNo, appNo, processName, appName);
        MsgTemplateVo templateVo = new MsgTemplateVo();
        templateVo.setCode("EHR0023");
        templateVo.setCreator(staffNo);
        templateVo.setUserCode(appNo);
        templateVo.setSystemCode(2);
        templateVo.setTitle(processName);
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = (calendar.get(Calendar.MONTH)) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//        int minute = calendar.get(Calendar.MINUTE);
//        int second = calendar.get(Calendar.SECOND);
//        String s = year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒";
//        String format = String.format("%s%s%s%s", appName, "(", appNo, ")");
//        String[] str = {format, s};
//        templateVo.setParams(str);
        String time = DateUtil.format(LocalDateTime.now(), "yyyy年MM月dd日HH时mm分ss秒");
        String format = MessageFormat.format("{0}({1})", appName, appNo);
        String[] params = {format, time};
        templateVo.setParams(params);
        ymsgInfoService.sendSysMsgInfo(templateVo);

    }
}
