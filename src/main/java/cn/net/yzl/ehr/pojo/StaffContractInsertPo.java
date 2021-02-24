package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "StaffContentPo", description = "员工合同信息")
public class StaffContractInsertPo implements Serializable {
    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    @NotBlank
    private String staffNo;

    @ApiModelProperty(value = "合同开始时间", name = "endTime")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date startDate;

    @ApiModelProperty(value = "合同束时间", name = "endDate")
    @JsonFormat(pattern = "yyyy-MM-DD")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date endDate;

    @ApiModelProperty(value = "工作邮箱", name = "workEmail")
    @NotBlank
    private String workEmail;

    @ApiModelProperty(value = "试用期到期日", name = "probationEndtime")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date probationEndtime;

    @ApiModelProperty(value = "试用期时长（月）", name = "probationMonths")
    @NotNull
    @Min(0)
    private Double probationMonths;

    @ApiModelProperty(value = "薪资", name = "salary")
    @NotNull
    @Min(0)
    private Integer salary;

    @ApiModelProperty(value = "月数（xx薪）", name = "months")
    @NotNull
    @Min(0)
    private Integer months;

    @ApiModelProperty(value = "季度奖金", name = "quarterlyBonus")
    @NotNull
    @Min(0)
    private Integer quarterlyBonus;

    @ApiModelProperty(value = "年度奖金", name = "annualBonus")
    @NotNull
    @Min(0)
    private Integer annualBonus;

    @ApiModelProperty(value = "试用期薪资比例", name = "probationSalary")
    @NotNull
    @Min(0)
    private Double probationSalary;

    @ApiModelProperty(value = "合同到期时间是否不超过一个月（0:否，1:是）", name = "addStatus",hidden = true)
    private Integer addStatus;

    @ApiModelProperty(value = "合同状态（0:过期，1:过期中最近一份，2:新建合同，3:启用中）", name = "contentStatus",hidden = true)
    private Integer contentStatus;
}
