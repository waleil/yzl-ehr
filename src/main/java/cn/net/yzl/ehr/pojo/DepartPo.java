package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * depart
 * @author 
 */
@Data
public class DepartPo implements Serializable {
    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父id(顶级目录为0)
     */
    private Integer pId;

    /**
     * 编制人数
     */
    private Integer staffNum;

    /**
     * 部门人数
     */
    private Integer num;

    /**
     * 负责人id
     */
    private Integer leaderId;

    /**
     * 描述
     */
    private String desc;

    /**
     * 排序(1,2,3.....)
     */
    private Integer order;

    /**
     * 钉钉部门名称
     */
    private String dingName;

    /**
     * 钉钉depart_id
     */
    private Long dingDepartId;

    /**
     * 钉钉父id
     */
    private Long dingPId;

    /**
     * 钉钉排序
     */
    private Long dingOrder;

    /**
     * 企业id
     */
    private String corpId;

    /**
     * 钉钉创建人id
     */
    private String dingOwner;

    /**
     * 创建来自于(1:ehr,2:钉钉)
     */
    private Byte from;

    /**
     * cti对应的部门id
     */
    private Integer ctiDepartId;

    /**
     * cti对应的部门名称
     */
    private String ctiDepartName;

    /**
     * 状态(0:有效,1:删除)
     */
    private Byte isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Integer updator;

    private static final long serialVersionUID = 1L;
}