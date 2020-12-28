package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * post_level
 * @author 
 */
@ApiModel
@Data
public class PostLevelVo implements Serializable {
    /**
     * 岗位编号
     */
    @ApiModelProperty(name="postId",value="岗位编号",required = true)
    @NotNull
    private Integer postId;

    /**
     * 级别名称
     */
    @ApiModelProperty(name="name",value="级别名称",required = true)
    @NotBlank
    private String name;

    /**
     * 创建人唯一标识
     */
    @ApiModelProperty(name="creator",value="创建人编号",hidden = true)
    @NotBlank
    private String creator;

    private static final long serialVersionUID = 1L;
}