package cn.net.yzl.ehr.dingding;

import cn.hutool.core.util.StrUtil;
import cn.net.yzl.ehr.config.redis.RedisUtil;
import cn.net.yzl.ehr.runner.MyStartupRunner;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 钉钉  获取默认的 token
 */

@Component
public class DefaultDingtalkToken implements DingtalkToken {
    private static Logger log = LoggerFactory.getLogger(DefaultDingtalkToken.class);


    @Autowired
    private DingProperties dingProperties;

    @Autowired
    private RedisUtil redisUtil;

    private int timout = 7200;//单位秒：2小时

    @Override
    public String getToken() throws ApiException {
        String token = (String) redisUtil.get(dingProperties.dingAccessTokenKey);
        if (!StrUtil.isBlank(token)) {
            return token;
        }
        Assert.isTrue(StringUtils.hasLength(dingProperties.appKey), "未配置dingtalk.appKey");
        Assert.isTrue(StringUtils.hasLength(dingProperties.appSecret), "未配置dingtalk.appSecret");
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.get_token_url);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(dingProperties.appKey);
        request.setAppsecret(dingProperties.appSecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        if (response.isSuccess()) {
            redisUtil.set(dingProperties.dingAccessTokenKey, response.getAccessToken(), timout);
            return response.getAccessToken();
        } else {
            log.info("获取AccessToken失败，响应的错误信息：{},请求的信息[url]={},[corpid]={},[corpsecret]={}", response.getErrmsg(), dingProperties.get_token_url, dingProperties.appKey, dingProperties.appSecret);
            throw new RuntimeException(response.getErrmsg());
        }
    }

    @Override
    public void renewal() throws ApiException {
        getToken();
    }


}
