
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
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staff/**").
                excludePathPatterns("/staff/abnor/timerUpdateStafffAbnorRecord")
                .excludePathPatterns("/staff/abnor/staffBatchPostLevelTimedTask")
                .excludePathPatterns("/staff/abnor/staffBatchPostLevelTimedDayTask");
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
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/resume/**")
                      .excludePathPatterns("/resume/updateFollowupStatus");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/departLevel/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/office/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/courseware/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/parking/**")
                .excludePathPatterns("/parking/timerUpdate");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/attend/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/saffAttend/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/achievementsConfigureForFrontLine/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/achievementsConfigureForFunc/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/performanceAuditConfigurationForFrontLine/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/performanceAuditConfigurationForFunc/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/performance/**")
                .excludePathPatterns("/performance/sendPerformanceRemind")
                .excludePathPatterns("/performance/updateSystemDate");
//        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/salary/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/salarySlip/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/salaryFrontLineRule/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/salaryNotFrontLineRule/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/performanceProportionConfiguration/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffRecruit/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/process/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/assessment/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/deductRecord/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/increaseRecord/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/processActive/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/processsInvite/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/StaffPasswordRule/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/work/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffInvoice/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/workOverTime/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffSponsorIntrRoya/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffPayment/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffLoan/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/staffContractApproval/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/processReimbursement/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/salaryFrontLineRuleNew/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/salaryRulePost/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/encrypt/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/appClockRangeConf/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/appDeviceRecord/**");
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/appStaffClockLog/**");

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
