package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.ding.DingTalkDepartFeginService;
import cn.net.yzl.ehr.service.DingTalkDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DingTalkDepartServiceImpl implements DingTalkDepartService {

    @Autowired
    private DingTalkDepartFeginService dingTalkDepartFeginService;


    @Override
    public ComResponse<Boolean> dingDepartToEhr(String departId) {

        return dingTalkDepartFeginService.dingDepartToEhr(departId);
    }
}
