package cn.net.yzl.ehr.dto;


import cn.net.yzl.ehr.pojo.DepartSocialPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "DepartSocialDto", description = "社保基本信息")
public class DepartSocialDto implements Serializable {
   @ApiModelProperty(value = "社保基本信息列表",name = "departSocialPoList")
   private List<DepartSocialPo> departSocialPoList;
}
