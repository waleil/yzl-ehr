package cn.net.yzl.ehr.pojo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import io.swagger.annotations.ApiModel;


/**
 * @Description 
 * @Author  jgYang
 * @Date: 2020-12-10 19:39:47
 */

@Data
@ApiModel(value=" office_supplies_change_record ", description=" 办公物品领用交还记录表 ")
public class OfficeSuppliesChangeRecord {

  private String id;
 

  @ApiModelProperty(value = "物品变更类型（1：领取/分发，2：交还/回收，3.购入）")
  private long changeType;
 

  @ApiModelProperty(value = "办公室物品编码(匹配office_supplies表中item_id)")
  private String itemId;
 

  @ApiModelProperty(value = "员工编码（匹配员工表staff_id）")
  private String staffId;
 

  @ApiModelProperty(value = "领取/交还/购入时间")
  private java.sql.Timestamp createTime;
 

  @ApiModelProperty(value = "领取/交还/购入数量")
  private long collectionQuantity;
 

  @ApiModelProperty(value = "领取/交还/购入说明")
  private String collectionDesc;
 

  @ApiModelProperty(value = "记录状态（0:未删除,1:已删除）")
  private long isDel;
 

  @ApiModelProperty(value = "更改时间")
  private java.sql.Timestamp updateTime;
 

}
