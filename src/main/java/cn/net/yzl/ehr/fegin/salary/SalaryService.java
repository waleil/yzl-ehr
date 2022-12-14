package cn.net.yzl.ehr.fegin.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.salary.MySalaryDto;
import cn.net.yzl.staff.dto.salary.SalaryDto;
import cn.net.yzl.staff.vo.salary.MySalaryVo;
import cn.net.yzl.staff.vo.salary.SalaryFinanceCheckVo;
import cn.net.yzl.staff.vo.salary.SalaryFinanceGrantVo;
import cn.net.yzl.staff.vo.salary.SalaryFinanceVo;
import cn.net.yzl.staff.vo.salary.SalaryImportVo;
import cn.net.yzl.staff.vo.salary.SalaryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 工资条
 */
@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/salary")
public interface SalaryService {

    @PostMapping("/list")
    ComResponse<Page<SalaryDto>> list(@RequestBody SalaryVo salaryVo);

    //导入数据
    @PostMapping(value = "/importSalary")
    ComResponse<Boolean> importSalary(@RequestBody SalaryImportVo salaryImportVo);

    //提交财务
    @PostMapping("/postToFinance")
    ComResponse<Void> postToFinance(@RequestBody List<SalaryFinanceVo> list);

    //财务通过/驳回
    @PostMapping("financePassOrReject")
    ComResponse<Void> financePassOrReject(@RequestBody List<SalaryFinanceCheckVo> list);

    //财务发放
    @PostMapping("financeGrantMoney")
    ComResponse<Void> financeGrantMoney(@RequestBody List<SalaryFinanceGrantVo> list);

    //我得工资
    @RequestMapping(value = "/getMySalary", method = RequestMethod.GET)
    ComResponse<MySalaryDto> getMySalary(MySalaryVo request);
}
