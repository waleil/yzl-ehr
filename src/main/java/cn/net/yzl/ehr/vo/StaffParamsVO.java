package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@ApiModel(value = "StaffParamsVO", description = "员工对象参数")
public class StaffParamsVO implements Serializable {

    @ApiModelProperty(value = "姓名或者工号", name = "params")
    private String  params;

    @ApiModelProperty(value = "工作地点code", name = "workplaceCode")
    private Integer workplaceCode;
    @ApiModelProperty(value = "部门id", name = "departId")
    private Integer departId;
    @ApiModelProperty(value = "岗位id", name = "postId")
    private Integer postId;
    @ApiModelProperty(value = "属性(1:正编,2:外包)", name = "nature")
    private Integer nature;
    @ApiModelProperty(value = "在岗状态", name = "postStatusCode")
    private Integer postStatusCode;
    @ApiModelProperty(value = "页数", name = "pageNo",required = true)
    @Min(1)
    Integer pageNo;
    @ApiModelProperty(value = "每页条数", name = "pageSize",required = true)
    @Min(10)
    Integer pageSize;

}
