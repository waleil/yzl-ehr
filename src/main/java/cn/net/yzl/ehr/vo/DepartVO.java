package cn.net.yzl.ehr.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart
 * @author 
 */
@Data
public class DepartVO implements Serializable {


    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空!")
    private String name;

    /**
     * 父id(root 的父id为0,御芝林)
     */
    @NotBlank(message = "部门的父编号不能为null!")
    @Min(value = 0)
    private Integer pid;

    private String leaderNo;
    /**
     * 财务归属部门id
     */
    @Min(value = 1)
    private Integer financeDepartId;
    /**
     * 描述
     */
    private String desc;


    private String creator;

}