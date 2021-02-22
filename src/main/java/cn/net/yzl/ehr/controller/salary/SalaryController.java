package cn.net.yzl.ehr.controller.salary;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.salary.SalaryService;
import cn.net.yzl.staff.dto.salary.MySalaryDto;
import cn.net.yzl.staff.dto.salary.SalaryDto;
import cn.net.yzl.staff.vo.salary.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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



    @ApiOperation(value = "工资发放列表(一线/职能共用)", notes = "工资发放列表(一线/职能共用)")
    @PostMapping("/list")
    ComResponse<Page<SalaryDto>> list(@RequestBody SalaryVo salaryVo) {
        return salaryService.list(salaryVo);
    }

    //导入数据
    @ApiOperation(value = "工资发放列表(一线/职能共用)-导入数据", notes = "工资发放列表(一线/职能共用)-导入数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "文件全路径", required = true, dataType = "String"),
            @ApiImplicitParam(name = "staffType", value = "一线员工1，非一线员工2", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/importSalary", method = RequestMethod.GET)
    ComResponse<Boolean> importSalary(@RequestParam("url") String url,@RequestParam("staffType") Integer staffType) {
        return salaryService.importSalary(url,staffType);
    }

    //导出数据
    @ApiOperation(value = "一线工资发放列表(一线/职能共用)-导出", notes = "工资发放列表(一线/职能共用)-导出")
    @PostMapping(value = "/exportSalary")
    void exportSalary(@RequestBody SalaryVo salaryVo, HttpServletResponse response) throws IOException{

        int pageTotal = 1;
        ExcelWriter writer = ExcelUtil.getWriter();
        if(salaryVo.getPageNo()==1){
            ComResponse<Page<SalaryDto>> list = salaryService.list(salaryVo);
            pageTotal = list.getData().getPageParam().getPageTotal();
            salaryVo.setPageNo(2);
            export(list.getData().getItems(),new String[]{"期间","员工姓名","身份证号","工号","在职状态","入职时间","离职时间",
                            "职务","上级架构","部门","开户银行","银行卡号","岗位工资","基本薪资","签收金额","提成比例","销售提成",
                            "团队提成","团队绩效","转介绍提成","培训补贴","薪资奖金","其它奖金","现金奖励","积分兑换","结余工资",
                            "全勤","加班费"," 迟到/早退/忘记打卡","应出勤","实际出勤","旷工","质检/考勤/行政扣款","应发工资",
                            "养老保险","医疗保险","失业险","工伤","生育","商业","住房公积金","住宿费扣款","停车费扣款",
                            "个人保险扣款","个人所得税","实发薪资","发放状态","是否参保","是否大学生","是否实习生","社保合计","提交状态",
                            "审核状态"},
                    new String[]{"salaryDate","staffName","idCard","staffNo","entryStatus","entryDate","quitDate","postName",
                            "parentDepartName","departName","bankName","bankCard","postMoney","basicMoney","signMoney","commissionRatio",
                            "saleCommission","teamCommission","teamAchievements","referralCommission","trainMoney","salaryBonusMoney",
                            "otherBonusMoney","cashMoney","pointsExchangeMoney","balanceMoney","fullAtteBonusMoney","overtimePayMoney","deductionMoney",
                            "attendanceDays","attendanceRealDays","compassionateDays","attendanceDedu","payMoney","endowInsurDedu","medicalInsurDedu",
                            "unemployInsurDedu","empInjuInsurDedu","materInsurDedu","busInsurDedu","housProvFundDedu","accomFeeDedu",
                            "parkFeeDedu","personalInsurDedu","individualIncomeTax","realMoney","delayStatus","insuredStatus",
                            "studentStatus","internshipStatus","socialSecurityTotal","submitStatus","checkStatus"},writer);
        }else {
            for(int pageNo=2;pageNo<pageTotal;pageNo++){
                salaryVo.setPageNo(pageNo);
                ComResponse<Page<SalaryDto>> list = list(salaryVo);

                export(list.getData().getItems(),new String[]{"期间","员工姓名","身份证号","工号","在职状态","入职时间","离职时间",
                        "职务","上级架构","部门","开户银行","银行卡号","岗位工资","基本薪资","签收金额","提成比例","销售提成",
                        "团队提成","团队绩效","转介绍提成","培训补贴","薪资奖金","其它奖金","现金奖励","积分兑换","结余工资",
                        "全勤","加班费"," 迟到/早退/忘记打卡","应出勤","实际出勤","旷工","质检/考勤/行政扣款","应发工资",
                        "养老保险","医疗保险","失业险","工伤","生育","商业","住房公积金","住宿费扣款","停车费扣款",
                        "个人保险扣款","个人所得税","实发薪资","发放状态","是否参保","是否大学生","是否实习生","社保合计","提交状态",
                        "审核状态"},new String[]{"salaryDate","staffName","idCard","staffNo","entryStatus","entryDate","quitDate","postName",
                        "parentDepartName","departName","bankName","bankCard","postMoney","basicMoney","signMoney","commissionRatio",
                        "saleCommission","teamCommission","teamAchievements","referralCommission","trainMoney","salaryBonusMoney",
                        "otherBonusMoney","cashMoney","pointsExchangeMoney","balanceMoney","fullAtteBonusMoney","overtimePayMoney","deductionMoney",
                        "attendanceDays","attendanceRealDays","compassionateDays","attendanceDedu","payMoney","endowInsurDedu","medicalInsurDedu",
                        "unemployInsurDedu","empInjuInsurDedu","materInsurDedu","busInsurDedu","housProvFundDedu","accomFeeDedu",
                        "parkFeeDedu","personalInsurDedu","individualIncomeTax","realMoney","delayStatus","insuredStatus",
                        "studentStatus","internshipStatus","socialSecurityTotal","submitStatus","checkStatus"},writer);
            }
        }
        closeStream(response,"工资表", writer);

    }
    //提交财务
    @ApiOperation(value = "工资发放列表(一线/职能共用)-提交财务", notes = "工资发放列表(一线/职能共用)-提交财务")
    @PostMapping("/postToFinance")
    ComResponse<Void>  postToFinance(@RequestBody List<SalaryFinanceVo> list,@ApiIgnore @CurrentStaffNo String staffNo) {
        list.forEach(t -> {
            t.setUpdator(staffNo);
        });
        salaryService.postToFinance(list);
        return ComResponse.success();
    }
    //财务审核通过/驳回
    @ApiOperation(value = "工资发放列表-财务审核通过/驳回(一线/职能共用)", notes = "工资发放列表-财务审核通过/驳回(一线/职能共用)")
    @PostMapping("/financePassOrReject")
    ComResponse<Void>  financePassOrReject(@RequestBody List<SalaryFinanceCheckVo> list,@ApiIgnore @CurrentStaffNo String staffNo) {
        list.forEach(t -> {
            t.setUpdator(staffNo);
        });
        salaryService.financePassOrReject(list);
        return ComResponse.success();
    }

    //发放
    @ApiOperation(value = "工资发放列表-发放(一线/职能共用)", notes = "工资发放列表-发放(一线/职能共用)")
    @PostMapping("/financeGrantMoney")
    ComResponse<Void>  financeGrantMoney(@RequestBody List<SalaryFinanceGrantVo> list,@ApiIgnore @CurrentStaffNo String staffNo) {
        list.forEach(t -> {
            t.setUpdator(staffNo);
        });
        salaryService.financeGrantMoney(list);
        return ComResponse.success();
    }
    //我得工资
    @ApiOperation(value = "我得工资-一线职能共用", notes = "我得工资-一线职能共用")
    @PostMapping("/getMySalary")
    ComResponse<MySalaryDto> getMySalary(@ApiIgnore @CurrentStaffNo String staffNo,@RequestBody MySalaryVo request) {
        request.setStaffNo(staffNo);
        return salaryService.getMySalary(request);
    }


    /**
     * @param columnNames 导出的excel中的列名
     * @param keys 对应的是对象中的字段名字
     */
    private  void export(List<SalaryDto> projects, String[] columnNames, String[] keys, ExcelWriter writer) {
        for (int i = 0; i < columnNames.length; i++) {
            writer.addHeaderAlias(columnNames[i], keys[i]);
            writer.setColumnWidth(i, 20);
        }
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(projects, true);
    }
    /**
     * @param response
     * @param fileName 文件名
     * @param writer
     */
    private void closeStream(HttpServletResponse response,String fileName,ExcelWriter writer)throws IOException{
        writer.setOnlyAlias(true);
        response.reset();
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }
}
