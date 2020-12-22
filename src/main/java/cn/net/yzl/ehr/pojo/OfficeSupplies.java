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
@ApiModel(value=" office_supplies ", description=" 办公物品表 ")
public class OfficeSupplies {


  private long id;
 

  @ApiModelProperty(value = "公司办公区域编号(匹配字典表type=company_area)")
  private long areaId;
 

  @ApiModelProperty(value = "办公用品类型编号（匹配字典表type=office_supplies_type）")
  private long typeId;
 

  @ApiModelProperty(value = "物品名称")
  private String itemName;
 

  @ApiModelProperty(value = "物品特征(型号+特征)，如：红色油墨笔")
  private String itemCharacteristics;
 

  @ApiModelProperty(value = "物品品牌")
  private String itemBrand;
 

  @ApiModelProperty(value = "物品全额数量")
  private long itemTotal;
 

  @ApiModelProperty(value = "物品剩余量")
  private long itemRemaining;
 

  @ApiModelProperty(value = "物品编码")
  private long itemId;
 

  @ApiModelProperty(value = "物品数量单位")
  private String itemUnit;
 

  @ApiModelProperty(value = "存放位置")
  private String storageLocation;
 

  @ApiModelProperty(value = "物品状态（0:余量不足,1:暂停领用,2.开启领用,3.已移除）")
  private long status;
 

  @ApiModelProperty(value = "采购日期(yyyy-MM-dd)")
  private String buyTime;
 

  @ApiModelProperty(value = "创建日期")
  private java.sql.Timestamp createTime;
 

  @ApiModelProperty(value = "创建人（员工编号staff_id）")
  private long creator;
 

  @ApiModelProperty(value = "更改时间")
  private java.sql.Timestamp updateTime;
 

  @ApiModelProperty(value = "更改人")
  private long updator;
 

  @ApiModelProperty(value = "删除标志(0:未删除1:已删除)")
  private long isDel;
 

}
