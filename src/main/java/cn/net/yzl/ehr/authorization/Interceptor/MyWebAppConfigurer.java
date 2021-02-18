
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
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departPost/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/postLevel/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/resumeDict/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departSocial/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departAttendFalse/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/abnor/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/businessPost/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffEdu/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffFamily/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffGrowUp/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffQua/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/noRobbedConf/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/chooseClassConf/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/recruit/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/deduct/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/resume/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departLevel/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/office/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/courseware/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/parking/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/attend/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/saffAttend/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/performance/**");
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
