package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.fegin.post.PostFeginMapper;
import cn.net.yzl.ehr.service.PostService;
import cn.net.yzl.ehr.vo.PostLevelUpdateVo;
import cn.net.yzl.ehr.vo.PostLevelVo;
import cn.net.yzl.ehr.vo.PostUpdateVo;
import cn.net.yzl.ehr.vo.PostVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostFeginMapper postFeginMapper;



    @Override
    public ComResponse<String> addPost(PostVo postVo) {
        ComResponse<String> result = postFeginMapper.addPost(postVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<List<PostDto>> getPostList(Integer departId) {
        ComResponse<List<PostDto>> result = postFeginMapper.getPostList(departId);
        if (result == null  ) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> updatePost(PostUpdateVo postVo) {
        ComResponse<String> result = postFeginMapper.updatePost(postVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }


    @Override
    public ComResponse<PostDto> getPostById(Integer id) {
        ComResponse<PostDto> result = postFeginMapper.getPostById(id);
        if (result == null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> deletePost(Integer id) {
        ComResponse<String> result = postFeginMapper.deletePost(id);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> addPostLevel(PostLevelVo postLevelVo) {
        ComResponse<String> result = postFeginMapper.addPostLevel(postLevelVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<List<PostLevelListDto>> getPostLevelListByDepartId(Integer departId) {
        ComResponse<List<PostLevelListDto>> result = postFeginMapper.getPostLevelListByDepartId(departId);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<PostLevelListDto> getPostLevelListByPostId(Integer postId) {
        ComResponse<PostLevelListDto> result = postFeginMapper.getPostLevelListByPostId(postId);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }


    @Override
    public ComResponse<PostLevelDto> getPostLevelById(Integer id) {
        ComResponse<PostLevelDto> result = postFeginMapper.getPostLevelById(id);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> updateLevelPost(PostLevelUpdateVo postLevelVo) {
        ComResponse<String> result = postFeginMapper.updateLevelPost(postLevelVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> deletePostLevel(Integer id) {
        ComResponse<String>  result = postFeginMapper.deletePostLevel(id);
        if (result == null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }
}