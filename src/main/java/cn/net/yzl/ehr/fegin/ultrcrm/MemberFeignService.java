package cn.net.yzl.ehr.fegin.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.Member;
import cn.net.yzl.model.vo.GroupVo;
import cn.net.yzl.model.vo.MemberVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "yzl-cti")
@Repository
public interface MemberFeignService {

    @RequestMapping(value = "/cti/buss/queryGroupMembers", method = RequestMethod.GET)
    ComResponse<List<MemberVo>> queryGroupMembers(@RequestParam("groupId")String groupId , @RequestParam("groupType")Integer groupType);

    @RequestMapping(value = "/cti/buss/queryMember", method = RequestMethod.GET)
    ComResponse<MemberVo> queryMember(@RequestParam("memberId")String memberId );

    @RequestMapping(value = "/cti/buss/addMember", method = RequestMethod.POST)
    ComResponse<Boolean> addMember(@RequestBody MemberVo member);

    @RequestMapping(value = "/cti/buss/delMember", method = RequestMethod.GET)
    ComResponse<Boolean> delMember(@RequestParam(name = "memberIds") String memberIds );

    @RequestMapping(value = "/cti/buss/bindMembersToGroup", method = RequestMethod.GET)
    ComResponse<Boolean> bindMembersToGroup( @RequestParam(name = "memberIds") String memberIds,@RequestParam(name = "groupId")String groupId,@RequestParam(name = "groupType")Integer groupType);

    @RequestMapping(value = "/cti/buss/unbindMembersFromGroup", method = RequestMethod.GET)
    ComResponse<Boolean> unbindMembersFromGroup( @RequestParam(name = "memberIds") String memberIds,@RequestParam(name = "groupId")String groupId,@RequestParam(name = "groupType")Integer groupType);

}
