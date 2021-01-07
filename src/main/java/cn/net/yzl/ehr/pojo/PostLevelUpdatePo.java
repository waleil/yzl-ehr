package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * post_level
 * @author 
 */
@Valid
@Data
public class PostLevelUpdatePo implements Serializable {

    @ApiModelProperty("岗位等级编号")
    @NotNull
    @Min(value = 0)
    private Integer id;

    @ApiModelProperty("级别名称")
    @NotBlank
    private String name;

    @ApiModelProperty("更新人唯一标识")
    @NotBlank
    private String updator;

    private static final long serialVersionUID = 1L;
}