package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartResumeDto;
import cn.net.yzl.ehr.dto.PostBaseDto;
import cn.net.yzl.ehr.service.DepartResumeService;
import cn.net.yzl.ehr.vo.DepartResumeUpdateVO;
import cn.net.yzl.ehr.vo.DepartResumeVO;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/conf/resume")
@Api(value = "配置模块", tags = {"配置模块"})
@Valid
public class DepartResumeController {

    @Autowired
    private DepartResumeService departResumeService;

    @ApiOperation(value = "创建面试流程配置", notes = "创建面试流程配置", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<Integer> add(@RequestBody @Validated DepartResumeVO departResumeVO) {
        return departResumeService.add(departResumeVO);
    }

    @ApiOperation(value = "根据主键更新面试流程信息", notes = "根据主键更新面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> update(@RequestBody DepartResumeUpdateVO departResumeUpdateVO) {
        return departResumeService.update(departResumeUpdateVO);
    }



    @ApiOperation(value = "获取部门下的面试流程信息", notes = "获取部门下的面试流程信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getByDepartId", method = RequestMethod.GET)
    ComResponse<Map<PostBaseDto, List<DepartResumeDto>>> getByDepartId(@RequestParam("departId") @Min(1) Integer departId) {
        return departResumeService.getByDepartId(departId);
    }







}
