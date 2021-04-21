package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
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

    @ApiModelProperty("是否加入黑名单 0.不加入 1.加入")
    @Min(0)
    @Max(1)
    private Integer onBlackList;

    @ApiModelProperty("异动内容")
    private String content;

    @ApiModelProperty("异动原因/备注")
    private String desc;

    @ApiModelProperty("调整前部门")
    @Min(0)
    private Integer adjustDepartFront;

    @ApiModelProperty("调整前部门名")
    private String adjustDepartNameFront;

    @ApiModelProperty("调整后部门")
    private Integer adjustDepartLater;

    @ApiModelProperty("调整后部门名")
    private String adjustDepartNameLater;

    @ApiModelProperty("调整前上级部门")
    @Min(0)
    private Integer adjustParentDepartFront;

    @ApiModelProperty("调整前上级部门名")
    private String adjustParentDepartNameFront;

    @ApiModelProperty("调整后上级部门")
    @Min(0)
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

    @ApiModelProperty(value = "调整前薪资",hidden = true)
    @Min(0)
    private Integer adjustSalaryFront;

    @ApiModelProperty(value = "调整后薪资",hidden = true)
    @Min(0)
    private Integer adjustSalaryLater;

    @ApiModelProperty(value = "调整前全勤薪资",hidden = true)
    @Min(0)
    private Integer adjustFullAttendanceSalaryFront;

    @ApiModelProperty(value = "调整后全勤薪资",hidden = true)
    @Min(0)
    private Integer adjustFullAttendanceSalaryLater;

    @ApiModelProperty(value = "调整前绩效薪资",hidden = true)
    @Min(0)
    private Integer adjustPerformanceSalaryFront;

    @ApiModelProperty(value = "调整后绩效薪资",hidden = true)
    @Min(0)
    private Integer adjustPerformanceSalaryLater;

    @ApiModelProperty(value = "调整前岗位薪资",hidden = true)
    @Min(0)
    private Integer adjustWageSalaryFront;

    @ApiModelProperty(value = "调整后岗位薪资",hidden = true)
    @Min(0)
    private Integer adjustWageSalaryLater;

    @ApiModelProperty(value = "调整前基本薪资",hidden = true)
    @Min(0)
    private Integer adjustBasicSalaryFront;

    @ApiModelProperty(value = "调整后基本薪资",hidden = true)
    @Min(0)
    private Integer adjustBasicSalaryLater;

    @ApiModelProperty("调整前基本薪资类型（1.日工资，2.月工资）")
    @Min(0)
    private Integer adjustBasicSalaryTypeFront;

    @ApiModelProperty("调整后基本薪资类型（1.日工资，2.月工资）")
    @Min(0)
    private Integer adjustBasicSalaryTypeLater;


    @ApiModelProperty("调整前薪资(元)")
    @Min(0)
    private Double adjustSalaryFrontD;

    @ApiModelProperty("调整后薪资(元)")
    private Double adjustSalaryLaterD;

    @ApiModelProperty("调整前全勤薪资(元)")
    private Double adjustFullAttendanceSalaryFrontD;

    @ApiModelProperty("调整后全勤薪资(元)")
    private Double adjustFullAttendanceSalaryLaterD;

    @ApiModelProperty("调整前绩效薪资(元)")
    private Double adjustPerformanceSalaryFrontD;

    @ApiModelProperty("调整后绩效薪资(元)")
    private Double adjustPerformanceSalaryLaterD;

    @ApiModelProperty("调整前岗位薪资(元)")
    private Double adjustWageSalaryFrontD;

    @ApiModelProperty("调整后岗位薪资(元)")
    private Double adjustWageSalaryLaterD;

    @ApiModelProperty("调整前基本薪资(元)")
    private Double adjustBasicSalaryFrontD;

    @ApiModelProperty("调整后基本薪资(元)")
    private Double adjustBasicSalaryLaterD;

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

    public void setAdjustSalaryFrontD(Double adjustSalaryFrontD) {
        this.adjustSalaryFrontD = adjustSalaryFrontD;
        if(adjustSalaryFrontD!=null){
            adjustSalaryFrontD= adjustSalaryFrontD*100;
            this.adjustSalaryFront=adjustSalaryFrontD.intValue();
        }
    }

    public void setAdjustSalaryLaterD(Double adjustSalaryLaterD) {
        this.adjustSalaryLaterD = adjustSalaryLaterD;
        if(adjustSalaryLaterD!=null){
            adjustSalaryLaterD= adjustSalaryLaterD*100;
            this.adjustSalaryLater=adjustSalaryLaterD.intValue();
        }
    }

    public void setAdjustFullAttendanceSalaryFrontD(Double adjustFullAttendanceSalaryFrontD) {
        this.adjustFullAttendanceSalaryFrontD = adjustFullAttendanceSalaryFrontD;
        if(adjustFullAttendanceSalaryFrontD!=null){
            adjustFullAttendanceSalaryFrontD= adjustFullAttendanceSalaryFrontD*100;
            this.adjustFullAttendanceSalaryFront=adjustFullAttendanceSalaryFrontD.intValue();
        }
    }

    public void setAdjustFullAttendanceSalaryLaterD(Double adjustFullAttendanceSalaryLaterD) {
        this.adjustFullAttendanceSalaryLaterD = adjustFullAttendanceSalaryLaterD;
        if(adjustFullAttendanceSalaryLaterD!=null){
            adjustFullAttendanceSalaryLaterD= adjustFullAttendanceSalaryLaterD*100;
            this.adjustFullAttendanceSalaryLater=adjustFullAttendanceSalaryLaterD.intValue();
        }
    }

    public void setAdjustPerformanceSalaryFrontD(Double adjustPerformanceSalaryFrontD) {
        this.adjustPerformanceSalaryFrontD = adjustPerformanceSalaryFrontD;
        if(adjustPerformanceSalaryFrontD!=null){
            adjustPerformanceSalaryFrontD= adjustPerformanceSalaryFrontD*100;
            this.adjustPerformanceSalaryFront=adjustPerformanceSalaryFrontD.intValue();
        }
    }

    public void setAdjustPerformanceSalaryLaterD(Double adjustPerformanceSalaryLaterD) {
        this.adjustPerformanceSalaryLaterD = adjustPerformanceSalaryLaterD;
        if(adjustPerformanceSalaryLaterD!=null){
            adjustPerformanceSalaryLaterD= adjustPerformanceSalaryLaterD*100;
            this.adjustPerformanceSalaryLater=adjustPerformanceSalaryLaterD.intValue();
        }
    }

    public void setAdjustWageSalaryFrontD(Double adjustWageSalaryFrontD) {
        this.adjustWageSalaryFrontD = adjustWageSalaryFrontD;
        if(adjustWageSalaryFrontD!=null){
            adjustWageSalaryFrontD= adjustWageSalaryFrontD*100;
            this.adjustWageSalaryFront=adjustWageSalaryFrontD.intValue();
        }
    }

    public void setAdjustWageSalaryLaterD(Double adjustWageSalaryLaterD) {
        this.adjustWageSalaryLaterD = adjustWageSalaryLaterD;
        if(adjustWageSalaryLaterD!=null){
            adjustWageSalaryLaterD= adjustWageSalaryLaterD*100;
            this.adjustWageSalaryLater=adjustWageSalaryLaterD.intValue();
        }
    }

    public void setAdjustBasicSalaryFrontD(Double adjustBasicSalaryFrontD) {
        this.adjustBasicSalaryFrontD = adjustBasicSalaryFrontD;
        if(adjustBasicSalaryFrontD!=null){
            adjustBasicSalaryFrontD= adjustBasicSalaryFrontD*100;
            this.adjustBasicSalaryFront=adjustBasicSalaryFrontD.intValue();
        }
    }

    public void setAdjustBasicSalaryLaterD(Double adjustBasicSalaryLaterD) {
        this.adjustBasicSalaryLaterD = adjustBasicSalaryLaterD;
        if(adjustBasicSalaryLaterD!=null){
            adjustBasicSalaryLaterD= adjustBasicSalaryLaterD*100;
            this.adjustBasicSalaryLater=adjustBasicSalaryLaterD.intValue();
        }
    }

}