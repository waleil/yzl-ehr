package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * depart_resume_node_staff
 * @author 
 */
@Data
public class DepartResumeNodeStaffDto implements Serializable {
    private Integer id;

    /**
     * 面试流程id
     */
    private Integer nodeId;

    /**
     * 面试官工号
     */
    private String staffNo;

    /**
     * 是否面试结果给出人
     */
    private Byte isSender;


}