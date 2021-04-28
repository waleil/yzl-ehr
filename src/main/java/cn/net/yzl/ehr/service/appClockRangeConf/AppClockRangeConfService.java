package cn.net.yzl.ehr.service.appClockRangeConf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.pojo.AppClockRangeConfPo;

public interface AppClockRangeConfService {

    ComResponse<Integer> saveUpDateAddress (AppClockRangeConfPo appClockRangeConfPo, String staffNo);

    ComResponse<AppClockRangeConfPo> queryByDepartId (Integer departId);

}
