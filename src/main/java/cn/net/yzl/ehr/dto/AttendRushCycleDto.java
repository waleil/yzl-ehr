package cn.net.yzl.ehr.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * attend_rush_cycle
 * @author 
 */

public class AttendRushCycleDto implements Serializable {
    private Integer id;

    /**
     * 考勤规则id
     */
    private Integer attendRuleId;

    /**
     * 时间(年,月)
     */
    private Date time;

    /**
     * 可选上班日期(0表示否,1表示是,用4个字节表示)
     */
    private Integer crycle;

    // 字符创 01010101  1表示勾选,0表示不勾选
    private String crycleStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttendRuleId() {
        return attendRuleId;
    }

    public void setAttendRuleId(Integer attendRuleId) {
        this.attendRuleId = attendRuleId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCrycle() {
        return crycle;
    }

}