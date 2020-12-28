package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 岗位表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:39:11
 */
@Data
public class PostDto implements Serializable {
    @ApiModelProperty(value = "岗位id", name = "id")
    private Integer id;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称", name = "name")
    private String name;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门编号", name = "departId")
    private Integer departId;
    
    @ApiModelProperty(value = "部门名称", name = "departName")
    private String departName;
    /**
     * 属性code(指向字典表,post_attribute)
     */
    @ApiModelProperty(value = "岗位属性编号", name = "attrCode")
    private Integer attrCode;

    @ApiModelProperty(value = "岗位属性名称", name = "attrName")
    private String attrName;
    /**
     * 编制人数
     */
    @ApiModelProperty(value = "编制人数", name = "staffNum")
    private Integer staffNum;

    /**
     * 岗位职责
     */
    @ApiModelProperty(value = "岗位职责", name = "duty")
    private String duty;

    /**
     * 在岗人数
     */
    @ApiModelProperty(value = "在岗人数", name = "jobNum")
    private Integer jobNum;



}