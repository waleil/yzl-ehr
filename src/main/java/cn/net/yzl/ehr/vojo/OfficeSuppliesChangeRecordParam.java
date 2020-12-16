package cn.net.yzl.ehr.vojo;

import io.swagger.annotations.ApiModelProperty;

public class OfficeSuppliesChangeRecordParam {

    @ApiModelProperty(value = "记录编号")
    private long id;

    @ApiModelProperty(value = "物品变更类型（1：领取/分发，2：交还/回收，3.购入）")
    private long changeType;


    @ApiModelProperty(value = "办公室物品编码(匹配office_supplies表中item_id)")
    private String itemId;


    @ApiModelProperty(value = "员工编码")
    private String staffNo;

    @ApiModelProperty(value = "员工姓名")
    private String staffName;

    @ApiModelProperty(value = "领取/交还/购入时间")
    private java.sql.Timestamp createTime;


    @ApiModelProperty(value = "领取/交还/购入数量")
    private long collectionQuantity;


    @ApiModelProperty(value = "领取/交还/购入说明")
    private String collectionDesc;



}
