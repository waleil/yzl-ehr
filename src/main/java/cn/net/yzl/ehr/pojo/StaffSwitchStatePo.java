package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "员工异动状态", description = "员工异动状态")
@Data
public class StaffSwitchStatePo implements Serializable {

    @ApiModelProperty("员工编号")
    @NotBlank
    private String staffNo;

    @ApiModelProperty("异动状态 20.正常 21.待优化 22.待劝退")
    @NotNull
    @Min(0)
    private Integer state;

    @ApiModelProperty(value = "修改人",hidden = true)
    private String updator;
}
