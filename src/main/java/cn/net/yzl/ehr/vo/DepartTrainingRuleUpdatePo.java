package cn.net.yzl.ehr.vo;

import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_training_rule
 * @author 
 */

@Data
public class DepartTrainingRuleUpdatePo implements Serializable {
    @ApiModelProperty("培训配置id")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty("岗位id")
    @NotNull
    @Min(1)
    private Integer postId;

    @ApiModelProperty("培训方式(0线上 1线下)")
    @NotNull
    @Min(1)
    private Integer way;

    @ApiModelProperty("培训标识(0:不培训,1:培训)")
    @NotNull
    @Min(0)
    private Integer trainingFlag;

    @ApiModelProperty("是否考试(0:否,1:是)")
    @NotNull
    @Min(0)
    private Integer examFlag;

    @ApiModelProperty(value = "更新人编号",hidden = true)
    private String updator;

    @Valid
    private ValidList<DepartTrainingRuleCwPo> insertList;
    @Valid
    private ValidList<DepartTrainingRuleCwDeletePo> deleteList;

    private static final long serialVersionUID = 1L;


}