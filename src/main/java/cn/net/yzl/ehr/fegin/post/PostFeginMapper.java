package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.pojo.PostItemPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface PostFeginMapper {


    @RequestMapping(value = "/post/getPostList", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostList();


    @RequestMapping(value = "/post/getPostById", method = RequestMethod.GET)
    public ComResponse<PostDto> getPostById(@RequestParam("id") Integer id);


    @RequestMapping(value = "/post/saveUpdatePost", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<Integer> saveUpdatePost(@RequestBody PostItemPo itemPo);

    @RequestMapping(value = "/post/selectDepartPostCountForPost", method = RequestMethod.GET)
    ComResponse<Integer> selectDepartPostCountForPost(@RequestParam("postId") Integer postId);
}
