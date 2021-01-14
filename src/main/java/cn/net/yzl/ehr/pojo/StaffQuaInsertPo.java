package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * staff_qua
 * @author 
 */
@Data
public class StaffQuaInsertPo implements Serializable {



    @ApiModelProperty(value = "员工表工号",name = "staffNo")
    @NotBlank
    private String staffNo;


    @ApiModelProperty(value = "资质证书图片地址",name = "imgAddr")
    @NotBlank
    private String imgAddr;


    @ApiModelProperty(value = "资质名称",name = "name")
    @NotBlank
    private String name;

    @ApiModelProperty(value = "创建人",name = "creator",hidden = true)
    private  String creator ;



    private static final long serialVersionUID = 1L;


}