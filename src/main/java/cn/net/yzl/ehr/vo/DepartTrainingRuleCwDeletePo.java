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
public class DepartTrainingRuleCwDeletePo implements Serializable {

    @ApiModelProperty(value = "培训课件关联id")
    @NotNull
    @Min(0)
    private Integer coursewareId;

    @ApiModelProperty(value = "更改人",hidden = true)
    private String updator;


    private static final long serialVersionUID = 1L;


}