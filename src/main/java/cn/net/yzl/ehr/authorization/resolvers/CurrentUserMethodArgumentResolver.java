package cn.net.yzl.ehr.authorization.resolvers;

import cn.hutool.core.util.StrUtil;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.authorization.annotation.CurrentUser;
import cn.net.yzl.ehr.dto.StaffDto;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


/**
 * 增加方法注入，将含有CurrentUser注解的方法参数注入当前登录用户
 *
 */
@Service
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是AdminDto并且有CurrentUser注解则支持
        if (parameter.getParameterType().isAssignableFrom(StaffDto.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }if(parameter.hasParameterAnnotation(CurrentStaffNo.class)){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //取出鉴权时存入的登录用户
    	String staffNo = (String) webRequest.getAttribute("CURRENT_USER_NO", RequestAttributes.SCOPE_REQUEST);

        if (StrUtil.isNotBlank(staffNo)) {
            //从数据库中查询并返回
            return staffNo;
        }
        throw new MissingServletRequestPartException("");
    }
}
