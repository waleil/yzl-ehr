package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_training_rule_cw
 * @author 
 */

@Data
public class DepartTrainingRuleCwPo implements Serializable {

    @ApiModelProperty(value = "培训规则编号",hidden = true)
    private Integer trainingRuleId;

    @ApiModelProperty("课件表编号")
    @NotNull
    @Min(1)
    private Integer coursewareId;

    @ApiModelProperty(value = "创建人编号",hidden = true)
    private String creator;

    private static final long serialVersionUID = 1L;


}