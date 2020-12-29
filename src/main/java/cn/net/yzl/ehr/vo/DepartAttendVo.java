package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "DepartAttendVo", description = "部门假勤类型")
public class DepartAttendVo implements Serializable {

    @ApiModelProperty(value = "假勤类型id", name = "id")
    @NotNull
    @Min(0)
    private Integer id;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id", name = "departId")
    @NotNull
    @Min(0)
    private Integer departId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", name = "name")
    @NotBlank
    private String name;

    /**
     * 勾选标识(1:勾选,0:没有勾选)
     */
    @ApiModelProperty(value = "勾选标识(0:没有勾选,1:勾选)", name = "checkFlag")
    @NotNull
    @Min(0)
    @Max(1)
    private Byte checkFlag;

    /**
     * 工龄左边区间
     */
    @ApiModelProperty(value = "工龄左边区间", name = "workLeft")
    private Integer workLeft;

    /**
     * 工龄右边区间
     */
    @ApiModelProperty(value = "工龄右边区间", name = "workRight")
    private Integer workRight;

    /**
     * 天数
     */
    @ApiModelProperty(value = "天数", name = "days")
    private Integer days;

    /**
     * 超过假期天数
     */
    @ApiModelProperty(value = "超过假期天数", name = "leaveDays")
    private Double leaveDays;

    /**
     * 惩罚方式：1.按旷工处理 2.扣日薪
     */
    @ApiModelProperty(value = "惩罚方式：1.按旷工处理 2.扣日薪", name = "type")
    @NotNull
    @Min(1)
    @Max(2)
    private Byte type;

    /**
     * 扣日薪比例
     */
    @ApiModelProperty(value = "扣日薪比例", name = "rate")
    private Double rate;

}
