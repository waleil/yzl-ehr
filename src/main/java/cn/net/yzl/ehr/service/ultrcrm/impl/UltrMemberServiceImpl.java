package cn.net.yzl.ehr.service.ultrcrm.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.entity.PageParam;
import cn.net.yzl.ehr.fegin.ultrcrm.MemberFeignService;
import cn.net.yzl.ehr.service.ultrcrm.UltrMemberService;
import cn.net.yzl.model.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UltrMemberServiceImpl implements UltrMemberService {

    @Autowired
    private MemberFeignService memberFeignService;

    /**
     * 调用Cti服务,获取组的成员
     * @param groupId 组id
     * @param groupType 组类型 0:ACD组 1:业务组
     * @param page 页码
     * @param size 每页条数
     * @param memberName 姓名
     * @param memberNo 工号
     * @return
     */
    @Override
    public Page<MemberVo> findUltrMemberList(String groupId, Integer groupType, Integer page, Integer size, String memberName, String memberNo) {
        ComResponse<Page<MemberVo>> pageComResponse = memberFeignService.queryGroupMembers(groupId, groupType, page, size, memberName, memberNo);
        if (null != pageComResponse && null != pageComResponse.getData()) {
            return pageComResponse.getData();
        }
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(page);
        pageParam.setPageSize(size);
        pageParam.setPageTotal(0);
        pageParam.setTotalCount(0);
        Page<MemberVo> pageNull = new Page<>();
        pageNull.setPageParam(pageParam);
        return pageNull;
    }

    /**
     * 通过工号获取员工信息
     * @param memberId 工号
     * @return
     */
    @Override
    public MemberVo findUltrMember(String memberId) {
        ComResponse<MemberVo> memberVoComResponse = memberFeignService.queryMember(memberId);
        if (null != memberVoComResponse && null !=memberVoComResponse.getData()) {
            return memberVoComResponse.getData();
        } else {
        	return null;
        }
    }

    /**
     * 调用Cti服务,添加成员
     * @param member
     */
    @Override
    public ComResponse<Boolean> addUltrMember(MemberVo member) {
        return memberFeignService.addMember(member);
    }

    /**
     * 调用Cti服务,删除成员
     * @param memberIds 坐席ID
     */
    @Override
    public ComResponse<Boolean> deleteUltrMember(String memberIds) {
        return memberFeignService.delMember(memberIds);
    }

    /**
     * 调用Cti服务,解绑坐席从组
     */
    @Override
    public ComResponse<Boolean> unbindUltrMembersFromGroup(String memberIds, String groupId, Integer groupType) {
        return memberFeignService.unbindMembersFromGroup(memberIds,groupId,groupType);
    }

    /**
     * 调用Cti服务,绑定坐席到组
     */
    @Override
    public ComResponse<Boolean> bindUltrMembersToGroup(String groupId, String memberIds, Integer groupType) {
        return memberFeignService.bindMembersToGroup(memberIds, groupId, groupType);
    }
}
