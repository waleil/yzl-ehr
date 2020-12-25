package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * attend_rush_class
 * @author 
 */
@Data
public class AttendRushClassDto implements Serializable {
    private Integer id;

    /**
     * 考勤规则id
     */
    private Integer attendRuleId;

    /**
     * 班次名称
     */
    private String name;

    /**
     * 开始时间(时,分)
     */
    private String startTime;

    /**
     * 结束时间(时,分)
     */
    private String endTime;

}