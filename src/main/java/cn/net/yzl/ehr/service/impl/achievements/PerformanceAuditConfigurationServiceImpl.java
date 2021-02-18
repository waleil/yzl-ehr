package cn.net.yzl.ehr.service.impl.achievements;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.achievements.PerformanceAuditConfigurationFeginService;
import cn.net.yzl.ehr.service.achievements.PerformanceAuditConfigurationService;
import cn.net.yzl.staff.dto.achievements.PerformanceAuditConfigurationDto;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationDetailVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationSaveVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationUpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PerformanceAuditConfigurationServiceImpl implements PerformanceAuditConfigurationService {

    @Autowired
    private PerformanceAuditConfigurationFeginService performanceAuditConfigurationFeginService;

    @Override
    public ComResponse<PerformanceAuditConfigurationDto> getById(PerformanceAuditConfigurationDetailVo request) {
        return performanceAuditConfigurationFeginService.getById(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ComResponse<Boolean> save(PerformanceAuditConfigurationSaveVo request) {
        return performanceAuditConfigurationFeginService.save(request);
    }

    @Override
    public ComResponse<Boolean> update(PerformanceAuditConfigurationUpdateVo request) {
        return performanceAuditConfigurationFeginService.update(request);
    }


}
