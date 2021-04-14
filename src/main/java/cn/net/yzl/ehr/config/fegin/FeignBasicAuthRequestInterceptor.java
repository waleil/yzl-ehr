package cn.net.yzl.ehr.config.fegin;

import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.util.UUIDGenerator;
import cn.net.yzl.ehr.authorization.Interceptor.AuthorizationInterceptor;
import cn.net.yzl.logger.common.XBasicUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(FeignBasicAuthRequestInterceptor.class);
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
//        requestTemplate.header("appid","yzl-ehr");
        requestTemplate.header("appid","yzl-staff-api");
        if (headerNames != null) {
            String traceId = request.getHeader("traceId");
            String spanId = request.getHeader("spanId");
            String userId = request.getHeader("userId");
            String token = request.getHeader("token");
            String cspanId = XBasicUtil.uuid();
            String url = requestTemplate.url();
            String params = requestTemplate.getRequestVariables().toString();
            log.info("{app:yzl-ehr,traceId:{},spanId:{},cspanId:{},userId:{},url:{},params:{}}",traceId,spanId,cspanId,userId,url,params);
            requestTemplate.header("spanId",cspanId);
            if (StringUtils.isNotBlank(userId)) requestTemplate.header("userId", userId);
            if (StringUtils.isNotBlank(token)) requestTemplate.header("token", token);
        }
//        Enumeration<String> bodyNames = request.getParameterNames();
//        StringBuffer body =new StringBuffer();
//        if (bodyNames != null) {
//            while (bodyNames.hasMoreElements()) {
//                String name = bodyNames.nextElement();
//                String values = request.getParameter(name);
//                body.append(name).append("=").append(values).append("&");
//            }
//        }
//        if(body.length()!=0) {
//            body.deleteCharAt(body.length()-1);
//            template.body(body.toString());
//            logger.info("feign interceptor body:{}",body.toString());
//        }
//    }
}
}
