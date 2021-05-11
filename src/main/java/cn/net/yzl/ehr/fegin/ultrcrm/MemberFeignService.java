package cn.net.yzl.ehr.fegin.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.model.vo.MemberVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "yzl-cti", url = "${fegin.cti.url}/cti")
public interface MemberFeignService {

    @RequestMapping(value = "/buss/queryGroupMembers", method = RequestMethod.GET)
    ComResponse<Page<MemberVo>> queryGroupMembers(@RequestParam("groupId") String groupId, @RequestParam("groupType") Integer groupType, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("memberName") String memberName, @RequestParam("memberNo") String memberNo);

    @RequestMapping(value = "/buss/queryMember", method = RequestMethod.GET)
    ComResponse<MemberVo> queryMember(@RequestParam("memberId") String memberId);

    @RequestMapping(value = "/buss/addMember", method = RequestMethod.POST)
    ComResponse<Boolean> addMember(@RequestBody MemberVo member);

    @RequestMapping(value = "/buss/delMember", method = RequestMethod.GET)
    ComResponse<Boolean> delMember(@RequestParam(name = "memberIds") String memberIds);

    @RequestMapping(value = "/buss/bindMembersToGroup", method = RequestMethod.GET)
    ComResponse<Boolean> bindMembersToGroup(@RequestParam(name = "memberIds") String memberIds, @RequestParam(name = "groupId") String groupId, @RequestParam(name = "groupType") Integer groupType);

    @RequestMapping(value = "/buss/unbindMembersFromGroup", method = RequestMethod.GET)
    ComResponse<Boolean> unbindMembersFromGroup(@RequestParam(name = "memberIds") String memberIds, @RequestParam(name = "groupId") String groupId, @RequestParam(name = "groupType") Integer groupType);

}
