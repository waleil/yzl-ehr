package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * resume_edu
 * @author 
 */
@Data
@ApiModel(value = "BusinessPostVO", description = "业务属性岗位信息实体")
public class BusinessPostVO implements Serializable {
    @ApiModelProperty(value = "业务属性id", name = "bussinessAtrrCode",required = true)
    @NotNull
    @Min(1)
    private Integer bussinessAtrrCode;
    @ApiModelProperty(value = "岗位id", name = "postId",required = true)
    @Min(1)
    private Integer postId;
  
}