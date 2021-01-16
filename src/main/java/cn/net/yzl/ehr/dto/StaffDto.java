package cn.net.yzl.ehr.dto;

import cn.net.yzl.ehr.dto.StaffAddrListDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * staff
 * @author
 */
@Data
public class StaffDto implements Serializable {
    /**
     * id 唯一标识
     */
    @ApiModelProperty("id 唯一标识")
    private Integer id;

    /**
     * 工号
     */
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
     * 工作地点 字典表 type: workarea
     */
    @ApiModelProperty("工作地点")
    private Integer workplaceCode;

    /**
     * 属性(1:正编,2:外包)
     */
    @ApiModelProperty(" 属性(1:正编,2:外包)")
    private Integer nature;

    /**
     * 合作方id
     */
    @ApiModelProperty("合作方id")
    private Integer partnerCode;

    /**
     * 职场id(字典表)
     */
    @ApiModelProperty("职场id")
    private Integer workCode;

    /**
     * 在职状态 0在职 1离职
     */
    @ApiModelProperty("在职状态 0在职 1离职")
    private Byte workStatus;

    /**
     * 在岗状态 (指向字典表)
     */
    @ApiModelProperty("在岗状态")
    private Integer postStatusCode;

    /**
     * 账号状态 0正常 1停用
     */
    @ApiModelProperty("账号状态 0正常 1停用")
    private Byte accountStatus;

    /**
     * 异动状态(指向字典）
     */
    @ApiModelProperty("异动状态")
    private Integer abnoStatusCode;

    /**
     * 入职次数
     */
    @ApiModelProperty("入职次数")
    private Byte entryTimes;

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
    @ApiModelProperty("学历名称")
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
    @ApiModelProperty("政治面貌")
    private Integer politicsStatusCode;

    /**
     * 生日
     *
     */
    @ApiModelProperty("生日")
    private Date birthdate;

    /**
     * 紧急联系电话
     */
    @ApiModelProperty("紧急联系电话")
    private String emergencyPhone;

    /**
     * 紧急联系人
     */
    @ApiModelProperty("紧急联系人")
    private String emergencyContact;

    /**
     * 开户行(暂定)
     */
    @ApiModelProperty("开户行")
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
    private Byte salesFlag;

    /**
     * 培训状态(0.未完成,1.已完成)
     */
    @ApiModelProperty("培训状态(0.未完成,1.已完成)")
    private Byte trainingStatus;

    /**
     * 入岗状态 0待入岗 1已入岗
     */
    @ApiModelProperty("入岗状态 0待入岗 1已入岗")
    private Byte enterStatus;

    /**
     * 介绍人工号
     */
    @ApiModelProperty("介绍人工号")
    private String introdNo;

    /**
     * 是否住宿 0否 1是
     */
    @ApiModelProperty("是否住宿 0否 1是")
    private Byte putUp;

    /**
     * 是否是储备人才 0否 1是
     */
    @ApiModelProperty("是否是储备人才 0否 1是")
    private Byte reserveTalent;

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

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updator;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
     * 是否删除 0正常 1删除
     */
    @ApiModelProperty("是否删除 0正常 1删除 ")
    private Byte isDel;

    /**
     * 老系统员工编号
     */
    @ApiModelProperty("老系统员工编号")
    private Integer oldStaffId;

    /**
     * 入职时间
     */
    @ApiModelProperty("入职时间")
    private Date entryTime;

    /**
     * 入岗时间
     */
    @ApiModelProperty("入岗时间")
    private Date postTime;

    /**
     * 转正时间
     */
    @ApiModelProperty("转正时间")
    private Date positiveTime;

    /**
     * 离职时间
     */
    @ApiModelProperty("离职时间")
    private Date dimissionTime;

    /**
     * 领用的物品
     */
    @ApiModelProperty("领用的物品")
    private String article;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    private Integer roleId;

    private List<StaffAddrListDto> addrListDtoList;

    private static final long serialVersionUID = 1L;

}