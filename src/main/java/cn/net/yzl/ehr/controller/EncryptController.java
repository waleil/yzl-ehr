package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.service.encrypt.EncryptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/encrypt")
@Api(value = "EHR-数据加密",tags = {"EHR-数据加密"})
@Slf4j
public class EncryptController {

    @Autowired
    private EncryptService encryptService;

    @ApiOperation(value = "数据加密",notes = "数据加密",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    ComResponse<Integer> encryptExecute (HttpServletRequest request){
        String userNo = request.getHeader("userNo");
        log.info("执行EHR-数据加密userNo:{}",userNo);
        return encryptService.encryptExecute();
    }

}
