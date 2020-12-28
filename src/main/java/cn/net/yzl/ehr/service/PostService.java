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




    ComResponse<String> addPost(PostVo postVo,String staffNo) ;


    ComResponse<List<PostDto>> getPostList(Integer departId) ;


    ComResponse<PostDto> getPostById(Integer id);

    ComResponse<String> updatePost(PostUpdateVo postVo,String staffNo);


    ComResponse<String> deletePost(Integer id,String staffNo);

    /**
     * 岗位级别管理
     * postlevel
     * @return
     */

    ComResponse<String> addPostLevel(PostLevelVo postLevelVo,String staffNo) ;

    ComResponse<List<PostLevelListDto>> getPostLevelListByDepartId(Integer departId);

    ComResponse<PostLevelListDto> getPostLevelListByPostId(Integer postId);

    ComResponse<PostLevelDto> getPostLevelById(Integer id) ;

    ComResponse<String> updateLevelPost( PostLevelUpdateVo postLevelVo,String staffNo) ;

    ComResponse<String> deletePostLevel(Integer id,String staffNo) ;
}
