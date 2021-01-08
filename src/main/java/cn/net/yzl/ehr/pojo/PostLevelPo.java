package cn.net.yzl.ehr.pojo;

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
public class PostLevelPo implements Serializable {

    @ApiModelProperty("岗位编号")
    @NotNull
    @Min(0)
    private Integer postId;

    @ApiModelProperty("级别名称")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "创建人唯一标识",hidden = true)
    private String creator;
//

    private static final long serialVersionUID = 1L;
}