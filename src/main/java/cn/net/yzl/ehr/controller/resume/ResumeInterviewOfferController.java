package cn.net.yzl.ehr.controller.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.resume.ResumeInterviewOfferFeginService;
import cn.net.yzl.staff.vo.resume.ResumeInterviewOfferInsertVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume/offer")
@Api(value = "人事管理-面试管理", tags = {"人事管理"})
@Validated
public class ResumeInterviewOfferController {

    @Autowired
    private ResumeInterviewOfferFeginService resumeInterviewOfferFeginService;

    @ApiOperation(value = "简历列表-发送offer", notes = "简历列表-发送offer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendOffer", method = RequestMethod.POST)
    ComResponse<String> sendOffer(@RequestBody @Validated ResumeInterviewOfferInsertVO resumeInterviewOfferInsertVO) throws IllegalAccessException {
        return resumeInterviewOfferFeginService.sendOffer(resumeInterviewOfferInsertVO);
    }



}
