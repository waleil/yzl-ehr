package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_training_rule_cw
 * @author 
 */

@Valid
@Data
public class DepartTrainingRuleCwUpdatePo implements Serializable {
    @ApiModelProperty("课件唯一标识")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty("培训规则编号")
    @NotNull
    @Min(1)
    private Integer trainingRuleId;

    @ApiModelProperty("课件表编号")
    @NotNull
    @Min(1)
    private Integer coursewareId;


    @ApiModelProperty(value = "更改人编号",hidden = true)
    @NotBlank
    private String updator;

    private static final long serialVersionUID = 1L;


}