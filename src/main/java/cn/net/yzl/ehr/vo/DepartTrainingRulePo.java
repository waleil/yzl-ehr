package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * depart_training_rule
 * @author 
 */
@Data
public class DepartTrainingRulePo implements Serializable {

    @ApiModelProperty(value = "id",hidden = true)
    private Integer id;

    @ApiModelProperty("部门id")
    @NotNull
    @Min(1)
    private Integer departId;

    @ApiModelProperty("岗位id")
    @NotNull
    @Min(1)
    private Integer postId;

    @ApiModelProperty("培训方式(1:线下,2,线上)")
    @NotNull
    @Min(1)
    private int way;

    @ApiModelProperty("培训标识(0:不培训,1:培训)")
    @NotNull
    @Min(0)
    private int trainingFlag;

    @ApiModelProperty("是否考试(0:否,1:是)")
    @NotNull
    @Min(0)
    private int examFlag;

    @ApiModelProperty(value = "创建人唯一标识",hidden = true)
    private String creator;



    private static final long serialVersionUID = 1L;

    @Valid
    private List<DepartTrainingRuleCwPo> coursewareList;
}