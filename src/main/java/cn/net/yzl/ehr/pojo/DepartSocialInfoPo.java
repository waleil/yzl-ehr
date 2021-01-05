package cn.net.yzl.ehr.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "DepartSocialInfoPo", description = "社保信息配置详情")
public class DepartSocialInfoPo implements Serializable{

    @ApiModelProperty(value = "主键", name = "id")
    private Integer id;

    @ApiModelProperty(value = "社保配置id", name = "socialId")
    private Integer socialId;

    @ApiModelProperty(value = "字典表社保类型id", name = "sysDictDataId")
    private Integer sysDictDataId;

//    @ApiModelProperty(value = "主键",name = "id")
//    private String name;

    @ApiModelProperty(value = "个人缴纳", name = "person")
    @Min(0)
    private Double person;

    @ApiModelProperty(value = "公司缴纳", name = "company")
    @Min(0)
    private Double company;

//    @ApiModelProperty(value = "主键",name = "id")
//    private Integer isDel;
}
