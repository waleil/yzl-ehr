package cn.net.yzl.ehr.pojo;


import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public  class DepartResumeUpdatePo implements Serializable {
    @ApiModelProperty("id")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty("此轮名称")
    @NotBlank
    private String stepId;

    @ApiModelProperty("面试人id")
    @NotBlank
    private String leaderNo;


    @ApiModelProperty("顺序序号")
    @NotNull
    @Min(0)
    private Integer sortNo;


    @ApiModelProperty(value = "更新人唯一标识",hidden = true)
    private String updator;

    private ValidList<DepartResumeNodeStaffPo> departResumeNodeStaffList;

    private static final long serialVersionUID = 1L;

}
