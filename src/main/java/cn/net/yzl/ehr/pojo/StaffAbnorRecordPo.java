package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * staff_abnor_record
 * @author 
 */
@ApiModel(value = "员工异动操作", description = "员工异动操作")
@Data
public class StaffAbnorRecordPo {

    @ApiModelProperty(value = "异动编号",hidden = true)
    private Integer id;

    @ApiModelProperty("员工工号")
    @NotBlank
    private String staffNo;

    @ApiModelProperty("异动类型(字典表)")
    @NotNull
    @Min(0)
    private Integer type;

    @ApiModelProperty("异动内容")
    private String content;

    @ApiModelProperty("调整前部门")
    @Min(1)
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
    @Min(0)
    private Integer adjustPostFront;

    @ApiModelProperty("调整前岗位名")
    private String adjustPostNameFront;

    @ApiModelProperty("调整后岗位")
    @Min(0)
    private Integer adjustPostLater;

    @ApiModelProperty("调整后岗位名")
    private String adjustPostNameLater;

    @ApiModelProperty("调整前岗位等级")
    @Min(0)
    private Integer adjustPostLevelFront;

    @ApiModelProperty("调整前岗位等级名")
    private String adjustPostLevelFrontName;

    @ApiModelProperty("调整后岗位等级")
    @Min(0)
    private Integer adjustPostLevelLater;

    @ApiModelProperty("调整后岗位等级名")
    private String adjustPostLevelLaterName;

    @ApiModelProperty("调整前部门岗位编号")
    @Min(0)
    private Integer adjustDepartPostFront;

    @ApiModelProperty("调整后部门岗位编号")
    @Min(0)
    private Integer adjustDepartPostLater;

    @ApiModelProperty("调整前薪资")
    @NotNull
    @Min(0)
    private Integer adjustSalaryFront;

    @ApiModelProperty("调整后薪资")
    private Integer adjustSalaryLater;

    @ApiModelProperty("异动时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @NotBlank
    private String abnorTime;

    @ApiModelProperty(value = "是否已执行:0.否,1.是",hidden = true)
    private String isExecute;

    @ApiModelProperty("薪资结算日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String positiveTime;

    @ApiModelProperty(value = "创建人",hidden = true)
    private String creator;

}