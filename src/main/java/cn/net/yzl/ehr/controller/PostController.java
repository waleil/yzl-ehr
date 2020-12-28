package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.baseDto.PostBaseDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.service.PostService;
import cn.net.yzl.ehr.vo.PostLevelUpdateVo;
import cn.net.yzl.ehr.vo.PostLevelVo;
import cn.net.yzl.ehr.vo.PostUpdateVo;
import cn.net.yzl.ehr.vo.PostVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/post")
@Api(value = "岗位服务层服务", tags = {"岗位服务层服务"})
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 岗位管理
     * post
     * @return
     */




    @ApiOperation(value = "创建岗位", notes = "创建岗位", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    ComResponse<String> addPost(@RequestBody @Validated PostVo postPo) {
        return postService.addPost(postPo);
    }

    @ApiOperation(value = "获取部门下岗位列表", notes = "获取部门下岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "departId", value = "部门编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/getPostList", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostList(@RequestParam("departId") @NotNull @Min(0) Integer departId) {
        return postService.getPostList(departId);
    }

    @ApiOperation(value = "获取岗位信息", notes = "获取岗位信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "岗位编号", required = true, paramType = "query")
    )
    public ComResponse<PostDto> getPostById(@RequestParam("id") @NotNull @Min(0) Integer id) {
        return postService.getPostById(id);
    }

    @ApiOperation(value = "更新岗位信息", notes = "更新", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<String> updatePost(@RequestBody @Validated PostUpdateVo postVo) {
        return postService.updatePost(postVo);
    }

    @ApiOperation(value = "删除岗位", notes = "删除岗位", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "岗位编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    ComResponse<String> deletePost(@RequestParam("id") @NotNull @Min(0) Integer id) {
        return postService.deletePost(id);
    }


    /**
     * 岗位级别管理
     * postlevel
     * @return
     */

    @ApiOperation(value = "创建岗位级别", notes = "创建岗位级别", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addPostLevelPost", method = RequestMethod.POST)
    ComResponse<String> addPostLevelPost(@RequestBody @Validated PostLevelVo postLevelVo) {
        return postService.addPostLevel(postLevelVo);
    }

    @ApiOperation(value = "获取部门岗位级别列表", notes = "获取部门岗位级别列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "departId", value = "部门编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/getPostLevelListByDepartId", method = RequestMethod.GET)
    public ComResponse<List<PostLevelListDto>> getPostLevelListByDepartId(@RequestParam("departId") @NotNull @Min(0) Integer departId) {
        return postService.getPostLevelListByDepartId(departId);
    }

    @ApiOperation(value = "查询岗位的岗位级别列表", notes = "查询岗位的岗位级别列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "postId", value = "岗位编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/getPostLevelListByPostId", method = RequestMethod.GET)
    ComResponse<PostLevelListDto> getPostLevelListByPostId(@RequestParam("postId") @NotNull @Min(0) Integer postId){
        return postService.getPostLevelListByPostId(postId);
    }

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "岗位级别编号", required = true, paramType = "query")
    )
    @ApiOperation(value = "获取岗位级别信息", notes = "获取岗位级别信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPostLevelById", method = RequestMethod.GET)
    public ComResponse<PostLevelDto> getPostLevelById(@RequestParam("id") @Min(1) Integer id) {
        return postService.getPostLevelById(id);
    }

    @ApiOperation(value = "更新岗位级别信息", notes = "更新岗位级别信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updatePostLevel", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<String> updateLevelPost(@RequestBody @Validated PostLevelUpdateVo postLevelVo) {
        return postService.updateLevelPost(postLevelVo);
    }

    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "岗位级别编号", required = true, paramType = "query")
    )
    @ApiOperation(value = "删除岗位级别", notes = "删除岗位级别", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deletePostLevel", method = RequestMethod.POST)
    ComResponse<String> deletePostLevel(@RequestParam("id") @Min(1) Integer id) {
        return postService.deletePostLevel(id);
    }
}
