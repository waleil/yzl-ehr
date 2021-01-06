package cn.net.yzl.ehr.dto;


import cn.net.yzl.ehr.pojo.AreaPo;
import cn.net.yzl.ehr.pojo.DepartSocialInfoPo;
import cn.net.yzl.ehr.pojo.DepartSocialPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "社保详情信息",description = "DepartSocialInfoDto")
public class DepartSocialInfoDto implements Serializable {

    @ApiModelProperty(value = "社保修改前的数据",name = "beforeDepartSocialPo")
    private DepartSocialPo beforeDepartSocialPo;
    @ApiModelProperty(value = "社保修改后的数据",name = "afterDepartSocialPo")
    private DepartSocialPo afterDepartSocialPo;

    @ApiModelProperty(value = "社保种类",name = "sysDictDataDtos")
    List<SysDictDataDto> sysDictDataDtos;

    @ApiModelProperty(value = "岗位集合列表",name = "postDtos")
    List<PostDto> postDtos;

    @ApiModelProperty(value = "缴纳地区集合",name = "areaPoList")
    List<AreaPo> areaPoList;

    @ApiModelProperty(value = "社保详细信息",name = "departSocialInfoPoList")
    private List<DepartSocialInfoPo> departSocialInfoPoList;
}