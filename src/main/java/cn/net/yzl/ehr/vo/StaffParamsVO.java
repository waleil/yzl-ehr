package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "StaffParamsVO", description = "员工对象参数")
public class StaffParamsVO implements Serializable {

    @ApiModelProperty(value = "当前登录的用户工号", name = "staffNo")
    private String staffNo;
    @ApiModelProperty(value = "姓名或者工号", name = "params")
    private String  params;
    @ApiModelProperty(value = "工作地点code", name = "workplaceCode")
    private Integer workplaceCode;
    @ApiModelProperty(value = "部门id", name = "departId")
    private Integer departId;
    @ApiModelProperty(value = "部门ids集合", name = "departIds")
    private List<Integer> departIds;
    @ApiModelProperty(value = "岗位id", name = "postId")
    private Integer postId;
    @ApiModelProperty(value = "部门岗位id", name = "departPostId")
    private Integer departPostId;
    @ApiModelProperty(value = "属性(1:正编,2:外包)", name = "nature")
    private Integer nature;

    @ApiModelProperty(value = "合作方(字典type=partner)", name = "nature")
    private Integer partnerCode;

    @ApiModelProperty(value = "职场(字典type=workplace)", name = "nature")
    private Integer workCode;

    @ApiModelProperty(value = "补全状态", name = "isComplete")
    private Integer isComplete;

    @ApiModelProperty(value = "1:标识crm,2:(非部门负责人则全量)", name = "isComplete",hidden = true)
    private Integer flag;

    @ApiModelProperty(value = "在职状态(字典type=post_status)", name = "postStatusCode")
    private Integer postStatusCode;
    @ApiModelProperty(value = "在职标识(0.离职,1.在职)", name = "workStatusCode")
    private Integer workStatusCode;
    @ApiModelProperty(value = "入岗状态(字典type=post_state)", name = "enterStatus")
    private Integer enterStatus;
    @ApiModelProperty(value = "异动状态(20.正常,21.待优化,22.待劝退)", name = "abnoStatusCode")
    private Integer abnoStatusCode;
    @ApiModelProperty(value = "是否加入人才池(0否 1是)", name = "reserveTalent")
    @Min(0)
    @Max(1)
    private Integer reserveTalent;
    @ApiModelProperty("是否加入黑名单 0.不加入 1.加入")
    @Min(0)
    @Max(1)
    private Integer onBlackList;
    @ApiModelProperty(value = "页数", name = "pageNo",required = true)
    @Min(1)
    Integer pageNo;
    @ApiModelProperty(value = "每页条数", name = "pageSize",required = true)
    @Min(10)
    Integer pageSize;

    @ApiModelProperty(value = "业务属性", name = "attrCode")
    private Integer attrCode;

}
