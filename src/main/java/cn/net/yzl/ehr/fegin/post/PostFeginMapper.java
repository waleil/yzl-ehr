package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostDto;
import cn.net.yzl.ehr.pojo.PostItemPo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "post",url = "${fegin.api.url}")
@RefreshScope
public interface PostFeginMapper {


    @RequestMapping(value = "/post/getPostList", method = RequestMethod.GET)
    public ComResponse<List<PostDto>> getPostList();


    @RequestMapping(value = "/post/getPostById", method = RequestMethod.GET)
    public ComResponse<PostDto> getPostById(@NotNull @Min(1) Integer id);


    @RequestMapping(value = "/post/saveUpdatePost", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> saveUpdatePost(@RequestBody  PostItemPo itemPo) ;

    @RequestMapping(value = "/post/cancelCheck", method = RequestMethod.GET)
    ComResponse<Integer> cancelCheck(@NotNull @Min(1) Integer postId);
}
