package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.vo.PostUpdateVo;
import cn.net.yzl.ehr.vo.PostVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-api")
@RefreshScope
public interface PostFeginMapper {

    @RequestMapping(value = "/post/addPost", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<String> addPost(@RequestBody PostVo post);

    @RequestMapping(value = "/post/getPostList", method = RequestMethod.GET)
    ComResponse<List<PostDto>> getList(@RequestParam("departId") int departId);

    @RequestMapping(value = "/post/updatePost", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<String> update(@RequestBody PostUpdateVo post);

    @RequestMapping(value = "/post/deletePost", method = RequestMethod.POST)
    ComResponse<String> delete(@RequestParam("id") int id);

    @RequestMapping(value = "/post/getPostById", method = RequestMethod.GET)
    ComResponse<PostDto> getPost(@RequestParam("id") int id);

}
