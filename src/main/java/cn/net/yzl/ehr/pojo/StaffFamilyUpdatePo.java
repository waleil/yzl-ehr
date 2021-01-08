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
    @NotBlank
    private String staffNo;

    @ApiModelProperty("家庭成员姓名")
    @NotBlank
    private String name;

    @ApiModelProperty("与员工的关系")
    @NotBlank
    private String relation;

    @ApiModelProperty("家庭成员的工作单位/职务")
    @NotBlank
    private String workUnit;

    @ApiModelProperty("家庭成员的联系电话")
    @NotBlank
    private String phone;

    @ApiModelProperty("修改人")
    @NotBlank
    private String updator;



}