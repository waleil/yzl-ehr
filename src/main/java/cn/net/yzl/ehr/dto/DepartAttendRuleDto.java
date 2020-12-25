package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * depart_attend_rule
 * @author 
 */
@Data
@JsonIgnoreProperties(value = { "handler" })
public class DepartAttendRuleDto implements Serializable {
    private Integer id;

    /**
     * 部门id
     */
    @NotNull
    @Min(1)
    private Integer departId;
    private String departName;

    /**
     * 岗位id
     */
    @NotNull
    @Min(1)
    private Integer postId;
    private String postName;

    /**
     * 考勤时段:上班时间
     */

    private String workStartTime;
    private String workkStartTimeDesc;

    /**
     * 考勤时段:下班时间
     */

    private String workEndTime;
    private String workEndTimeDesc;
    /**
     * 中休的开始时间
     */

    private String restStartTime;
    private String restStartTimeDesc;

    /**
     * 中休的结束时间
     */

    private String restEndTime;
    private String restEndTimeDesc;

    /**
     * 考勤类型(1:定时打卡-正常,2定时打卡-可抢,3:弹性打卡,4:不打卡)
     */
    @NotNull
    @Min(1)
    @Max(4)
    private Byte type;

    /**
     * 迟到规则(首次打卡时间大于上班时间,单位分钟)
     */

    private Integer lateTime;

    /**
     * 早退规则(末次打卡时间小于下班时间,单位分钟)
     */

    private Integer leaveTime;

    /**
     * 抢休规则(每天缺勤率,小于)
     */
    private Double rushAbsenRate;

    /**
     * 抢休规则(每人每天抢休天数,小于等于)
     */
    private Double rushDays;

    /**
     * 是否大小周(0:否,1:是)
     */
    private Byte weekFlag;

    /**
     * 日期选择(1:周一,2:周二,3:周三,4:周四,5:周五,6:周六,7:周天)
     */
    private String week;

    // 考勤班次
    private List<AttendRushClassDto> attendRushClassDtoList;

    // 考勤周期
    private AttendRushCycleDto attendRushCycleDto;
}