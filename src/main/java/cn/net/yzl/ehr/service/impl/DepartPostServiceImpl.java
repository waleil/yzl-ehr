package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.fegin.post.DepartPostFeginMapper;
import cn.net.yzl.ehr.pojo.DepartPostPo;
import cn.net.yzl.ehr.pojo.DepartPostUpdatePo;
import cn.net.yzl.ehr.service.DepartPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartPostServiceImpl implements DepartPostService {

    @Autowired
    private DepartPostFeginMapper departPostMapper;

    @Override
    public ComResponse<String> addPost(DepartPostPo departPostPo,String staffNo) {
        departPostPo.setCreator(staffNo);
        ComResponse<Integer> result = departPostMapper.addPost(departPostPo);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<List<DepartPostDto>> getListByDepartId(Integer departId) {
        ComResponse<List<DepartPostDto>> result = departPostMapper.getListByDepartId(departId);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<List<DepartPostDto>> getListWithoutResumeByDepartId(Integer departId) {
        ComResponse<List<DepartPostDto>> result = departPostMapper.getListWithoutResumeByDepartId(departId);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return result;
    }




    @Override
    public ComResponse<DepartPostDto> getPostByPostId(Integer departId, Integer postId) {
        ComResponse<DepartPostDto> result = departPostMapper.getPostByPostId(departId, postId);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<DepartPostDto> getPostById(Integer id) {
        ComResponse<DepartPostDto> result = departPostMapper.getPostById(id);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()==null){
            return ComResponse.nodata();
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<String> updatePost(DepartPostUpdatePo post,String staffNo) {
        post.setUpdator(staffNo);
        ComResponse<Integer> result = departPostMapper.updatePost(post);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<String> delete(Integer id, String staffNo) {
        ComResponse<Integer> result = departPostMapper.delete(id,staffNo);
        if(result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(result.getCode()==200 &&  result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.UPDATE_DATA_ERROR_CODE.getMessage());
        }else if(result.getCode()!=200){
            return ComResponse.fail(result.getCode(),result.getMessage());
        }
        return ComResponse.success();
    }
}
