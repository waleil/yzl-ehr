package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;
@Valid
@Data
public class StaffWorkUpdatePo implements Serializable {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    private Integer staffNo;
    @ApiModelProperty(value = "起始时间", name = "startTime")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String startTime;
    @ApiModelProperty(value = "结束时间", name = "endTime")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String endTime;
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
    @ApiModelProperty(value = "经历类型：0入职前经历 1入职后经历", name = "type")
    private Integer type;
    @ApiModelProperty(value = "更改人", name = "updator",hidden = true)
    private String updator;
}
