package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ApiModel(value="DepartDto",description="部门信息实体")
public class DepartDto implements Serializable {
    @ApiModelProperty(value="主键",name="id")
    private Integer id;
    @ApiModelProperty(value="部门名称",name="name")
    private String name;
    @ApiModelProperty(value="父id(顶级目录为0)",name="pId")
    private Integer pId;
    @ApiModelProperty(value="编制人数",name="staffNum")
    private Integer staffNum;
    @ApiModelProperty(value="部门人数",name="num")
    private Integer num;
    @ApiModelProperty(value="负责人id",name="leaderId")
    private Integer leaderId;
    @ApiModelProperty(value="负责人名称",name="leadName")
    private String leaderName;
    @ApiModelProperty(value="描述",name="desc")
    private String desc;
    @ApiModelProperty(value="排序(1,2,3.....)",name="order")
    private Integer order;
    @ApiModelProperty(value="子部门集合",name="childDepartDto")
    private List<DepartDto> childDepartDto;
}
