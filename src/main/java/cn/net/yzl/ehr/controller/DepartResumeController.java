package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.DepartResumeInfoDto;
import cn.net.yzl.ehr.service.DepartResumeService;
import cn.net.yzl.ehr.vo.DepartResumeInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/conf/resume")
@Api(value = "配置模块", tags = {"配置模块"})
@Valid
public class DepartResumeController {

    @Autowired
    private DepartResumeService departResumeService;

    @ApiOperation(value = "面试流程-创建面试流程配置", notes = "面试流程-创建面试流程配置", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody @Validated DepartResumeInfoVO departResumeInfoVO, @CurrentStaffNo String staffNo) {
        return departResumeService.add(departResumeInfoVO,staffNo);
    }

    @ApiOperation(value = "面试流程-根据主键更新面试流程信息", notes = "面试流程-根据主键更新面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<String> update(@RequestBody  DepartResumeInfoVO departResumeInfoVO,@CurrentStaffNo String staffNo) {
        return departResumeService.update(departResumeInfoVO,staffNo);
    }



    @ApiOperation(value = "面试流程-获取部门下的面试流程信息", notes = "面试流程-获取部门下的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeInfoDto>> getByDepartId(@RequestParam("departId") @Min(1) Integer departId) {
        return departResumeService.getByDepartId(departId);
    }

    @ApiOperation(value = "面试流程-获取岗位下的面试流程信息", notes = "面试流程-获取部门下的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByPostId", method = RequestMethod.GET)
    ComResponse<List<DepartResumeDto>> getByPostId(@RequestParam("postId") @Min(1) Integer postId) {
        return departResumeService.getByPostId(postId);
    }



    @ApiOperation(value = "面试流程-删除岗位的面试流程信息", notes = "面试流程-删除岗位的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteByPostId", method = RequestMethod.POST)
    ComResponse<String> deleteByPostId(@RequestParam("postId") @Min(1) Integer postId) {
        return departResumeService.deleteByPostId(postId);
    }


}
