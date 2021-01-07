package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.fegin.post.PostFeginMapper;
import cn.net.yzl.ehr.pojo.PostItemPo;
import cn.net.yzl.ehr.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostFeginMapper postMapper;


    @Override
    public ComResponse<List<PostDto>> getList() {
        ComResponse<List<PostDto>> result = postMapper.getPostList();
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 && (result.getData()==null || result.getData().size()<1)){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<PostDto> getById(Integer id) {
        ComResponse<PostDto> result = postMapper.getPostById(id);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<String> selectStaffCountForPost(Integer postId){
        ComResponse<Integer> integerComResponse = postMapper.cancelCheck(postId);
        if(integerComResponse==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(integerComResponse.getCode()==200 && integerComResponse.getData()>1){
            return ComResponse.fail(ResponseCodeEnums.POST_HAS_STAFF_ERROR_CODE.getCode(),ResponseCodeEnums.POST_HAS_STAFF_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<String> saveUpdate(PostItemPo postItemPo,String staffNo){
        postItemPo.getPostDeleteList().forEach(x->{
            x.setUpdator(staffNo);
        });
        postItemPo.getPostInsertList().forEach(x->{
            x.setCreator(staffNo);
        });
        postItemPo.getPostUpdateList().forEach(x->{
            x.setUpdator(staffNo);
        });
        ComResponse<Integer> integerComResponse = postMapper.saveUpdatePost(postItemPo);
        if(integerComResponse==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(integerComResponse.getCode()==200   ) {
            if (integerComResponse.getData() == 0) {
                return ComResponse.fail(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(), ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getMessage());
            } else {
                return ComResponse.success();
            }
        }
        return ComResponse.fail(integerComResponse.getCode(),integerComResponse.getMessage());
    }
}
