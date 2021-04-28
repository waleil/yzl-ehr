package cn.net.yzl.ehr.service.impl.appClockRangeConf;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.fegin.appClockRangeConf.AppClockRangeConfFeginService;
import cn.net.yzl.ehr.service.appClockRangeConf.AppClockRangeConfService;
import cn.net.yzl.staff.pojo.AppClockRangeConfPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AppClockRangeConfServiceImpl implements AppClockRangeConfService {
    @Autowired
    private AppClockRangeConfFeginService appClockRangeConfFeginService;


    @Override
    public ComResponse<Integer> saveUpDateAddress(AppClockRangeConfPo appClockRangeConfPo,String staffNo) {
        appClockRangeConfPo.setCreator(staffNo);
        log.info("保存考勤范围配置", JsonUtil.toJsonStr(appClockRangeConfPo));
        ComResponse<Integer> result = appClockRangeConfFeginService.saveUpDateAddress(appClockRangeConfPo);
        return result;
    }

    @Override
    public ComResponse<AppClockRangeConfPo> queryByDepartId(Integer departId) {
        ComResponse<AppClockRangeConfPo> result = appClockRangeConfFeginService.queryByDepartId(departId);
        return result;
    }

}
