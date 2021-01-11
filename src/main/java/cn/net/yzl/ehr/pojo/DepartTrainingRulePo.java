package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * depart_training_rule
 * @author 
 */
@Data
public class DepartTrainingRulePo implements Serializable {
    private Integer id;

    @ApiModelProperty("部门id")
    @NotNull
    @Min(0)
    private Integer departId;

    @ApiModelProperty("岗位id")
    @NotNull
    @Min(0)
    private Integer postId;

    @ApiModelProperty("培训方式(1:线下,2,线上)")
    @NotNull
    @Min(0)
    private int way;

    @ApiModelProperty("培训标识(0:不培训,1:培训)")
    @NotNull
    @Min(0)
    private int trainingFlag;

    @ApiModelProperty("是否考试(0:否,1:是)")
    @NotNull
    @Min(0)
    private int examFlag;

    @ApiModelProperty("状态:0:未删除,1:删除")
    @NotNull
    @Min(0)
    private int isDel;


    @ApiModelProperty(value = "创建人唯一标识",hidden = true)
    private String creator;


    @ApiModelProperty(value ="更新人唯一标识",hidden = true)
    private String updator;


    private static final long serialVersionUID = 1L;

    private List<DepartTrainingRuleCwPo> coursewareId;
}