package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.mapper.StaffMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value="测试",tags={"测试模块"})
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StaffMapper staffMapper;


    @ApiOperation(value="测试Redis,设置值", notes="测试Redis,设置值",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "value", value = "值", required = true,dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/getKey", method = RequestMethod.GET)
    public String getKey(String key,String value){

        redisTemplate.opsForValue().set(key, value);

        return redisTemplate.opsForValue().get(key).toString();
    }

    @ApiOperation(value="测试mysql", notes="测试mysql",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public String getKey(int id){
        return JsonUtil.toJsonStr(staffMapper.selectByPrimaryKey(id));
    }

}
