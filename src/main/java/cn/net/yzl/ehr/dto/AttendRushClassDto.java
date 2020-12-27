package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * attend_rush_class
 * @author 
 */
@Data
@ApiModel(value="AttendRushClassDto",description="考勤班次实体")
public class AttendRushClassDto implements Serializable {
    @ApiModelProperty(value="考勤班次id",name="id")
    private Integer id;
    @ApiModelProperty(value="考勤规则id",name="attendRuleId")
    private Integer attendRuleId;
    @ApiModelProperty(value="班次名称",name="name")
    private String name;
    @ApiModelProperty(value="开始时间(时,分)",name="startTime")
    private String startTime;
    @ApiModelProperty(value="结束时间(时,分)",name="endTime")
    private String endTime;

}