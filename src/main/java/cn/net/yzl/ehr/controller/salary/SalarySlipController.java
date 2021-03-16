package cn.net.yzl.ehr.controller.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salary.SalarySlipFeignService;
import cn.net.yzl.staff.dto.salary.SalarySlipListDto;
import cn.net.yzl.staff.enumeration.StaffTypeEnum;
import cn.net.yzl.staff.vo.salary.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(SalarySlipController.class);
    /**
     * 服务对象
     */
    @Autowired
    private SalarySlipFeignService salarySlipFeignService;


    @ApiOperation(value = "职能管理-工资发放列表-工资导入", notes = "职能管理-工资发放列表-工资导入")
    @PostMapping("/importFunctionSalary")
    public ComResponse<Boolean> importFunctionSalary(@RequestBody SalaryImportVo salaryImportVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryImportVo.setStaffType(StaffTypeEnum.NOT_FRONT_LINE_STAFF.getCode());
        salaryImportVo.setStaffNo(staffNo);
        return salarySlipFeignService.importSalary(salaryImportVo);
    }

    @ApiOperation(value = "一线管理-工资发放列表-工资导入", notes = "一线管理-工资发放列表-工资导入")
    @PostMapping("/importLineSalary")
    public ComResponse<Boolean> importLineSalary(@RequestBody SalaryImportVo salaryImportVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryImportVo.setStaffType(StaffTypeEnum.FRONT_LINE_STAFF.getCode());
        salaryImportVo.setStaffNo(staffNo);
        return salarySlipFeignService.importSalary(salaryImportVo);
    }

    @ApiOperation(value = "职能管理-工资发放列表(人资)-工资导出", notes = "职能管理-工资发放列表(人资)-工资导出")
    @PostMapping("/exportFunctionSalary")
    public ComResponse<byte[]> exportFunctionSalary(@RequestBody SalaryVo salaryVo, HttpServletResponse response) {
        salaryVo.setStaffType(StaffTypeEnum.NOT_FRONT_LINE_STAFF.getCode().toString());
        ComResponse<byte[]> exportResponse = salarySlipFeignService.exportSalary(salaryVo);
        if (200 != exportResponse.getCode()) {
            return exportResponse;
        }
        return exportSalary(exportResponse.getData(), salaryVo, response);
    }

    @ApiOperation(value = "职能管理-工资发放列表(财务)-工资导出", notes = "职能管理-工资发放列表(财务)-工资导出")
    @PostMapping("/exportFunctionFinanceSalary")
    public ComResponse<byte[]> exportFunctionFinanceSalary(@RequestBody SalaryVo salaryVo, HttpServletResponse response) {
        salaryVo.setStaffType(StaffTypeEnum.NOT_FRONT_LINE_STAFF.getCode().toString());
        salaryVo.setSubmitStatus("1");
        ComResponse<byte[]> exportResponse = salarySlipFeignService.exportSalary(salaryVo);
        if (200 != exportResponse.getCode()) {
            return exportResponse;
        }
        return exportSalary(exportResponse.getData(), salaryVo, response);
    }

    @ApiOperation(value = "一线管理-工资发放列表(人资)-工资导出", notes = "一线管理-工资发放列表(人资)-工资导出")
    @PostMapping("/exportLineSalary")
    public ComResponse<byte[]> exportLineSalary(@RequestBody SalaryVo salaryVo, HttpServletResponse response) {
        salaryVo.setStaffType(StaffTypeEnum.FRONT_LINE_STAFF.getCode().toString());
        ComResponse<byte[]> exportResponse = salarySlipFeignService.exportSalary(salaryVo);
        if (200 != exportResponse.getCode()) {
            return exportResponse;
        }
        return exportSalary(exportResponse.getData(), salaryVo, response);
    }

    @ApiOperation(value = "一线管理-工资发放列表(财务)-工资导出", notes = "一线管理-工资发放列表(财务)-工资导出")
    @PostMapping("/exportLineFinanceSalary")
    public ComResponse<byte[]> exportLineFinanceSalary(@RequestBody SalaryVo salaryVo, HttpServletResponse response) {
        salaryVo.setStaffType(StaffTypeEnum.FRONT_LINE_STAFF.getCode().toString());
        salaryVo.setSubmitStatus("1");
        ComResponse<byte[]> exportResponse = salarySlipFeignService.exportSalary(salaryVo);
        if (200 != exportResponse.getCode()) {
            return exportResponse;
        }
        return exportSalary(exportResponse.getData(), salaryVo, response);
    }

    /**
     * 导出工资报表
     *
     * @param bytes    报表流
     * @param salaryVo 请求参数
     * @param response 响应流
     * @return 返回结果
     */
    private ComResponse<byte[]> exportSalary(byte[] bytes, SalaryVo salaryVo, HttpServletResponse response) {
        try {
            String fileName = salaryVo.getSalaryYear() + "年" + salaryVo.getSalaryMonth() + "月工资表";
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            LOGGER.error("工资条导出报表失败", e);
        }
        return ComResponse.fail(ResponseCodeEnums.BIZ_ERROR_CODE.getCode(), "工资条导出报表失败");
    }

    @ApiOperation(value = "工资发放列表(人资/财务)", notes = "工资发放列表(人资/财务)")
    @PostMapping("/list")
    public ComResponse<Page<SalarySlipListDto>> list(@RequestBody SalaryVo salaryVo) {
        return salarySlipFeignService.list(salaryVo);
    }

    @ApiOperation(value = "工资发放列表-人资提交财务", notes = "工资发放列表-人资提交财务")
    @PostMapping("/salarySubmit")
    ComResponse<Void> salarySubmit(@RequestBody List<SalarySubmitVo> list) {
        salarySlipFeignService.salarySubmit(list);
        return ComResponse.success();
    }

    @ApiOperation(value = "工资发放列表-财务审核", notes = "工资发放列表-财务审核")
    @PostMapping("/salaryExamine")
    ComResponse<Void> salaryExamine(@RequestBody List<SalaryFinanceExamineVo> list) {
        salarySlipFeignService.salaryExamine(list);
        return ComResponse.success();
    }

    @ApiOperation(value = "工资发放列表-工资发放类型修改（1-正常发，默认;0-缓发）", notes = "工资发放列表-修改工资发放类型（1-正常发，默认;0-缓发）")
    @PostMapping("/salaryGrantStatusUpDate")
    ComResponse<Void> salaryGrantStatusUpDate(@RequestBody List<SalaryGrantVo> list) {
        salarySlipFeignService.salaryGrantStatusUpDate(list);
        return ComResponse.success();
    }

    @ApiOperation(value = "工资发放列表-工资条状态修改（0-未发；1-已发）", notes = "工资发放列表-工资条状态修改（0-未发；1-已发）")
    @PostMapping("/salaryFinalGrantStatusUpDate")
    ComResponse<Void> salaryFinalGrantStatusUpDate(@RequestBody List<SalaryGrantFinalVo> list) {
        salarySlipFeignService.salaryFinalGrantStatusUpDate(list);
        return ComResponse.success();
    }
}
