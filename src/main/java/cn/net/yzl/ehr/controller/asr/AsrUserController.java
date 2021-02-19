package cn.net.yzl.ehr.controller.asr;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.fegin.asr.AsrUserFeignService;
import cn.net.yzl.model.dto.UserOperaDto;
import cn.net.yzl.model.dto.UserRoleDto;
import cn.net.yzl.model.vo.AsrUserPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author wanghuasheng
 * @version 1.0
 * @description 代理asr操作用户
 * @title: AsrUserController
 * @date: 2021/02/04 15:00 下午
 */
@RestController
@Slf4j
@Api(tags = "asr组织架构")
@RequestMapping("asrUser")
public class AsrUserController {

    @Autowired
    private AsrUserFeignService asrUserFeignService;


    /**
     * @author wanghuasheng
     * @description 查询asr组织架构
     * @date: 2021/02/03 16:00 下午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @GetMapping(value = "v1/query")
    @ApiOperation(value = "查询asr组织架构", httpMethod = "GET")
    public ComResponse<AsrUserPageVO> getUserList(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                                  @RequestParam(value = "pagesize", defaultValue = "10") Integer pagesize,
                                                  @RequestParam(value = "userJobNumber") String userJobNumber,
                                                  @RequestParam(value = "userName") String userName,
                                                  @RequestParam(value = "userGroupId") String userGroupId) {
        return asrUserFeignService.getUserList(pageno,pagesize,userJobNumber,userName,userGroupId);
    }

    /**
     * @author wanghuasheng
     * @description 获取员工信息
     * @date: 2021/02/03 16:00 下午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @GetMapping(value = "v1/query/user/by/uid")
    @ApiOperation(value = "查询asr组织架构", httpMethod = "GET")
    public ComResponse<AsrUserPageVO.AsrUserVO> getUser(@RequestParam(value = "uid") String uid) {
        return  asrUserFeignService.getUser(uid);
    }

    /**
     * @author wangshuaidong
     * @description 删除用户
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<Boolean>
     */
    @DeleteMapping(value = "v1/delete/by/uid")
    @ApiOperation(value = "删除用户", httpMethod = "DELETE")
    public ComResponse<Boolean> deleteUser(@RequestParam("uid") String uid) {
        log.info("进入到删除用户接口。。。");
        return asrUserFeignService.deleteUser(uid);
    }
    /**
     * @author wangshuaidong
     * @description 查询所有Role列表
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<Boolean>
     */
    @GetMapping(value = "v1/role/all")
    @ApiOperation(value = "查询所有Role列表", httpMethod = "GET")
    public ComResponse<List<UserRoleDto>> roleAll() {
        return asrUserFeignService.roleAll();
    }

    /**
     * @author wangshuaidong
     * @description 添加用户
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<Boolean>
     */
    @PostMapping(value = "v1/user/add")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    public ComResponse<Boolean> userAdd(@RequestBody UserOperaDto userOperaDto){
        log.info("进入到添加用户接口 添加参数:{}",JsonUtil.toJsonStr(userOperaDto));
        return asrUserFeignService.userAdd(userOperaDto);
    }
}
