package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dingding.RobotHelperUtil;
import cn.net.yzl.ehr.dingding.service.DingTalkDepartmentService;
import cn.net.yzl.ehr.dingding.service.DingTalkUserService;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.github.pagehelper.PageInfo;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/ding")
@Api(value="钉钉测试",tags={"钉钉测试"})
public class DingController {

    @Autowired
    private DingTalkDepartmentService dingTalkDepartmentService;
    @Autowired
    private DingTalkUserService dingTalkUserService;




    @ApiOperation(value="钉钉获取部门信息", notes="钉钉获取部门信息",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partentid", value = "父id(根是1)", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/getDingDepartList", method = RequestMethod.GET)
    public OapiDepartmentListResponse getDingDepartList(String partentid){
        try {
            return dingTalkDepartmentService.getDepartmentList(partentid,false);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value="钉钉获取用户信息", notes="钉钉获取用户信息",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/getDingUser", method = RequestMethod.GET)
    public OapiUserGetResponse getDingUser(String userId){

        try {
            return dingTalkUserService.getUser(userId);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return  null;
    }



    @ApiOperation(value="机器人发送消息", notes="机器人发送消息",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "secret", value = "秘钥", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "webhookUrl", value = "webhook", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/robotSend", method = RequestMethod.GET)
    public String robotSend(String secret,String webhookUrl){
        try {
            RobotHelperUtil.sdkDemoJava(secret,webhookUrl);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "success";
    }


    @ApiOperation(value="钉钉部门数据初始化(钉钉数据同步到ehr)", notes="钉钉部门数据初始化(钉钉数据同步到ehr)",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequestMapping(value = "/departInit", method = RequestMethod.GET)
    public ComResponse<Boolean> departInit() throws ApiException {
        return dingTalkDepartmentService.init(1+"");
    }
    @ApiOperation(value="钉钉员工数据数据初始化(钉钉数据同步到ehr)", notes="钉钉部门数据初始化(钉钉数据同步到ehr)",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequestMapping(value = "/staffInit", method = RequestMethod.GET)
    public ComResponse<Boolean> staffInit() throws ApiException {
        return dingTalkUserService.init("1");
    }

}
