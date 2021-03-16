package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * 员工异动信息记录表
 * 
 * @author
 * @date： 2020-12-30 21:11:37
 */
@Data
public class StaffAbnorRecordDto {
    @ApiModelProperty("主键 唯一id")
    private Integer id;

/*    @ApiModelProperty(value = "员工工号",hidden = true)
    private String staffNo;

    @ApiModelProperty(value = "员工姓名",hidden = true)
    private String staffName;*/

    @ApiModelProperty("异动类型(字典表 )")
    private Integer type;

    @ApiModelProperty("异动类型名称")
    private String typeName;

    @ApiModelProperty("异动内容")
    private String content;

    @ApiModelProperty("调整前部门")
    private Integer adjustDepartFront;

    @ApiModelProperty("调整前部门名")
    private String adjustDepartNameFront;

    @ApiModelProperty("调整后部门")
    private Integer adjustDepartLater;

    @ApiModelProperty("调整后部门名")
    private String adjustDepartNameLater;

    @ApiModelProperty("调整前上级部门")
    @Min(1)
    private Integer adjustParentDepartFront;

    @ApiModelProperty("调整前上级部门名")
    private String adjustParentDepartNameFront;

    @ApiModelProperty("调整后上级部门")
    @Min(1)
    private Integer adjustParentDepartLater;

    @ApiModelProperty("调整后上级部门名")
    private String adjustParentDepartNameLater;

    @ApiModelProperty("调整前岗位")
    private Integer adjustPostFront;

    @ApiModelProperty("调整前岗位名")
    private String adjustPostNameFront;

    @ApiModelProperty("调整后岗位")
    private Integer adjustPostLater;

    @ApiModelProperty("调整后岗位名")
    private String adjustPostNameLater;

    @ApiModelProperty("调整前部门岗位编号")
    private Integer adjustDepartPostFront;

    @ApiModelProperty("调整后部门岗位编号")
    private Integer adjustDepartPostLater;

    @ApiModelProperty("调整前薪资")
    private Integer adjustSalaryFront;

    @ApiModelProperty("调整后薪资")
    private Integer adjustSalaryLater;


    @ApiModelProperty("调整前全勤薪资")
    private Integer adjustFullAttendanceSalaryFront;

    @ApiModelProperty("调整后全勤薪资")
    private Integer adjustFullAttendanceSalaryLater;

    @ApiModelProperty("调整前绩效薪资")
    private Integer adjustPerformanceSalaryFront;

    @ApiModelProperty("调整后绩效薪资")
    private Integer adjustPerformanceSalaryLater;

    @ApiModelProperty("调整前岗位薪资")
    private Integer adjustWageSalaryFront;

    @ApiModelProperty("调整后岗位薪资")
    private Integer adjustWageSalaryLater;

    @ApiModelProperty("调整前基本薪资")
    private Integer adjustBasicSalaryFront;

    @ApiModelProperty("调整后基本薪资")
    private Integer adjustBasicSalaryLater;

    @ApiModelProperty("调整前基本薪资类型（1.日工资，2.月工资）")
    private Integer adjustBasicSalaryTypeFront;

    @ApiModelProperty("调整后基本薪资类型（1.日工资，2.月工资）")
    private Integer adjustBasicSalaryTypeLater;

    @ApiModelProperty("异动时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date abnorTime;

    @ApiModelProperty("薪资结算日期时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date positiveTime;

    @ApiModelProperty("调整前岗位等级")
    private Integer adjustPostLevelFront;

    @ApiModelProperty("调整后岗位等级")
    private Integer adjustPostLevelLater;

    @ApiModelProperty("调整前岗位等级名")
    private String adjustPostLevelFrontName;

    @ApiModelProperty("调整后岗位等级名")
    private String adjustPostLevelLaterName;

    @ApiModelProperty("异动创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;



}