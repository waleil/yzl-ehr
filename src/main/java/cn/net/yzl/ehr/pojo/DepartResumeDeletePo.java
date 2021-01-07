package cn.net.yzl.ehr.pojo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public  class DepartResumeDeletePo implements Serializable {

    @ApiModelProperty(value = "面试流程节点id",hidden = true)
    @NotNull
    @Min(1)
    private Integer id;



    @ApiModelProperty(value = "更新人唯一标识",hidden = true)
    private String updator;




    private static final long serialVersionUID = 1L;

}

