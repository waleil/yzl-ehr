package cn.net.yzl.ehr.service.encrypt;

import cn.net.yzl.common.entity.ComResponse;

public interface EncryptService {
    //数据加密
    ComResponse<Integer> encryptExecute();

}
