package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "员工加入人才储备池状态", description = "员工加入人才储备池状态")
@Data
public class StaffSwitchTalentPoolPo implements Serializable {

    @ApiModelProperty("员工编号")
    @NotBlank
    private String staffNo;

    @ApiModelProperty("是否加入储备人才池 0.未加入 1.已加入")
    @NotNull
    @Min(0)
    @Max(1)
    private Integer state;

    @ApiModelProperty(value = "修改人",hidden = true)
    private String updator;
}
