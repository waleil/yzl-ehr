package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "DepartAttendStDto", description = "考勤结算日信息实体")
public class DepartAttendStDto implements Serializable {
    @ApiModelProperty(value = "部门id", name = "id")
    private Integer departId;
    @ApiModelProperty(value = "结算日(每个月几号)", name = "day")
    private Byte day;

}