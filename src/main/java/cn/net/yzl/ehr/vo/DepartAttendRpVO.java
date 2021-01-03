package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * depart_attend_rp
 * @author 
 */
@Data
@ApiModel(value = "DepartAttendRpVO", description = "考勤奖惩项信息")
public class DepartAttendRpVO implements Serializable {

    @ApiModelProperty(value = "考勤奖惩项id", name = "rpItemId",required = true)
    @Min(1)
    private Integer rpItemId;
    @ApiModelProperty(value = "部门id", name = "departId",required = true)
    @Min(1)
    private Integer departId;
    @ApiModelProperty(value = "生效时间", name = "effectTime",hidden = true)
    private Date effectTime;
    @ApiModelProperty(value = "几日后生效", name = "days",required = true)
    @Min(1)
    private Integer days;
    @NotEmpty
    @ApiModelProperty(value = "扣除的钱list集合", name = "moneyList",required = true)
    private List<Double> moneyList;

}