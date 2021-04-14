package cn.net.yzl.ehr.config.fegin;

import feign.Request;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Feign配置注册（全局）
 */
@Configuration
public class FeignSupportConfig {

    @Bean
    @Order(-1)
    public RequestInterceptor requestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }

@Bean
    public Request.Options options(){
        return new Request.Options(50000,50000);
    }
}
