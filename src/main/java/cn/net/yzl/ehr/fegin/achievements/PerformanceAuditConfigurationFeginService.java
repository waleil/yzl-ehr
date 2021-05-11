package cn.net.yzl.ehr.fegin.achievements;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.achievements.PerformanceAuditConfigurationDto;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationDetailVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationSaveVo;
import cn.net.yzl.staff.vo.achievements.PerformanceAuditConfigurationUpdateVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/performanceAuditConfiguration")
public interface PerformanceAuditConfigurationFeginService {

    @PostMapping("/getByDepartId")
    ComResponse<PerformanceAuditConfigurationDto> getById(PerformanceAuditConfigurationDetailVo request);

    @PostMapping("/save")
    ComResponse<Boolean> save(PerformanceAuditConfigurationSaveVo request);

    @PostMapping("/update")
    ComResponse<Boolean> update(PerformanceAuditConfigurationUpdateVo request);

}
