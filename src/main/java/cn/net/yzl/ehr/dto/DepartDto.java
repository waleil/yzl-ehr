package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * depart
 *
 * @author
 */
@Data
@JsonIgnoreProperties(value = {"handler"})
@ApiModel(value = "DepartDto", description = "部门实体信息")
public class DepartDto implements Serializable {
    /**
     * 唯一标识
     */
    @ApiModelProperty(value = "部门id", name = "id")
    private Integer id;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称", name = "name")
    private String name;

    /**
     * 父id(root 的父id为0,御芝林)
     */
    @ApiModelProperty(value = "父id", name = "pid")
    private Integer pid;

    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id", name = "leaderNo")
    private Integer leaderNo;
    @ApiModelProperty(value = "负责人名称", name = "leaderName")
    private String leaderName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", name = "desc")
    private String desc;

    /**
     * 排序(1,2,3.....)
     */
    @ApiModelProperty(value = "排序(1,2,3.....)", name = "order")
    private Integer order;

    @ApiModelProperty(value = "子部门信息列表", name = "children")
    private List<DepartDto> children;
    @ApiModelProperty(value = "级别", name = "level")
    private Integer level;
    @ApiModelProperty(value = "财务归属部门id", name = "financeDepartId")
    private Integer financeDepartId;
    @ApiModelProperty(value = "财务归属部门名称", name = "financeDepartName")
    private String financeDepartName;
    @ApiModelProperty(value = "业务属性code", name = "attrCode")
    private Integer attrCode;
}