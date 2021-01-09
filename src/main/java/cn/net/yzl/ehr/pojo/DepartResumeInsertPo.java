package cn.net.yzl.ehr.pojo;


import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class DepartResumeInsertPo implements Serializable {

    @ApiModelProperty(value = "配置节点id",hidden = true)
    private Integer id;

    @ApiModelProperty(value = "配置id",hidden = true)
    private Integer resumeId;

    @ApiModelProperty("此轮名称")
    @NotBlank
    private String stepId;

    @ApiModelProperty(value = "面试人id",hidden = true)
    @NotBlank
    private String leaderNo;


    @ApiModelProperty("顺序序号")
    @NotNull
    @Min(1)
    private Integer sortNo;

    @ApiModelProperty(value = "创建人唯一标识",hidden = true)
    private String creator;

    private ValidList<DepartResumeNodeStaffPo> departResumeNodeStaffList;

    private static final long serialVersionUID = 1L;

}

