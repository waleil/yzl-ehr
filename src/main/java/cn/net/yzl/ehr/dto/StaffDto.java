package cn.net.yzl.ehr.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * staff
 * @author
 */
@Data
public class StaffDto implements Serializable {
    @ApiModelProperty("id 唯一标识")
    private Integer id;

    @ApiModelProperty("工号")
    private String no;

    @ApiModelProperty("员工姓名")
    private String name;

    @ApiModelProperty("英文名")
    private String enName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("性别 0:男,1:女")
    private Byte sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("工作地点 字典表 type: workarea")
    private Integer workplaceCode;

    @ApiModelProperty("属性(1:正编,2:外包)")
    private Byte nature;

    @ApiModelProperty("合作方id")
    private Integer partnerCode;

    @ApiModelProperty("职场id(字典表)")
    private Integer workCode;

    @ApiModelProperty("在职状态(字典表)")
    private Byte workStatus;

    @ApiModelProperty("在岗状态 (0：已入职，1.未入职)")
    private Integer postStatusCode;

    @ApiModelProperty("账号状态 0正常 1停用")
    private Byte accountStatus;

    @ApiModelProperty("异动状态(指向字典）")
    private Integer abnoStatusCode;

    @ApiModelProperty("入职次数")
    private Byte entryTimes;

    @ApiModelProperty("头像地址")
    private String imgUrl;

    @ApiModelProperty("民族编号")
    private Integer nationCode;

    @ApiModelProperty("学历名称(指向字典)")
    private Integer degreeCode;

    @ApiModelProperty("身份证号")
    private String idCardNo;

    @ApiModelProperty("专业")
    private String major;

    @ApiModelProperty("政治面貌(字典表)")
    private Integer politicsStatusCode;

    @ApiModelProperty("生日")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @ApiModelProperty("紧急联系电话")
    private String emergencyPhone;

    @ApiModelProperty("紧急联系人")
    private String emergencyContact;

    @ApiModelProperty("开户行(暂定)")
    private Integer bankId;

    @ApiModelProperty("开户行名称")
    private String bankName;

    @ApiModelProperty("银行卡号")
    private String bankCard;

    @ApiModelProperty("订单结算中心")
    private String orderClearingCenter;

    @ApiModelProperty("薪酬结算中心")
    private String payClearingCenter;

    @ApiModelProperty("微信号")
    private String wechat;

    @ApiModelProperty("是否有销售经验 0否 1是")
    private Byte salesFlag;

    @ApiModelProperty("培训次数")
    private Integer trainingTimes;

    @ApiModelProperty("培训状态(0.未完成,1.已完成)")
    private Integer trainingStatus;

    @ApiModelProperty("培训成绩(字典表)")
    private Integer trainingGrade;

    @ApiModelProperty("入岗状态 0待入岗 1已入岗")
    private Byte enterStatus;

    @ApiModelProperty("介绍人工号")
    private String introdNo;

    @ApiModelProperty("是否住宿 0否 1是")
    private Byte putUp;

    @ApiModelProperty("是否是储备人才 0否 1是")
    private Byte reserveTalent;

    @ApiModelProperty("保险备注")
    private String insuraRemark;

    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty("修改人")
    private String updator;

    @ApiModelProperty("修改时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    @ApiModelProperty("是否删除 0正常 1删除")
    private Byte isDel;

    @ApiModelProperty("老系统员工编号")
    private Integer oldStaffId;

    @ApiModelProperty("入职时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;

    @ApiModelProperty("入岗时间")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postTime;



    private List<String> permsList;
}
