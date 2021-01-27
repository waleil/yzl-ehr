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
    @NotBlank
    private String content;

    @ApiModelProperty("调整前部门")
    @NotNull
    @Min(1)
    private Integer adjustDepartFront;

    @ApiModelProperty("调整前部门名")
    @NotBlank
    private String adjustDepartNameFront;

    @ApiModelProperty("调整后部门")
    private Integer adjustDepartLater;

    @ApiModelProperty("调整后部门名")
    private String adjustDepartNameLater;

    @ApiModelProperty("调整前岗位")
    @NotNull
    @Min(0)
    private Integer adjustPostFront;

    @ApiModelProperty("调整前岗位名")
    @NotBlank
    private String adjustPostNameFront;

    @ApiModelProperty("调整后岗位")
    private Integer adjustPostLater;

    @ApiModelProperty("调整后岗位名")
    private String adjustPostNameLater;

    @ApiModelProperty("调整前薪资")
    @NotNull
    @Min(0)
    private Double adjustSalaryFront;

    @ApiModelProperty("调整后薪资")
    private Double adjustSalaryLater;

    @ApiModelProperty("异动时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotBlank
    private String abnorTime;
    /*@ApiModelProperty("异动时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date abnorTime;*/

    @ApiModelProperty("创建人")
    @NotBlank
    private String creator;

    /*@ApiModelProperty(value="修改人",hidden = true)
    private String updator;

    @ApiModelProperty(value = "是否删除 0正常 1删除",hidden = true)
    private Integer isDel;*/


}