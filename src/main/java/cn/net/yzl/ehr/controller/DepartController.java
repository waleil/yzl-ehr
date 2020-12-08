package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.UnAuthorization;
import cn.net.yzl.ehr.dto.DepartDto;
import cn.net.yzl.ehr.service.DepartService;
import cn.net.yzl.ehr.vo.DepartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/depart")
@Api(value = "部门模块", tags = {"部门模块"})
public class DepartController {

    @Autowired
    private DepartService departService;


    @ApiOperation(value = "获取部门的树状列表", notes = "获取部门的树状列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "query")
    })
    @UnAuthorization
    @RequestMapping(value = "/getTreeList", method = RequestMethod.GET)
    public ComResponse<DepartDto> getTreeList() {
        return departService.getTreeList();
    }


    @ApiOperation(value = "添加部门", notes = "添加部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ComResponse<String> add(@RequestBody @Validated DepartVO departVO) {
        return departService.add(departVO);
    }
    @ApiOperation(value = "更新部门", notes = "更新部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ComResponse<String> update(@RequestBody @Validated DepartVO departVO) {
        return departService.update(departVO);
    }

    @ApiOperation(value = "删除部门", notes = "删除部门", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ComResponse<String> del(@NotBlank(message = "部门id不能为null!") String departId) {
        return departService.del(departId);
    }

}
