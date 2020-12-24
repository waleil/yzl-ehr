package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 岗位级别表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:39:56
 */
@Data
public class PostLevelDto implements Serializable {
    private Integer id;

    /**
     * 岗位编号
     */
    private Integer postId;

    private String postName;

    /**
     * 级别名称
     */
    private String name;


}