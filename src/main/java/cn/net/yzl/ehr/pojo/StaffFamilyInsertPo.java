package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * staff_family
 * @author 
 */
@Data
public class StaffFamilyInsertPo implements Serializable {


    /**
     *员工表工号
     */
    @ApiModelProperty("员工表工号")
    @NotBlank
    private String staffNo;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")

    private String name;

    /**
     * 关系
     */
    @ApiModelProperty("关系")

    private String relation;

    /**
     * 工作单位/职务
     */
    @ApiModelProperty("工作单位/职务")

    private String workUnit;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")

    private String phone;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",hidden = true)
    private String creator;


    private static final long serialVersionUID = 1L;

}