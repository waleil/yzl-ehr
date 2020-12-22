package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author：yangxf
 * @date： 2020-12-03 13:54:25
 */
@Data
public class Courseware implements Serializable {
    /**
     * 课件id
     */
    private Integer id;

    /**
     * 课件名称
     */
    private String name;


    /**
     * 课件描述
     */
    private String desc;

    /**
     * 附件路径
     */
    private String attachmentPath;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人编号
     */
    private Integer creator;

    /**
     * 更改时间
     */
    private Date updateTime;

    /**
     * 更改人编号
     */
    private Integer updator;

    /**
     * 启用状态：0：待审核，1：审核通过待启用，2：已启用，3：已撤销
     */
    private Integer state;

    //适用部门
    private List<CoursewareDepart> departList;

    //课件种类
    private List<CoursewareCategory> categoryList;
}