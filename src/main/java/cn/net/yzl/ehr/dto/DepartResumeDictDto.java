package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * depart_resume_dict
 * @author 
 */
@Data
public class DepartResumeDictDto implements Serializable {
    private Integer id;

    /**
     * 面试轮次名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;


}