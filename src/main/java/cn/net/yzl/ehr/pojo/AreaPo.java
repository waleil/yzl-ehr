package cn.net.yzl.ehr.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "缴纳地区",description = "AreaPo")
public class AreaPo {
    @ApiModelProperty(value = "缴纳地区id",name = "dictCode")
    private Integer dictCode;
    @ApiModelProperty(value = "缴纳地区名称",name = "cityName")
    private String cityName;
}
