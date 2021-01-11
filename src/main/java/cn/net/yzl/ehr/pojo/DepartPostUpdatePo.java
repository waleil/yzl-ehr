package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_post
 * @author 
 */
@Data
public class DepartPostUpdatePo implements Serializable {
    @ApiModelProperty("id")
    @NotNull
    @Min(0)
    private Integer id;

    @ApiModelProperty("岗位id")
    @NotNull
    @Min(0)
    private Integer postId;

    @ApiModelProperty("属性code(指向字典表,post_attr)")
    @NotNull
    @Min(0)
    private Integer attrCode;

    @ApiModelProperty("编制人数")
    @Min(0)
    private Integer staffNum;

    @ApiModelProperty("岗位职责")
    @NotBlank
    private String duty;

    @ApiModelProperty(value = "在岗人数",hidden = true)
    private Integer jobNum;

    @ApiModelProperty("需要确认入岗：0.不需要,1.需要")
    @NotNull
    @Min(0)
    private Integer confirmFlag;

    @ApiModelProperty("工资计算标识：0.入职计算1.入岗计算")
    @NotNull
    @Min(0)
    private Integer salarySign;

    @ApiModelProperty(value = "更新人唯一标识",hidden = true)
    private String updator;

    @ApiModelProperty("父id")
    @NotNull
    @Min(0)
    private Integer pid;

    @ApiModelProperty("排序")
    @Min(0)
    private Integer sort;

    @ApiModelProperty(value = "层级",hidden = true)
    private Integer level;

    private static final long serialVersionUID = 1L;


}