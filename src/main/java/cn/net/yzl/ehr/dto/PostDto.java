package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 岗位表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:39:11
 */
@Data
public class PostDto implements Serializable {
    private Integer id;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 部门id
     */
    private Integer departId;

    private String departName;
    /**
     * 属性code(指向字典表,post_attribute)
     */
    private Integer attrCode;

    private String attrName;
    /**
     * 编制人数
     */
    private Integer staffNum;

    /**
     * 岗位职责
     */
    private String duty;

    /**
     * 在岗人数
     */
    private Integer jobNum;



}