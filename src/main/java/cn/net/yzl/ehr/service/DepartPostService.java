package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.pojo.DepartPostPo;
import cn.net.yzl.ehr.pojo.DepartPostUpdatePo;
import cn.net.yzl.ehr.pojo.PostItemPo;


import javax.validation.constraints.NotNull;
import java.util.List;

public interface DepartPostService {


    ComResponse<String> addPost( DepartPostPo departPostPo,String staffNo) ;

    public ComResponse<List<DepartPostDto>> getListByDepartId(Integer departId);
    public ComResponse<DepartPostDto> getPostByPostId( Integer departId, Integer postId);

    public ComResponse<DepartPostDto> getPostById( Integer id);

    ComResponse<String> updatePost(DepartPostUpdatePo post,String staffNo);

    ComResponse<String> delete( Integer id, String staffNo) ;

    public ComResponse<List<DepartPostDto>> getListWithoutResumeByDepartId(Integer departId) ;

    public ComResponse<List<DepartPostDto>> getListByLoginDepartId(String departId);
}
