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
    /**
     * 部门岗位id
     */
    @ApiModelProperty(value="部门岗位id",name="departPostId")
    private Integer departPostId;
    @ApiModelProperty(value="考勤时段:上班时间",name="workStartTime")
    private String workStartTime;
    @ApiModelProperty(value="考勤时段:下班时间",name="workEndTime")
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
    @ApiModelProperty(value="迟到规则时间描述(例如:09:01)",name="lateTimeStr")
    private String lateTimeStr;
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime")
    private Integer leaveTime;

    @ApiModelProperty(value="早退规则时间描述(例如:09:11)",name="leaveTimeStr")
    private String leaveTimeStr;

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

    @ApiModelProperty(value="标题",name="title")
    private String title;


    @ApiModelProperty(value="加班费标识 1:有,0:没有",name="overtimePayFlag")
    private Byte overtimePayFlag;
    @ApiModelProperty(value="加班费发放类型(0:无效,1:日薪固定计算,2:固定金额)",name="overtimePayType")
    private Byte overtimePayType;
    @ApiModelProperty(value="加班费固定金额方法的方式(0:无效,1:元/天,2:元/小时)",name="overtimePayWay")
    private Byte overtimePayWay;
    @ApiModelProperty(value="工作日加班开始时间()",name="workDayStartTime")
    private String workDayStartTime;
    @ApiModelProperty(value="抢休开启标识(0:关闭,1:开启)()",name="rushFlag")
    private Byte rushFlag;

    @ApiModelProperty(value="视为旷工标准(0:关闭,1:开启)",name="absenFlag")
    private Byte absenFlag;
    @ApiModelProperty(value="上午旷工时段开始",name="amAbsenStartTime")
    private String amAbsenStartTime;

    @ApiModelProperty(value="下午旷工时段开始",name="pmAbsenStartTime")
    private String pmAbsenStartTime;
    @ApiModelProperty(value="下午旷工时段开始amAbsenEndTime",name="amAbsenEndTime")
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
    @ApiModelProperty(value="加班费的值(单位为分)",name="overtimeValue")
    private Integer overtimeValue;

}