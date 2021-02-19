package cn.net.yzl.ehr.service.achievements;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.achievements.PerformanceAuditConfigurationDto;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationDetailVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationSaveVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationUpdateVo;


public interface PerformanceAuditConfigurationService {

    ComResponse<PerformanceAuditConfigurationDto> getById(PerformanceAuditConfigurationDetailVo request);

    ComResponse<Boolean> save(PerformanceAuditConfigurationSaveVo request);

    ComResponse<Boolean> update(PerformanceAuditConfigurationUpdateVo request);

}
