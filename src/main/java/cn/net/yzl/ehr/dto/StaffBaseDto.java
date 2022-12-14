package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ApiModel(value="StaffBaseDto",description="用户基本信息")
public class StaffBaseDto implements Serializable {
    @ApiModelProperty(value="用户工号",name="userNo")
    private String userNo;
    @ApiModelProperty(value="用户工号",name="staffNo")
    private String staffNo;
    @ApiModelProperty(value="用户英文名称",name="enName")
    private String enName;
    @ApiModelProperty(value="电子邮件",name="email")
    private String email;
    @ApiModelProperty(value="用户名称",name="name")
    private String name;
    @ApiModelProperty(value="密码",name="password",hidden = true)
    private String password;

    @ApiModelProperty(value="部门岗位编号",name="departPostId")
    private String departPostId;
    @ApiModelProperty(value="部门编号",name="departId")
    private String departId;
    @ApiModelProperty(value="岗位编号",name="postId")
    private String postId;
    @ApiModelProperty(value="部门名称",name="departName")
    private String departName;
    @ApiModelProperty(value="岗位名称",name="postName")
    private String postName;
    @ApiModelProperty(value="入职时间",name="entryTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date entryTime;
    @ApiModelProperty(value="是否在黑名单中:0否 1是",name="onBlackList")
    private Integer onBlackList;
}
