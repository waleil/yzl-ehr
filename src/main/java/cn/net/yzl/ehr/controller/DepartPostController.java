package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.pojo.DepartPostPo;
import cn.net.yzl.ehr.pojo.DepartPostUpdatePo;
import cn.net.yzl.ehr.service.DepartPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/departPost")
@Api(value = "部门岗位接口", tags = {"部门岗位接口"})
public class DepartPostController {

    @Autowired
    private DepartPostService departPostService;

    @ApiOperation(value = "部门下新建岗位", notes = "部门下新建岗位", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addDepartPost", method = RequestMethod.POST)
    ComResponse<String> addPost(@RequestBody @Validated DepartPostPo departPostPo,@CurrentStaffNo @ApiIgnore String staffNo) {
        return departPostService.addPost(departPostPo,staffNo);
    }

    @ApiOperation(value = "获取部门下岗位列表", notes = "获取岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getListByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartPostDto>> getListByDepartId(Integer departId) {
        return departPostService.getListByDepartId(departId);
    }

    @ApiOperation(value = "获取部门岗位信息", notes = "获取部门岗位信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departId", value = "部门id", required = true,  paramType = "query"),
            @ApiImplicitParam(name = "postId", value = "岗位id", required = true,  paramType = "query")
    })
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    public ComResponse<DepartPostDto> getPostById(@NotNull @Min(1) Integer departId, @NotNull @Min(1) Integer postId) {
        return departPostService.getPostById(departId,postId);
    }

    @ApiOperation(value = "更新岗位信息", notes = "更新", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<String> updatePost(@RequestBody @Validated DepartPostUpdatePo post, @CurrentStaffNo @ApiIgnore String staffNo) {
        return departPostService.updatePost(post,staffNo);
    }

    @ApiOperation(value = "删除岗位", notes = "删除岗位", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    ComResponse<String> delete(@RequestParam("id") @NotNull @Min(0) Integer id, @CurrentStaffNo @ApiIgnore String staffNo) {
        return departPostService.delete(id,staffNo);
    }

}
