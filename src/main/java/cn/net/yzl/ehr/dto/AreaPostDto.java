package cn.net.yzl.ehr.dto;

import cn.net.yzl.ehr.pojo.AreaPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "AreaPostDto",description = "岗位和缴纳地区信息")
public class AreaPostDto implements Serializable {

    @ApiModelProperty(value = "岗位集合",name = "postDtos")
    List<PostDto> postDtos;
    @ApiModelProperty(value = "缴纳地区集合",name = "areaPoList")
    List<AreaPo> areaPoList;
}
