package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 字典数据表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:58:54
 */
@Data
@ApiModel(value="SysDictDataDto",description="字典数据")
public class SysDictDataDto {
    @ApiModelProperty("字典编码")
    private Integer dictCode;

    @ApiModelProperty("字典排序")
    private Integer dictSort;

    @ApiModelProperty("字典标签")
    private String dictLabel;

    @ApiModelProperty("字典键值")
    private String dictValue;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("字典类型名称")
    private String dictTypeName;

    @ApiModelProperty("是否默认（1是 0否）")
    private Byte isDefault;

    @ApiModelProperty("状态（0正常 1停用）")
    private Byte status;

    @ApiModelProperty("备注")
    private String remark;

}