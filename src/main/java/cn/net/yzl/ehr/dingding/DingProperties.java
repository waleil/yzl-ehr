package cn.net.yzl.ehr.dingding;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * +  钉钉 api 配置
 */
@Data
@ConfigurationProperties(prefix = "ding")
@Component
public class DingProperties {
    // 获取tokenurl
    public String get_token_url = "https://oapi.dingtalk.com/gettoken";

    // 用户 list
    private String user_list_v2_url = "https://oapi.dingtalk.com/topapi/v2/user/list";

    // 获取用户信息
    public String user_get_url = "https://oapi.dingtalk.com/topapi/inactive/user/get";
    // 获取用户信息 v2
    public String user_get_v2_url = "https://oapi.dingtalk.com/topapi/inactive/user/v2/get";

    private String user_create = "https://oapi.dingtalk.com/user/create";

    private String user_update = "https://oapi.dingtalk.com/user/update";

    private String user_delete = "https://oapi.dingtalk.com/user/delete";

    private String user_batch_delete = "https://oapi.dingtalk.com/user/batchdelete";

    private String user_simple_list = "https://oapi.dingtalk.com/user/simplelist";



    // 部门  list
    public String department_list_url = "https://oapi.dingtalk.com/department/list";
    // 部门 详情
    public String department_get_url = "https://oapi.dingtalk.com/department/get";
    // 查询根部门下的子部门ID列表
    public String department_list_ids_url="https://oapi.dingtalk.com/department/list_ids";


    private String department_create = "https://oapi.dingtalk.com/department/create";

    private String department_update = "https://oapi.dingtalk.com/department/update";

    private String department_delete = "https://oapi.dingtalk.com/department/delete";

    private String getUserInfoUrl = "https://oapi.dingtalk.com/user/getuserinfo";


    // 事件回调的接口

    public String event_fallback_url="https://oapi.dingtalk.com/call_back/register_call_back";

    // 企业id
    public String corpId = "ding5959226e86d9c70335c2f4657eb6378f";
    // app key
    public String appKey = "dingcdl4qyn52qzdojoy";
    // app secret
    public String appSecret = "cRWadUYub-Rxx9u8JT4-3q8Q3IdBCgGJ9J9RWQX0gOba6z46zNZhZR2j_6mNQ5wE";


    // 存储 钉钉 access_token 的key
    public String  dingAccessTokenKey="dingAccessToken";

}
