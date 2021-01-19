package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "StaffContractFileInsertPo", description = "员工合同信息文件添加")
public class StaffContractFileInsertPo implements Serializable {
    @ApiModelProperty(value = "合同信息表no", name = "staff_contract_id")
    private Integer staffContractId;
    @ApiModelProperty(value = "分类 (0电子版合同 1其他资质)", name = "classify")
    private Integer classify;
    @ApiModelProperty(value = "类型( 0图片 1文件)", name = "type")
    private Integer type;
    @ApiModelProperty(value = "文件地址", name = "file_addr")
    private String fileAddr;
}
