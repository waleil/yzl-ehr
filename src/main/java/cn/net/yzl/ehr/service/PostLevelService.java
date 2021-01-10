package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.pojo.PostLevelPo;
import cn.net.yzl.ehr.pojo.PostLevelUpdatePo;

import java.util.List;

public interface PostLevelService {



    ComResponse<PostLevelDto> getById( Integer id);

    ComResponse<Integer> delete(Integer id,String staffNo);


    ComResponse<Integer> addPostLevel( PostLevelPo postLevelPo,String staffNo);

    ComResponse<Integer> update( PostLevelUpdatePo postLevel,String staffNo);

    ComResponse<List<PostLevelListDto>> getList();

    ComResponse<PostLevelListDto> getListByPostId( Integer postId);


    ComResponse<Integer> getStaffTotalForPostLevel( Integer postLevelId) ;

}
