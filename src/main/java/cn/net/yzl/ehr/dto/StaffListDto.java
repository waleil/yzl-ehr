package cn.net.yzl.ehr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_back
 * @author 
 */
@Data
@JsonIgnoreProperties(value = {"handler"})
@ApiModel(value = "DepartDto", description = "部门实体信息")
public class StaffListDto implements Serializable {

    @ApiModelProperty(value = "用户名称", name = "name")
    private String name;
    @ApiModelProperty(value = "拼音名", name = "enName")
    private String enName;
    @ApiModelProperty(value = "手机号", name = "phone")
    private String phone;
    @ApiModelProperty(value = "电子邮件", name = "email")
    private String email;
    @ApiModelProperty(value = "员工工号", name = "staffNo")
    @Id
    private String staffNo;

    @ApiModelProperty(value = "工作地点code", name = "workplaceCode")
    private Integer workplaceCode;
    @ApiModelProperty(value = "工作地点", name = "workplaceCodeStr")
    private String workplaceCodeStr;
    /**
     * 性别 0:男,1:女
     */
    @ApiModelProperty(value = "性别 0:男,1:女", name = "sex")
    private Integer sex;

    @ApiModelProperty(value = "属性(1:正编,2:外包)", name = "nature")
    private Integer nature;
    @ApiModelProperty(value = "上级架构部门id", name = "pDepartId")
    private Integer pDepartId;
    @ApiModelProperty(value = "上级部门名称", name = "pDepartName")
    private String pDepartName;
    @ApiModelProperty(value = "部门id", name = "departId")
    private Integer departId;
    @ApiModelProperty(value = "部门名称", name = "departName")
    private String departName;
    @ApiModelProperty(value = "岗位id", name = "postId")
    private Integer postId;
    @ApiModelProperty(value = "岗位名称", name = "postName")
    private String postName;
    @ApiModelProperty(value = "岗位id", name = "departPostId")
    private Integer departPostId;

    @ApiModelProperty(value = "岗位级别id", name = "postLevelId")
    private Integer postLevelId;
    @ApiModelProperty(value = "岗位级别名称", name = "postLevelName")
    private String postLevelName;
    @ApiModelProperty(value = "合作方code", name = "partnerCode")
    private Integer partnerCode;
    @ApiModelProperty(value = "合作方名称", name = "partnerName")
    private String partnerName;

    @ApiModelProperty(value = "职场id(字典表)", name = "workCode")
    private Integer workCode;
    @ApiModelProperty(value = "职场", name = "workCodeStr")
    private String workCodeStr;
    @ApiModelProperty(value = "在职状态", name = "postStatusCode")
    private Integer postStatusCode;
    @ApiModelProperty(value = "在职状态名称", name = "postStatusCodeStr")
    private String postStatusCodeStr;
    @ApiModelProperty(value = "账号状态 0正常 1停用", name = "accountStatus")
    private Integer accountStatus;

    @ApiModelProperty(value = "异动状态code", name = "abnoStatusCode")
    private Integer abnoStatusCode;
    @ApiModelProperty(value = "异动状态", name = "abnoStatusCodeStr")
    private String abnoStatusCodeStr;

    @ApiModelProperty(value = "入职次数", name = "entryTimes")
    private Integer entryTimes;
    @ApiModelProperty(value = "异动时间", name = "abnorTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date abnorTime;
    @ApiModelProperty(value = "入岗时间", name = "postTime")
    private Date postTime;
    @ApiModelProperty(value = "最近调入岗时间", name = "transferPostTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date transferPostTime;
    @ApiModelProperty(value = "离职时间", name = "dimissionTime")
    private Date dimissionTime;
    @ApiModelProperty(value = "薪资核算结算日", name = "payrollAccountingDate")
    private Date payrollAccountingDate;
    @ApiModelProperty(value = "培训次数", name = "trainingTimes")
    private Integer training_times;
    @ApiModelProperty(value = "培训完成度code", name = "trainingCompletion")
    private Integer trainingCompletion;
    @ApiModelProperty(value = "培训完成度", name = "trainingCompletionName")
    private String trainingCompletionName;
    @ApiModelProperty(value = "培训成绩code", name = "trainingGrade")
    private Integer trainingGrade;
    @ApiModelProperty(value = "培训成绩", name = "trainingGradeName")
    private String trainingGradeName;
    @ApiModelProperty(value = "入岗状态code", name = "enterStatus")
    private Integer enterStatus;
    @ApiModelProperty(value = "入岗状态名称", name = "enterStatusName")
    private String enterStatusName;


}