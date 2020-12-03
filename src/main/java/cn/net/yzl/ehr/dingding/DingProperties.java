package cn.net.yzl.ehr.dingding;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public String user_get_url = "https://oapi.dingtalk.com/user/get";
    // 获取用户信息 v2
    public String user_get_v2_url = "https://oapi.dingtalk.com/topapi/inactive/user/v2/get";
    // 获取部门下的用户id list
    public  String depart_user_list_ids_url="https://oapi.dingtalk.com/topapi/user/listid";

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
    public String department_list_ids_url = "https://oapi.dingtalk.com/department/list_ids";


    private String department_create = "https://oapi.dingtalk.com/department/create";

    private String department_update = "https://oapi.dingtalk.com/department/update";

    private String department_delete = "https://oapi.dingtalk.com/department/delete";

    private String getUserInfoUrl = "https://oapi.dingtalk.com/user/getuserinfo";


    // 事件回调的注册接口
    public String event_register_callback_url = "https://oapi.dingtalk.com/call_back/register_call_back";
    //事件回调接口
    public String event_callback_url = "http://xxxx.xxxx.xxx/staff/dingCallback";

    // 查询回调接口事件信息
    public String event_get_callback_url = "https://oapi.dingtalk.com/call_back/get_call_back";
    // 更新回调接口事件
    public String event_update_callack_url = "https://oapi.dingtalk.com/call_back/update_call_back";
    // 删除回调接口事件
    public String event_del_callack_url = "https://oapi.dingtalk.com/call_back/delete_call_back";
    //  获取回调失败结果
    public String event_get_fail_callack_url = "https://oapi.dingtalk.com/call_back/get_call_back_failed_result";

    // 钉钉 call_back_tag
    public List<String> callBackTagList;

    // 企业id
    public String corpId = "ding5959226e86d9c70335c2f4657eb6378f";
    // app key
    public String appKey = "dingcdl4qyn52qzdojoy";
    // app secret
    public String appSecret = "cRWadUYub-Rxx9u8JT4-3q8Q3IdBCgGJ9J9RWQX0gOba6z46zNZhZR2j_6mNQ5wE";

    // 钉钉 事件callback 注册 aeskey
    public String eventCallBackAesKey = "r4nkgxvvueoccr33yzj5x8v1jvzyxybyodtbmzp34u5";
    // 钉钉 事件callback 注册 token
    public String eventCallBackToken = "d7ca88e525994edbac815bc60f2508fd";

    // 存储 钉钉 access_token 的key
    public String dingAccessTokenKey = "dingAccessToken";

}
