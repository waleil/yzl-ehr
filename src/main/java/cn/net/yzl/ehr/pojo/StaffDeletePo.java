package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * staff_family
 * @author 
 */
@Data
public class StaffDeletePo implements Serializable {
    @ApiModelProperty("id 唯一标识")
    @NotNull
    @Min(1)
    private Integer id;


    @ApiModelProperty("修改人")

    private String updator;

}