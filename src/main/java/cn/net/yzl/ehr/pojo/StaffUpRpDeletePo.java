package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * staff_up_rp
 * @author 
 */
@Data
public class StaffUpRpDeletePo implements Serializable {

    /**
     * id 唯一标识
     */
    @ApiModelProperty(value = "id 唯一标识")
    @NotNull
    @Min(1)
    private Integer id;


    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人",hidden = true)
    @NotBlank
    private String updator;
}