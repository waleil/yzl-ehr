package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;

public interface DingTalkDepartService {
    ComResponse<Boolean> dingDepartToEhr(String departId);
}
