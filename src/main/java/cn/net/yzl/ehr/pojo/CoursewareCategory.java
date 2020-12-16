package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 课件种类关系表
 * 
 * @author：yangxf
 * @date： 2020-12-14 10:14:07
 */
@Data
public class CoursewareCategory {
    private Integer id;

    /**
     * 课件类别(courseware_category_dict)
     */
    private Integer typeId;

    /**
     * 课件id(courseware表id)
     */
    private Integer coursewareId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更改时间
     */
    private Date updateTime;

    /**
     * 创建者id
     */
    private Integer creator;

    /**
     * 更改者id
     */
    private Integer updator;

    /**
     * 删除标志(0:未删除,1:已删除)
     */
    private int isDel;


}