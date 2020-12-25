package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * depart_attend_rp
 * @author 
 */
@Data
public class DepartAttendRpDto implements Serializable {

    private Integer attendRpId;

    /**
     * 奖惩金额
     */
    private Double money;

    /**
     * 第几次(0:表示一次奖惩)
     */
    private Integer times;

    private Integer rpItemId;
    private String rpItemName;


}