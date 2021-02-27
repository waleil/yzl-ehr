package cn.net.yzl.ehr.service.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.model.vo.MemberVo;

public interface UltrMemberService {

    // 调用Cti服务,获取组的成员
    Page<MemberVo> findUltrMemberList(String groupId, Integer groupType, Integer page, Integer size, String memberName, String memberNo);

    // 调用Cti服务,获取指定成员
    MemberVo findUltrMember(String memberId);

    // 调用Cti服务,添加成员
    ComResponse<Boolean> addUltrMember(MemberVo member);

    // 调用Cti服务,删除成员
    ComResponse<Boolean> deleteUltrMember(String memberIds);

    // 调用Cti服务,解绑坐席从组
    ComResponse<Boolean> unbindUltrMembersFromGroup(String memberIds, String groupId, Integer groupType);

    // 调用Cti服务,绑定坐席到组
    ComResponse<Boolean> bindUltrMembersToGroup(String groupId, String memberIds, Integer groupType);
}
