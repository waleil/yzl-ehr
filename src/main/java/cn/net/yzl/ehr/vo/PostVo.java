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
@ApiModel(value = "PostVo", description = "创建岗位")
@Data
public class PostVo implements Serializable {

    /**
     * 岗位名称
     */
    @ApiModelProperty(name ="name",value ="岗位名称",required = true)
    @NotBlank
    private String name;

    /**
     * 部门id
     */
    @ApiModelProperty(name ="departId",value ="部门编号",required = true)
    @NotNull
    @Min(1)
    private Integer departId;

    /**
     * 属性code(指向字典表,post_attribute)
     */
    @ApiModelProperty(name ="attrCode",value ="岗位属性编码",required = true)
    @NotNull
    @Min(1)
    private Integer attrCode;

    /**
     * 编制人数
     */
    @ApiModelProperty(name ="staffNum",value ="岗位编制人数",required = true)
    @Min(1)
    private Integer staffNum;

    /**
     * 岗位职责
     */
    @ApiModelProperty(name ="duty",value ="岗位职责",required = true)
    private String duty;

    /**
     * 创建人唯一标识
     */
    @ApiModelProperty(name ="creator",value ="创建人编号",hidden = true)
    @NotNull
    private String creator;

    private static final long serialVersionUID = 1L;
}