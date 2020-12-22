package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CoursewareDto implements Serializable {

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
    private String createTime;

    /**
     * 创建人编号
     */
    private Integer creator;

    /**
     * 更改时间
     */
    private String updateTime;

    /**
     * 更改人编号
     */
    private Integer updator;

    /**
     * 启用状态：0：待审核，1：审核通过待启用，2：已启用，3：已撤销
     */
    private int state;

    //适用部门
    private List<CoursewareDepartParam> departList;

    //课件种类
    private List<CoursewareCategoryParam> categoryList;

    @Data
    public static class  CoursewareCategoryParam {
        private int typeId;
        private String typeName;
    }


    @Data
    public static class CoursewareDepartParam {
        private  String departId;
        private  String departName;
    }


}
