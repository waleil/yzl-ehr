package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.pojo.PostLevelPo;
import cn.net.yzl.ehr.pojo.PostLevelUpdatePo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "yzl-staff-db")
//@FeignClient(value = "post",url = "${fegin.db.url}")
@RefreshScope
public interface PostLevelFeginMapper {

    @RequestMapping(value = "/postLevel/getById", method = RequestMethod.GET)
    ComResponse<PostLevelDto> getById(@RequestParam("id")  Integer id);


    @RequestMapping(value = "/postLevel/delete", method = RequestMethod.POST)
    ComResponse<Integer> delete(@RequestParam("id")  Integer id,@RequestParam("staffNo")  String staffNo);

    @RequestMapping(value = "/postLevel/addPostLevel", method = RequestMethod.POST)
    ComResponse<Integer> addPostLevel(@RequestBody PostLevelPo postLevelPo);

    @RequestMapping(value = "/postLevel/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody PostLevelUpdatePo postLevel);

    @RequestMapping(value = "/postLevel/getList", method = RequestMethod.GET)
    ComResponse<List<PostLevelListDto>> getList();

    @RequestMapping(value = "/postLevel/getListByPostId", method = RequestMethod.GET)
    ComResponse<PostLevelListDto> getListByPostId(@RequestParam("postId") Integer postId);

    @RequestMapping(value = "/postLevel/getStaffTotalForPostLevel", method = RequestMethod.GET)
    ComResponse<Integer> getStaffTotalForPostLevel(@RequestParam("postLevelId") Integer postLevelId) ;
}
