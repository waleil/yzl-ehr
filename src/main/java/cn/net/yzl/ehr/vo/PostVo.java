package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * post
 * @author 
 */
@ApiModel
@Data
public class PostVo implements Serializable {

    /**
     * 岗位名称
     */
    @ApiModelProperty(value ="name",name="岗位名称",required = true)
    @NotBlank
    private String name;

    /**
     * 部门id
     */
    @ApiModelProperty(value ="departId",name="部门编号",required = true)
    @NotNull
    @Min(1)
    private Integer departId;

    /**
     * 属性code(指向字典表,post_attribute)
     */
    @ApiModelProperty(value ="attrCode",name="岗位属性编码",required = true)
    @NotNull
    @Min(1)
    private Integer attrCode;

    /**
     * 编制人数
     */
    @ApiModelProperty(value ="staffNum",name="岗位编制人数",required = true)
    @Min(1)
    private Integer staffNum;

    /**
     * 岗位职责
     */
    @ApiModelProperty(value ="duty",name="岗位职责",required = true)
    private String duty;

    /**
     * 创建人唯一标识
     */
    @ApiModelProperty(value ="creator",name="创建人编号",required = true)
    @NotNull
    private String creator;

    private static final long serialVersionUID = 1L;
}