package cn.net.yzl.ehr.vo.attendRule;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * depart_attend_rule
 * @author 
 */

@JsonIgnoreProperties(value = { "handler" })
@ApiModel(value="DepartAttendRuleVO",description="部门考勤规则实体")
public class DepartAttendRuleVO implements Serializable {

    @ApiModelProperty(value="考勤规则id,备注-更新必传",name="id")
    private Integer id;

    @ApiModelProperty(value="部门id,备注-创建必传",name="departId")
    private Integer departId;
    @ApiModelProperty(value="部门名称",name="departName",required = false)
    private String departName;
    @ApiModelProperty(value="创建或者更新表示,1:创建,2:更新",name="flag",required = true)
    private int flag;

    /**
     * 岗位id
     */
    @ApiModelProperty(value="岗位id,部门id,备注-创建必传",name="postId")
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
    @ApiModelProperty(value="字典类型名称",name="typeName")
    private String typeName;

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

    // 考勤班次
    @ApiModelProperty(value="考勤班次信息集合",name="attendRushClassDtoList")
    private List<AttendRushClassVO> attendRushClassDtoList;




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

    @ApiModelProperty(value="是否半天班(1:是,0:否)",name="halfFlag")
    private Integer halfFlag;

    @ApiModelProperty(value="时间(年,月)",name="time")
    @JsonFormat(pattern="yyyy-MM",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date time;

    @ApiModelProperty(value="选上班日期(0表示否,1表示是,用4个字节表示)",name="crycle")
    private Integer crycle;

    // 字符创 01010101  1表示勾选,0表示不勾选
    @ApiModelProperty(value="字符创 01010101  1表示勾选,0表示不勾选(1:上班,0:可以休息)",name="crycleStr")
    private String crycleStr;

    @ApiModelProperty(value="编辑标识(1:可以编辑,0:不可编辑)",name="editFlagStr")
    private int editFlagStr;
    @ApiModelProperty(value="提醒日期",name="remindTime")
    private Integer remindTime;



}