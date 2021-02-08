package cn.net.yzl.ehr.controller.dictConfig;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.pojo.PostItemPo;
import cn.net.yzl.ehr.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/post")
@Api(value = "岗位字典接口", tags = {"字典配置"})
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation(value = "岗位字典-获取岗位列表", notes = "获取岗位列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getPostList", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostList() {
        return postService.getList();
    }

    @ApiOperation(value = "岗位字典-用岗位id获取岗位信息", notes = "获取岗位信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "岗位id", required = true,  paramType = "query")
    })
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    public ComResponse<PostDto> getPostById(@NotNull @Min(1) Integer id) {
        return postService.getById(id);
    }


    @ApiOperation(value = "岗位字典-保存岗位列表", notes = "保存岗位列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/saveUpdatePost", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<String> saveUpdatePost(@RequestBody @Validated PostItemPo itemPo, @CurrentStaffNo @ApiIgnore String staffNo) {
        return postService.saveUpdate(itemPo,staffNo);
    }

}
