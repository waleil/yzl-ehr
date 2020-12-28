package cn.net.yzl.ehr.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public  class DepartResumeUpdatePo implements Serializable {
    @ApiModelProperty("面试轮次id")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty("部门id")
    @NotNull
    @Min(1)
    private Integer departId;

    @ApiModelProperty("岗位id")
    @NotNull
    @Min(1)
    private Integer postId;

    @ApiModelProperty("此轮名称")
    @NotBlank
    private String stepName;

    @ApiModelProperty("面试人id")
    @NotBlank
    private String leaderNo;


    @ApiModelProperty("顺序序号")
    @NotNull
    @Min(0)
    private Integer sortNo;


    @ApiModelProperty("更新人唯一标识")
    @NotBlank
    private String updator;

    private static final long serialVersionUID = 1L;

}
