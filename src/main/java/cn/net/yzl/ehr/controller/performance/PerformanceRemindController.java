package cn.net.yzl.ehr.controller.performance;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.performance.PerformanceRemindFeignService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.order.model.vo.MailVo;
import cn.net.yzl.order.util.SendTask;
import cn.net.yzl.staff.constant.PerformanceConstant;
import cn.net.yzl.staff.dto.performance.PerformanceApproveRemindDto;
import cn.net.yzl.staff.dto.performance.PerformanceRemindDepartDto;
import cn.net.yzl.staff.dto.performance.PerformanceRemindDto;
import cn.net.yzl.staff.dto.performance.PerformanceRemindStaffDto;
import cn.net.yzl.staff.pojo.performance.PerformanceRemindPo;
import cn.net.yzl.staff.vo.performance.PerformanceNoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * 职能管理-考评填报提醒
 *
 * @author biebaojie
 */
@RestController
@RequestMapping("/performance")
@Api(value = "职能管理-考评填报提醒", tags = {"职能管理-考评填报提醒"})
public class PerformanceRemindController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceRemindController.class);


    @Autowired
    private PerformanceRemindFeignService performanceRemindFeignService;

    @Autowired
    private YMsgInfoService ymsgInfoService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "remindNo", value = "提醒编号", required = true, dataType = "Long", paramType = "query")
    })
    @ApiOperation(value = "查询填报提醒详情", notes = "查询填报提醒详情", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillRemind", method = RequestMethod.GET)
    public ComResponse<PerformanceRemindPo> queryFillRemind(@RequestParam("remindNo") Long remindNo) {
        return performanceRemindFeignService.queryFillRemind(remindNo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "显示条数", required = true, dataType = "Long", paramType = "query")
    })
    @ApiOperation(value = "查询填报提醒列表", notes = "查询填报提醒列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryFillRemindAll", method = RequestMethod.GET)
    public ComResponse<Page<PerformanceRemindDto>> queryFillRemindAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return performanceRemindFeignService.queryFillRemindAll(pageNum, pageSize);
    }

    @ApiOperation(value = "新增填报提醒", notes = "新增填报提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertFillRemind", method = RequestMethod.POST)
    public ComResponse<Integer> insertFillRemind(@RequestBody PerformanceRemindPo performanceRemind, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceRemind.setCreator(staffNo);
        performanceRemind.setRemindType(PerformanceConstant.REMIND_TYPE_FILL);
        return performanceRemindFeignService.insertFillRemind(performanceRemind);
    }

    @ApiOperation(value = "修改填报提醒", notes = "修改填报提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateFillRemind", method = RequestMethod.POST)
    public ComResponse<Integer> updateFillRemind(@RequestBody PerformanceRemindPo performanceRemind, @ApiIgnore @CurrentStaffNo String staffNo) {
        performanceRemind.setUpdator(staffNo);
        return performanceRemindFeignService.updateFillRemind(performanceRemind);
    }

    @ApiOperation(value = "删除填报提醒", notes = "删除填报提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteByRemindNo", method = RequestMethod.POST)
    public ComResponse<Integer> deleteByRemindNo(@RequestBody PerformanceNoVo performanceNoVo) {
        return performanceRemindFeignService.deleteByRemindNo(performanceNoVo);
    }

    @ApiOperation(value = "查询考核提醒", notes = "查询考核提醒", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryApproveRemind", method = RequestMethod.GET)
    public ComResponse<PerformanceApproveRemindDto> queryApproveRemind(@ApiIgnore @CurrentStaffNo String staffNo) {
        return performanceRemindFeignService.queryApproveRemind(staffNo);
    }

    @ApiOperation(value = "修改考核提醒", notes = "修改考核提醒", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateApproveRemind", method = RequestMethod.POST)
    public ComResponse<Integer> updateApproveRemind(@RequestBody PerformanceApproveRemindDto approveRemindDto, @ApiIgnore @CurrentStaffNo String staffNo) {
        approveRemindDto.setUpdator(staffNo);
        return performanceRemindFeignService.updateApproveRemind(approveRemindDto);
    }

    @ApiOperation(value = "发送绩效提醒(每小时执行一次)", notes = "发送绩效提醒(每小时执行一次)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendPerformanceRemind", method = RequestMethod.GET)
    public ComResponse<Boolean> sendPerformanceRemind() {
        LOGGER.info("发送绩效提醒(每小时执行一次)");
        ComResponse<List<PerformanceRemindDepartDto>> response = performanceRemindFeignService.sendPerformanceRemind();
        if (200 == response.getCode()) {
            List<PerformanceRemindDepartDto> departList = response.getData();
            if (!CollectionUtils.isEmpty(departList)) {
                for (PerformanceRemindDepartDto depart : departList) {
                    if (1 == depart.getSendType()) {
                        // 发送系统消息
                        sendSystemMsg(depart);
                    } else if (3 == depart.getSendType()) {
                        // 发送邮件消息
                        sendEmailMsg(depart);
                    } else {
                        // 发送系统消息
                        sendSystemMsg(depart);
                        // 发送邮件消息
                        sendEmailMsg(depart);
                    }
                }
            }
        } else {
            LOGGER.error("定时考评提醒失败. error={}", response.getMessage());
        }
        return ComResponse.success(true);
    }

    @Async
    public void sendEmailMsg(PerformanceRemindDepartDto depart) {
        try {
            // 人员信息
            List<PerformanceRemindStaffDto> staffList = depart.getStaffList();
            if (!CollectionUtils.isEmpty(staffList)) {
                LOGGER.info("部门:{} 发送邮件考评填报提醒. remindType={}", depart.getDepartId(), depart.getRemindType());
                for (PerformanceRemindStaffDto staff : staffList) {
                    List<MailVo> mailList = new ArrayList<>();
                    if (!StringUtils.isEmpty(staff.getEmail()) && staff.getEmail().contains("@")) {
                        String subject;
                        String content;
                        if (1 == depart.getRemindType()) {
                            // 填报
                            subject = "职能管理-考评填报提醒-新建填报提醒";
                            content = "你好，新一周期的绩效填报已开始，请前往填报。";
                        } else {
                            // 考核
                            subject = "职能管理-考评填报提醒-考核提醒";
                            content = "你好，新一周期的绩效考核已开始，请前往查阅。";
                        }
                        MailVo mailVo = new MailVo(staff.getEmail(), subject, staff.getStaffName() + content);
                        mailList.add(mailVo);
//                        MailUtil.sendMail(mailVo);
                    }
                    SendTask.runTask(mailList);
                }
            }

        } catch (Exception e) {
            LOGGER.error("考评填报提醒,发送邮件失败. depart={}", JsonUtil.toJsonStr(depart), e);
        }
    }

    private void sendSystemMsg(PerformanceRemindDepartDto depart) {
        try {
            // 人员信息
            List<PerformanceRemindStaffDto> staffList = depart.getStaffList();
            if (!CollectionUtils.isEmpty(staffList)) {
                LOGGER.info("部门:{} 发送系统消息考评填报提醒. remindType={}", depart.getDepartId(), depart.getRemindType());
                List<MsgTemplateVo> list = new ArrayList<>();
                for (PerformanceRemindStaffDto staff : staffList) {
                    MsgTemplateVo msgTemplateVo = new MsgTemplateVo();
                    if (1 == depart.getRemindType()) {
                        // 填报
                        msgTemplateVo.setCode("EHR0013");//模板编号
                        msgTemplateVo.setType(1);//模版类型
                        msgTemplateVo.setTitle("职能管理-考评填报提醒-新建填报提醒");
                    } else {
                        // 考核
                        msgTemplateVo.setCode("EHR0014");//模板编号
                        msgTemplateVo.setType(1);//模版类型
                        msgTemplateVo.setTitle("职能管理-考评填报提醒-考核提醒");
                    }
                    msgTemplateVo.setSystemCode(2);//1：crm，2：ehr，3：dmc，4：bi
                    msgTemplateVo.setParams(new Object[]{staff.getStaffName()});//模板参数
                    msgTemplateVo.setCreator(depart.getCreator());//发送人编号
                    msgTemplateVo.setUserCode(staff.getStaffNo());//接收人编号
                    list.add(msgTemplateVo);
                }
                ymsgInfoService.insertMsgTemplateBatch(list);
            }
        } catch (Exception e) {
            LOGGER.error("考评填报提醒,发送系统消息失败. depart={}", JsonUtil.toJsonStr(depart), e);
        }
    }

}
