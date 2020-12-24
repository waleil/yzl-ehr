package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.baseDto.PostBaseDto;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.vo.PostLevelUpdateVo;
import cn.net.yzl.ehr.vo.PostLevelVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-api")
@RefreshScope
public interface PostLevelFeginMapper {

    @RequestMapping(value = "/post/getPostLevelById", method = RequestMethod.GET)
    ComResponse<PostLevelDto> getPostLevelById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/post/deletePostLevel", method = RequestMethod.POST)
    ComResponse<String> deletePostLevel(@RequestParam("id") Integer id);

    @RequestMapping(value = "/post/addPostLevelPost", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<String> addPostLevelPost(@RequestBody @Validated PostLevelVo postLevel);

    @RequestMapping(value = "/post/updatePostLevel", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<String> updatePostLevel(@RequestBody @Validated PostLevelUpdateVo postLevel);

    @RequestMapping(value = "/post/getLevelList", method = RequestMethod.GET)
    ComResponse<List<PostBaseDto>> getListByDepartId(@RequestParam("departId") Integer departId);


}
