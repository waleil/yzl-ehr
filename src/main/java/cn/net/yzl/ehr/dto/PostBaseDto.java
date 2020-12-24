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
public class PostBaseDto implements Serializable {
    private Integer id;

    /**
     * 岗位名称
     */
    private String name;





}