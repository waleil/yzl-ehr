package cn.net.yzl.ehr.pojo;


import cn.net.yzl.staff.pojo.StaffContractFileInsertPo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class StaffCFInsertPo {

    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    @NotBlank
    private String staffNo;

    @ApiModelProperty(value = "合同开始时间", name = "startDate")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date startDate;

    @ApiModelProperty(value = "合同束时间", name = "endDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date endDate;

    @ApiModelProperty(value = "工作邮箱", name = "workEmail")
    private String workEmail;

    @ApiModelProperty(value = "试用期到期日", name = "probationEndtime")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date probationEndtime;

    @ApiModelProperty(value = "试用期时长（月）", name = "probationMonths")
    @Min(0)
    private Double probationMonths;

    @ApiModelProperty(value = "岗位薪资", name = "salary",hidden = true)
    @Min(0)
    private Integer salary;

    @ApiModelProperty(value = "全勤工资)", name = "fullAttendanceSalary",hidden = true)
    @Min(0)
    private Integer fullAttendanceSalary;

    @ApiModelProperty(value = "绩效工资", name = "performanceSalary",hidden = true)
    @Min(0)
    private Integer performanceSalary;

    @ApiModelProperty(value = "岗位工资", name = "wageSalary",hidden = true)
    @Min(0)
    private Integer wageSalary;

    @ApiModelProperty(value = "基本工资", name = "basicSalary",hidden = true)
    @Min(0)
    private Integer basicSalary;

    @ApiModelProperty(value = "季度奖金", name = "quarterlyBonus",hidden = true)
    @Min(0)
    private Integer quarterlyBonus;

    @ApiModelProperty(value = "年度奖金", name = "annualBonus",hidden = true)
    @Min(0)
    private Integer annualBonus;

    @ApiModelProperty(value = "试用期薪资", name = "probationSalary",hidden = true)
    @Min(0)
    private Integer probationSalary;

    @ApiModelProperty(value = "岗位薪资(元)", name = "salaryD")
    @Min(0)
    private Integer salaryD;

    @ApiModelProperty(value = "全勤工资(元)", name = "fullAttendanceSalaryD")
    @Min(0)
    private Integer fullAttendanceSalaryD;

    @ApiModelProperty(value = "绩效工资(元)", name = "performanceSalaryD")
    @Min(0)
    private Integer performanceSalaryD;

    @ApiModelProperty(value = "岗位工资(元)", name = "wageSalaryD")
    @Min(0)
    private Integer wageSalaryD;

    @ApiModelProperty(value = "基本工资(元)", name = "basicSalaryD")
    @Min(0)
    private Integer basicSalaryD;

    @ApiModelProperty(value = "季度奖金(元)", name = "quarterlyBonusD")
    @Min(0)
    private Integer quarterlyBonusD;

    @ApiModelProperty(value = "年度奖金(元)", name = "annualBonusD")
    @Min(0)
    private Integer annualBonusD;

    @ApiModelProperty(value = "试用期薪资(元)", name = "probationSalaryD")
    @Min(0)
    private Integer probationSalaryD;

    @ApiModelProperty(value = "月数（xx薪）", name = "months")
    @Min(0)
    private Integer months;

    @ApiModelProperty(value = "基本工资类型（1.日工资，2.月工资）", name = "basicSalaryType")
    private Integer basicSalaryType;

    @ApiModelProperty(value = "合同到期时间是否不超过一个月（0:否，1:是）", name = "addStatus",hidden = true)
    private Integer addStatus;

    @ApiModelProperty(value = "合同状态（0:过期，1:过期中最近一份，2:新建合同，3:启用中）", name = "contentStatus",hidden = true)
    private Integer contentStatus;

    @ApiModelProperty(value = "创建人", name = "creator",hidden = true)
    private String creator;

    @ApiModelProperty(value = "电子合同及其他资质", name = "电子合同及其他资质")
    private List<StaffContractFileInsertPo> staffContractFileInsertPos;

    public void setSalaryD(Integer salaryD) {
        this.salaryD = salaryD;
        if(salaryD!=null){
            salaryD=salaryD*100;
            this.salary=salaryD.intValue();
        }
    }

    public void setFullAttendanceSalaryD(Integer fullAttendanceSalaryD) {
        this.fullAttendanceSalaryD = fullAttendanceSalaryD;
        if(fullAttendanceSalaryD!=null){
            fullAttendanceSalaryD=fullAttendanceSalaryD*100;
            this.fullAttendanceSalary=fullAttendanceSalaryD.intValue();
        }
    }

    public void setPerformanceSalaryD(Integer performanceSalaryD) {
        this.performanceSalaryD = performanceSalaryD;
        if(performanceSalaryD!=null){
            performanceSalaryD=performanceSalaryD*100;
            this.performanceSalary=performanceSalaryD.intValue();
        }
    }

    public void setWageSalaryD(Integer wageSalaryD) {
        this.wageSalaryD = wageSalaryD;
        if(wageSalaryD!=null){
            wageSalaryD=wageSalaryD*100;
            this.wageSalary=wageSalaryD.intValue();
        }
    }

    public void setBasicSalaryD(Integer basicSalaryD) {
        this.basicSalaryD = basicSalaryD;
        if(basicSalaryD!=null){
            basicSalaryD=basicSalaryD*100;
            this.basicSalary=basicSalaryD.intValue();
        }
    }

    public void setQuarterlyBonusD(Integer quarterlyBonusD) {
        this.quarterlyBonusD = quarterlyBonusD;
        if(quarterlyBonusD!=null){
            quarterlyBonusD=quarterlyBonusD*100;
            this.quarterlyBonus=quarterlyBonusD.intValue();
        }
    }

    public void setAnnualBonusD(Integer annualBonusD) {
        this.annualBonusD = annualBonusD;
        if(annualBonusD!=null){
            annualBonusD=annualBonusD*100;
            this.annualBonus=annualBonusD.intValue();
        }
    }

    public void setProbationSalaryD(Integer probationSalaryD) {
        this.probationSalaryD = probationSalaryD;
        if(probationSalaryD!=null){
            probationSalaryD=probationSalaryD*100;
            this.probationSalary=probationSalaryD.intValue();
        }
    }
}
