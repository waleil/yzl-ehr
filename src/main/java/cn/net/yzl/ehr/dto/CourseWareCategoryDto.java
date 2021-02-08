package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 课件开放部门表
 * 
 * @author：yangxf
 * @date： 2020-12-17 13:25:30
 */
@Data
public class CourseWareCategoryDto {

    @ApiModelProperty(value = "课件类型id", name = "id")
    private Integer id;

    /**
     *类型名称
     */
    @ApiModelProperty(value = "课件类型名称", name = "name")
    private String name;

    /**
     *创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    /**
     *创建者id 原数据库使用int  现在使用varchar数据类型
     */
    @ApiModelProperty(value = "创建人工号", name = "creator")
    private String creator;

    /**
     *更新时间
     */
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private Date updateTime;

    /**
     *更新者id 原数据库使用int  现在使用varchar数据类型
     */
    @ApiModelProperty(value = "修改人工号", name = "updator")
    private String updator;

    /**
     *删除字段
     */
    @ApiModelProperty(value = "是否删除", name = "isDel",hidden = true)
    private Integer isDel;


}