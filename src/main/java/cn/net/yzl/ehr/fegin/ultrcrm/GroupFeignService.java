package cn.net.yzl.ehr.fegin.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.vo.GroupVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-cti", url = "${fegin.cti.url}/cti")
public interface GroupFeignService {

    @RequestMapping(value = "/buss/queryGroups", method = RequestMethod.GET)
    ComResponse<List<Group>> queryGroups(@RequestParam("groupType") Integer groupType, @RequestParam("fatherId") String fatherId);

    @RequestMapping(value = "/buss/addGroup", method = RequestMethod.POST)
    ComResponse<Boolean> addGroup(@RequestBody GroupVo group);

    @RequestMapping(value = "/buss/delGroup", method = RequestMethod.GET)
    ComResponse<Boolean> delGroup(@RequestParam("groupIds") String groupIds, @RequestParam("groupType") Integer groupType);

    @RequestMapping(value = "/buss/updateGroup", method = RequestMethod.GET)
    ComResponse<Boolean> updateUltrGroup(@RequestParam(value = "groupId") String groupId, @RequestParam(value = "groupType") Integer groupType, @RequestParam(value = "groupName") String groupName);
}
