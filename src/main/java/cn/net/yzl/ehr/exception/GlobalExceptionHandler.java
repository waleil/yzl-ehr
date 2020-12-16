package cn.net.yzl.ehr.exception;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 *
 *  全局异常类处理
 */


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);






    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        logger.error("发生业务异常,原因是:{}"+e.getMessage());
        return ComResponse.fail(ResponseCodeEnums.SERVICE_ERROR_CODE.getCode(),ResponseCodeEnums.SERVICE_ERROR_CODE.getMessage());
    }
}