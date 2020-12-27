//package cn.net.yzl.ehr.controller;
//
//import cn.net.yzl.common.entity.ComResponse;
//import cn.net.yzl.common.util.JsonUtil;
//import cn.net.yzl.ehr.config.redis.RedisDbSelectFactory;
//import cn.net.yzl.ehr.config.redis.RedisUtil;
//import cn.net.yzl.ehr.mapper.StaffMapper;
//import cn.net.yzl.ehr.pojo.StaffPo;
//import cn.net.yzl.ehr.service.StaffService;
//import com.github.pagehelper.PageInfo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.concurrent.TimeUnit;
//
//@RestController
//@RequestMapping("/test")
//@Api(value="测试",tags={"测试模块"})
//public class TestController {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Autowired
//    RedissonClient redisson;
//
//
//
//
//    @Autowired
//    private StaffService staffService;
//
////
////    @ApiOperation(value="测试Redis,设置值", notes="测试Redis,设置值",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
////    @ApiImplicitParams({
////            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String",paramType="query"),
////            @ApiImplicitParam(name = "value", value = "值", required = true,dataType = "String",paramType="query")
////    })
////    @RequestMapping(value = "/getKey", method = RequestMethod.GET)
////    public String getKey(String key,String value){
////
//////        redisTemplate.opsForValue().set(key, value);
////        RedisTemplate redisTemplate = RedisDbSelectFactory.selectDb(this.redisTemplate, 3);
////
////        redisTemplate.opsForValue().set(key,value);
////        boolean set = redisUtil.set(key, value);
////        return set+"";
////    }
////
////    @ApiOperation(value="测试redisson分布式锁", notes="测试redisson分布式锁",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
////    @ApiImplicitParams({
////            @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String",paramType="query")
////    })
////    @RequestMapping(value = "/testRedissonLock", method = RequestMethod.GET)
////    public String testRedissonLock(String key){
////
////        RLock lock = redisson.getLock(key);
////
////        boolean locked = lock.isLocked();
////        System.err.println(locked);
////        try {
//////            boolean b = lock.tryLock(10, 1, TimeUnit.SECONDS);
////            lock.lock(10,TimeUnit.SECONDS);
////            Thread.sleep(5000);
////            lock.unlock();
////            return "aaa";
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////
////        return false+"";
////    }
////
////
////
////    @ApiOperation(value="测试mysql", notes="测试mysql",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
////    @ApiImplicitParams({
////            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String",paramType="query")
////    })
////    @RequestMapping(value = "/getById", method = RequestMethod.GET)
////    public String getKey(int id){
////        return JsonUtil.toJsonStr(staffService.getByPrimaryKey(id));
////    }
////
////
////
////
////    @ApiOperation(value="测试mysql的读写分离", notes="测试mysql的读写分离",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
////    @ApiImplicitParams({
////            @ApiImplicitParam(name = "pageNum", value = "pageNum", required = true, dataType = "String",paramType="query"),
////            @ApiImplicitParam(name = "pageSize", value = "pageSize", required = true, dataType = "String",paramType="query")
////    })
////    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
////    public ComResponse<PageInfo<StaffPo>> getPage(int pageNum,int pageSize){
////
////        return ComResponse.success(staffService.getPage(pageNum,pageSize));
////    }
//}
