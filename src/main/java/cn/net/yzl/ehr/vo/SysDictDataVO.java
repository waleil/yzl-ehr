package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@ApiModel(value="SysDictDataVO",description="字典数据实体")
public class SysDictDataVO {

    @ApiModelProperty(value = "字典编码(修改,删除必传)",required = true)
    private Integer dictCode;

//    @ApiModelProperty("字典排序")
//    private Integer dictSort;

//    @ApiModelProperty("字典标签")
//    private String dictLabel;

    @ApiModelProperty(value = "字典键值,添加必传",required = true)
    @NotBlank
    private String dictValue;

    @ApiModelProperty(value = "字典类型,(业务属性:depart_attr,假勤类型:false_name,社保类型:social)",required = true)    @NotBlank
    private String dictType;


    @ApiModelProperty(value = "1:新增,2:删除,3:修改",required = true)
    @NotBlank
    private Integer flag;

//    @ApiModelProperty("字典类型名称")
//    private String dictTypeName;

//    @ApiModelProperty("是否默认（1是 0否）")
//    private Byte isDefault;
//
//    @ApiModelProperty("状态（0正常 1停用）")
//    private Byte status;
//
//    @ApiModelProperty("备注")
//    private String remark;

}