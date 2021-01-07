package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * depart_attend_rp
 * @author 
 */
@Data
@ApiModel(value = "DepartBusinessAttrVO", description = "部门业务属性实体")
public class DepartBusinessAttrVO implements Serializable {

    @ApiModelProperty(value = "departId", name = "部门id集合",required = true)
    @NotEmpty
    private List<Integer> departId;
    @ApiModelProperty(value = "业务属性code", name = "dictCode",required = true)
    @Min(1)
    @NotNull
    private Integer dictCode;

}