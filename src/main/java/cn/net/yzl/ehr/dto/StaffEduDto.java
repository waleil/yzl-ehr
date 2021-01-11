package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    private Integer id;

    /**
     * 员工表工号
     */
    @ApiModelProperty(value = "员工表工号", name = "staffNo")
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
    private String school;

    /**
     * 学历
     */
    @ApiModelProperty(value = "学历", name = "degree")
    private Integer degree;

    /**
     * 专业/院系
     */
    @ApiModelProperty(value = "专业/院系", name = "major")
    private String major;

    /**
     * 证书路径
     */
    @ApiModelProperty(value = "证书路径", name = "path")
    private String path;

    /**
     * 持有证书
     */
    @ApiModelProperty(value = "持有证书", name = "certificate")
    private String certificate;

    /**
     * 是否删除 0正常 1删除
     */
    @ApiModelProperty(value = "是否删除 (0正常 1删除)", name = "isDel")
    private Integer isDel;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;

    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人", name = "updator")
    private String updator;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", name = "updateTime")
    private Date updateTime;

    private static final long serialVersionUID = 1L;


}