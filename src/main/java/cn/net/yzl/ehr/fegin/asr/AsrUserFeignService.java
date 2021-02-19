package cn.net.yzl.ehr.fegin.asr;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.dto.UserOperaDto;
import cn.net.yzl.model.dto.UserRoleDto;
import cn.net.yzl.model.vo.AsrUserPageVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "asrUserService",url = "${fegin.db.url}")
public interface AsrUserFeignService {


    /**
     * @author wanghuasheng
     * @description 查询asr组织架构
     * @date: 2021/02/03 16:00 下午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @GetMapping(value = "asrUser/v1/query")
    @ApiOperation(value = "查询asr组织架构", httpMethod = "GET")
    ComResponse<AsrUserPageVO> getUserList(@RequestParam(value = "pageno", defaultValue = "1") Integer pageno,
                                                  @RequestParam(value = "pagesize", defaultValue = "10") Integer pagesize,
                                                  @RequestParam(value = "userJobNumber") String userJobNumber,
                                                  @RequestParam(value = "userName") String userName,
                                                  @RequestParam(value = "userGroupId") String userGroupId) ;

    /**
     * @author wanghuasheng
     * @description 获取员工信息
     * @date: 2021/02/03 16:00 下午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @GetMapping(value = "asrUser/v1/query/user/by/uid")
    @ApiOperation(value = "查询asr组织架构", httpMethod = "GET")
    ComResponse<AsrUserPageVO.AsrUserVO> getUser(@RequestParam(value = "uid") String uid);
    /**
     * @author wangshuaidong
     * @description 删除用户
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<Boolean>
     */
    @DeleteMapping(value = "asrUser/v1/delete/by/uid")
    @ApiOperation(value = "删除用户", httpMethod = "DELETE")
    ComResponse<Boolean> deleteUser(@RequestParam("uid") String uid) ;
    /**
     * @author wangshuaidong
     * @description 查询所有Role列表
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<Boolean>
     */
    @GetMapping(value = "asrUser/v1/role/all")
    @ApiOperation(value = "查询所有Role列表", httpMethod = "GET")
    ComResponse<List<UserRoleDto>> roleAll() ;

    /**
     * @author wangshuaidong
     * @description 添加用户
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<Boolean>
     */
    @PostMapping(value = "asrUser/v1/user/add")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    ComResponse<Boolean> userAdd(@RequestBody UserOperaDto userOperaDto);

}
