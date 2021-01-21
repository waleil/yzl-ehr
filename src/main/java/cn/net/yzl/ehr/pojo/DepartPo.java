package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.ValidatedGroup.UpdateVal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

/**
 * depart
 * @author 
 */
@Data
@ApiModel(value = "DepartPo", description = "部门实体对象")
public class DepartPo implements Serializable {

    @ApiModelProperty(value = "部门id", name = "id")
    @Min(value = 1,groups = {UpdateVal.class})
    private Integer id;
    @ApiModelProperty(value = "部门名称", name = "name")
    private String name;
    @Min(value = 1,groups = {UpdateVal.class})
    @ApiModelProperty(value = "父id(顶级目录为0)", name = "pid")
    private Integer pid;
    @ApiModelProperty(value = "财务归属id", name = "financeDepartId")
    private Integer financeDepartId;

    /**
     * 编制人数
     */
    @ApiModelProperty(value = "编制人数", name = "staffNum")
    private Integer staffNum;

    /**
     * 部门人数
     */
    @ApiModelProperty(value = "部门人数", name = "num")
    private Integer num;

    @ApiModelProperty(value = "负责人id", name = "leaderNo")
    private String leaderNo;

    @ApiModelProperty(value = "描述", name = "desc")
    private String desc;


    @ApiModelProperty(value = "排序(1,2,3.....)", name = "order")
    private Integer order;

    /**
     * 钉钉部门名称
     */
    @ApiModelProperty(value = "钉钉部门名称", name = "dingName")
    private String dingName;

    /**
     * 钉钉depart_id
     */
    @ApiModelProperty(value = "钉钉depart_id", name = "dingDepartId")
    private Integer dingDepartId;

    /**
     * 钉钉父id
     */
    @ApiModelProperty(value = "钉钉父id", name = "dingPId")
    private Integer dingPId;


    @ApiModelProperty(value = "钉钉排序", name = "dingOrder")
    private Integer dingOrder;

    @ApiModelProperty(value = "企业id", name = "corpId")
    private String corpId;

    @ApiModelProperty(value = "钉钉创建人id", name = "dingOwner")
    private String dingOwner;

    @ApiModelProperty(value = "创建来自于(1:ehr,2:钉钉)", name = "from")
    private Byte from;
    @ApiModelProperty(value = "cti对应的部门id", name = "ctiDepartId")
    private Integer ctiDepartId;
    @ApiModelProperty(value = "cti对应的部门名称", name = "ctiDepartName")
    private String ctiDepartName;

    @ApiModelProperty(value = "级别", name = "level")
    private Integer level;

    @ApiModelProperty(value = "状态(0:有效,1:删除)", name = "isDel")
    private Byte isDel;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "创建人id", name = "creator")
    private String creator;

    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "更新人id", name = "updator")
    private String updator;
    @ApiModelProperty(value = "业务属性code", name = "attrCode")
    private Integer attrCode;
    @ApiModelProperty(value = "自动入岗设置天数", name = "entrySetting")
    private Integer entrySetting;

}