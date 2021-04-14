package cn.net.yzl.ehr.fegin.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.vo.GroupVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "yzl-cti",url = "${fegin.cti.url}/cti")
@Repository
public interface GroupFeignService {

    @RequestMapping(value = "/buss/queryGroups", method = RequestMethod.GET)
    ComResponse<List<Group>> queryGroups( @RequestParam("groupType")Integer groupType, @RequestParam("fatherId")String fatherId);

    @RequestMapping(value = "/buss/addGroup", method = RequestMethod.POST)
    ComResponse<Boolean> addGroup( @RequestBody GroupVo group);

    @RequestMapping(value = "/buss/delGroup", method = RequestMethod.GET)
    ComResponse<Boolean> delGroup(@RequestParam("groupIds")String groupIds,@RequestParam("groupType")Integer groupType);

    @RequestMapping(value = "/buss/updateGroup", method = RequestMethod.GET)
    ComResponse<Boolean> updateUltrGroup(@RequestParam(value = "groupId") String groupId,@RequestParam(value = "groupType") Integer groupType,@RequestParam(value = "groupName") String groupName);
}
