package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.fegin.post.PostLevelFeginMapper;
import cn.net.yzl.ehr.pojo.PostLevelPo;
import cn.net.yzl.ehr.pojo.PostLevelUpdatePo;
import cn.net.yzl.ehr.service.PostLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostLevelServiceImpl implements PostLevelService {

    @Autowired
    private PostLevelFeginMapper postLevelMapper;


    @Override
    public ComResponse<PostLevelDto> getById(Integer id) {
        ComResponse<PostLevelDto> result = postLevelMapper.getById(id);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> delete(Integer id, String staffNo) {
        ComResponse<Integer> result = postLevelMapper.delete(id, staffNo);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()<1){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> addPostLevel(PostLevelPo postLevelPo,String staffNo) {
        postLevelPo.setCreator(staffNo);
        ComResponse<Integer> result = postLevelMapper.addPostLevel(postLevelPo);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> update(PostLevelUpdatePo postLevel,String staffNo) {
        postLevel.setUpdator(staffNo);
        ComResponse<Integer> result = postLevelMapper.update(postLevel);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getCode(),ResponseCodeEnums.NO_MATCHING_RESULT_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<List<PostLevelListDto>> getList() {
        ComResponse<List<PostLevelListDto>> result = postLevelMapper.getList();
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<PostLevelListDto> getListByPostId(Integer postId) {
        ComResponse<PostLevelListDto> result = postLevelMapper.getListByPostId(postId);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> getStaffTotalForPostLevel(Integer postLevelId) {
        ComResponse<Integer> result = postLevelMapper.getStaffTotalForPostLevel(postLevelId);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }
}
