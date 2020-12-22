package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统字典表
 * 
 * @author：yangxf
 * @date： 2020-12-03 11:21:28
 */
@Data
public class SysDict implements Serializable {
    private Integer id;
    /**
     * 序号
     */
    private Integer indexNo;
    /**
     * code
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 类型
     */
    private String type;

    /**
     * 状态(0:无效,1:有效)
     */
    private Byte isDel;

}