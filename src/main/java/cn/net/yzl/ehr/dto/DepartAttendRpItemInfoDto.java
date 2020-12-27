package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 考勤奖惩信息 考勤奖惩信息表
 */
@Data
@ApiModel(value = "DepartAttendRpItemInfoDto", description = "考勤奖惩信息表")
public class DepartAttendRpItemInfoDto implements Serializable {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "奖惩项id", name = "attendRpItemId")
    private Integer attendRpItemId; // 奖惩项id
    @ApiModelProperty(value = "部门id", name = "attendRpItemId")
    private Integer departId;
    @ApiModelProperty(value = "考勤奖惩项名称", name = "name")
    private String name;
    @ApiModelProperty(value = "总共几次", name = "times")
    private Integer times; // 几次

    @ApiModelProperty(value = "考勤奖惩项扣款信息表", name = "attendRpDtoList")
    private List<DepartAttendRpDto> attendRpDtoList;



}