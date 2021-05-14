package cn.net.yzl.ehr.exception;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 全局异常类处理
 */


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 方法参数校验异常 Validate
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Object handleValidationException(HttpServletRequest request, ConstraintViolationException ex) {
        logger.error("异常:" + request.getRequestURI(), ex);
        String collect = ex.getConstraintViolations().stream().filter(Objects::nonNull)
                .map(cv -> cv == null ? "null" : cv.getPropertyPath() + ": " + cv.getMessage())
                .collect(Collectors.joining(", "));
        logger.info("请求参数异常", collect);
        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), collect);
    }

    /**
     * Bean 校验异常 Validate
     *
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class) //400
    @ResponseBody
    public Object methodArgumentValidationHandler(HttpServletRequest request, MethodArgumentNotValidException exception)  {

        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage()).append(", ");
        }
        logger.info("接口路径:{},请求参数:{},报错信息:{}", request.getRequestURI(),
                showParams(request),
                JsonUtil.toJsonStr(bindingResult.getFieldErrors()));
        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), sb.toString());
    }

    /**
     * 绑定异常
     *
     * @param request
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Object bindException(HttpServletRequest request, BindException exception) {
        logger.error("异常:" + request.getRequestURI(), exception);
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(", ");
        }

        return ComResponse.fail(ResponseCodeEnums.PARAMS_ERROR_CODE.getCode(), sb.toString());
    }


    /**
     * 访问接口参数不全
     *
     * @param request
     * @param pe
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Object missingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException pe) {
        logger.error("异常:" + request.getRequestURI(), pe);
//        RestResultWrapper<String> restResultWrapper = new RestResultWrapper();
//        restResultWrapper.setCode(HttpStatus.BAD_REQUEST.value());
//        restResultWrapper.setMessage("该请求路径："+request.getRequestURI()+"下的请求参数不全："+pe.getMessage());
        return ComResponse.fail(ResponseCodeEnums.LOGIN_ERROR_CODE.getCode(), "该请求路径："+request.getRequestURI()+"下的请求参数不全："+pe.getMessage());
    }

    /**
     * HttpRequestMethodNotSupportedException
     *
     * @param request
     * @param pe
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Object httpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException pe) {
        logger.error("异常:" + request.getRequestURI(), pe);
//        RestResultWrapper<String> restResultWrapper = new RestResultWrapper();
//        restResultWrapper.setCode(HttpStatus.BAD_REQUEST.value());
//        restResultWrapper.setMessage("请求方式不正确");
        return ComResponse.fail(HttpStatus.BAD_REQUEST.value(), "请求方式不正确");
    }


    /**
     * 异常详情
     *
     * @param e
     * @return
     */
    private String getExceptionDetail(Exception e) {
        StringBuilder stringBuffer = new StringBuilder(e.toString() + "\n");
        StackTraceElement[] messages = e.getStackTrace();
        Arrays.stream(messages).filter(Objects::nonNull).forEach(stackTraceElement -> {
            stringBuffer.append(stackTraceElement.toString() + "\n");
        });
        return stringBuffer.toString();
    }

    /**
     * 请求参数
     *
     * @param request
     * @return
     */
    public String showParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        StringBuilder stringBuilder = new StringBuilder();
        Enumeration paramNames = request.getParameterNames();
        if (Objects.nonNull(paramNames)) {
            stringBuilder.append("----------------参数开始-------------------");
            stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues.length > 0) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() != 0) {
                        stringBuilder.append("参数名:").append(paramName).append("参数值:").append(paramValue);
                    }
                }
            }
            stringBuilder.append("----------------参数结束-------------------");
        }
        return stringBuilder.toString();
    }


//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Object exceptionHandler(Exception e) {
//        logger.error("发生业务异常,原因是:{}" + e.getMessage());
//        return ComResponse.fail(ResponseCodeEnums.SERVICE_ERROR_CODE.getCode(), ResponseCodeEnums.SERVICE_ERROR_CODE.getMessage());
//    }
}