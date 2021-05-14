package cn.net.yzl.ehr.controller.departConfig;

import cn.hutool.core.collection.CollectionUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeItemDto;
import cn.net.yzl.ehr.dto.DepartResumeNodeDto;
import cn.net.yzl.ehr.fegin.departResume.DepartResumeFeignService;
import cn.net.yzl.ehr.pojo.DepartResumeInsertListPo;
import cn.net.yzl.ehr.pojo.DepartResumeUpdateListPo;
import cn.net.yzl.ehr.service.DepartResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/conf/resume")
@Api(value = "配置模块-面试流程配置", tags = {"配置模块"})
@Valid
public class DepartResumeController {

    @Autowired
    private DepartResumeService departResumeService;
    @Autowired
    private DepartResumeFeignService departResumeFeignService;

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

 @ApiOperation(value = "面试流程-根据部门岗位id获取面试流程节点", notes = "面试流程-获取岗位的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartPostId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeNodeDto>> getByDepartPostId(@RequestParam("departPostId") @NotNull @Min(1)  Integer departPostId) {
     ComResponse<List<DepartResumeNodeDto>> byDepartPostId = departResumeFeignService.getByDepartPostId(departPostId);
     List<DepartResumeNodeDto> data = byDepartPostId.getData();
     if(CollectionUtil.isNotEmpty(data)){
         data = data.stream().sorted((s1, s2) -> s1.getNoteId().compareTo(s2.getNoteId())).collect(Collectors.toList());
     }
     return byDepartPostId;
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
