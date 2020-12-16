package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lhw
 * @Date 2020/12/16 12:49
 */
@Data
@ApiModel(value="StaffDetailsDto",description="员工详情")
public class StaffDetailsDto {
    @ApiModelProperty(value = "工号", name = "id")
    private String userNo;
    @ApiModelProperty(value = "用户名称", name = "name")
    private String name;
    @ApiModelProperty(value = "拼音名", name = "enName")
    private String enName;
    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;
    @ApiModelProperty(value = "电子邮件", name = "email")
    private String email;
}
