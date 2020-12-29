package cn.net.yzl.ehr.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class DepartResumeInsertPo implements Serializable {


    @ApiModelProperty(value = "部门id",hidden = true)
    private Integer departId;

    @ApiModelProperty(value ="岗位id",hidden = true)
    private Integer postId;

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

    @ApiModelProperty(value = "创建人编号", required = false,hidden = true)
    private String creator;


    private static final long serialVersionUID = 1L;

}

