package cn.net.yzl.ehr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * staff
 * @author 
 */
@Data
@Builder(toBuilder = true)
public class StaffPo implements Serializable {
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
    private Byte workplaceId;

    /**
     * 在岗状态(0:无效,1:试用,2:正式,3:离职,4:实习)
     */
    private Byte workStatus;

    /**
     * 账号状态 (0:停用,1:正常)
     */
    private Byte accountStatus;

    /**
     * 培训状态 (0:未培训,1:已培训,2:培训完成)
     */
    private Byte trainStatus;

    /**
     * 异动状态(1:正常,2:待优化,3:待劝退,4:已离职)
     */
    private Byte abnormalStatus;

    /**
     * 异动时间(最新的)
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date abnormalTime;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entryTime;

    /**
     * 性别(0:未知1:男,2:女)
     */
    private Byte sex;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    /**
     * 紧急联系人
     */
    private String emergency;

    /**
     * 转正时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
     * 钉钉userid
     */
    private String dingUserId;

    /**
     * 钉钉唯一表示
     */
    private String dingUnionId;

    /**
     * 状态(0:删除,1:有效)
     */
    private Byte isDel;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;


    @ApiModelProperty(value = "业务属性", name = "attrCode")
    private Integer attrCode;

    /**
     * 更新人id
     */
    private Integer updateId;

    private static final long serialVersionUID = 1L;
}