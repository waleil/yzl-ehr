package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ResultDto;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.config.redis.RedisDbSelectFactory;
import cn.net.yzl.ehr.config.redis.RedisUtil;
import cn.net.yzl.ehr.fegin.StaffFeginService;
import cn.net.yzl.ehr.mapper.StaffMapper;
import cn.net.yzl.ehr.pojo.StaffPo;
import cn.net.yzl.ehr.service.StaffService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/staff")
@Api(value="员工服务",tags={"员工服务"})
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;





    @ApiOperation(value="根据id获取员工信息(通过fegin进行远程调用)", notes="根据id获取员工信息(通过fegin进行远程调用)",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResultDto<String> getKey(int id){

        return staffFeginService.getByPrimaryKey(id);
    }




//    @ApiOperation(value="测试mysql的读写分离", notes="测试mysql的读写分离",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNum", value = "pageNum", required = true, dataType = "String",paramType="query"),
//            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = true, dataType = "String",paramType="query")
//    })
//    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
//    public ResultDto<PageInfo<StaffPo>> getPage(int pageNum,int pageSize){
//
//        return ResultDto.success(staffService.getPage(pageNum,pageSize));
//    }
}
