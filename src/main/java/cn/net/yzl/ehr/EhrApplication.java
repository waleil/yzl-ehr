package cn.net.yzl.ehr;

import cn.net.yzl.common.swagger2.EnableSwagger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"cn.net.yzl.ehr", "cn.net.yzl.pm", "cn.net.yzl.msg"})
@EnableSwagger
@EnableTransactionManagement(order = 10) //开启事务，并设置order值，默认是Integer的最大值
@EnableFeignClients(basePackages = {"cn.net.yzl.ehr.fegin", "cn.net.yzl.msg.feign"})
@EnableDiscoveryClient
@EnableAsync
@Slf4j
public class EhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhrApplication.class, args);
        log.info("ehr successfully started....");
    }
}