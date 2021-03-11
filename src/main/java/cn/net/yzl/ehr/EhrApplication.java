package cn.net.yzl.ehr;

import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.swagger2.EnableSwagger;
import org.checkerframework.checker.units.qual.A;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = {"cn.net.yzl.ehr","cn.net.yzl.logger","cn.net.yzl.pm","cn.net.yzl.msg"})
@EnableSwagger
@EnableTransactionManagement(order = 10) //开启事务，并设置order值，默认是Integer的最大值
@EnableFeignClients(basePackages = {"cn.net.yzl.ehr.fegin","cn.net.yzl.msg.feign"})
@EnableDiscoveryClient
@EnableAsync
public class EhrApplication {


    public static void main(String[] args) {
        SpringApplication.run(EhrApplication.class, args);

        System.err.println("测试....");
    }
}