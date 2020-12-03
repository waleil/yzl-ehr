package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_depart_post
 * @author 
 */
@Data
public class StaffDepartPostPo implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer staffId;

    /**
     * 部门id
     */
    private Integer departId;

    /**
     * 岗位id
     */
    private Integer postId;

    /**
     * 岗位级别
     */
    private Integer postLevelId;

    /**
     * 状态(0:删除,1:有效)
     */
    private Byte isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Integer updateId;

    private static final long serialVersionUID = 1L;
}