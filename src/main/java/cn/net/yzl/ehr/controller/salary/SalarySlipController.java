package cn.net.yzl.ehr.controller.salary;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salary.SalarySlipFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.salary.SalaryGrantStatusDto;
import cn.net.yzl.staff.dto.salary.SalaryMyDto;
import cn.net.yzl.staff.dto.salary.SalarySlipListShowDto;
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
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


    @ApiOperation(value = "工资发放列表(人资)-工资导入", notes = "工资发放列表(人资)-工资导入")
    @PostMapping("/importSalary")
    public ComResponse<Boolean> importSalary(@RequestBody SalaryImportVo salaryImportVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        salaryImportVo.setStaffNo(staffNo);
        return salarySlipFeignService.importSalary(salaryImportVo);
    }

    @ApiOperation(value = "工资发放列表(人资/财务)-工资导出", notes = "工资发放列表(人资/财务)-工资导出")
    @PostMapping("/exportSalary")
    public ComResponse<byte[]> exportSalary(@RequestBody SalaryVo salaryVo, HttpServletResponse response) {
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
            Integer staffType = salaryVo.getStaffType();
            String salaryType = staffType == 1 ? "一线" : "职能";
            String fileName = "御芝林-" + salaryType + "工资条-" + DateUtil.format(new Date(), "yyyy-MM-dd_HHmmss");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
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
    public ComResponse<Page<SalarySlipListShowDto>> list(@RequestBody SalaryVo salaryVo) {
        return salarySlipFeignService.list(salaryVo);
    }

    @ApiOperation(value = "工资发放列表-财务审核", notes = "工资发放列表-财务审核")
    @PostMapping("/salaryExamine")
    public ComResponse<Void> salaryExamine(@RequestBody List<SalaryFinanceExamineVo> list) {
        return salarySlipFeignService.salaryExamine(list);
    }

    @ApiOperation(value = "工资发放列表-人资提交财务", notes = "工资发放列表-修改工资发放类型（1-正常发，默认;0-缓发）")
    @PostMapping("/salaryGrantStatusUpDate")
    public ComResponse<Void> salaryGrantStatusUpDate(@RequestBody List<SalaryGrantVo> list) {
        return salarySlipFeignService.salaryGrantStatusUpDate(list);
    }

    @ApiOperation(value = "工资发放列表-发工资", notes = "工资发放列表-发工资")
    @PostMapping("/salaryFinalGrantStatusUpDate")
    public ComResponse<List<SalaryGrantStatusDto>> salaryFinalGrantStatusUpDate(@RequestBody List<SalaryGrantFinalVo> list, @ApiIgnore @CurrentStaffNo String staffNo) {
        ComResponse<List<SalaryGrantStatusDto>> comResponse = salarySlipFeignService.salaryFinalGrantStatusUpDate(list);
        if (comResponse.getCode() == 200) {
            List<SalaryGrantStatusDto> salaryGrantStatusDtos = comResponse.getData();
            if (salaryGrantStatusDtos != null) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月");
                salaryGrantStatusDtos.forEach(item -> {
                    MessageRemandAPI.paySalary(staffNo,
                            item.getStaffNo(),
                            item.getStaffName(),
                            item.getDuration().format(dtf));
                });
            }
        }
        return comResponse;
    }

    @ApiOperation(value = "个人中心-我的工资", notes = "个人中心-我的工资")
    @PostMapping("/mySalary")
    public ComResponse<SalaryMyDto> mySalary(@RequestBody MySalaryVo mySalaryVo, @ApiIgnore @CurrentStaffNo String staffNo) {
        mySalaryVo.setStaffNo(staffNo);
        return salarySlipFeignService.mySalary(mySalaryVo);
    }
}
