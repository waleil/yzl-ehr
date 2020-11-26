package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 员工实体
 */
@Data
public class StaffPo {

    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 工号
     */
    private Integer no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 工作地点:指向系统字典表
     1总部,2:桥西,3:邢台,4:方北,5:北京
     */
    private Integer workplaceId;

    /**
     * 部门id
     */
    private Integer departId;

    /**
     * 岗位id
     */
    private Integer postId;

    /**
     * 岗位级别id
     */
    private Integer postLevelId;

    /**
     * 在岗状态(0:无效,1:试用,2:正式,3:离职,4:实习)
     */
    private Integer workStatus;

    /**
     * 账号状态 (0:停用,1:正常)
     */
    private Integer accountStatus;

    /**
     * 培训状态 (0:未培训,1:已培训,2:培训完成)
     */
    private Integer trainStatus;

    /**
     * 加盐后密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 名族标识
     */
    private Integer nationId;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 住址
     */
    private String address;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 性别(0:未知1:男,2:女)
     */
    private Integer sex;

    /**
     * 学历(指向字典表)
     */
    private Integer educationId;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 紧急联系人
     */
    private String emergency;

    /**
     * 转正时间
     */
    private Date positiveTime;

    /**
     * 银行卡号
     */
    private String card;

    /**
     * 订单结算中心
     */
    private String orderClearingCenter;

    /**
     * 薪酬结算中心
     */
    private String payClearingCenter;

    /**
     * 状态(0:无效,1:有效)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人id
     */
    private Integer updateId;

  }