package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_attend_ft
 * @author 
 */
@Data
@Valid
@ApiModel(value = "DepartAttendFtPo", description = "部门假勤类型")
public class DepartAttendFtPo implements Serializable {

    @ApiModelProperty(value = "假勤类型id", name = "id")
    @NotNull
    @Min(0)
    private Integer id;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id", name = "departId")
    @NotNull
    @Min(0)
    private Integer departId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", name = "name")
    @NotBlank
    private String name;

    /**
     * 勾选标识(1:勾选,0:没有勾选)
     */
    @ApiModelProperty(value = "勾选标识(0:没有勾选,1:勾选)", name = "checkFlag")
    @NotNull
    @Min(0)
    @Max(1)
    private Byte checkFlag;

    /**
     * 状态:0:有效,1:删除
     */
    @ApiModelProperty(value = "状态(0:有效,1:删除)", name = "isDel")
    @NotNull
    @Min(0)
    @Max(1)
    private Byte isDel;

    private static final long serialVersionUID = 1L;

}