package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * StaffAbnorRecordSalaryPo
 * 用于处理前端传来的金额*100转化为分
 * @author 
 */
@ApiModel(value = "员工异动操作(金额转化)", description = "员工异动操作(金额转化)")
@Data
public class StaffAbnorRecordSalaryPo {

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
    @NotBlank
    private String abnorTime;

    @ApiModelProperty(value = "是否已执行:0.否,1.是",hidden = true)
    private String isExecute;

    @ApiModelProperty("薪资结算日期")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String positiveTime;

    @ApiModelProperty(value = "创建人",hidden = true)
    private String creator;

    public void setAdjustSalaryFront(Integer adjustSalaryFront) {
        if(adjustSalaryFront!=null){
            this.adjustSalaryFront = adjustSalaryFront*100;
        }else{
            this.adjustSalaryFront =null;
        }
    }

    public void setAdjustSalaryLater(Integer adjustSalaryLater) {
        this.adjustSalaryLater = adjustSalaryLater*100;
        if(adjustSalaryLater!=null){
            this.adjustSalaryLater = adjustSalaryLater*100;
        }else{
            this.adjustSalaryLater =null;
        }
    }

    public void setAdjustFullAttendanceSalaryFront(Integer adjustFullAttendanceSalaryFront) {
        this.adjustFullAttendanceSalaryFront = adjustFullAttendanceSalaryFront*100;
        if(adjustFullAttendanceSalaryFront!=null){
            this.adjustFullAttendanceSalaryFront = adjustFullAttendanceSalaryFront*100;
        }else{
            this.adjustFullAttendanceSalaryFront =null;
        }
    }

    public void setAdjustFullAttendanceSalaryLater(Integer adjustFullAttendanceSalaryLater) {
        this.adjustFullAttendanceSalaryLater = adjustFullAttendanceSalaryLater*100;
        if(adjustFullAttendanceSalaryLater!=null){
            this.adjustFullAttendanceSalaryLater = adjustFullAttendanceSalaryLater*100;
        }else{
            this.adjustFullAttendanceSalaryLater =null;
        }
    }

    public void setAdjustPerformanceSalaryFront(Integer adjustPerformanceSalaryFront) {
        this.adjustPerformanceSalaryFront = adjustPerformanceSalaryFront*100;
        if(adjustPerformanceSalaryFront!=null){
            this.adjustPerformanceSalaryFront = adjustPerformanceSalaryFront*100;
        }else{
            this.adjustPerformanceSalaryFront =null;
        }
    }

    public void setAdjustPerformanceSalaryLater(Integer adjustPerformanceSalaryLater) {
        this.adjustPerformanceSalaryLater = adjustPerformanceSalaryLater*100;
        if(adjustPerformanceSalaryLater!=null){
            this.adjustPerformanceSalaryLater = adjustPerformanceSalaryLater*100;
        }else{
            this.adjustPerformanceSalaryLater =null;
        }
    }

    public void setAdjustWageSalaryFront(Integer adjustWageSalaryFront) {
        this.adjustWageSalaryFront = adjustWageSalaryFront*100;
        if(adjustWageSalaryFront!=null){
            this.adjustWageSalaryFront = adjustWageSalaryFront*100;
        }else{
            this.adjustWageSalaryFront =null;
        }
    }

    public void setAdjustWageSalaryLater(Integer adjustWageSalaryLater) {
        this.adjustWageSalaryLater = adjustWageSalaryLater*100;
        if(adjustWageSalaryLater!=null){
            this.adjustWageSalaryLater = adjustWageSalaryLater*100;
        }else{
            this.adjustWageSalaryLater =null;
        }
    }

    public void setAdjustBasicSalaryFront(Integer adjustBasicSalaryFront) {
        this.adjustBasicSalaryFront = adjustBasicSalaryFront*100;
        if(adjustBasicSalaryFront!=null){
            this.adjustBasicSalaryFront = adjustBasicSalaryFront*100;
        }else{
            this.adjustBasicSalaryFront =null;
        }
    }

    public void setAdjustBasicSalaryLater(Integer adjustBasicSalaryLater) {
        this.adjustBasicSalaryLater = adjustBasicSalaryLater*100;
        if(adjustBasicSalaryLater!=null){
            this.adjustBasicSalaryLater = adjustBasicSalaryLater*100;
        }else{
            this.adjustBasicSalaryLater =null;
        }
    }

    public void setAdjustBasicSalaryTypeFront(Integer adjustBasicSalaryTypeFront) {
        this.adjustBasicSalaryTypeFront = adjustBasicSalaryTypeFront*100;
        if(adjustBasicSalaryTypeFront!=null){
            this.adjustBasicSalaryTypeFront = adjustBasicSalaryTypeFront*100;
        }else{
            this.adjustBasicSalaryTypeFront =null;
        }
    }

    public void setAdjustBasicSalaryTypeLater(Integer adjustBasicSalaryTypeLater) {
        this.adjustBasicSalaryTypeLater = adjustBasicSalaryTypeLater*100;
        if(adjustBasicSalaryTypeLater!=null){
            this.adjustBasicSalaryTypeLater = adjustBasicSalaryTypeLater*100;
        }else{
            this.adjustBasicSalaryTypeLater =null;
        }
    }
}