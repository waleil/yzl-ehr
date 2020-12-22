package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.util.Date;

/**
 * 课件开放部门表
 * 
 * @author：yangxf
 * @date： 2020-12-17 13:25:30
 */
@Data
public class CoursewareCategoryDictDto {

    private Integer id;

    /**
     * 课件类型名称
     */
    private String name;

    /**
     * 删除标志(0.未删除，1.已删除)
     */
    private Integer isDel;

    /**
     * 创建人
     */
    private Integer creator;

    /**
     * 更改人
     */
    private Integer updator;


}