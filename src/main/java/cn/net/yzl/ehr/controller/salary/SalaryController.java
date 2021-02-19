package cn.net.yzl.ehr.controller.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salary.SalaryService;
import cn.net.yzl.staff.dto.salary.MySalaryDto;
import cn.net.yzl.staff.dto.salary.SalaryDto;
import cn.net.yzl.staff.vo.salary.MySalaryVo;
import cn.net.yzl.staff.vo.salary.SalaryFinanceVo;
import cn.net.yzl.staff.vo.salary.SalaryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Author
 * @Date 2021/2/19
 * @Description
 */
@RestController
@RequestMapping("/salary")
@Api(value = "薪资", tags = {"薪资"})
public class SalaryController {
    @Autowired
    private SalaryService salaryService;



    @ApiOperation(value = "一线工资发放列表(人资)", notes = "一线工资发放列表(人资)")
    @PostMapping("/list")
    ComResponse<Page<SalaryDto>> list(@RequestBody SalaryVo salaryVo) {
        return salaryService.list(salaryVo);
    }

    //导入数据
    @ApiOperation(value = "一线工资发放列表(人资)-导入数据", notes = "一线工资发放列表(人资)-导入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "文件全路径", required = true, dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/importSalary", method = RequestMethod.GET)
    ComResponse<Boolean> importSalary(@RequestParam("url") String url) {
        return salaryService.importSalary(url);
    }

    //导出数据

    //提交财务
    @ApiOperation(value = "一线工资发放列表(人资)-提交财务", notes = "一线工资发放列表(人资)-提交财务")
    @PostMapping("/postToFinance")
    ComResponse<Void>  postToFinance(@RequestBody List<SalaryFinanceVo> list) {
        salaryService.postToFinance(list);
        return ComResponse.success();
    }

    //我得工资
    @ApiOperation(value = "我得工资-一线职能共用", notes = "我得工资-一线职能共用")
    @PostMapping("/getMySalary")
    ComResponse<MySalaryDto> getMySalary(@ApiIgnore @CurrentStaffNo String staffNo,@RequestBody MySalaryVo request) {
        request.setStaffNo(staffNo);
        return salaryService.getMySalary(request);
    }

}
