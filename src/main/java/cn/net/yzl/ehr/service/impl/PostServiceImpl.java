package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.baseDto.PostBaseDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.fegin.post.PostFeginMapper;
import cn.net.yzl.ehr.fegin.post.PostLevelFeginMapper;
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

    @Autowired
    private PostLevelFeginMapper postLevelFeginMapper;


    @Override
    public ComResponse<String> insertPost(PostVo postVo) {
        ComResponse<String> result = postFeginMapper.addPost(postVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<List<PostDto>> getPostList(int departId) {
        ComResponse<List<PostDto>> result = postFeginMapper.getList(departId);
        if (result == null  ) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> updatePost(PostUpdateVo postVo) {
        ComResponse<String> result = postFeginMapper.update(postVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> deletePost(int id) {
        ComResponse<String> result = postFeginMapper.delete(id);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }



    @Override
    public ComResponse<PostDto> getPostById(int id) {
        ComResponse<PostDto> result = postFeginMapper.getPost(id);
        if (result == null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> insertPostLevel(PostLevelVo postLevelVo) {
        ComResponse<String> result = postLevelFeginMapper.addPostLevelPost(postLevelVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }


    @Override
    public ComResponse<List<PostBaseDto>> getPostLevelList(int departId) {
        ComResponse<List<PostBaseDto>> result = postLevelFeginMapper.getListByDepartId(departId);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> updatePostLevel(PostLevelUpdateVo postLevelUpdateVo) {
        ComResponse<String> result = postLevelFeginMapper.updatePostLevel(postLevelUpdateVo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> deletePostLevel(int id) {
        //判断是否有此岗位级别的员工
        ComResponse<String>  result = postLevelFeginMapper.deletePostLevel(id);
        if (result == null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<PostLevelDto> getPostLevelById(int id) {
        ComResponse<PostLevelDto> result = postLevelFeginMapper.getPostLevelById(id);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }


}