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
public class PostUpdateVo implements Serializable {

    @ApiModelProperty(value ="id",name="岗位编号",required = true)
    @NotNull
    @Min(1)
    private Integer id;

    /**
     * 岗位名称
     */
    @ApiModelProperty(value ="name",name="岗位名称",required = true)
    @NotBlank
    private String name;

    /**
     * 属性code(指向字典表,post_attribute)
     */
    @ApiModelProperty(value ="attrCode",name="岗位属性编码",required = true)
    @NotNull
    @Min(0)
    private Integer attrCode;

    /**
     * 编制人数
     */
    @ApiModelProperty(value ="staffNum",name="编制人数",required = true)
    private Integer staffNum;

    /**
     * 岗位职责
     */
    @ApiModelProperty(value ="duty",name="岗位职责",required = true)
    private String duty;

    /**
     * 更新人唯一标识
     */
    @ApiModelProperty(value ="updator",name="更改人编号",required = true)
    @NotBlank
    private String updator;

    private static final long serialVersionUID = 1L;
}