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

    @ApiModelProperty("账号状态 0正常 1停用")
    @NotNull
    @Min(0)
    private Integer state;

    @ApiModelProperty(value = "修改人",hidden = true)
    private String updator;
}
