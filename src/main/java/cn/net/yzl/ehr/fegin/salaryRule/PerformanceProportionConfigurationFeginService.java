package cn.net.yzl.ehr.fegin.salaryRule;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.salaryRule.PerformanceProportionConfigurationListDto;
import cn.net.yzl.staff.pojo.salaryRule.PerformanceProportionConfigurationPo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationDelVo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationListVo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationSaveVo;
import cn.net.yzl.staff.vo.salaryRule.PerformanceProportionConfigurationUpdateVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Author
 * @Date 2021/2/4
 * @Description
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/performanceProportionConfiguration")
//@FeignClient(value = "yzl-staff-db",url = "http://localhost:38080/performanceProportionConfiguration")
public interface PerformanceProportionConfigurationFeginService {

    //列表
    @PostMapping("/list")
    ComResponse<Page<PerformanceProportionConfigurationListDto>> getPerformanceProportionList(PerformanceProportionConfigurationListVo request);

    //新建
    @PostMapping("/save")
    ComResponse<Boolean> save(PerformanceProportionConfigurationSaveVo request);

    //编辑
    @PostMapping("/update")
    ComResponse<Boolean> update(PerformanceProportionConfigurationUpdateVo request);

    //删除
    @PostMapping("/del")
    ComResponse<Boolean> del(PerformanceProportionConfigurationDelVo request);

    // 详情
    @GetMapping("/show")
    ComResponse<PerformanceProportionConfigurationPo> show(@RequestParam("departId") Integer departId);
}
