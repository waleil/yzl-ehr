package cn.net.yzl.ehr.fegin.post;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.PostLevelDto;
import cn.net.yzl.ehr.dto.PostLevelListDto;
import cn.net.yzl.ehr.pojo.PostLevelUpdatePo;
import cn.net.yzl.ehr.util.ValidList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-db", url = "${fegin.db.url}")
public interface PostLevelFeginMapper {

    @RequestMapping(value = "/postLevel/getById", method = RequestMethod.GET)
    ComResponse<PostLevelDto> getById(@RequestParam("id") Integer id);

/*
    @RequestMapping(value = "/postLevel/delete", method = RequestMethod.POST)
    ComResponse<Integer> delete(@RequestParam("id")  Integer id,@RequestParam("staffNo")  String staffNo);

    @RequestMapping(value = "/postLevel/addPostLevel", method = RequestMethod.POST)
    ComResponse<Integer> addPostLevel(@RequestBody PostLevelPo postLevelPo);

    @RequestMapping(value = "/postLevel/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody PostLevelUpdatePo postLevel);*/

    @RequestMapping(value = "/postLevel/getList", method = RequestMethod.GET)
    ComResponse<List<PostLevelDto>> getList();

    @RequestMapping(value = "/postLevel/getListByPostId", method = RequestMethod.GET)
    ComResponse<PostLevelListDto> getListByPostId(@RequestParam("postId") Integer postId);

    @RequestMapping(value = "/postLevel/getStaffTotalForPostLevel", method = RequestMethod.GET)
    ComResponse<Integer> getStaffTotalForPostLevel(@RequestParam("postLevelId") Integer postLevelId);

    @RequestMapping(value = "/postLevel/saveUpdate", method = RequestMethod.POST)
    ComResponse<Integer> saveUpdate(@RequestBody ValidList<PostLevelUpdatePo> updatePo);
}
