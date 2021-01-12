package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * post_level_indicators
 * @author 
 */
@Data
@ApiModel(value = "PostLevelIndicatorsVO", description = "岗位指标实体")
public class PostLevelIndicatorsVO implements Serializable {
    @ApiModelProperty(value = "岗位指标唯一标识(修改,删除必传,添加不需要)", name = "id")
    @Min(1)
    private Integer id;
    @ApiModelProperty(value = "岗位级别id(添加必传)", name = "postLevelId")
    @Min(1)
    private Integer postLevelId;
    @ApiModelProperty(value = "bi指标库id(添加必传)", name = "biIndicatorsId")
    @Min(1)
    private Integer biIndicatorsId;
    @ApiModelProperty(value = "指标值(添加,修改必传)", name = "indicatorsvalue")
    @Min(1)
    private Double indicatorsValue;
    @ApiModelProperty(value = "操作标识:(1:添加,2:删除,3:修改)", name = "flag",required = true)
    @Min(1)
    @Max(3)
    private int flag;

}