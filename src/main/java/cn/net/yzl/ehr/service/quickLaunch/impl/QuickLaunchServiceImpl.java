package cn.net.yzl.ehr.service.quickLaunch.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.quickLaunch.QuickLaunchFeginService;
import cn.net.yzl.ehr.service.quickLaunch.QuickLaunchService;
import cn.net.yzl.staff.dto.quickLaunch.QuickLaunchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuickLaunchServiceImpl implements QuickLaunchService {
    @Autowired
    private QuickLaunchFeginService quickLaunchFeginService;

    @Override
    public ComResponse<List<QuickLaunchDto>> queryByNo(String staffNo) {
        ComResponse<List<QuickLaunchDto>> list = quickLaunchFeginService.queryByNo(staffNo);
        return list;
    }
}
