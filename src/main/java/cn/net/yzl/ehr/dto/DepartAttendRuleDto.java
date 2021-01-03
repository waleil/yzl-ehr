package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * depart_attend_rule
 * @author 
 */

@JsonIgnoreProperties(value = { "handler" })
@ApiModel(value="DepartAttendRuleDto",description="部门考勤规则实体")
@Data
public class DepartAttendRuleDto implements Serializable {

    @ApiModelProperty(value="考勤规则id",name="id")
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
    @ApiModelProperty(value="考勤时段:上班时间/上班打卡时段开始时间",name="workStartTime")
    private String workStartTime;
    @ApiModelProperty(value="考勤时段:下班时间/下班打卡时段结束时间",name="workEndTime")
    private String workEndTime;
    @ApiModelProperty(value="中休的开始时间",name="restStartTime")
    private String restStartTime;
    @ApiModelProperty(value="中休的结束时间",name="restEndTime")
    private String restEndTime;
    @ApiModelProperty(value="字典类型id",name="type")
    private Integer type;
    @ApiModelProperty(value="字典类型名称",name="typeStr")
    private String typeStr;

    @ApiModelProperty(value="迟到规则(首次打卡时间大于上班时间,单位分钟)",name="lateTime")
    private Integer lateTime;
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime")
    private Integer leaveTime;

    @ApiModelProperty(value="是否大小周(0:否,1:是)",name="weekFlag")
    private Integer weekFlag;
    @ApiModelProperty(value="大小周字节",name="weekBit")
    private Integer weekBit;
    @ApiModelProperty(value="大小周字节字节描述",name="weekBitStr")
    private String weekBitStr;

//    // 考勤班次
//    @ApiModelProperty(value="考勤班次信息集合",name="attendRushClassDtoList")
//    private List<AttendRushClassDto> attendRushClassDtoList;

//    // 考勤周期
//    @ApiModelProperty(value="考勤规则抢休周期表",name="attendRushCycleDtoList")
//    private List<AttendRushCycleDto> attendRushCycleDtoList;


    @ApiModelProperty(value="抢休规则(每天缺勤率,小于)",name="rushAbsenRate")
    private Double rushAbsenRate;
    @ApiModelProperty(value="抢休规则(每人每天抢休天数,小于等于)",name="rushDays")
    private Double rushDays;
    // 抢休开始时间
    @ApiModelProperty(value="抢休开始时间(几号)",name="rushStart")
    private Integer rushStart;
    // 抢休结束时间
    @ApiModelProperty(value="抢休结束时间(几号)",name="rushEnd")
    private Integer rushEnd;

//    @ApiModelProperty(value="是否半天班(1:是,0:否)",name="halfFlag")
//    private Integer halfFlag;

//    @ApiModelProperty(value="时间(年,月)",name="time")
//    @JsonFormat(pattern="yyyy-MM",timezone="GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM")
//    private Date time;

//    @ApiModelProperty(value="选上班日期(0表示否,1表示是,用4个字节表示)",name="crycle")
//    private Integer crycle;

    // 字符创 01010101  1表示勾选,0表示不勾选
//    @ApiModelProperty(value="字符创 01010101  1表示勾选,0表示不勾选(1:上班,0:可以休息)",name="crycleStr")
//    private String crycleStr;

    @ApiModelProperty(value="弹性打卡:上班打卡时段开始时间",name="elasticUpStartTime")
    private String elasticUpStartTime;
    @ApiModelProperty(value="弹性打卡:上班打卡时段结束时间",name="remindTime")
    private String elasticUpEndTime;
    @ApiModelProperty(value="弹性打卡:下班打卡时段开始时间",name="remindTime")
    private String elasticDownStartTime;
    @ApiModelProperty(value="弹性打卡:下班打卡时段结束时间",name="remindTime")
    private String elasticDownEndTime;

    @ApiModelProperty(value="0:否,1:是(1:也表示立即生效的)",name="enable")
    private Integer enable;
    @ApiModelProperty(value="生效时间",name="effectTime")
    private Date effectTime;

    @ApiModelProperty(value="几日后生效",name="days")
    private Integer days;

}