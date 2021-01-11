package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * staff_edu
 * @author 
 */
@Data
@ApiModel(value = "StaffEduPo", description = "员工教育经历")
public class StaffEduDto implements Serializable {

    @ApiModelProperty(value = "员工教育编号", name = "id")
    @NotNull
    private Integer id;

    /**
     * 员工表工号
     */
    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    @NotBlank
    private String staffNo;

    /**
     * 起始时间
     */
    @ApiModelProperty(value = "起始时间", name = "startTime")
    private Date startTime;

    /**
     * 终止时间
     */
    @ApiModelProperty(value = "终止时间", name = "endTime")
    private Date endTime;

    /**
     * 毕业学校
     */
    @ApiModelProperty(value = "毕业学校", name = "school")
    @NotBlank
    private String school;

    /**
     * 学历
     */
    @ApiModelProperty(value = "学历", name = "degree")
    @NotNull
    private Integer degree;

    /**
     * 专业/院系
     */
    @ApiModelProperty(value = "专业/院系", name = "major")
    @NotBlank
    private String major;

    /**
     * 证书路径
     */
    @ApiModelProperty(value = "证书路径", name = "path")
    @NotBlank
    private String path;

    /**
     * 持有证书
     */
    @ApiModelProperty(value = "持有证书", name = "certificate")
    @NotBlank
    private String certificate;


    private static final long serialVersionUID = 1L;


}