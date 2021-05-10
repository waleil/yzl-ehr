package cn.net.yzl.ehr.controller.resume;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.async.MsgSendAsync;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.resume.ResumeExportDto;
import cn.net.yzl.ehr.fegin.resume.ResumeFeginService;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.DepartPostDto;
import cn.net.yzl.staff.dto.DepartResumeNodeStaffDto;
import cn.net.yzl.staff.dto.resume.ResumeDetailDto;
import cn.net.yzl.staff.dto.resume.ResumeImportResultDto;
import cn.net.yzl.staff.dto.resume.ResumeListDto;
import cn.net.yzl.staff.pojo.StaffPo;
import cn.net.yzl.staff.pojo.resume.ResumeDepartStaffInsertPo;
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
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resume")
@Api(value = "人事管理-面试管理", tags = {"人事管理"})
@Validated
public class ResumeController {

    @Autowired
    private ResumeFeginService resumeFeginService;
    @Autowired
    private MsgSendAsync msgSendAsync;


    @ApiOperation(value = "简历列表-获取需求部门列表", notes = "简历列表-获取需求部门列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getRecruitDepartDtoList", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getRecruitDepartDtoList() {
        return resumeFeginService.getRecruitDepartDtoList();
    }

    @ApiOperation(value = "简历列表-获取需求部门对应的岗位列表(根据当前操作人筛选)", notes = "简历列表-获取需求部门对应的岗位列表(根据当前操作人筛选)", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getRecruitDepartPostDtoList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<DepartPostDto>> getRecruitDepartPostDtoList(@NotNull @Min(0) Integer departId,@ApiIgnore @CurrentStaffNo String staffNo) {
        return resumeFeginService.getRecruitDepartPostDtoList(departId,staffNo);
    }

    @ApiOperation(value = "简历列表-获取需求部门对应的岗位列表（不根据当前操作人筛选）", notes = "简历列表-获取需求部门对应的岗位列表（不根据当前操作人筛选）", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getRecruitDepartPostList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<DepartPostDto>> getRecruitDepartPostList(@NotNull @Min(0) Integer departId) {
        return resumeFeginService.getRecruitDepartPostList(departId);
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

    @ApiOperation(value = "简历列表-批量/单个推送(简历库)", notes = "简历列表-批量推送(简历库)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendTo", method = RequestMethod.POST)
    ComResponse<String> sendToBeatch( @RequestBody  List<ResumeDepartStaffVO> resumeDepartStaffVOList,@ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        resumeDepartStaffVOList.stream().forEach(resumeDepartStaffVO -> {
            resumeDepartStaffVO.setCreator(staffNo);
            resumeDepartStaffVO.setUpdator(staffNo);
        });

        ComResponse<String> re = resumeFeginService.sendToBeatch(resumeDepartStaffVOList);

        if(StrUtil.isNotBlank(re.getData())){
            for (String s : re.getData().split("=")) {
                msgSendAsync.sendToDepart(staffNo,s);

            }

        }
        return re;
    }
//    @ApiOperation(value = "简历列表-推送(待筛选或筛选未通过或简历库)", notes = "简历列表-推送(待筛选或筛选未通过或简历库)", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = "/sendTo", method = RequestMethod.POST)
//    ComResponse<String> sendTo( @RequestBody @Validated ResumeDepartStaffVO resumeDepartStaffVO) throws IllegalAccessException {
//        resumeDepartStaffVO= StaffBeanUtils.setNullValue(resumeDepartStaffVO);
//
//        return resumeFeginService.sendTo(resumeDepartStaffVO);
//    }


    @ApiOperation(value = "简历列表-批量发送(待筛选)", notes = "简历列表-批量发送(待筛选)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendToBatchDepart", method = RequestMethod.POST)
    ComResponse<String> sendToBatchDepart( @RequestBody @NotEmpty List<ResumeDepartStaffInsertPo> insertPos, @ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        insertPos.forEach(x->x.setCreator(staffNo));
        ComResponse<String> re = resumeFeginService.sendToBatchDepart(insertPos);
        if(re.getData()!=null){
            String[] split = re.getData().split("=");
            for (String s : split) {
                msgSendAsync.sendToDepart(staffNo,s);

            }

        }

        return re;
    }
    @ApiOperation(value = "简历列表-单个发给部门(待筛选)", notes = "简历列表-单个发给部门(待筛选)", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/sendToDepart", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resumeId", value = "简历id", required = true, dataType = "Integer", paramType = "query")
    })
    ComResponse<String> sendToDepart(@RequestBody ResumeDepartStaffInsertPo insertPo, @ApiIgnore @CurrentStaffNo String staffNo) throws IllegalAccessException {
        insertPo.setCreator(staffNo);
        ComResponse<String> re = resumeFeginService.sendToDepart(insertPo);
        if(re.getData()!=null){
            msgSendAsync.sendToDepart(staffNo,re.getData());
        }
        return re;
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

    @ApiOperation(value = "简历超时状态修改(定时修改)", notes = "简历超时状态修改", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updateFollowupStatus", method = RequestMethod.GET)
    ComResponse<String> updateFollowupStatus(HttpServletRequest request) throws ParseException {
        ComResponse<String> re = resumeFeginService.updateFollowupStatus();
        if (StrUtil.isNotBlank(re.getData())){
            msgSendAsync.resumeFllowUpStatus(JsonUtil.jsonToList(re.getData(), StaffPo.class));
        }
        return re;
    }
    @ApiOperation(value = "简历列表-导出", notes = "简历列表-导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "state", value = "状态 0 待筛选  1筛选未通过  2筛选通过待面试 3面试中 4面试未通过 5面试通过待入职 6:推送中 7:面试通过已入职  8放入简历库", required = true, dataType = "Int", paramType = "query")
    })
    @RequestMapping(value = "/export", method = RequestMethod.GET)
   public void noBatchPass(@RequestParam("state") Integer state, HttpServletResponse response) {
        String execName="resume_list";
        try {
            ExcelWriter writer = ExcelUtil.getWriter();
            writer.renameSheet("简历列表");     //甚至sheet的名称
            if(state==0){ // 待筛选
                execName="待筛选";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("startEndTime","就读时间");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("intentionName","初试意向");
                writer.addHeaderAlias("entryTimes","入司次数");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creatorName","录入人");
                writer.addHeaderAlias("creator","工号");
                writer.addHeaderAlias("followUpTime","简历跟进时间点");
                writer.addHeaderAlias("followUpStatusStr","跟进状态");
            }else if(state==1){
                execName="筛选未通过";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("startEndTime","就读时间");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("entryTimes","入司次数");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("resumeDepartStaffDesc","备注");
                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creatorName","录入人");
                writer.addHeaderAlias("creator","工号");
            }else if (state==2){
                execName="筛选通过待面试";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("startEndTime","就读时间");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("entryTimes","入司次数");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("resumeDepartStaffDesc","备注");
                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creatorName","录入人");
                writer.addHeaderAlias("creator","工号");
            }else if (state==3){
                execName="面试中";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("entryTimes","入司次数");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("resumeNodeName","面试轮次");
                writer.addHeaderAlias("resultCodeName","面试结果");
                writer.addHeaderAlias("evaluate","备注");
                writer.addHeaderAlias("interviewTime","面试时间");
                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creatorName","录入人");
                writer.addHeaderAlias("creator","工号");
            }else if (state==4){
                execName="面试未通过";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("entryTimes","入司次数");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("interviewTime","面试时间");
                writer.addHeaderAlias("evaluate","备注");
                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creatorName","录入人");
                writer.addHeaderAlias("creator","工号");
            }
            else if (state==5){
                execName="面试通过待入职";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("entryTimes","入司次数");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("evaluate","备注");
                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creatorName","录入人");
                writer.addHeaderAlias("creator","工号");
            }
            else if (state==7){
                execName="面试通过已入职";
                writer.addHeaderAlias("entryTime", "入职时间");
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("postName","岗位");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("natureStr","属性");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("partnerCodeStr","合作方");
                writer.addHeaderAlias("workCodeStr","职场");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("startEndTime","就读时间");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("contractFile","劳动合同");
                writer.addHeaderAlias("backCard","银行卡号");
                writer.addHeaderAlias("article","领取物品");
                writer.addHeaderAlias("entryTimes","入司次数");
            }
            else if (state==8){
                execName="放入简历库";
                writer.addHeaderAlias("name", "姓名");
                writer.addHeaderAlias("sex","性别");
                writer.addHeaderAlias("degreeName","学历");
                writer.addHeaderAlias("schoolName","毕业院校");
                writer.addHeaderAlias("startEndTime","时间");
                writer.addHeaderAlias("phone", "手机号");
                writer.addHeaderAlias("email","邮箱");
                writer.addHeaderAlias("departName","岗位部门");
                writer.addHeaderAlias("postName","应聘岗位");
                writer.addHeaderAlias("pDepartName","上级架构");
                writer.addHeaderAlias("sourceName","来源渠道");
                writer.addHeaderAlias("fileName","附件简历");
                writer.addHeaderAlias("rdCreateTime","入库时间");
                writer.addHeaderAlias("reasonCodeName","入库原因");
                writer.addHeaderAlias("intentionName","初试意向");
                writer.addHeaderAlias("entryTimes","入司次数");

                writer.addHeaderAlias("createTime","录入时间");
                writer.addHeaderAlias("creator","录入人");
            }


            ResumeParamsVO resumeParamsVO = new ResumeParamsVO();
            resumeParamsVO.setState(state);
            resumeParamsVO.setPageSize(100000);
            ComResponse<Page<ResumeListDto>> listByParams = resumeFeginService.getListByParams(resumeParamsVO);
            List list = new ArrayList();
            if(null != listByParams.getData()) {
                List<ResumeListDto> items = listByParams.getData().getItems();
//            List<RecordInfoDetailsDTO> list = query(); //查询出所有的需要导出的数据
                if (items != null || items.size() > 0) {
                    for (ResumeListDto item : items) {
                        ResumeExportDto resumeExportDto = new ResumeExportDto();
                        try {
                            BeanUtil.copyProperties(item, resumeExportDto);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        list.add(resumeExportDto);
                    }
                }
            }
            writer.setOnlyAlias(true);
            writer.write(list, true);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
//            response.setContentType("application/octet-stream");
//            execName = new String(execName.getBytes("UTF-8"),"ISO8859-1");
            response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(execName, "UTF-8")+".xlsx");   //中文名称需要特殊处理
//            response.setHeader("Content-Disposition", "attachment; filename="+ execName+".xlsx");   //中文名称需要特殊处理
            writer.autoSizeColumnAll();
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


    @ApiOperation(value = "简历录入-导入", notes = "查简历录入-导入", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/importResumeList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "文件路径(相对路径)", required = true, dataType = "String", paramType = "query"),
    })
    void importResumeList(String url, HttpServletResponse response, @ApiIgnore @CurrentStaffNo String staffNo) {
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.renameSheet("简历导入结果");     //甚至sheet的名称
        ComResponse<List<ResumeImportResultDto>> result =  resumeFeginService.importResumeList(url,staffNo);


        List<ResumeImportResultDto> list = result.getData();
        try {
            writer.addHeaderAlias("departNo", "部门id");
            writer.addHeaderAlias("result", "导入结果");
            writer.addHeaderAlias("resultDesc", "resultDesc");
            writer.setOnlyAlias(true);
            writer.write(list, true);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("简历导入结果", "UTF-8") + ".xlsx");   //中文名称需要特殊处理
            writer.autoSizeColumnAll();
            writer.flush(response.getOutputStream());
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
