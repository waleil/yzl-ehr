package cn.net.yzl.ehr.authorization.Interceptor;

import cn.hutool.json.JSONUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.UUIDGenerator;
import cn.net.yzl.ehr.authorization.annotation.UnAuthorization;
import cn.net.yzl.ehr.authorization.service.TokenManager;
import cn.net.yzl.ehr.dto.StaffDto;
import cn.net.yzl.ehr.permission.ReqPermissions;
import cn.net.yzl.logger.common.XBasicUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * 自定义拦截器
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(AuthorizationInterceptor.class);
    @Autowired
    private TokenManager manager;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        log.info("----------c映射----------" + (handler instanceof HandlerMethod) + "----------------------");


        String traceId = request.getHeader("traceId");
        String spanId = XBasicUtil.uuid();
        request.setAttribute("span",spanId);

        String gateway = request.getHeader("gateway");
        // gateway 已经验证过
        if("true".equals(gateway)){
            // 员工工号
            String staffNo = request.getHeader("userNo");
            request.setAttribute("CURRENT_USER_NO", staffNo);

            log.info("{traceId:{},spanId:{},userNo:{}}",traceId,spanId,staffNo);



            return true;
        }else {
            response.setStatus(200);
            ComResponse<String> rep = ComResponse.fail(ResponseCodeEnums.TOKEN_INVALID_ERROR_CODE.getCode(), ResponseCodeEnums.TOKEN_INVALID_ERROR_CODE.getMessage());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().append(JSONUtil.toJsonStr(rep));
            return false;
        }

//        String token = request.getHeader("token");

//        String methods = request.getMethod();
//        // 预请求处理
//        if (HttpMethod.OPTIONS.toString().equals(methods)) {
//            return true;
//        }
//        //
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        String packageName = handlerMethod.getBeanType().getPackage().getName();
//
//        if (!packageName.startsWith("cn.net.yzl")) {
//            return true;
//        }
//
//        // 从header中得到token
//        String authorization = request.getHeader("authorization");
//        // 验证token
//        StaffDto admin = manager.get(authorization);
//        Method method = handlerMethod.getMethod();
//        String name = method.getName();
//        log.info("方法名----------" + name);
//        if ("error".equals(name)) {
//            return true;
//        }
//        // 如果方法注明了UnAuthorization，不需要认证
//        if (method.getAnnotation(UnAuthorization.class) != null) {
//            return true;
//        } else {
//            if (StringUtils.isBlank(authorization) || admin == null) {
//                response.setStatus(200);
//                ComResponse<String> rep = ComResponse.fail(ResponseCodeEnums.TOKEN_INVALID_ERROR_CODE.getCode(), ResponseCodeEnums.TOKEN_INVALID_ERROR_CODE.getMessage());
//                response.setContentType("application/json;charset=UTF-8");
//                response.getWriter().append(JSONUtil.toJsonStr(rep));
//                return false;
//            }
//            if (manager.check(authorization)) {
//
//                if (method.getAnnotation(ReqPermissions.class) != null) {
//                    ReqPermissions annotation = method.getAnnotation(ReqPermissions.class);
//                    // 方法上的权限
//                    List<String> value = Arrays.asList(annotation.value());
//                    // 具有的权限
//                    List<String> permsList = admin.getPermsList();
//                    // 交集
//                    if (!value.retainAll(permsList)) {
//                        response.setStatus(200);
//                        ComResponse<String> rep = ComResponse.fail(ResponseCodeEnums.AUTHOR_ERROR_CODE.getCode(), ResponseCodeEnums.AUTHOR_ERROR_CODE.getMessage());
//                        response.setContentType("application/json;charset=UTF-8");
//                        response.getWriter().append(JSONUtil.toJsonStr(rep));
//                        return false;
//                    }
//                }
//                // 如果token验证成功，将用户存在request中，便于之后注入
//                request.setAttribute("CURRENT_USER", admin);
//                response.setHeader("authorization", authorization);
//                return true;
//            } else {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                return false;
//            }
//        }

    }

}
