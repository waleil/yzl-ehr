package cn.net.yzl.ehr.controller.resume;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.resume.ResumeFeginService;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.DepartPostDto;
import cn.net.yzl.staff.dto.DepartResumeNodeStaffDto;
import cn.net.yzl.staff.dto.resume.ResumeDetailDto;
import cn.net.yzl.staff.dto.resume.ResumeListDto;
import cn.net.yzl.staff.pojo.StaffPo;
import cn.net.yzl.staff.util.StaffBeanUtils;
import cn.net.yzl.staff.vo.resume.ResumeDbVO;
import cn.net.yzl.staff.vo.resume.ResumeDepartStaffVO;
import cn.net.yzl.staff.vo.resume.ResumeInsertVO;
import cn.net.yzl.staff.vo.resume.ResumeParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
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
    @ApiOperation(value = "简历列表-根据节点获取面试人列表", notes = "建立列表-获取简历列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getDepartResumeNodeStaffList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nextResumeNodeId", value = "面试节点id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<DepartResumeNodeStaffDto>> getDepartResumeNodeStaffList(Integer nextResumeNodeId) throws IllegalAccessException {
        return resumeFeginService.getDepartResumeNodeStaffList(nextResumeNodeId);
    }


    @ApiOperation(value = "简历列表-添加/修改简历", notes = "建立列表-添加/修改简历", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    ComResponse<String> addOrUpdate(@RequestBody @Validated ResumeInsertVO resumeParamsVO,@ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        Integer id = resumeParamsVO.getId();
        if(id==null|| id<1){

            resumeParamsVO.setCreator(staffNo);
        }else{
            resumeParamsVO.setUpdator(staffNo);
        }
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
    @ApiOperation(value = "简历列表-简历库-批量删除", notes = "简历列表-简历库-批量删除", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/delBatchResume", method = RequestMethod.POST)
    ComResponse<String> delBatchResume(@RequestBody @NotEmpty List<Integer> resumeIds) throws IllegalAccessException {
        return resumeFeginService.delBatchResume(resumeIds);
    }

    @ApiOperation(value = "简历列表-推送(待筛选或筛选未通过或简历库)", notes = "简历列表-推送(待筛选或筛选未通过或简历库)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendTo", method = RequestMethod.POST)
    ComResponse<String> sendTo( @RequestBody @Validated ResumeDepartStaffVO resumeDepartStaffVO) throws IllegalAccessException {
        resumeDepartStaffVO= StaffBeanUtils.setNullValue(resumeDepartStaffVO);

        return resumeFeginService.sendTo(resumeDepartStaffVO);
    }
    @ApiOperation(value = "简历列表-批量发送(待筛选或简历库)", notes = "简历列表-批量发送(待筛选或简历库)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendToBatchDepart", method = RequestMethod.POST)
    ComResponse<String> sendToBatchDepart( @RequestBody @NotEmpty List<Integer> resumeIds, @ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        return resumeFeginService.sendToBatchDepart(resumeIds,staffNo);
    }
    @ApiOperation(value = "简历列表-单个发给部门(待筛选或简历库)", notes = "简历列表-单个发给部门(待筛选或简历库)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendToDepart", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Integer", paramType = "query")
    })
    ComResponse<String> sendToDepart(Integer resumeId, @ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        return resumeFeginService.sendToDepart(resumeId,staffNo);
    }


    @ApiOperation(value = "简历列表-待筛选-未通过", notes = "简历列表-待筛选-未通过", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/noPass", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<String> noPass( Integer resumeId) {
        return resumeFeginService.noPass(resumeId);
    }


    @ApiOperation(value = "简历列表-面试中-未通过", notes = "简历列表-面试中-未通过", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/interviewNoPass", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<String> interviewNoPass( Integer resumeId) {
        return resumeFeginService.interviewNoPass(resumeId);
    }

    @ApiOperation(value = "简历列表-待筛选-批量未通过", notes = "简历列表-待筛选-批量未通过", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/noBatchPass", method = RequestMethod.POST)
    ComResponse<String> noBatchPass( @RequestBody @NotEmpty List<Integer> resumeIds) {
        return resumeFeginService.noBatchPass(resumeIds);
    }


    @ApiOperation(value = "简历列表-导出", notes = "简历列表-导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "状态 0 待筛选  1筛选未通过  2筛选通过待面试 3面试中 4面试未通过 5面试通过待入职 6:推送中 7:面试通过已入职  8放入简历库", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    void noBatchPass(@RequestParam("state") Integer state, HttpServletResponse response) {

        try {
            ExcelWriter writer = ExcelUtil.getWriter();
            writer.renameSheet("简历列表");     //甚至sheet的名称
            // 构建表头信息
            if(state==7){
                writer.addHeaderAlias("entryTime","入职时间");
            }
            writer.addHeaderAlias("name", "姓名");
            writer.addHeaderAlias("sex","性别");
            writer.addHeaderAlias("phone", "手机号");
            if(state!=7){
                writer.addHeaderAlias("email", "邮箱");
                writer.addHeaderAlias("resumeEduDto.degreeName", "学历");
                writer.addHeaderAlias("resumeEduDto.schoolName", "毕业院校");
                writer.addHeaderAlias("","就读时间");
            }else{

            }
            writer.addHeaderAlias("staffNo", "员工工号");   //设置head的名称， 此时的顺寻就是导出的顺序，
            writer.addHeaderAlias("workCodeStr", "工作地点");

            writer.addHeaderAlias("status_name", "状态");
            writer.addHeaderAlias("approvalStatus_name", "审核状态");
            ResumeParamsVO resumeParamsVO = new ResumeParamsVO();
            resumeParamsVO.setState(state);
            ComResponse<Page<ResumeListDto>> listByParams = resumeFeginService.getListByParams(resumeParamsVO);
            List<ResumeListDto> items = listByParams.getData().getItems();
            List list=null;
//            List<RecordInfoDetailsDTO> list = query(); //查询出所有的需要导出的数据
            writer.write(items, true);
            writer.setOnlyAlias(true);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode("所有数据", "UTF-8")+".xlsx");   //中文名称需要特殊处理
            writer.flush(response.getOutputStream());

            writer.close();
        } catch (Exception e) {
            //如果导出异常，则生成一个空的文件
//            log.info("######导出  excel异常  ：{}",e.getMessage());
//            try (ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream()) {
//                Workbook workbook = new XSSFWorkbook();
//                workbook.createSheet("生成数据异常");
//                StringBuilder fileName = new StringBuilder("所有数据").append(".xlsx");
//                workbook.write(outputStream2);
//                outputStream2.flush();
//                AasExcelUtils.export(request, response, outputStream2.toByteArray(), fileName.toString());
//            }catch (Exception e2) {}
        }


    }

}
