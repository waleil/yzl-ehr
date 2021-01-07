package cn.net.yzl.ehr.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class DepartResumeInsertPo implements Serializable {


    @ApiModelProperty(value = "配置id",hidden = true)
    private Integer resumeId;

    @ApiModelProperty("此轮名称")
    @NotBlank
    private String stepName;

    @ApiModelProperty("面试人id")
    @NotBlank
    private String leaderNo;


    @ApiModelProperty("顺序序号")
    @NotNull
    @Min(1)
    private Integer sortNo;

    @ApiModelProperty(value = "创建人唯一标识",hidden = true)
    private String creator;


    private static final long serialVersionUID = 1L;

}

