package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * depart
 * @author 
 */
@Data
@ApiModel(value = "DepartVO", description = "创建部门实体信息")
public class DepartVO implements Serializable {

    @NotBlank()
    @ApiModelProperty(value = "部门名称", name = "name",required = true)
    private String name;

    @Min(value = 1)
    @ApiModelProperty(value = "父id", name = "pid",required = true)
    private Integer pid;
    @ApiModelProperty(value = "负责人工号", name = "leaderNo")
    private String leaderNo;
    @Min(value = 1)
    @ApiModelProperty(value = "财务归属部门id", name = "financeDepartId")
    private Integer financeDepartId;
    @ApiModelProperty(value = "描述", name = "desc")
    private String desc;
    @ApiModelProperty(value = "创建人id", name = "creator",hidden = true)
    private String creator;

}