package cn.net.yzl.ehr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ding_talk_user
 * @author 
 */
@Data
public class DingTalkUserPo implements Serializable {
    /**
     * 员工在当前企业内的唯一标识，也称staffId。可由企业在创建时指定，并代表一定含义比如工号，创建后不可修改
     */
    private String userId;

    /**
     * 员工在当前开发者企业账号范围内的唯一标识，系统生成，固定值，不会改变
     */
    private String unionId;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 分机号（仅限企业内部开发调用）
     */
    private String tel;

    /**
     * 办公地点
     */
    private String workPlace;

    /**
     * 备注
     */
    private String remark;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回
     */
    private String orgEmail;

    /**
     * 是否已经激活，1表示已激活，0表示未激活
     */
    private Byte active;

    /**
     * 在对应的部门中的排序，Map结构的json字符串，key是部门的id，value是人员在这个部门的排序值
     */
    private String orderInDepts;

    /**
     * 是否为企业的管理员，1表示是，0表示不是
     */
    private Byte isAdmin;

    /**
     * 是否为企业的老板，1表示是，0表示不是
     */
    private Byte isBoss;

    /**
     * 在对应的部门中是否为主管：Map结构的json字符串，key是部门的id，value是人员在这个部门中是否为主管，true表示是，false表示不是
     */
    private String isLeaderinDepts;

    /**
     * 是否号码隐藏，1表示隐藏，0表示不隐藏
     */
    private Byte isHide;

    /**
     * 成员所属部门id列表
     */
    private String department;

    /**
     * 职位信息
     */
    private String position;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     */
    private Date hiredDate;

    /**
     * 员工工号
     */
    private String jobnumber;

    /**
     * 扩展属性，可以设置多种属性（手机上最多显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置）。

该字段的值支持链接类型填写，同时链接支持变量通配符自动替换，目前支持通配符有：userid，corpid。示例： [工位地址](http://www.dingtalk.com?userid=#userid#&corpid=#corpid#) 
     */
    private String extattr;

    /**
     * 是否是高管
     */
    private Byte isSenior;

    /**
     * 国家地区码
     */
    private String stateCode;

    /**
     * 是否实名认证
     */
    private Byte realAuthed;

    /**
     * 钉钉部门id信息集合 ,逗号分隔
     */
    private String departIds;

    private static final long serialVersionUID = 1L;
}