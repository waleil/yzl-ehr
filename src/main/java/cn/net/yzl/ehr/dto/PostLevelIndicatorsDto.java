package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * post_level_indicators
 * @author 
 */
@Data
@ApiModel(value = "PostLevelIndicatorsDto", description = "岗位指标实体")
public class PostLevelIndicatorsDto implements Serializable {
    @ApiModelProperty(value = "岗位指标唯一标识", name = "id")
    private Integer id;
    @ApiModelProperty(value = "岗位级别id", name = "postLevelId")
    private Integer postLevelId;
    @ApiModelProperty(value = "bi指标库id", name = "biIndicatorsId")
    private Integer biIndicatorsId;
    @ApiModelProperty(value = "指标值率类型(1:值 2:百分比)", name = "indicatorsType")
    private Integer indicatorsType;
    @ApiModelProperty(value = "指标名称", name = "indicatorsName")
    private String indicatorsName;
    @ApiModelProperty(value = "指标值", name = "indicatorsvalue")
    private double indicatorsValue;
}