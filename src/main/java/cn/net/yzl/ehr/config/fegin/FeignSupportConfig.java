package cn.net.yzl.ehr.config.fegin;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置注册（全局）
 */
@Configuration
public class FeignSupportConfig {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }
}
