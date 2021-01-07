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
public class DepartPostPo implements Serializable {

    @ApiModelProperty(value = "id",hidden = true)
    private Integer id;

    @ApiModelProperty("部门id")
    @NotNull
    @Min(0)
    private Integer departId;

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
    private String duty;

    @ApiModelProperty(value="在岗人数",hidden = true)
    @Min(0)
    private Integer jobNum;

    @ApiModelProperty("需要确认入岗：0.不需要,1.需要")
    @NotNull
    @Min(0)
    private Integer confirmFlag;

    @ApiModelProperty("工资计算标识：0.入职计算1.入岗计算")
    @NotNull
    @Min(0)
    private Integer salarySign;


    @ApiModelProperty("创建人")
    @NotBlank
    private String creator;

    @ApiModelProperty("父id")
    @NotNull
    private Integer pid;

    @ApiModelProperty("排序")
    @NotNull
    @Min(0)
    private Integer sort;

    @ApiModelProperty(value = "层级",hidden = true)
    private Integer level;

    private static final long serialVersionUID = 1L;


}