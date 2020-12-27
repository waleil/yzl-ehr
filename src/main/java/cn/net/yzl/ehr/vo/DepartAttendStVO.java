package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_attend_st
 * @author 
 */
@Data
@ApiModel(value = "DepartAttendStVO", description = "考勤结算日信息实体")
public class DepartAttendStVO implements Serializable {
    /**
     * 部门id
     */
    @Min(1)
    @ApiModelProperty(value = "部门id", name = "id")
    private Integer departId;

    /**
     * 结算日(每个月几号)
     */
    @Min(1)
    @Max(31)
    @ApiModelProperty(value = "部门id", name = "id")
    private Byte day;

}