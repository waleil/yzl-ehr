package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.baseDto.PostBaseDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.vo.PostLevelUpdateVo;
import cn.net.yzl.ehr.vo.PostLevelVo;
import cn.net.yzl.ehr.vo.PostUpdateVo;
import cn.net.yzl.ehr.vo.PostVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostService {




    ComResponse<String> addPost(PostVo postVo) ;


    ComResponse<List<PostDto>> getPostList(Integer departId) ;


    ComResponse<PostDto> getPostById(Integer id);

    ComResponse<String> updatePost(PostUpdateVo postVo);


    ComResponse<String> deletePost(Integer id);

    /**
     * 岗位级别管理
     * postlevel
     * @return
     */

    ComResponse<String> addPostLevel(@RequestBody PostLevelVo postLevelVo) ;

    ComResponse<List<PostLevelListDto>> getPostLevelListByDepartId(@RequestParam("departId")  Integer departId);

    ComResponse<PostLevelListDto> getPostLevelListByPostId(@RequestParam("postId") Integer postId);

    ComResponse<PostLevelDto> getPostLevelById(@RequestParam("id")  Integer id) ;

    ComResponse<String> updateLevelPost(@RequestBody PostLevelUpdateVo postLevelVo) ;

    ComResponse<String> deletePostLevel(@RequestParam("id") Integer id) ;
}
