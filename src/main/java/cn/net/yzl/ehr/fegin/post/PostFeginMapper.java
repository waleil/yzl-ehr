package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.vo.PostLevelUpdateVo;
import cn.net.yzl.ehr.vo.PostLevelVo;
import cn.net.yzl.ehr.vo.PostUpdateVo;
import cn.net.yzl.ehr.vo.PostVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-api")
//@FeignClient(value = "post",url = "${fegin.api.url}")
@RefreshScope
public interface PostFeginMapper {



    @RequestMapping(value = "/post/addPost", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<String> addPost(@RequestBody PostVo postVo) ;

    @RequestMapping(value = "/post/getPostList", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostList(@RequestParam("departId") Integer departId) ;

    @RequestMapping(value = "/post/getPostById", method = RequestMethod.GET)
    public ComResponse<PostDto> getPostById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/post/updatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<String> updatePost(@RequestBody PostUpdateVo postVo);

    @RequestMapping(value = "/post/deletePost", method = RequestMethod.POST)
    ComResponse<String> deletePost(@RequestParam("id") Integer id, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/post/addBatchPost", method = RequestMethod.POST)
    ComResponse<Integer> addBatchPost(@RequestBody List<PostVo> postList);

    /////////////////////////////////////////

    /**
     * 岗位级别管理
     * postlevel
     * @return
     */

    @RequestMapping(value = "/post/addPostLevel", method = RequestMethod.POST)
    ComResponse<String> addPostLevel(@RequestBody PostLevelVo postLevelVo) ;

    @RequestMapping(value = "/post/getPostLevelListByDepartId", method = RequestMethod.GET)
    public ComResponse<List<PostLevelListDto>> getPostLevelListByDepartId(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/post/getPostLevelListByPostId", method = RequestMethod.GET)
    ComResponse<PostLevelListDto> getPostLevelListByPostId(@RequestParam("postId") Integer postId);

    @RequestMapping(value = "/post/getPostLevelById", method = RequestMethod.GET)
    public ComResponse<PostLevelDto> getPostLevelById(@RequestParam("id") Integer id) ;

    @RequestMapping(value = "/post/updatePostLevel", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<String> updateLevelPost(@RequestBody PostLevelUpdateVo postLevelVo) ;

    @RequestMapping(value = "/post/deletePostLevel", method = RequestMethod.POST)
    ComResponse<String> deletePostLevel(@RequestParam("id") Integer id, @RequestParam("staffNo") String staffNo) ;

    @RequestMapping(value = "/post/addBatchPostLevel", method = RequestMethod.POST)
    ComResponse<Integer> addBatchPostLevel(@RequestBody List<PostLevelVo> postLevelList);
}
