package cn.net.yzl.ehr.dingding;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.util.UUIDGenerator;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Collections;

/**
 * 钉钉的 事件管理
 */
@Component
public class DingEventManagement {
    private static Logger log = LoggerFactory.getLogger(DingEventManagement.class);
    @Autowired
    private DingProperties dingProperties;
    @Autowired
    private DefaultDingtalkToken defaultDingtalkToken;

    // 注册业务事件回调接口
    public void registerEventCallback(){
        try {
            DingTalkClient client = new DefaultDingTalkClient(dingProperties.event_register_callback_url);
            OapiCallBackRegisterCallBackRequest req = new OapiCallBackRegisterCallBackRequest();
            req.setCallBackTag(dingProperties.callBackTagList);
//            req.setToken(UUIDGenerator.getUUID());

//            String aesKey = RandomUtil.randomString(43);
            req.setToken(dingProperties.eventCallBackToken);
            req.setAesKey(dingProperties.eventCallBackAesKey);
            req.setUrl(dingProperties.event_callback_url);
            OapiCallBackRegisterCallBackResponse response = client.execute(req, defaultDingtalkToken.getToken());
            if (response.isSuccess()) {
                log.info("注册业务时间回调接口 success!");
            } else {
                log.info("注册业务时间回调接口 fail! info {}",response.getErrmsg());
                throw new RuntimeException(response.getErrmsg());
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    // 查询事件回调接口
    public OapiCallBackGetCallBackResponse getEventCallBack() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.event_get_callback_url);
        OapiCallBackGetCallBackRequest req = new OapiCallBackGetCallBackRequest();
        req.setHttpMethod("GET");
        OapiCallBackGetCallBackResponse response = client.execute(req, defaultDingtalkToken.getToken());
        if (response.isSuccess()) {
            return response;
        } else {
            log.info("获取事件回调接口失败，响应的错误信息：{}!", response.getErrmsg());
            throw new RuntimeException(response.getErrmsg());
        }
    }

    // 更新事件回调接口
    public OapiCallBackUpdateCallBackResponse updateEventCallBack() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.event_update_callack_url);
        OapiCallBackUpdateCallBackRequest req = new OapiCallBackUpdateCallBackRequest();
        req.setCallBackTag(dingProperties.callBackTagList);
        req.setAesKey(dingProperties.eventCallBackAesKey);
        req.setToken(dingProperties.eventCallBackToken);
        req.setUrl(dingProperties.event_callback_url);
        OapiCallBackUpdateCallBackResponse response = client.execute(req, defaultDingtalkToken.getToken());
        if (response.isSuccess()) {
            return response;
        } else {
            log.info("获取事件回调接口失败，响应的错误信息：{}!", response.getErrmsg());
            throw new RuntimeException(response.getErrmsg());
        }
    }

    //获取回调失败结果
    public OapiCallBackGetCallBackFailedResultResponse getFailEventCallBack() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.event_get_fail_callack_url);
        OapiCallBackGetCallBackFailedResultRequest req = new OapiCallBackGetCallBackFailedResultRequest();
        req.setHttpMethod("GET");
        OapiCallBackGetCallBackFailedResultResponse response = client.execute(req, "");
        if (response.isSuccess()) {
            return response;
        } else {
            log.info("获取事件回调接口失败，响应的错误信息：{}!", response.getErrmsg());
            throw new RuntimeException(response.getErrmsg());
        }
    }


    public static void main(String[] args) {
        System.err.println(RandomUtil.randomString(43));
        System.err.println(UUIDGenerator.getUUID());
    }

}
