package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * depart_attend_rp
 * @author 
 */
@Data
@ApiModel(value = "DepartAttendRpDto", description = "DepartAttendRpDto")
public class DepartAttendRpDto implements Serializable {

    @ApiModelProperty(value = "考勤奖惩项规则id", name = "attendRpId")
    private Integer attendRpId;
    @ApiModelProperty(value = "奖惩金额", name = "money")
    private Double money;
    @ApiModelProperty(value = "第几次(0:表示一次奖惩)", name = "times")
    private Integer times;
    @ApiModelProperty(value = "考勤奖惩项id", name = "rpItemId")
    private Integer rpItemId;
    @ApiModelProperty(value = "考勤奖惩名称", name = "rpItemName")
    private String rpItemName;


}