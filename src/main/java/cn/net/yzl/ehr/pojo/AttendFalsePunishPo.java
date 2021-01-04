package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * attend_false_punish
 * @author 
 */
@Data
@Valid
@ApiModel(value = "AttendFalsePunishPo", description = "部门假勤配置惩罚规则实体对象")
public class AttendFalsePunishPo implements Serializable {

    @ApiModelProperty(value = "假勤配置惩罚规则id", name = "id")
    @NotNull
    @Min(0)
    private Integer id;

    /**
     * 惩罚方式：1.按旷工处理 2.扣日薪
     */
    @ApiModelProperty(value = "惩罚方式：1.按旷工处理 2.扣日薪", name = "type")
    @NotNull
    @Min(1)
    @Max(2)
    private Integer type;

    /**
     * 扣日薪比例
     */
    @ApiModelProperty(value = "扣日薪比例", name = "rate")
    private Double rate;

    /**
     * 惩罚方式名称
     */
    @NotEmpty
    @NotNull
    @ApiModelProperty(value = "惩罚方式名称",name = "name")
    private String name;

    /**
     * 删除标志（0.未删除1.已删除）
     */
    @ApiModelProperty(value = "删除标志（0.未删除1.已删除）", name = "isDel")
    @NotNull
    @Min(0)
    @Max(1)
    private Integer isDel;



    private static final long serialVersionUID = 1L;
}