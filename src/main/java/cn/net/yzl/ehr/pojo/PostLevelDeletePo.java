package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostLevelDeletePo {

    @ApiModelProperty("岗位等级编号")
    @NotNull
    @Min(value = 0)
    private Integer id;

    @ApiModelProperty(value="更改人",hidden=true)
    private String updator;
}
