
package cn.net.yzl.ehr.authorization.Interceptor;

import cn.net.yzl.ehr.authorization.resolvers.CurrentUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
@ComponentScan({"cn.net.yzl.ehr.authorization.Interceptor","cn.net.yzl.ehr.authorization.resolvers"})
public class MyWebAppConfigurer  implements WebMvcConfigurer {

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;
    //解决跨域问题
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        //设置允许跨域的路径
//        registry.addMapping("/**")
//                //设置允许跨域请求的域名
//                .allowedOrigins("*")
//                //是否允许证书 不再默认开启
//                .allowCredentials(true)
//                //设置允许的方法
//                .allowedMethods("*")
//                //跨域允许时间
//                .maxAge(3600);
//
//
//    }

    /**
     * 自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/depart/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staff/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/sysDic/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/conf/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/post/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/postLevel/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departSocial/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departAttendFalse/**");
    }

    /**
     * 配置ArgumentResolvers
     * 实现采用业务逻辑，向controllor 方法中注入参数
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver);
    }


}
