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
@ApiModel(value = "staffListDto", description = "员工信息")
public class StaffListDto implements Serializable {

    @ApiModelProperty(value = "id", name = "id")
    private Integer id;
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
    @ApiModelProperty(value = "身份证号", name = "idCardNo")
    private String idCardNo;
    @ApiModelProperty(value = "工作地点code", name = "workplaceCode")
    private Integer workplaceCode;
    @ApiModelProperty(value = "工作地点", name = "workplaceCodeStr")
    private String workplaceCodeStr;
    /**
     * 性别 0:男,1:女
     */
    @ApiModelProperty(value = "性别 0:男,1:女", name = "sex")
    private Integer sex;
    @ApiModelProperty(value = "性别名称", name = "sexName")
    private String sexName;
    @ApiModelProperty(value = "属性(1:正编,2:外包)", name = "nature")
    private Integer nature;
    @ApiModelProperty(value = "属性名称", name = "natureName")
    private String natureName;
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
    @ApiModelProperty(value = "部门岗位id", name = "departPostId")
    private Integer departPostId;
    @ApiModelProperty(value = "是否显示确认入岗按钮(0.不需要,1.需要)", name = "confirmType")
    private Integer confirmType;

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
    @ApiModelProperty(value = "在职标识(0.不在职，1.在职)", name = "workStatus")
    private Integer workStatus;
    @ApiModelProperty(value = "账号状态 0正常 1停用", name = "accountStatus")
    private Integer accountStatus;
    @ApiModelProperty(value = "账号状态名称", name = "accountStatusStr")
    private String accountStatusStr;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date postTime;
    @ApiModelProperty(value = "转正时间", name = "positiveTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date positiveTime;
    @ApiModelProperty(value = "最近调入岗时间", name = "transferPostTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date transferPostTime;
    @ApiModelProperty(value = "离职时间", name = "dimissionTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date dimissionTime;
    @ApiModelProperty(value = "薪资核算结算日", name = "payrollAccountingDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
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
    @ApiModelProperty(value = "是否有异动历史(0.无,1.有)", name = "abnorHistory")
    private Integer abnorHistory;
    @ApiModelProperty(value = "是否补全（0.未补全，1.已补全）", name = "isComplete")
    private Integer isComplete;
    @ApiModelProperty(value = "来源类型(0.招聘,1.导入)", name = "isImport")
    private Integer isImport;
    @ApiModelProperty(value = "来源类型(0.招聘,1.导入)", name = "isImportName")
    private String isImportName;

    public void setIsImport(Integer isImport) {
        if(isImport!=null){
            this.isImport=isImport;
            if (isImport == 0) {
                this.isImportName = "招聘";
            } else if (isImport == 1) {
                this.isImportName = "导入";
            }
        }
    }

    public void setSex(Integer sex) {
        if(sex!=null) {
            this.sex = sex;
            if (sex == 0) {
                this.sexName = "男";
            } else if (sex == 1) {
                this.sexName = "女";
            }
        }
    }

    public void setNature(Integer nature) {
        if(nature!=null){
            this.nature=nature;
            if(nature==1){
                this.natureName = "正编";
            }else if(nature==2){
                this.natureName = "外包";
            }
        }
    }

    public void setAccountStatus(Integer accountStatus) {
        if(accountStatus!=null) {
            this.accountStatus = accountStatus;
            if (accountStatus == 0) {
                this.accountStatusStr = "正常";
            } else if (accountStatus == 1) {
                this.accountStatusStr = "停用";
            }
        }
    }
}