package cn.net.yzl.ehr.fegin.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.salary.SalaryDto;
import cn.net.yzl.staff.vo.salary.SalaryFinanceVo;
import cn.net.yzl.staff.vo.salary.SalaryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author
 * @Date 2021/2/19
 * @Description
 */
@FeignClient(value = "SalaryService",url = "${fegin.db.url}/salary")
//@FeignClient(value = "SalaryService",url = "localhost:38080/salary")
public interface SalaryService {

    @PostMapping("/list")
    ComResponse<Page<SalaryDto>> list(@RequestBody SalaryVo salaryVo);

    //导入数据
    @RequestMapping(value = "/importSalary", method = RequestMethod.GET)
    ComResponse<Boolean> importSalary(@RequestParam("url") String url);

    //导出数据

    //提交财务
    @PostMapping("/postToFinance")
    ComResponse<Void>  postToFinance(@RequestBody List<SalaryFinanceVo> list);

}
