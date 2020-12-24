package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.baseDto.PostBaseDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.vo.PostLevelUpdateVo;
import cn.net.yzl.ehr.vo.PostLevelVo;
import cn.net.yzl.ehr.vo.PostUpdateVo;
import cn.net.yzl.ehr.vo.PostVo;

import java.util.List;

public interface PostService {

    ComResponse<String> insertPost(PostVo postVo);

    ComResponse<List<PostDto>> getPostList(int departId);

    ComResponse<String> updatePost(PostUpdateVo postUpdateVo);

    ComResponse<String> deletePost(int id);

    ComResponse<PostDto> getPostById(int id);

    ComResponse<String> insertPostLevel(PostLevelVo postLevelVo);

    ComResponse<List<PostBaseDto>> getPostLevelList(int departId);

    ComResponse<String> updatePostLevel(PostLevelUpdateVo postLevelUpdateVo);

    ComResponse<String> deletePostLevel(int id);

    ComResponse<PostLevelDto> getPostLevelById(int id);
}
