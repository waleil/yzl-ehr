package cn.net.yzl.ehr.service.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.vo.GroupVo;

import java.util.List;

public interface UltrGroupService {

    // 调用Cti服务获取组的信息
    List<Group> findUltrGroupInfo(Integer groupType, String fatherId);

    // 调用Cti服务添加组
    ComResponse<Boolean> addUltrGroup(GroupVo group);

    // 调用Cti服务删除组
    ComResponse<Boolean> deleteUltrGroup(String groupIds, Integer groupType);

    ComResponse<Boolean> updateUltrGroup(String groupId, Integer groupType, String groupName);
}
