package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class StaffTrainDto implements Serializable {

    @ApiModelProperty("员工工号")
    private String staffNo;

    @ApiModelProperty("员工姓名")
    private String staffName;

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
    private Integer adjustParentDepartFront;

    @ApiModelProperty("调整前上级部门名")
    private String adjustParentDepartNameFront;

    @ApiModelProperty("调整后上级部门")
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

    @ApiModelProperty("异动时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date abnorTime;

    @ApiModelProperty("调整前岗位等级")
    private String adjustPostLevelFront;

    @ApiModelProperty("调整前岗位等级名")
    private String adjustPostLevelNameFront;

    @ApiModelProperty("调整后岗位等级")
    private String adjustPostLevelLater;

    @ApiModelProperty("调整后岗位等级名")
    private String adjustPostLevelNameLater;

    @ApiModelProperty("转正时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date positive_time;

    @ApiModelProperty("商品编码")
    private String productCode;

    @ApiModelProperty("培训课程名称")
    private String  courseName;

    @ApiModelProperty("调整人")
    private String creator;

    @ApiModelProperty("调整人姓名")
    private String creatorName;
}
