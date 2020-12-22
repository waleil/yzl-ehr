package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.UnAuthorization;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.service.DepartService;
import cn.net.yzl.ehr.vo.DepartUpdateVO;
import cn.net.yzl.ehr.vo.DepartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/depart")
@Api(value = "部门模块", tags = {"部门模块"})
public class DepartController {

    @Autowired
    private DepartService departService;


    @ApiOperation(value = "获取部门的树状列表", notes = "获取部门的树状列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getTreeList", method = RequestMethod.GET)
    public ComResponse<DepartDto> getTreeList() {
        return departService.getTreeList();
    }


    @ApiOperation(value = "获取子部门信息(1层)", notes = "获取子部门信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getChildById", method = RequestMethod.GET)
    ComResponse<List<DepartDto>> getChildById(@RequestParam("id") Integer id) {
        return departService.getChildById(id);
    }

    @ApiOperation(value = "添加部门", notes = "添加部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ComResponse<String> add(@RequestBody @Validated DepartVO departVO) {
        return departService.add(departVO);
    }

    @ApiOperation(value = "更新部门", notes = "更新部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<String> update(@RequestBody @Validated DepartUpdateVO departUpdateVo) {
        return departService.update(departUpdateVo);
    }

    @ApiOperation(value = "删除部门", notes = "删除部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    ComResponse<String> del(@RequestParam @NotBlank(message = "部门编号不能为null!") Integer departId) {
        return departService.del(departId);
    }


    @ApiOperation(value = "通过员工工号获取组织架构信息", notes = "通过员工工号获取组织架构信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo", value = "userNo", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getByUserNo", method = RequestMethod.GET)
    @UnAuthorization
    public ComResponse<DepartDto> getByUserNo(@RequestParam("userNo") String userNo) {
        return departService.getByUserNo(userNo);
    }

}
