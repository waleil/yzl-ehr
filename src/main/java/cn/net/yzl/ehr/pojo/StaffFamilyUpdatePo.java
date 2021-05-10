package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * staff_family
 * @author 
 */
@Data
public class StaffFamilyUpdatePo implements Serializable {

    @ApiModelProperty("家庭信息唯一标识")
    @NotNull
    @Min(1)
    private Integer id;

    @ApiModelProperty("员工工号")

    private String staffNo;

    @ApiModelProperty("家庭成员姓名")

    private String name;

    @ApiModelProperty("与员工的关系")

    private String relation;

    @ApiModelProperty("家庭成员的工作单位/职务")

    private String workUnit;

    @ApiModelProperty("家庭成员的联系电话")

    private String phone;

    @ApiModelProperty(value = "修改人",hidden = true)
    private String updator;



}