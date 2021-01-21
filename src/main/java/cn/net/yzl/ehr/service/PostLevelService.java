package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.pojo.PostLevelUpdatePo;
import cn.net.yzl.ehr.util.ValidList;

import java.util.List;

public interface PostLevelService {

    ComResponse<PostLevelDto> getById( Integer id);

    ComResponse<List<PostLevelDto>> getList();

    ComResponse<PostLevelListDto> getListByPostId( Integer postId);

    ComResponse<Integer> getStaffTotalForPostLevel( Integer postLevelId) ;

    ComResponse<Integer> saveUpdate(ValidList<PostLevelUpdatePo> postLevelUpdatePo,String staffNo) ;

}
