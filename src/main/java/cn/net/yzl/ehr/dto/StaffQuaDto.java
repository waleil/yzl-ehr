package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * staff_qua
 * @author 
 */

@Data
@ApiModel(value = "StaffQuaDto", description = "员工资质证书")
public class StaffQuaDto implements Serializable {
    /**
     * 主键 唯一ID
     */
    @ApiModelProperty("主键 唯一ID")
    private Integer id;

    /**
     * 员工表工号
     */
    @ApiModelProperty("员工表工号")
    private Integer staffNo;

    /**
     * 资质证书图片地址
     */
    @ApiModelProperty("资质证书图片地址")
    private String imgAddr;

    /**
     * 资质名称
     */
    @ApiModelProperty("资质名称")
    private String name;



    private static final long serialVersionUID = 1L;


}