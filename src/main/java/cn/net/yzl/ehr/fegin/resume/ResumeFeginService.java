package cn.net.yzl.ehr.fegin.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.DepartPostDto;
import cn.net.yzl.staff.dto.resume.ResumeDetailDto;
import cn.net.yzl.staff.dto.resume.ResumeListDto;
import cn.net.yzl.staff.vo.resume.ResumeDbVO;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffVO;
import cn.net.yzl.staff.vo.resume.ResumeInsertVO;
import cn.net.yzl.staff.vo.resume.ResumeParamsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(value = "ResumeFeginService",url = "${fegin.db.url}/resume")
public interface ResumeFeginService{




    @RequestMapping(value = "/getRecruitDepartDtoList", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getRecruitDepartDtoList();
    @RequestMapping(value = "/getRecruitDepartPostDtoList", method = RequestMethod.GET)
    ComResponse<List<DepartPostDto>> getRecruitDepartPostDtoList(@RequestParam("departId") Integer departId);
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<ResumeListDto>> getListByParams(@RequestBody ResumeParamsVO resumeParamsVO);
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    ComResponse<String> addOrUpdate(@RequestBody ResumeInsertVO resumeParamsVO);
    @RequestMapping(value = "/getResumeDetail", method = RequestMethod.GET)
    ComResponse<ResumeDetailDto> getResumeDetail(@RequestParam("resumeId") Integer resumeId);
    @RequestMapping(value = "/saveResumeToDB", method = RequestMethod.POST)
    ComResponse<String> saveResumeToDB(@RequestBody ResumeDbVO resumeDbVO);
    @RequestMapping(value = "/delResume", method = RequestMethod.GET)
    ComResponse<String> delResume(@RequestParam("resumeId") Integer resumeId);
    @RequestMapping(value = "/sendToDepart", method = RequestMethod.POST)
    ComResponse<String> sendToDepart( @RequestBody ResumeDepartStaffVO resumeDepartStaffVO);
    @RequestMapping(value = "/noPass", method = RequestMethod.GET)
    ComResponse<String> noPass(@RequestParam("resumeId") Integer resumeId);



}
