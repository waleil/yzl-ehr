package cn.net.yzl.ehr.vo.attendRule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * attend_rush_class
 * @author 
 */
@Data
@ApiModel(value="AttendRushClassVO",description="考勤班次实体")
public class AttendRushClassVO implements Serializable {
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
    @ApiModelProperty(value="创建或者更新表示,1:创建,2:更新",name="flag",required = true)
    private int flag;

}