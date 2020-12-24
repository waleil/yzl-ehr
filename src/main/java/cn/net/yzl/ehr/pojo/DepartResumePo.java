package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * depart_resume
 * @author 
 */
@Data
public class DepartResumePo implements Serializable {
    private Integer id;

    /**
     * 部门id
     */
    private Integer departId;

    /**
     * 岗位id
     */
    private Integer postId;

    /**
     * 此轮名称
     */
    private String stepName;

    /**
     * 面试人id
     */
    private Integer leaderNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人唯一标识
     */
    private String creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人唯一标识
     */
    private String updator;

    /**
     * 状态:0:有效,1:删除
     */
    private Byte isDel;

    private static final long serialVersionUID = 1L;
}