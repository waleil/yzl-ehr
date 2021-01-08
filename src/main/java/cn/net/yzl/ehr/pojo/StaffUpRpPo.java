package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * staff_up_rp
 * @author 
 */
@Data
@ApiModel(value = "StaffUpRpPo", description = "员工奖惩记录")
public class StaffUpRpPo implements Serializable {

    @ApiModelProperty(value = "员工奖惩记录编号", name = "id")
    private Integer id;

    @ApiModelProperty(value = "员工表工号", name = "staffNo")
    private String staffNo;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private Date endTime;

    @ApiModelProperty(value = "奖惩内容", name = "content")
    private String content;

    @ApiModelProperty(value = "奖惩结果", name = "result")
    private String result;

    @ApiModelProperty(value = "奖/惩( 1.奖励 2.惩罚)", name = "flag")
    private Integer flag;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "创建人", name = "creator")
    private String creator;

    @ApiModelProperty(value = " 修改时间", name = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "修改人", name = "updator")
    private String updator;

    private static final long serialVersionUID = 1L;


}