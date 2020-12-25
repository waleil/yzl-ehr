package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * depart_attend_st
 * @author 
 */
@Data
public class DepartAttendStDto implements Serializable {
    private Integer id;

    /**
     * 部门id
     */
    private Integer departId;

    /**
     * 结算日(每个月几号)
     */
    private Byte day;

}