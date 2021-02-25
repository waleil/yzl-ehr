package cn.net.yzl.ehr.service.ultrcrm.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.ultrcrm.GroupFeignService;
import cn.net.yzl.ehr.service.ultrcrm.UltrGroupService;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.vo.GroupVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UltrGroupServiceImpl implements UltrGroupService {

    @Autowired
    private GroupFeignService groupFeignService;

    /**
     * 调用Cti服务获取组的信息
     * @param groupType 0:ACD组 1:业务组 默认业务组
     * @param fatherId 父ID 不传递返回1级分组
     */
    @Override
    public List<Group> findUltrGroupInfo(Integer groupType, String fatherId) {
        ComResponse<List<Group>> comResponse = groupFeignService.queryGroups(groupType, fatherId);
        if (null != comResponse && null != comResponse.getData()) {
            return comResponse.getData();
        }
        return new ArrayList<>();
    }

    /**
     * 调用Cti服务添加组
     * @param group 组拓展实体
     */
    @Override
    public ComResponse<Boolean> addUltrGroup(GroupVo group) {
        return groupFeignService.addGroup(group);
    }

    /**
     * 调用Cti服务删除组
     * @param groupIds 组ID
     */
    @Override
    public ComResponse<Boolean> deleteUltrGroup(String groupIds, Integer groupType) {
        return groupFeignService.delGroup(groupIds,groupType);
    }

    @Override
    public ComResponse<Boolean> updateUltrGroup(String groupId, Integer groupType, String groupName) {
        return groupFeignService.updateUltrGroup(groupId,groupType,groupName);
    }
}
