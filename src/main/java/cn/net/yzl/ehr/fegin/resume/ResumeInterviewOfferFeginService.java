package cn.net.yzl.ehr.fegin.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.resume.ResumeInterviewOfferInsertVO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(value = "ResumeFeginService",url = "${fegin.db.url}/resume/offer")
public interface ResumeInterviewOfferFeginService {



    @RequestMapping(value = "/sendOffer", method = RequestMethod.POST)
    ComResponse<String> sendOffer(@RequestBody @Validated ResumeInterviewOfferInsertVO resumeInterviewOfferInsertVO);



}
