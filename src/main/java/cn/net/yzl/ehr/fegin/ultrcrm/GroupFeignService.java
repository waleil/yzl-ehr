package cn.net.yzl.ehr.fegin.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.vo.GroupVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "yzl-cti")
@Repository
public interface GroupFeignService {

    @RequestMapping(value = "/cti/buss/queryGroups", method = RequestMethod.GET)
    ComResponse<List<Group>> queryGroups( @RequestParam("groupType")Integer groupType, @RequestParam("fatherId")String fatherId);

    @RequestMapping(value = "/cti/buss/addGroup", method = RequestMethod.POST)
    ComResponse<Boolean> addGroup( @RequestBody GroupVo group);

    @RequestMapping(value = "/cti/buss/delGroup", method = RequestMethod.GET)
    ComResponse<Boolean> delGroup(@RequestParam("groupIds")String groupIds,@RequestParam("groupType")Integer groupType);

    @RequestMapping(value = "/cti/buss/updateGroup", method = RequestMethod.GET)
    ComResponse<Boolean> updateUltrGroup(@RequestParam(value = "groupId") String groupId,@RequestParam(value = "groupType") Integer groupType,@RequestParam(value = "groupName") String groupName);
}
