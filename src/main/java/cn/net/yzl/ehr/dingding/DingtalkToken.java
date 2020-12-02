package cn.net.yzl.ehr.dingding;


import com.taobao.api.ApiException;

public interface DingtalkToken {
    /**
     * 获取access_token
     * @return
     */
    String getToken() throws ApiException;

    /**
     * 续期accesss_token
     */
    void renewal() throws ApiException;

}
