package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "StaffContentFilePo", description = "员工合同信息文件表")
public class StaffContractFilePo implements Serializable {
    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
    @ApiModelProperty(value = "合同信息表no", name = "staff_contract_id")
    private Integer staffContractId;
    @ApiModelProperty(value = "分类 (0电子版合同 1其他资质)", name = "classify")
    private Integer classify;
    @ApiModelProperty(value = "类型( 0图片 1文件)", name = "type")
    private Integer type;
    @ApiModelProperty(value = "文件地址", name = "file_addr")
    private String fileAddr;
    @ApiModelProperty(value = "创建时间", name = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "创建人", name = "creator")
    private Integer creator;
    @ApiModelProperty(value = "修改时间", name = "update_time")
    private Date updateTime;
    @ApiModelProperty(value = "修改人", name = "updator")
    private String updator;
    @ApiModelProperty(value = "是否删除", name = "is_del")
    private Integer isDel;
}
