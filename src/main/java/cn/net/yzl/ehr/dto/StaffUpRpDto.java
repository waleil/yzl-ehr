package cn.net.yzl.ehr.dto;

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
@ApiModel(value = "StaffUpRpDto", description = "员工奖惩记录")
public class StaffUpRpDto implements Serializable {
    @ApiModelProperty(value = "员工编号",name = "id")
    private Integer id;

    @ApiModelProperty(value = "员工工号",name = "staffNo")
    private String staffNo;

    @ApiModelProperty(value = "开始时间",name = "startTime")
    private Date startTime;

    @ApiModelProperty(value = "结束时间",name = " endTime")
    private Date endTime;

    @ApiModelProperty(value = "奖惩内容",name = "content")
    private String content;

    @ApiModelProperty(value = "奖惩结果",name = "result")
    private String result;

    @ApiModelProperty(value = "奖/惩 (1.奖励 2.惩罚)",name = "flag")
    private Integer flag;


    private static final long serialVersionUID = 1L;


}