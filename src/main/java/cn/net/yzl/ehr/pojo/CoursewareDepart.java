package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 课件使用人群(部门)表
 * 
 * @author：yangxf
 * @date： 2020-12-14 10:15:17
 */
@Data
public class CoursewareDepart {
    private Integer id;

    /**
     * 课件id(匹配courseware表中id)
     */
    private Integer coursewareId;

    /**
     * 部门id(匹配depart表中id)
     */
    private Integer departId;

    /**
     * 状态:0:未删除,1:已删除
     */
    private int isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人唯一标识
     */
    private Integer creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人唯一标识
     */
    private Integer updator;


}