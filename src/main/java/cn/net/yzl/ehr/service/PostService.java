package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.pojo.PostItemPo;

import java.util.List;

public interface PostService {

/*    ComResponse<Integer> add(PostPo postPo);

    ComResponse<Integer> addBatch(ValidList<PostPo> postList);

    ComResponse<Integer> update(PostUpdatePo postPo);

    ComResponse<Integer> delete(int id,String staffNo);*/

    ComResponse<List<PostDto>> getList();

    ComResponse<PostDto> getById(Integer id);

    ComResponse<String> saveUpdate(PostItemPo postItemPo,String staffNo);

    ComResponse<String> selectDepartPostCountForPost(Integer postId);
}
