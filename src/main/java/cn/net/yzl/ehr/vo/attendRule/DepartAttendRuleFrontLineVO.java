package cn.net.yzl.ehr.vo.attendRule;

import cn.net.yzl.staff.vo.attendRule.DepartAttendRuleBaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * depart_attend_rule
 * @author 
 */

@ApiModel(value="DepartAttendRuleFrontLineVO",description="部门考勤规则通话打卡一线实体")
@Data
public class DepartAttendRuleFrontLineVO extends DepartAttendRuleBaseVO {


    // 定时打卡正常
    @ApiModelProperty(value="考勤时段:上班时间",name="workStartTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String workStartTime;
    @ApiModelProperty(value="考勤时段:下班时间",name="workEndTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String workEndTime;
    @ApiModelProperty(value="中休的开始时间",name="restStartTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restStartTime;
    @ApiModelProperty(value="中休的结束时间",name="restEndTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restEndTime;
    @ApiModelProperty(value="迟到规则(首次打卡时间大于上班时间,单位分钟)",name="lateTime",required = true)
    @Min(1)
    @NotNull
    private Integer lateTime;
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime",required = true)
    @Min(1)
    @NotNull
    private Integer leaveTime;

    @ApiModelProperty(value="是否大小周(0:否,1:是)",name="weekFlag",required = true)
    @Min(0)
    @Max(1)
    @NotNull
    private Integer weekFlag;
    @ApiModelProperty(value="大小周字节",name="weekBit",hidden = true)
    private Integer weekBit;
    @ApiModelProperty(value="大小周字节字符串(101010)",name="weekBitStr",required = true)
    @NotBlank
    @Pattern(regexp = "^([0-1]{7}|[0-1]{14})$")
    private String weekBitStr;
    @ApiModelProperty(value="抢休开启标识(0:关闭,1:开启)",name="rushFlag",readOnly = true)
    @Min(1)
    @NotNull
    private Byte rushFlag;
    @ApiModelProperty(value="抢休规则(每天缺勤率,小于)",name="rushAbsenRate")
    private Double rushAbsenRate;
    @ApiModelProperty(value="抢休规则(每人每天抢休天数,小于等于)",name="rushDays")
    private Double rushDays;
    @ApiModelProperty(value="抢休开始时间(几号)",name="rushStart",required = true)
    private Integer rushStart;
    @ApiModelProperty(value="抢休结束时间(几号)",name="rushEnd",required = true)
    private Integer rushEnd;


    @ApiModelProperty(value="视为旷工标准(0:关闭,1:开启)",name="absenFlag",readOnly = true)
    @Min(1)
    @NotNull
    private Byte absenFlag;

    @ApiModelProperty(value="上午旷工时段开始",name="amAbsenStartTime")
    private String amAbsenStartTime;
    @ApiModelProperty(value="下午旷工时段开始",name="pmAbsenStartTime")
    private String pmAbsenStartTime;
    @ApiModelProperty(value="下午旷工时段开始",name="amAbsenEndTime")
    private String amAbsenEndTime;
    @ApiModelProperty(value="下午旷工时段结束",name="pmAbsenEndTime")
    private String pmAbsenEndTime;
    @ApiModelProperty(value="上午通话次数符号(0:无效,1:小于,2:大于)",name="amSymal")
    private Byte amSymal;
    @ApiModelProperty(value="下午通话次数符号(0:无效,1:小于,2:大于)",name="pmSymal")
    private Byte pmSymal;
    @ApiModelProperty(value="上午通话次数值",name="amValue")
    private Byte amValue;
    @ApiModelProperty(value="下午通话次数值",name="pmValue")
    private Byte pmValue;
}