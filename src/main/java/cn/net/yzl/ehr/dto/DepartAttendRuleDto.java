package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * depart_attend_rule
 * @author 
 */
@Data
@JsonIgnoreProperties(value = { "handler" })
@ApiModel(value="DepartAttendRuleDto",description="部门考勤规则实体")
public class DepartAttendRuleDto implements Serializable {

    @ApiModelProperty(value="规则id",name="id")
    private Integer id;

    @ApiModelProperty(value="部门id",name="departId")
    private Integer departId;
    @ApiModelProperty(value="部门名称",name="departName")
    private String departName;

    /**
     * 岗位id
     */
    @ApiModelProperty(value="岗位id",name="postId")
    private Integer postId;
    @ApiModelProperty(value="岗位名称",name="postName")
    private String postName;
    @ApiModelProperty(value="考勤时段:上班时间",name="workStartTime")
    private String workStartTime;
    @ApiModelProperty(value="考勤时段:下班时间",name="workEndTime")
    private String workEndTime;
    @ApiModelProperty(value="考勤时段:下班时间",name="restStartTime")
    private String restStartTime;
    @ApiModelProperty(value="中休的结束时间",name="restEndTime")
    private String restEndTime;
    @ApiModelProperty(value="考勤类型(1:定时打卡-正常,2:定时打卡-可抢,2:弹性打卡,4:不打卡)",name="type")
    @NotNull
    @Min(1)
    @Max(4)
    private Byte type;

    @ApiModelProperty(value="迟到规则(首次打卡时间大于上班时间,单位分钟)",name="lateTime")
    private Integer lateTime;
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime")
    private Integer leaveTime;
    @ApiModelProperty(value="抢休规则(每天缺勤率,小于)",name="rushAbsenRate")
    private Double rushAbsenRate;
    @ApiModelProperty(value="抢休规则(每人每天抢休天数,小于等于)",name="rushDays")
    private Double rushDays;
    @ApiModelProperty(value="是否大小周(0:否,1:是)",name="weekFlag")
    private Byte weekFlag;

    /**
     * 日期选择(1:周一,2:周二,3:周三,4:周四,5:周五,6:周六,7:周天)
     */
    @ApiModelProperty(value="大周-日期选择(1:周一,2:周二,3:周三,4:周四,5:周五,6:周六,7:周天)",name="week1")
    private String week1;
    @ApiModelProperty(value="小周-日期选择(1:周一,2:周二,3:周三,4:周四,5:周五,6:周六,7:周天)",name="week2")
    private String week2;

    // 考勤班次
    @ApiModelProperty(value="考勤班次信息集合",name="attendRushClassDtoList")
    private List<AttendRushClassDto> attendRushClassDtoList;

    // 考勤周期
    @ApiModelProperty(value="考勤规则抢休周期表",name="attendRushCycleDto")
    private AttendRushCycleDto attendRushCycleDto;

    // 抢休开始时间
    @ApiModelProperty(value="抢休开始时间",name="rushStart")
    private Integer rushStart;
    // 抢休结束时间
    @ApiModelProperty(value="抢休结束时间",name="rushEnd")
    private Integer rushEnd;
}