package cn.net.yzl.ehr.fegin.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.resume.ResumeInterviewTimeDto;
import cn.net.yzl.staff.vo.resume.ResumeInterviewInsertVO;
import cn.net.yzl.staff.vo.resume.ResumeInterviewUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@FeignClient(value = "ResumeFeginService",url = "${fegin.db.url}/resume/time")
public interface ResumeInterviewFeginService {



    @ApiOperation(value = "简历列表-安排面试", notes = "简历列表-安排面试", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/arrange", method = RequestMethod.POST)
    ComResponse<String> arrange(@RequestBody ResumeInterviewInsertVO resumeInterviewInsertVO);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody  ResumeInterviewUpdateVO resumeInterviewInsertVO);

    @RequestMapping(value = "/getResumeInterviewTimeDtoByStaffNo", method = RequestMethod.GET)
    ComResponse<List<ResumeInterviewTimeDto>> getResumeInterviewTimeDtoByStaffNo(@RequestParam("staffNo") String staffNo);
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    ComResponse<String> submit(@RequestBody  ResumeInterviewUpdateVO resumeInterviewUpdateVO);


    @RequestMapping(value = "/getResumeInterviewTimeDtoPageByStaffNo", method = RequestMethod.GET)
    ComResponse<Page<ResumeInterviewTimeDto>> getResumeInterviewTimeDtoPageByStaffNo(@RequestParam("staffNo") String staffNo, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(value = "/takeBack", method = RequestMethod.GET)
    ComResponse<String> takeBack(@RequestParam("interviewResumeId")Integer interviewResumeId) throws IllegalAccessException ;
}
