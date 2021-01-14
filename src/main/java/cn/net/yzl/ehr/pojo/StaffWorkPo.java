package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;
@Valid
@Data
@ApiModel(value = "StaffWorkPo", description = "员工入职经历信息")
public class StaffWorkPo implements Serializable {

    @ApiModelProperty(value = "员工工号", name = "staffNo")
    private Integer staffNo;
    @ApiModelProperty(value = "起始时间", name = "startTime")
    private Date startTime;
    @ApiModelProperty(value = "结束时间", name = "endTime")
    private Date endTime;
    @ApiModelProperty(value = "单位名称", name = "company")
    private String company;
    @ApiModelProperty(value = "部门", name = "depart")
    private String depart;
    @ApiModelProperty(value = "职务", name = "post")
    private String post;
    @ApiModelProperty(value = "部门负责人手机号", name = "departLeaderPhone")
    private String departLeaderPhone;
    @ApiModelProperty(value = "部门负责人", name = "departLeader")
    private String departLeader;
    @ApiModelProperty(value = "荣誉体系", name = "honor")
    private String honor;
    @ApiModelProperty(value = "社保", name = "social")
    private String social;
    @ApiModelProperty(value = "离职原因", name = "leaveReasons")
    private String leaveReasons;
    @ApiModelProperty(value = "证明人", name = "certifier")
    private String certifier;
    @ApiModelProperty(value = "证明人电话", name = "certifierPhone")
    private String certifierPhone;
    @ApiModelProperty(value = "经历类型", name = "type")
    private Integer type;
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "creator")
    private Integer creator;
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private Date updateTime;
    @ApiModelProperty(value = "修改人", name = "updator")
    private String updator;
    @ApiModelProperty(value = "是否删除", name = "isDel")
    private Integer isDel;
}
