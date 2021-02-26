package cn.net.yzl.ehr.fegin.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.DepartPostDto;
import cn.net.yzl.staff.dto.DepartResumeNodeStaffDto;
import cn.net.yzl.staff.dto.attend.StaffAttendImportResultDto;
import cn.net.yzl.staff.dto.resume.ResumeDetailDto;
import cn.net.yzl.staff.dto.resume.ResumeImportResultDto;
import cn.net.yzl.staff.dto.resume.ResumeListDto;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.resume.ResumeDbVO;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffVO;
import cn.net.yzl.staff.vo.resume.ResumeInsertVO;
import cn.net.yzl.staff.vo.resume.ResumeParamsVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;


@FeignClient(value = "ResumeFeginService",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
public interface ResumeFeginService{




    @RequestMapping(value = "/resume/getRecruitDepartDtoList", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getRecruitDepartDtoList();
    @RequestMapping(value = "/resume/getRecruitDepartPostDtoList", method = RequestMethod.GET)
    ComResponse<List<DepartPostDto>> getRecruitDepartPostDtoList(@RequestParam("departId") Integer departId,@RequestParam("staffNo")String staffNo);
    @RequestMapping(value = "/resume/getRecruitDepartPostList", method = RequestMethod.GET)
    ComResponse<List<DepartPostDto>> getRecruitDepartPostList(@RequestParam("departId") Integer departId);
    @RequestMapping(value = "/resume/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<ResumeListDto>> getListByParams(@RequestBody ResumeParamsVO resumeParamsVO);
    @RequestMapping(value = "/resume/addOrUpdate", method = RequestMethod.POST)
    ComResponse<String> addOrUpdate(@RequestBody ResumeInsertVO resumeParamsVO);
    @RequestMapping(value = "/resume/getResumeDetail", method = RequestMethod.GET)
    ComResponse<ResumeDetailDto> getResumeDetail(@RequestParam("resumeId") Integer resumeId);
    @RequestMapping(value = "/resume/saveResumeToDB", method = RequestMethod.POST)
    ComResponse<String> saveResumeToDB(@RequestBody ResumeDbVO resumeDbVO);
    @RequestMapping(value = "/resume/delResume", method = RequestMethod.GET)
    ComResponse<String> delResume(@RequestParam("resumeId") Integer resumeId);
    @RequestMapping(value = "/resume/noPass", method = RequestMethod.GET)
    ComResponse<String> noPass(@RequestParam("resumeId") Integer resumeId);

    @RequestMapping(value = "/resume/delBatchResume", method = RequestMethod.POST)
    ComResponse<String> delBatchResume(@RequestBody List<Integer> resumeIds);
    @RequestMapping(value = "/resume/noBatchPass", method = RequestMethod.POST)
    ComResponse<String> noBatchPass(List<Integer> resumeIds);

    @RequestMapping(value = "/resume/sendTo", method = RequestMethod.POST)
    ComResponse<String> sendTo( @RequestBody  ResumeDepartStaffVO resumeDepartStaffVO);
    @RequestMapping(value = "/resume/sendToBatchDepart", method = RequestMethod.POST)
    ComResponse<String> sendToBatchDepart(@RequestBody List<Integer> resumeIds, @RequestParam("staffNo") String staffNo);
    @RequestMapping(value = "/resume/sendToDepart", method = RequestMethod.GET)
    ComResponse<String> sendToDepart(@RequestParam("resumeId") Integer resumeId,@RequestParam("staffNo") String staffNo);
    @RequestMapping(value = "/resume/getDepartResumeNodeStaffList", method = RequestMethod.GET)
    ComResponse<List<DepartResumeNodeStaffDto>> getDepartResumeNodeStaffList(@RequestParam("nextResumeNodeId") Integer nextResumeNodeId);

    @RequestMapping(value = "/resume/interviewNoPass", method = RequestMethod.GET)
    ComResponse<String> interviewNoPass(@RequestParam("resumeId") Integer resumeId);
    @RequestMapping(value = "/resume/importResumeList", method = RequestMethod.GET)
    ComResponse<List<ResumeImportResultDto>> importResumeList(@RequestParam("url") String url, @RequestParam("staffNo")String staffNo);
}
