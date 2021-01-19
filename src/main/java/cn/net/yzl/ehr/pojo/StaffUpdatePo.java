package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * staff
 * @author 
 */
@Data
public class StaffUpdatePo implements Serializable {
    private Integer id;

    @ApiModelProperty("工号")

    private String no;

    /**
     * 员工姓名
     */
    @ApiModelProperty("员工姓名")
    private String name;

    /**
     * 英文名
     */
    @ApiModelProperty("英文名")
    private String enName;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 性别 0:男,1:女
     */
    @ApiModelProperty("性别 0:男,1:女")
    private Integer sex;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 工作地点 字典表 type: workplace
     */
    @ApiModelProperty("工作地点 字典表 type: workplace")
    private Integer workplaceCode;

    /**
     * 属性(1:正编,2:外包)
     */
    @ApiModelProperty("属性(1:正编,2:外包)")
    private Integer nature;

    /**
     * 合作方id
     */
    @ApiModelProperty("合作方id")
    private Integer partnerCode;

    /**
     * 职场id(字典表)
     */
    @ApiModelProperty("职场id(字典表)")
    private Integer workCode;

    /**
     * 在职状态 0在职 1离职
     */
    @ApiModelProperty("在职状态 0在职 1离职")
    private Integer workStatus;

    /**
     * 在岗状态 (指向字典表)
     */
    @ApiModelProperty("在岗状态 (指向字典表)")
    private Integer postStatusCode;

    /**
     * 账号状态 0正常 1停用
     */
    @ApiModelProperty("账号状态 0正常 1停用")
    private Integer accountStatus;

    /**
     * 异动状态(指向字典）
     */
    @ApiModelProperty("异动状态(指向字典）")
    private Integer abnoStatusCode;

    /**
     * 入职次数
     */
    @ApiModelProperty("入职次数")
    private Integer entryTimes;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String imgUrl;

    /**
     * 民族编号
     */
    @ApiModelProperty("民族编号")
    private Integer nationCode;

    /**
     * 学历名称(指向字典)
     */
    @ApiModelProperty("学历名称(指向字典)")
    private Integer degreeCode;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String idCardNo;

    /**
     * 专业
     */
    @ApiModelProperty("专业")
    private String major;

    /**
     * 政治面貌(字典表)
     */
    @ApiModelProperty("政治面貌(字典表)")
    private Integer politicsStatusCode;

    /**
     * 生日
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    /**
     * 紧急联系电话
     */
    @ApiModelProperty("紧急联系电话")
    private String emergencyPhone;

    /**
     * 紧急联系人
     */
    @ApiModelProperty(" 紧急联系人")
    private String emergencyContact;

    /**
     * 开户行(暂定)
     */
    @ApiModelProperty("开户行(暂定)")
    private Integer bankId;

    /**
     * 开户行名称
     */
    @ApiModelProperty("开户行名称")
    private String bankName;

    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    private String bankCard;

    /**
     * 订单结算中心
     */
    @ApiModelProperty("订单结算中心")
    private String orderClearingCenter;

    /**
     * 薪酬结算中心
     */
    @ApiModelProperty("薪酬结算中心")
    private String payClearingCenter;

    /**
     * 微信号
     */
    @ApiModelProperty("微信号")
    private String wechat;

    /**
     * 是否有销售经验 0否 1是
     */
    @ApiModelProperty("是否有销售经验 0否 1是")
    private Integer salesFlag;

    /**
     * 培训状态(0.未完成,1.已完成)
     */
    @ApiModelProperty("培训状态(0.未完成,1.已完成)")
    private Integer trainingStatus;

    /**
     * 入岗状态 0待入岗 1已入岗
     */
    @ApiModelProperty("入岗状态 0待入岗 1已入岗")
    private Integer enterStatus;

    /**
     * 介绍人工号
     */
    @ApiModelProperty("介绍人工号")
    private Integer introdNo;

    /**
     * 是否住宿 0否 1是
     */
    @ApiModelProperty("是否住宿 0否 1是")
    private Integer putUp;

    /**
     * 是否是储备人才 0否 1是
     */
    @ApiModelProperty("是否是储备人才 0否 1是")
    private Integer reserveTalent;

    /**
     * 保险备注
     */
    @ApiModelProperty("保险备注")
    private String insuraRemark;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updator;

    @ApiModelProperty("修改时间")
    private Date updateTime;


    /**
     * 老系统员工编号
     */
    @ApiModelProperty("老系统员工编号")
    private Integer oldStaffId;

    /**
     * 入职时间
     */
    @ApiModelProperty("工号")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;

    /**
     * 入岗时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postTime;

    /**
     * 转正时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date positiveTime;

    /**
     * 离职时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dimissionTime;

    /**
     * 领用的物品
     */
    @ApiModelProperty("领用的物品")
    private String article;

    @ApiModelProperty("户籍省id")
    private Integer hjProvinceId ;

    @ApiModelProperty("户籍省名")
    private String hjProvinceName ;

    @ApiModelProperty("户籍市id")
    private Integer hjCityId;

    @ApiModelProperty("户籍市名")
    private String hjCityName;

    @ApiModelProperty("户籍(区/县)id")
    private Integer hjCountyId;

    @ApiModelProperty("户籍(区/县)名称")
    private String hjCountyName;

    @ApiModelProperty("户籍街道/镇id")
    private Integer hjStreetId;

    @ApiModelProperty("户籍街道/镇名")
    private String hjStreetName;

    @ApiModelProperty("户籍详细地址")
    private String  hjAddress;

    @ApiModelProperty("现住址省id")
    private Integer xjzdProvinceId ;

    @ApiModelProperty("现住址省名")
    private String xjzdProvinceName ;

    @ApiModelProperty("现住址市id")
    private Integer xjzdCityId;

    @ApiModelProperty("现住址市名")
    private String  xjzdCityName;

    @ApiModelProperty("现住址(区/县)id")
    private Integer  xjzdCountyId;

    @ApiModelProperty("现住址(区/县)名称")
    private String  xjzdCountyName;

    @ApiModelProperty("现住址街道/镇id")
    private Integer  xjzdStreetId;

    @ApiModelProperty("现住址街道/镇名")
    private String xjzdStreetName;

    @ApiModelProperty("现住址详细地址")
    private String  xjzdAddress;




}