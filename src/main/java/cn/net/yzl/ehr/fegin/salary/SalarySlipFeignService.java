package cn.net.yzl.ehr.fegin.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.salary.SalarySlipListDto;
import cn.net.yzl.staff.vo.salary.SalaryImportVo;
import cn.net.yzl.staff.vo.salary.SalaryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 工资条服务接口
 *
 * @author biebaojie
 * @since 2021-03-11 10:02:46
 */
@FeignClient(value = "SalaryService",url = "${fegin.db.url}/salarySlip")
//@FeignClient(value = "SalaryService", url = "localhost:38080/salarySlip")
public interface SalarySlipFeignService {

    /**
     * 工资发放列表(人资)-导入数据
     *
     * @param salaryImportVo 请求参数
     * @return
     */
    @PostMapping("/importFunctionSalary")
    ComResponse<Boolean> importSalary(@RequestBody SalaryImportVo salaryImportVo);

    /**
     * 查询工资条列表
     *
     * @param salaryVo 请求参数
     * @return 工资列表
     */
    @PostMapping("/list")
    ComResponse<Page<SalarySlipListDto>> list(@RequestBody SalaryVo salaryVo);

    /**
     * 工资导出
     *
     * @param salaryVo 请求参数
     * @return 工资报表
     */
    @PostMapping("/exportSalary")
    ComResponse<byte[]> exportSalary(@RequestBody SalaryVo salaryVo);
}
