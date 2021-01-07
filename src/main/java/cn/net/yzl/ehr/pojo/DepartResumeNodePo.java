package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 部门岗位面试配置表
 * 
 * @author：yangxf
 * @date： 2021-01-04 16:49:36
 */
@Data
public class DepartResumeNodePo {
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
    private String leaderNo;

    /**
     * 顺序序号
     */
    private Integer sortNo;

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

}