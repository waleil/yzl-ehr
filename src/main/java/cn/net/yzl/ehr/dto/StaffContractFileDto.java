package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "StaffContentFilePo", description = "员工合同信息文件表")
public class StaffContractFileDto implements Serializable {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "合同信息表no", name = "staffContractId")
    private Integer staffContractId;
    @ApiModelProperty(value = "分类 (0电子版合同 1其他资质)", name = "classify")
    private Integer classify;
    @ApiModelProperty(value = "类型( 0图片 1文件)", name = "type")
    private Integer type;
    @ApiModelProperty(value = "文件地址", name = "fileAddr")
    private String fileAddr;

}
