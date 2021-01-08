package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 */
@Data
@ApiModel(value = "StaffDetailsDto", description = "员工详情实体")
public class StaffDetailsDto implements Serializable {
    @ApiModelProperty(value = "工号(用户工号)", name = "id")
    private String userNo;
    @ApiModelProperty(value = "用户名称", name = "name")
    private String name;
    @ApiModelProperty(value = "拼音名", name = "enName")
    private String enName;
    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;
    @ApiModelProperty(value = "电子邮件", name = "email")
    private String email;
    @ApiModelProperty(value = "员工工号(用户工号)", name = "staffNo")
    private String staffNo;
    @ApiModelProperty(value = "属性(1:正编,2:外包)", name = "nature")
    private Integer nature;
    @ApiModelProperty(value = "性别 0:男,1:女", name = "sex")
    private Integer sex;
    @ApiModelProperty(value = "民族code", name = "nationCode")
    private Integer nationCode;
    @ApiModelProperty(value = ",民族", name = "nationCodeStr")
    private String nationCodeStr;
    @ApiModelProperty(value = "学历code", name = "degreeCode")
    private Integer degreeCode;
    @ApiModelProperty(value = "学历", name = "degreeCodeStr")
    private String degreeCodeStr;
    @ApiModelProperty(value = "身份证号", name = "idCardNo")
    private String idCardNo;
    @ApiModelProperty(value = "微信号", name = "wechat")
    private String wechat;
    @ApiModelProperty(value = "是否有销售经验 0否 1是", name = "salesFlag")
    private Integer salesFlag;
    @ApiModelProperty(value = "政治code", name = "politicsStatusCode")
    private Integer politicsStatusCode;
    @ApiModelProperty(value = "政治", name = "politicsStatusCodeStr")
    private String politicsStatusCodeStr;
    @ApiModelProperty(value = "省id", name = "provinceId")
    private Integer provinceId;
    @ApiModelProperty(value = "市id", name = "cityId")
    private Integer cityId;
    @ApiModelProperty(value = "区/县id", name = "countyId")
    private Integer countyId;
    @ApiModelProperty(value = "街道id", name = "streetId")
    private Integer streetId;
    @ApiModelProperty(value = "地址详情", name = "address")
    private String address;
    @ApiModelProperty(value = "地址详情", name = "address")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date birthdate;
    @ApiModelProperty(value = "紧急联系人", name = "emergencyContact")
    private String emergencyContact;
    @ApiModelProperty(value = "紧急联系人手机号", name = "emergencyPhone")
    private String emergencyPhone;

    @ApiModelProperty(value = "初试密码", name = "firstPassword")
    private String firstPassword;
    @ApiModelProperty(value = "部门ids", name = "departIds")
    private List<Integer> departIds;
    @ApiModelProperty(value = "部门ids对应的名称集合", name = "departNames")
    private String departNames;
    @ApiModelProperty(value = "岗位id", name = "postId")
    private Integer postId;
    @ApiModelProperty(value = "岗位名称", name = "postName")
    private String postName;
    @ApiModelProperty(value = "岗位级别id", name = "postLevelId")
    private Integer postLevelId;
    @ApiModelProperty(value = "岗位级别名称", name = "postLevelName")
    private String postLevelName;
    @ApiModelProperty(value = "角色id", name = "roleId")
    private Integer roleId;
    @ApiModelProperty(value = "角色名称", name = "roleName")
    private String roleName;
    @ApiModelProperty(value = "工作地点code", name = "workplaceCode")
    private Integer workplaceCode;
    @ApiModelProperty(value = "工作地点", name = "workplaceCodeStr")
    private String workplaceCodeStr;
    @ApiModelProperty(value = "入职时间", name = "entryTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date entryTime;
    @ApiModelProperty(value = "入岗状态 0待入岗 1已入岗", name = "enterStatus")
    private Integer enterStatus;
    @ApiModelProperty(value = "入岗时间", name = "postTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date postTime;
    @ApiModelProperty(value = "转正时间", name = "positiveTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date positiveTime;
    @ApiModelProperty(value = "在岗状态", name = "postStatusCode")
    private Integer postStatusCode;
    @ApiModelProperty(value = "在岗状态名称", name = "postStatusCodeStr")
    private String postStatusCodeStr;
    @ApiModelProperty(value = "开户行名称", name = "bankName")
    private String bankName;
    @ApiModelProperty(value = "银行卡号", name = "bankCard")
    private String bankCard;
    @ApiModelProperty(value = "保险备注", name = "insuraRemark")
    private String insuraRemark;
    @ApiModelProperty(value = "合作方code", name = "partnerCode")
    private Integer partnerCode;
    @ApiModelProperty(value = "合作方名称", name = "partnerName")
    private String partnerName;
    @ApiModelProperty(value = "职场id(字典表)", name = "workCode")
    private Integer workCode;
    @ApiModelProperty(value = "职场", name = "workCodeStr")
    private String workCodeStr;
    @ApiModelProperty(value = "介绍人工号", name = "introdNo")
    private String introdNo;
    @ApiModelProperty(value = "介绍人", name = "introdName")
    private String introdName;
    @ApiModelProperty(value = "是否住宿 0否 1是", name = "putUp")
    private Integer putUp;
    @ApiModelProperty(value = "领取物品", name = "article")
    private String article;
    @ApiModelProperty(value = "入职次数", name = "entryTimes")
    private Integer entryTimes;





















}
