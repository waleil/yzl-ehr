package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class StaffInsertPo implements Serializable {
    /**
     * id 唯一标识
     */
    private Integer id;

    /**
     * 工号
     */
    private String no;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别 0:男,1:女
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工作地点 字典表 type: workplace
     */
    private Integer workplaceCode;

    /**
     * 属性(1:正编,2:外包)
     */
    private Integer nature;

    /**
     * 合作方id
     */
    private Integer partnerCode;

    /**
     * 职场id(字典表)
     */
    private Integer workCode;

    /**
     * 在职状态 0在职 1离职
     */
    private Integer workStatus;

    /**
     * 在岗状态 (指向字典表)
     */
    private Integer postStatusCode;

    /**
     * 账号状态 0正常 1停用
     */
    private Integer accountStatus;

    /**
     * 异动状态(指向字典）
     */
    private Integer abnoStatusCode;

    /**
     * 入职次数
     */
    private Integer entryTimes;

    /**
     * 头像地址
     */
    private String imgUrl;

    /**
     * 民族编号
     */
    private Integer nationCode;

    /**
     * 学历名称(指向字典)
     */
    private Integer degreeCode;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 专业
     */
    private String major;

    /**
     * 政治面貌(字典表)
     */
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
    private String emergencyPhone;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 开户行(暂定)
     */
    private Integer bankId;

    /**
     * 开户行名称
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String bankCard;

    /**
     * 订单结算中心  
     */
    private String orderClearingCenter;

    /**
     * 薪酬结算中心
     */
    private String payClearingCenter;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 是否有销售经验 0否 1是
     */
    private Integer salesFlag;

    /**
     * 培训状态(0.未完成,1.已完成)
     */
    private Integer trainingStatus;

    /**
     * 入岗状态 0待入岗 1已入岗
     */
    private Integer enterStatus;

    /**
     * 介绍人工号
     */
    private Integer introdNo;

    /**
     * 是否住宿 0否 1是
     */
    private Integer putUp;

    /**
     * 是否是储备人才 0否 1是
     */
    private Integer reserveTalent;

    /**
     * 保险备注
     */
    private String insuraRemark;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;


    /**
     * 老系统员工编号
     */
    private Integer oldStaffId;

    /**
     * 入职时间
     */
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
    private String article;

    private Integer hjProvinceId ;
    private String hjProvinceName ;
    private Integer hjCityId;
    private String hjCityName;
    private Integer hjCountyId;
    private String hjCountyName;
    private Integer hjStreetId;
    private String hjStreetName;
    private String  hjAddress;
    private Integer xjzdProvinceId ;
    private String xjzdProvinceName ;
    private Integer xjzdCityId;
    private String  xjzdCityName;
    private Integer  xjzdCountyId;
    private String  xjzdCountyName;
    private Integer  xjzdStreetId;
    private String xjzdStreetName;
    private String  xjzdAddress;







}