package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "StaffWorkPo", description = "员工入职经历信息")
public class StaffWorkDto implements Serializable {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "员工表工号", name = "staff_no")
    private Integer staffNo;
    @ApiModelProperty(value = "起始时间", name = "start_time")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startTime;
    @ApiModelProperty(value = "结束时间", name = "end_time")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endTime;
    @ApiModelProperty(value = "单位名称", name = "company")
    private String company;
    @ApiModelProperty(value = "部门", name = "depart")
    private String depart;
    @ApiModelProperty(value = "职务", name = "post")
    private String post;
    @ApiModelProperty(value = "部门负责人手机号", name = "depart_leader_phone")
    private String departLeaderPhone;
    @ApiModelProperty(value = "部门负责人", name = "depart_leader")
    private String departLeader;
    @ApiModelProperty(value = "荣誉体系", name = "honor")
    private String honor;
    @ApiModelProperty(value = "社保", name = "social")
    private String social;
    @ApiModelProperty(value = "离职原因", name = "leave_reasons")
    private String leaveReasons;
    @ApiModelProperty(value = "证明人", name = "certifier")
    private String certifier;
    @ApiModelProperty(value = "证明人电话", name = "certifier_phone")
    private String certifierPhone;
    @ApiModelProperty(value = "经历类型", name = "type")
    private Integer type;

}
