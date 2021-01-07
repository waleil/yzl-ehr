package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * depart_post
 * @author 
 */
@Data
public class DepartPostDto implements Serializable {

    @ApiModelProperty("部门岗位id")
    private Integer id;

    @ApiModelProperty("部门id")
    private Integer departId;
    @ApiModelProperty("部门名称")
    private String departName;

    @ApiModelProperty("岗位id")
    private Integer postId;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("父岗位id")
    private Integer pid;

    @ApiModelProperty("父岗位名称")
    private String pname;

    @ApiModelProperty("属性code(指向字典表,post_attr)")
    private Integer attrCode;

    @ApiModelProperty("属性code(指向字典表,post_attr)")
    private String attrName;

    @ApiModelProperty("是否需要入岗确认,0.不需要,1.需要")
    private Integer confirmFlag;

    @ApiModelProperty("工资计算标识:0.入职计算,1.入岗计算")
    private Integer salarySign;

    @ApiModelProperty("工资计算标识方式")
    private String salaryName;

    @ApiModelProperty("编制人数")
    private Integer staffNum;

    @ApiModelProperty("岗位职责")
    private String duty;

    @ApiModelProperty("在岗人数")
    private Integer jobNum;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty(value = "层级",hidden = true)
    private Integer level;

    private static final long serialVersionUID = 1L;


}