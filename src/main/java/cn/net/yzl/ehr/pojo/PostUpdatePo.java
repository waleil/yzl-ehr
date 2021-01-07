package cn.net.yzl.ehr.pojo;

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

@Data
public class PostUpdatePo implements Serializable {

    @ApiModelProperty("岗位编号")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty("岗位名称")
    @NotBlank
    private String name;

    @ApiModelProperty("顺序排序")
    @NotNull
    @Min(1)
    private Integer sortNo;

    @ApiModelProperty("更改人")
    @NotBlank
    private String updator;

    private static final long serialVersionUID = 1L;

}