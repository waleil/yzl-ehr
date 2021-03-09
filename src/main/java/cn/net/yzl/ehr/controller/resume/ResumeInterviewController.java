package cn.net.yzl.ehr.controller.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.async.MsgSendAsync;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.resume.ResumeInterviewFeginService;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.msg.service.YMsgInfoService;
import cn.net.yzl.staff.dto.resume.ResumeInterviewTimeDto;
import cn.net.yzl.staff.vo.resume.ResumeInterviewInsertVO;
import cn.net.yzl.staff.vo.resume.ResumeInterviewUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/resume/time")
@Api(value = "人事管理-面试管理", tags = {"人事管理"})
@Validated
public class ResumeInterviewController {

    @Autowired
    private ResumeInterviewFeginService resumeInterviewFeginService;
    @Autowired
    private YMsgInfoService ymsgInfoService;
    @Autowired
    private MsgSendAsync msgSendAsync;

    @ApiOperation(value = "简历列表-安排面试", notes = "简历列表-安排面试", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/arrange", method = RequestMethod.POST)
    ComResponse<String> arrange(@RequestBody @Validated ResumeInterviewInsertVO resumeInterviewInsertVO,@ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {

        ComResponse<String> arrange = resumeInterviewFeginService.arrange(resumeInterviewInsertVO);

        msgSendAsync.sendArrangeinfo(resumeInterviewInsertVO,staffNo);
        return arrange;
    }

    @ApiOperation(value = "简历列表-修改面试时间", notes = "简历列表-修改面试时间", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody @Validated ResumeInterviewUpdateVO resumeInterviewInsertVO) throws IllegalAccessException {
        return resumeInterviewFeginService.update(resumeInterviewInsertVO);
    }

    @ApiOperation(value = "个人中心-我的面试", notes = "个人中心-我的面试", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getResumeInterviewTimeDtoByStaffNo", method = RequestMethod.GET)
    ComResponse<List<ResumeInterviewTimeDto>> getResumeInterviewTimeDtoByStaffNo(@ApiIgnore @CurrentStaffNo String staffNo) {
        return resumeInterviewFeginService.getResumeInterviewTimeDtoByStaffNo(staffNo);
    }


    @ApiOperation(value = "个人中心-提交", notes = "个人中心-提交", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    ComResponse<String> submit(@RequestBody @Validated ResumeInterviewUpdateVO resumeInterviewUpdateVO,@ApiIgnore @CurrentStaffNo String staffNo) {
        return resumeInterviewFeginService.submit(resumeInterviewUpdateVO);
    }


}
