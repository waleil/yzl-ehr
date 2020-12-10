package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.UnAuthorization;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
@Api(value = "基本接口", tags = {"基本接口"})
public class LoginController {

    @Autowired
    private LoginService loginService;



    @ApiOperation(value = "登录", notes = "登录", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo", value = "用户工号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "enName", value = "英文名", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "电子邮件", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @UnAuthorization
    ComResponse<StaffBaseDto> login(String userNo, String enName, String email, String phone,String password){
        return loginService.login(userNo,enName,email,phone,password);
    }



}
