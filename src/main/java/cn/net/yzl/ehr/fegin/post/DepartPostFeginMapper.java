package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.DepartPostDto;
import cn.net.yzl.ehr.pojo.DepartPostPo;
import cn.net.yzl.ehr.pojo.DepartPostUpdatePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "departPost",url = "${fegin.db.url}")
@RefreshScope
public interface DepartPostFeginMapper {

    @RequestMapping(value = "/departPost/addDepartPost", method = RequestMethod.POST)
    ComResponse<Integer> addPost(@RequestBody DepartPostPo departPostPo) ;

    @RequestMapping(value = "/departPost/getListByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartPostDto>> getListByDepartId(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/departPost/getWithoutResumeByDepartId", method = RequestMethod.GET)
    public ComResponse<List<DepartPostDto>> getListWithoutResumeByDepartId(@RequestParam("departId") Integer departId);

    @RequestMapping(value = "/departPost/getPostByPostId", method = RequestMethod.GET)
    public ComResponse<DepartPostDto> getPostByPostId(@RequestParam("departId") Integer departId,@RequestParam("postId") Integer postId);

    @RequestMapping(value = "/departPost/getPostById", method = RequestMethod.GET)
    public ComResponse<DepartPostDto> getPostById(@RequestParam("id")  Integer id) ;

    @RequestMapping(value = "/departPost/updatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> updatePost(@RequestBody DepartPostUpdatePo post);

    @RequestMapping(value = "/departPost/deletePost", method = RequestMethod.GET)
    ComResponse<Integer> delete(@RequestParam("id")  Integer id,@RequestParam("staffNo") String staffNo) ;

    @RequestMapping(value = "/departPost/getListByLoginDepartId", method = RequestMethod.GET)
    ComResponse<List<DepartPostDto>> getListByLoginDepartId(@RequestParam("staffNo") String staffNo);

}
