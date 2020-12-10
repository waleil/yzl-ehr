package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value="StaffBaseDto",description="用户基本信息")
public class StaffBaseDto implements Serializable {
    @ApiModelProperty(value="用户工号",name="userNo")
    private String userNo;
    @ApiModelProperty(value="用户英文名称",name="enName")
    private String enName;
    @ApiModelProperty(value="电子邮件",name="email")
    private String email;
    @ApiModelProperty(value="用户名称",name="name")
    private String name;
    @ApiModelProperty(value="密码",name="password",hidden = true)
    private String password;


}
