package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DepartResumePageParamPo {

    @ApiModelProperty("当页条数")
    @NotNull
    @Min(0)
    private int pageSize;

    @ApiModelProperty("当前页码")
    @NotNull
    @Min(0)
    private int pageNo;

    @ApiModelProperty("部门id")
    @NotNull
    @Min(0)
    private int departId;

}
