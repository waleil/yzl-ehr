package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * attend_false_punish
 * @author 
 */
@Data
public class AttendFalsePunishDto implements Serializable {
    private Integer id;

    /**
     * 惩罚方式：1.按旷工处理 2.扣日薪
     */
    private Integer type;

    /**
     * 扣日薪比例
     */
    private Double rate;

    /**
     * 奖惩规则名称
     */
    private String name;
}