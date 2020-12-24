package cn.net.yzl.ehr.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典数据表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:58:54
 */
@Data
public class SysDictDataUpdateVo implements Serializable {
    /**
     * 字典编码
     */
    private Integer dictCode;

    /**
     * 字典排序
     */
    private Integer dictSort;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典类型名称
     */
    private String dictTypeName;

    /**
     * 是否默认（1是 0否）
     */
    private Byte isDefault;

    /**
     * 状态（0正常 1停用）
     */
    private Byte status;

    /**
     * 是否删除(0:否,1:是)
     */
    private Byte isDel;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 更新者
     */
    private String updator;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

}