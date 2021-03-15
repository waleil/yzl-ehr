package cn.net.yzl.ehr.controller.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.salary.SalarySlipFeignService;
import cn.net.yzl.staff.dto.salary.SalarySlipListDto;
import cn.net.yzl.staff.enumeration.StaffTypeEnum;
import cn.net.yzl.staff.vo.salary.SalaryImportVo;
import cn.net.yzl.staff.vo.salary.SalaryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工资条控制层
 *
 * @author biebaojie
 * @since 2021-03-11 10:02:49
 */
@RestController
@RequestMapping("/salarySlip")
@Api(value = "薪资-最新版", tags = {"薪资-最新版"})
public class SalarySlipController {
    /**
     * 服务对象
     */
    @Autowired
    private SalarySlipFeignService salarySlipFeignService;


    @ApiOperation(value = "职能管理-工资发放列表(人资)-导入数据", notes = "职能管理-工资发放列表(人资)-导入数据")
    @PostMapping("/importFunctionSalary")
    public ComResponse<Boolean> importFunctionSalary(@RequestBody SalaryImportVo salaryImportVo) {
        salaryImportVo.setStaffType(StaffTypeEnum.NOT_FRONT_LINE_STAFF.getCode());
        return salarySlipFeignService.importSalary(salaryImportVo);
    }

    @ApiOperation(value = "一线管理-工资发放列表(人资)-导入数据", notes = "一线管理-工资发放列表(人资)-导入数据")
    @PostMapping("/importLineSalary")
    public ComResponse<Boolean> importLineSalary(@RequestBody SalaryImportVo salaryImportVo) {
        salaryImportVo.setStaffType(StaffTypeEnum.FRONT_LINE_STAFF.getCode());
        return salarySlipFeignService.importSalary(salaryImportVo);
    }

    @ApiOperation(value = "工资发放列表(人资)", notes = "工资发放列表(人资)")
    @PostMapping("/list")
    public ComResponse<Page<SalarySlipListDto>> list(@RequestBody SalaryVo salaryVo) {
        return salarySlipFeignService.list(salaryVo);
    }
}
