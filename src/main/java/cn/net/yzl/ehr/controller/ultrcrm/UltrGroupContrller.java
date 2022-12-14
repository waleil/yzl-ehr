package cn.net.yzl.ehr.controller.ultrcrm;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.ultrcrm.UltrGroupService;
import cn.net.yzl.model.Group;
import cn.net.yzl.model.vo.GroupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cti/ultrcrm/group")
@Api(tags="调用Cti服务操作组")
public class UltrGroupContrller {

    @Autowired
    private UltrGroupService ultrGroupService;

    /**
     * 调用Cti服务获取组的信息
     * @param groupType 0:ACD组 1:业务组 默认业务组
     * @param fatherId 父ID 不传递返回1级分组
     */
    @ApiOperation(value="调用Cti服务获取组的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupType", value = "0:ACD组 1:业务组 默认业务组", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "fatherId", value = "父ID 不传递返回1级分组", dataType = "String", paramType = "query", required = false)
    })
    @GetMapping(value = "/queryGroups")
    public ComResponse<List<Group>> queryGroups(
            @RequestParam(value = "groupType",required = false) Integer groupType,
            @RequestParam(value = "fatherId",required = false) String fatherId) {
        List<Group> groupList = ultrGroupService.findUltrGroupInfo(groupType, fatherId);
        return ComResponse.success(groupList);
    }

    /**
     * 调用Cti服务添加组
     * @param group 组拓展实体
     */
    @ApiOperation(value="调用Cti服务添加组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "group", value = "name:组名称,groupType:0:ACD组 1:业务组", required = true, dataType = "group", paramType = "body")
    })
    @PostMapping(value = "/addGroup")
    public ComResponse<Boolean> addGroup(@RequestBody GroupVo group) {
        return ultrGroupService.addUltrGroup(group);
    }

    /**
     * 调用Cti服务编辑组
     * @param groupId 组ID
     * @param groupName 组名字
     * @param groupType 组类型
     * @return
     */
    @ApiOperation(value="调用Cti服务编辑组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId", value = "groupId:组ID,", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "0:ACD组 1:业务组", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "groupName", value = "修改后的组名(不可包括|或-)", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping(value = "/updateGroup")
    public ComResponse<Boolean> updateGroup(
            @RequestParam(value = "groupId") String groupId,
            @RequestParam(value = "groupName") String groupName,
            @RequestParam(value = "groupType") Integer groupType) {
        return ultrGroupService.updateUltrGroup(groupId,groupType,groupName);
    }

    /**
     * 调用Cti服务删除组
     * @param groupIds 组ID
     */
    @ApiOperation(value="调用Cti服务删除组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupIds", value = "groupIds:组ID,", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "groupType", value = "groupType:0:ACD组 1:业务组", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping(value = "/delGroup")
    public ComResponse<Boolean> deleteGroup(
            @RequestParam(value = "groupIds") String groupIds,
            @RequestParam(value = "groupType") Integer groupType) {
        return ultrGroupService.deleteUltrGroup(groupIds, groupType);
    }

}
