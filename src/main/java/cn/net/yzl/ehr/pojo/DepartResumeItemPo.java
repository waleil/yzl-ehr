package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class DepartResumeItemPo {
    @ApiModelProperty(value = "面试流程id")
    @NotNull
    @Min(0)
    private Integer resumeId;

    @ApiModelProperty(value = "更改人id")
    @NotBlank
    private String updator;


    private ValidList<DepartResumeInsertPo> insertList;

    private ValidList<DepartResumeUpdatePo> updateList;

    private ValidList<DepartResumeDeletePo> deleteList;
}
