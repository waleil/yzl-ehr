package cn.net.yzl.ehr.service.quickLaunch;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.quickLaunch.QuickLaunchDto;

import java.util.List;

public interface QuickLaunchService {
    /**
     * 根据员工展示前8个常用流程
     * @param staffNo
     * @return
     */
    ComResponse<List<QuickLaunchDto>> queryByNo(String staffNo);
}
