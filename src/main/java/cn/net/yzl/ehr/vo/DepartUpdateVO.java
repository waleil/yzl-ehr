package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart
 * @author 
 */
@Data
@ApiModel(value = "DepartUpdateVO", description = "更新部门实体信息")
public class DepartUpdateVO implements Serializable {

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称", name = "name")
    private String name;


    @Min(value = 1)
    @ApiModelProperty(value = "部门id", name = "id",required = true)
    private Integer id;

    @ApiModelProperty(value = "负责人工号", name = "leaderNo")
    private String leaderNo;
    @ApiModelProperty(value = "财务归属部门地", name = "financeDepartId")
    private Integer financeDepartId;
    @ApiModelProperty(value = "描述", name = "desc")
    private String desc;
    @ApiModelProperty(value = "更新人", name = "updator",hidden = true)
    private String updator;




}