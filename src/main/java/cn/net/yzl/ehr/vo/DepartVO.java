package cn.net.yzl.ehr.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="DepartDto",description="部门信息实体")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartVO implements Serializable {
    @ApiModelProperty(value="部门名称",name="name")
    @NotBlank(message = "部门名称不能为空!")
    private String name;
    @ApiModelProperty(value="父id(顶级目录为0)",name="pId")
    @NotNull(message = "部门的父id不能为null!")
    @Min(value = 0)
    private Integer pId;
    @ApiModelProperty(value="编制人数",name="staffNum")
    private Integer staffNum;
    @ApiModelProperty(value="部门人数",name="num")
    private Integer num;
    @ApiModelProperty(value="负责人id",name="leaderId")
    @Min(value = 0)
    @NotBlank(message = "部门负责人id不能为null!")
    private Integer leaderId;
    @ApiModelProperty(value="负责人名称",name="leadName")
    private String leaderName;
    @ApiModelProperty(value="描述",name="desc")
    private String desc;
    @ApiModelProperty(value="排序(1,2,3.....)",name="order")
    @NotNull(message = "部门的排序不能为null!")
    @Min(value = 0)
    private Integer order;
}
