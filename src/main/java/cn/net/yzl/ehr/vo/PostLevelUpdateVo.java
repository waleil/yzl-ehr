package cn.net.yzl.ehr.vo;

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
@Data
public class PostLevelUpdateVo implements Serializable {

    @ApiModelProperty(value ="id",name="岗位级别编号",required = true)
    @NotNull
    @Min(1)
    private Integer id;

    /**
     * 岗位编号
     */
    @ApiModelProperty(value ="postId",name="岗位编号",required = true)
    @NotNull
    private Integer postId;

    /**
     * 级别名称
     */
    @ApiModelProperty(value ="name",name="岗位级别名称",required = true)
    @NotBlank
    private String name;


    /**
     * 更新人唯一标识
     */
    @ApiModelProperty(value ="updator",name="更新人编号",required = true)
    @NotBlank
    private String updator;

    private static final long serialVersionUID = 1L;
}