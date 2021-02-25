package cn.net.yzl.ehr.controller.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.service.ultrcrm.UltrMemberService;
import cn.net.yzl.model.vo.MemberVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cti/ultrcrm/member")
@Api(tags="调用Cti服务操作成员")
public class UltrMemberController {

    @Autowired
    private UltrMemberService memberService;

    /**
     * 调用Cti服务,获取组的成员
     * @param groupId 组id
     * @param groupType 组类型 0:ACD组 1:业务组
     * @return
     */
    @ApiOperation(value="调用Cti服务,获取组的成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "组ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "groupType:0:ACD组 1:业务组", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "memberName", value = "成员工号ID", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "memberNo", value = "成员姓名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/queryGroupMembers")
    public ComResponse<Page<MemberVo>> queryGroupMembers(
            @RequestParam(name = "groupId")String groupId ,
            @RequestParam(name = "groupType")Integer groupType,
            @RequestParam(name = "page")Integer page,
            @RequestParam(name = "size")Integer size,
            @RequestParam(name = "memberName",required = false)String memberName,
            @RequestParam(name = "memberNo",required = false)String memberNo ) {
        Page<MemberVo> memberList = memberService.findUltrMemberList(groupId, groupType, page, size, memberName, memberNo);
        return ComResponse.success(memberList);
    }

    /**
     * 调用Cti服务,获取指定成员
     * @param memberId
     */
    @ApiOperation(value="调用Cti服务,获取指定成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "成员ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping(value = "/getMember")
    public ComResponse<MemberVo> getMember(@RequestParam(name = "memberId") String memberId) {
        MemberVo member = memberService.findUltrMember(memberId);
        return ComResponse.success(member);
    }

    /**
     * 调用Cti服务,添加成员
     * @param member
     */
    @ApiOperation(value="调用Cti服务,添加成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "member", value = "id:成员ID,name:成员名称", required = true, dataType = "Member", paramType = "body")
    })
    @PostMapping(value = "/addMember")
    public ComResponse<Boolean> addMember(@RequestBody @Validated MemberVo member, BindingResult result) {
        return memberService.addUltrMember(member);
    }

    /**
     * 调用Cti服务,删除成员
     * @param memberIds 坐席ID
     */
    @ApiOperation(value="调用Cti服务,删除成员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberIds", value = "成员ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping(value = "/delMember")
    public ComResponse<Boolean> deleteMember(@RequestParam(name = "memberIds") String memberIds) {
        return memberService.deleteUltrMember(memberIds);
    }

    /**
     * 调用Cti服务,绑定坐席到组
     */
    @ApiOperation(value="调用Cti服务,绑定坐席到组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberIds", value = "成员ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupId", value = "组id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "组类型 0:ACD组 1:业务组", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/bindMembersToGroup")
    public ComResponse<Boolean> bindMembersToGroup(
            @RequestParam(name = "memberIds") String memberIds,
            @RequestParam(name = "groupId")String groupId,
            @RequestParam(name = "groupType")Integer groupType) {
        return memberService.bindUltrMembersToGroup(groupId, memberIds,groupType);
    }

    /**
     * 调用Cti服务,解绑坐席从组
     */
    @ApiOperation(value="解绑坐席从组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberIds", value = "成员ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupId", value = "组id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "组类型 0:ACD组 1:业务组", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/unbindMembersFromGroup")
    public ComResponse<Boolean> unbindMembersFromGroup(
            @RequestParam(name = "memberIds") String memberIds,
            @RequestParam(name = "groupId")String groupId,
            @RequestParam(name = "groupType")Integer groupType) {
        return memberService.unbindUltrMembersFromGroup(memberIds,groupId,groupType);
    }

}
