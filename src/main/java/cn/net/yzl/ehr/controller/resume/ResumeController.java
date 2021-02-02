package cn.net.yzl.ehr.controller.resume;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.resume.ResumeFeginService;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.DepartPostDto;
import cn.net.yzl.staff.dto.resume.ResumeDetailDto;
import cn.net.yzl.staff.dto.resume.ResumeListDto;
import cn.net.yzl.staff.vo.resume.ResumeDbVO;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffVO;
import cn.net.yzl.staff.vo.resume.ResumeInsertVO;
import cn.net.yzl.staff.vo.resume.ResumeParamsVO;
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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/resume")
@Api(value = "人事管理-面试管理", tags = {"人事管理"})
@Validated
public class ResumeController {

    @Autowired
    private ResumeFeginService resumeFeginService;


    @ApiOperation(value = "简历列表-获取需求部门列表", notes = "简历列表-获取需求部门列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getRecruitDepartDtoList", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getRecruitDepartDtoList() {
        return resumeFeginService.getRecruitDepartDtoList();
    }

    @ApiOperation(value = "简历列表-获取需求部门对应的岗位列表", notes = "简历列表-获取需求部门对应的岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getRecruitDepartPostDtoList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<DepartPostDto>> getRecruitDepartPostDtoList(@NotNull @Min(0) Integer departId) {
        return resumeFeginService.getRecruitDepartPostDtoList(departId);
    }

    @ApiOperation(value = "简历列表-获取简历列表", notes = "建立列表-获取简历列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<ResumeListDto>> getListByParams(@RequestBody @Validated ResumeParamsVO resumeParamsVO) throws IllegalAccessException {
        return resumeFeginService.getListByParams(resumeParamsVO);
    }



    @ApiOperation(value = "简历列表-添加/修改简历", notes = "建立列表-添加/修改简历", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    ComResponse<String> addOrUpdate(@RequestBody @Validated ResumeInsertVO resumeParamsVO) throws IllegalAccessException {
        return resumeFeginService.addOrUpdate(resumeParamsVO);
    }

    @ApiOperation(value = "简历列表-获取简历详情", notes = "建立列表-获取简历详情", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getResumeDetail", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<ResumeDetailDto> getResumeDetail(@NotNull @Min(1) Integer resumeId) throws IllegalAccessException {
        return resumeFeginService.getResumeDetail(resumeId);
    }

    @ApiOperation(value = "简历列表-放入简历库", notes = "建立列表-放入简历库", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/saveResumeToDB", method = RequestMethod.POST)
    ComResponse<String> saveResumeToDB(@RequestBody ResumeDbVO resumeDbVO) throws IllegalAccessException {
        return resumeFeginService.saveResumeToDB(resumeDbVO);
    }
    @ApiOperation(value = "简历列表-简历库-删除", notes = "简历列表-简历库-删除", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/delResume", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<String> delResume( Integer resumeId) throws IllegalAccessException {
        return resumeFeginService.delResume(resumeId);
    }


    @ApiOperation(value = "简历列表-发送部门(待筛选或筛选未通过或简历库)", notes = "简历列表-发送部门(待筛选或筛选未通过或简历库)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendToDepart", method = RequestMethod.POST)
    ComResponse<String> sendToDepart( @RequestBody @Validated ResumeDepartStaffVO resumeDepartStaffVO) throws IllegalAccessException {
        return resumeFeginService.sendToDepart(resumeDepartStaffVO);
    }


    @ApiOperation(value = "简历列表-待筛选-未通过", notes = "简历列表-待筛选-未通过", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/noPass", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<String> noPass( Integer resumeId) {
        return resumeFeginService.noPass(resumeId);
    }



}
