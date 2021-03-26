package cn.net.yzl.ehr.vo.attendRule;

import cn.net.yzl.staff.vo.attendRule.DepartAttendRuleBaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * depart_attend_rule
 * @author 
 */

@ApiModel(value="DepartAttendRuleRobbedVO",description="部门考勤规则可抢实体")
@Data
public class DepartAttendRuleRobbedVO extends DepartAttendRuleBaseVO {


    // 定时打卡正常
    @ApiModelProperty(value="考勤时段:上班时间",name="workStartTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String workStartTime;
    @ApiModelProperty(value="考勤时段:下班时间",name="workEndTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String workEndTime;
    @ApiModelProperty(value="中休的开始时间",name="restStartTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restStartTime;
    @ApiModelProperty(value="中休的结束时间",name="restEndTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restEndTime;
    @ApiModelProperty(value="迟到规则(首次打卡时间大于上班时间,单位分钟)",name="lateTime",required = true)
    private Integer lateTime;
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime",required = true)
    private Integer leaveTime;

    @ApiModelProperty(value="抢休规则(每天缺勤率,小于)",name="rushAbsenRate",required = true)
    private Double rushAbsenRate;
    @ApiModelProperty(value="抢休规则(每人每天抢休天数,小于等于)",name="rushDays",required = true)
    private Double rushDays;
    // 抢休开始时间
    @ApiModelProperty(value="抢休开始时间(几号)",name="rushStart",required = true)
    private Integer rushStart;
    // 抢休结束时间
    @ApiModelProperty(value="抢休结束时间(几号)",name="rushEnd",required = true)
    private Integer rushEnd;

}