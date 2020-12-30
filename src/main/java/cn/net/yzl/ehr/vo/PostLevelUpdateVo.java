package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * post_level
 * @author 
 */
@ApiModel
@Data
public class PostLevelUpdateVo implements Serializable {

    @ApiModelProperty(name ="id",value ="岗位级别编号",required = true)
    @NotNull
    @Min(1)
    private Integer id;

    /**
     * 岗位编号
     */
    @ApiModelProperty(name ="postId",value ="岗位编号",required = true)
    @NotNull
    private Integer postId;

    /**
     * 级别名称
     */
    @ApiModelProperty(name ="name",value ="岗位级别名称",required = true)
    @NotBlank
    private String name;


    /**
     * 更新人唯一标识
     */
    @ApiModelProperty(name ="updator",value ="更新人编号",required = true)
    @NotBlank
    private String updator;

    @ApiModelProperty(value = "排序(1,2,3.....)", name = "order")
    private Integer order;

    private static final long serialVersionUID = 1L;
}