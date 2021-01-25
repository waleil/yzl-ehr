package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ApiModelProperty("调整前岗位")
    private Integer adjustPostFront;

    @ApiModelProperty("调整前岗位名")
    private String adjustPostNameFront;

    @ApiModelProperty("调整后岗位")
    private Integer adjustPostLater;

    @ApiModelProperty("调整后岗位名")
    private String adjustPostNameLater;

    @ApiModelProperty("调整前薪资")
    private Double adjustSalaryFront;

    @ApiModelProperty("调整后薪资")
    private Double adjustSalaryLater;

    @ApiModelProperty("异动时间")
    private Date abnorTime;

    @ApiModelProperty("转正时间")
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




}