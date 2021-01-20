package cn.net.yzl.ehr.controller.departConfig;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeItemDto;
import cn.net.yzl.ehr.pojo.DepartResumeInsertListPo;
import cn.net.yzl.ehr.pojo.DepartResumeUpdateListPo;
import cn.net.yzl.ehr.service.DepartResumeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/conf/resume")
@Api(value = "配置模块-面试流程配置", tags = {"配置模块"})
@Valid
public class DepartResumeController {

    @Autowired
    private DepartResumeService departResumeService;

    @ApiOperation(value = "面试流程-创建面试流程配置", notes = "面试流程-创建面试流程配置", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody @Validated DepartResumeInsertListPo departResumePo, @CurrentStaffNo @ApiIgnore String staffNo) {
        departResumePo.setStaffNo(staffNo);
        return departResumeService.add(departResumePo);
    }

    @ApiOperation(value = "面试流程-根据主键更新面试流程信息", notes = "面试流程-根据主键更新面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody @Validated DepartResumeUpdateListPo itemUpdatePo, @CurrentStaffNo @ApiIgnore String staffNo) {
        itemUpdatePo.setStaffNo(staffNo);
        return departResumeService.saveUpdate(itemUpdatePo);
    }

    @ApiOperation(value = "面试流程-获取部门下的面试流程信息", notes = "面试流程-获取部门下的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    ComResponse<Page<DepartResumeItemDto>> getByDepartId(@RequestParam("departId") @Min(1) @NotNull Integer departId, @RequestParam("pageNo")  @Min(1) @NotNull Integer pageNo,
                                                         @RequestParam("pageSize")  @Min(1) @NotNull Integer pageSize) {
        return departResumeService.getByDepartId(departId,pageNo,pageSize);
    }

    @ApiOperation(value = "面试流程-获取岗位的面试流程信息", notes = "面试流程-获取岗位的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByPostId", method = RequestMethod.GET)
    ComResponse<DepartResumeDto> getByPostId(@RequestParam("departId") @NotNull @Min(1)  Integer departId, @RequestParam("postId") @NotNull @Min(1) Integer postId) {
        return departResumeService.getByPostId(departId,postId);
    }

    @ApiOperation(value = "面试流程-用配置ip获取流程信息", notes = "面试流程-用配置ip获取流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByResumeId", method = RequestMethod.GET)
    ComResponse<DepartResumeDto> getByResumeId(@RequestParam("resumeId") @NotNull @Min(1)  Integer resumeId) {
        return departResumeService.getByResumeId(resumeId);
    }


    @ApiOperation(value = "面试流程-删除面试流程信息", notes = "面试流程-删除面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteByResumeId", method = RequestMethod.POST)
    ComResponse<Integer> deleteByResumeId(@RequestParam("resumeId") @Min(1) Integer resumeId,@CurrentStaffNo @ApiIgnore String staffNo) {
        return departResumeService.deleteByResumeId(resumeId,staffNo);
    }

}
