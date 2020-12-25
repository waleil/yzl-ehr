package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * depart
 * @author 
 */
@Data
@JsonIgnoreProperties(value = { "handler" })
public class DepartDto implements Serializable {
    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父id(root 的父id为0,御芝林)
     */
    private Integer pid;

    /**
     * 负责人id
     */
    private Integer leaderNo;

    private String leaderName;

    /**
     * 描述
     */
    private String desc;

    /**
     * 排序(1,2,3.....)
     */
    private Integer order;

    //部门子
    private List<DepartDto> children;

    private Integer level;
}