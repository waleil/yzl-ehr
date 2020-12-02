package cn.net.yzl.ehr.runner;


import cn.hutool.core.util.StrUtil;
import cn.net.yzl.ehr.config.redis.RedisUtil;
import cn.net.yzl.ehr.dingding.DefaultDingtalkToken;
import cn.net.yzl.ehr.dingding.DingProperties;
import com.taobao.api.ApiException;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.management.MalformedObjectNameException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
@Order(value = 1)
public class MyStartupRunner implements CommandLineRunner {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DefaultDingtalkToken defaultDingtalkToken;

    private static Logger log = LoggerFactory.getLogger(MyStartupRunner.class);

    @Override
    public void run(String... strings) {
       // 刷新钉钉 的token
        try {
            defaultDingtalkToken.renewal();
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
