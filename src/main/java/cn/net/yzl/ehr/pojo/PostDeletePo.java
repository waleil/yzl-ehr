package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class PostDeletePo {

    @ApiModelProperty("岗位编号")
    @NotNull
    @Min(0)
    private Integer id;

    @ApiModelProperty(value = "更改人",hidden = true)
    private String updator;
}
