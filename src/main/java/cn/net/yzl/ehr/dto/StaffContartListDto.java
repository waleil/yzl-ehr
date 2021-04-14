package cn.net.yzl.ehr.dto;

import cn.net.yzl.staff.dto.StaffContractFileDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StaffContartListDto {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    private String staffNo;
    @ApiModelProperty(value = "合同开始时间", name = "startDate")
    private Date startDate;
    @ApiModelProperty(value = "合同束时间", name = "endDate")
    private Date endDate;
    @ApiModelProperty(value = "工作邮箱", name = "workEmail")
    private String workEmail;
    @ApiModelProperty(value = "试用期到期日", name = "probationEndtime")
    private Date probationEndtime;
    @ApiModelProperty(value = "试用期时长（月）", name = "probationMonths")
    private Double probationMonths;
    @ApiModelProperty(value = "岗位薪资(分)", name = "salary")
    private Integer salary;
    @ApiModelProperty(value = "月数（xx薪）", name = "months")
    private Integer months;
    @ApiModelProperty(value = "季度奖金(分)", name = "quarterlyBonus")
    private Integer quarterlyBonus;
    @ApiModelProperty(value = "年度奖金(分)", name = "annualBonus")
    private Integer annualBonus;
    @ApiModelProperty(value = "试用期薪资(分)", name = "probationSalary")
    private Integer probationSalary;
    @ApiModelProperty(value = "合同到期时间是否不超过一个月（0:否，1:是）", name = "add_status")
    private Integer addStatus;
    @ApiModelProperty(value = "合同状态（0:过期，1:过期中最近一份，2:新建待用合同，3:启用中）", name = "contentStatus")
    private Integer contentStatus;
    @ApiModelProperty(value = "是否离职废弃(0.否,1.是)", name = "discardStatus")
    private Integer discardStatus;

    @ApiModelProperty(value = "全勤工资(分)", name = "fullAttendanceSalary")
    private Integer fullAttendanceSalary;

    @ApiModelProperty(value = "绩效工资(分)", name = "performanceSalary")
    private Integer performanceSalary;

    @ApiModelProperty(value = "岗位工资(分)", name = "wageSalary")
    private Integer wageSalary;

    @ApiModelProperty(value = "基本工资(分)", name = "basicSalary")
    private Integer basicSalary;

    @ApiModelProperty(value = "岗位薪资(元)", name = "salaryD")
    private Double salaryD;

    @ApiModelProperty(value = "季度奖金(元)", name = "quarterlyBonusD")
    private Double quarterlyBonusD;

    @ApiModelProperty(value = "年度奖金(元)", name = "annualBonusD")
    private Double annualBonusD;

    @ApiModelProperty(value = "试用期薪资(元)", name = "probationSalaryD")
    private Double probationSalaryD;

    @ApiModelProperty(value = "全勤工资(元)", name = "fullAttendanceSalaryD")
    private Double fullAttendanceSalaryD;

    @ApiModelProperty(value = "绩效工资(元)", name = "performanceSalaryD")
    private Double performanceSalaryD;

    @ApiModelProperty(value = "岗位工资(元)", name = "wageSalaryD")
    private Double wageSalaryD;

    @ApiModelProperty(value = "基本工资(元)", name = "basicSalaryD")
    private Double basicSalaryD;

    @ApiModelProperty(value = "基本工资类型（1.日工资，2.月工资）", name = "basicSalaryType")
    private Integer basicSalaryType;
    //合同文件及资质
    @ApiModelProperty(value="合同文件及资质",name="staffContractFiles")
    private List<StaffContractFileDto> staffContractFiles;
}
