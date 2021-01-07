package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 面试流程表
 * 
 * @author：yangxf
 * @date： 2021-01-04 16:49:36
 */
@Data
public class DepartResumePo implements Serializable {
    @ApiModelProperty(value = "id",hidden = true)
    private Integer id;

    @ApiModelProperty("部门id")
    @NotNull
    @Min(0)
    private Integer departId;

    @ApiModelProperty("岗位id")
    @NotNull
    @Min(0)
    private Integer postId;

    @ApiModelProperty("创建人唯一标识")
    @NotBlank
    private String creator;

    @Valid
    private List<DepartResumeInsertPo> insertPo;
}