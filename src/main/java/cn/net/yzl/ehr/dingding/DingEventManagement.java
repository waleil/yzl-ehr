package cn.net.yzl.ehr.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 钉钉的 事件管理
 */
@Component
public class DingEventManagement {

    @Autowired
    private DingProperties dingProperties;

    // 注册业务事件回调接口
    public void registerEventFallback(){
//        try {
//            DingTalkClient client = new DefaultDingTalkClient();
//            OapiCallBackRegisterCallBackRequest req = new OapiCallBackRegisterCallBackRequest();
//            req.setCallBackTag("sss");
//            req.setToken("sss");
//            req.setAesKey("ss");
//            req.setUrl("sss");
//            OapiCallBackRegisterCallBackResponse rsp = client.execute(req, "ce9d418707f53962ac0602d0dee73b42");
//            System.out.println(rsp.getBody());
//        } catch (ApiException e) {
//            e.printStackTrace();
//        }
    }
}
