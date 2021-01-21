package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "StaffContentPo", description = "员工合同信息")
public class StaffContractInsertPo implements Serializable {
    @ApiModelProperty(value = "员工表工号", name = "staff_no")
    private String staffNo;
    @ApiModelProperty(value = "合同开始时间", name = "start_date")
    private String startDate;
    @ApiModelProperty(value = "合同束时间", name = "end_date")
    private String endDate;
    @ApiModelProperty(value = "工作邮箱", name = "work_email")
    private String workEmail;
    @ApiModelProperty(value = "试用期到期日", name = "probation_endtime")
    private String probationEndtime;
    @ApiModelProperty(value = "试用期时长（月）", name = "probation_months")
    private Double probationMonths;
    @ApiModelProperty(value = "薪资", name = "salary")
    private Double salary;
    @ApiModelProperty(value = "月数（xx薪）", name = "months")
    private Integer months;
    @ApiModelProperty(value = "季度奖金", name = "quarterly_bonus")
    private Double quarterlyBonus;
    @ApiModelProperty(value = "年度奖金", name = "annual_bonus")
    private Double annualBonus;
    @ApiModelProperty(value = "试用期薪资比例", name = "probation_salary")
    private Double probationSalary;
    @ApiModelProperty(value = "合同到期时间是否不超过一个月（0:否，1:是）", name = "add_status")
    private Integer addStatus;
    @ApiModelProperty(value = "合同状态（0:过期，1:过期中最近一份，2:新建合同，3:启用中）", name = "content_status")
    private Integer contentStatus;
}
