package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * staff_family
 * @author 
 */
@Valid
@Data
public class StaffWorkDeletePo implements Serializable {
    /**
     * id 唯一标识
     */
    @ApiModelProperty(value = "员工工作记录id")
    @NotNull
    @Min(1)
    private Integer id;


    /**
     * 修改人
     */
    @ApiModelProperty(value = "更改操作人",hidden=true)
    private String updator;

}