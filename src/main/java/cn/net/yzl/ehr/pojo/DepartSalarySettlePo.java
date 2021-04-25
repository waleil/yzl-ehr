package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "DepartSalarySettlePo",description = "工资发放日与结算日")
public class DepartSalarySettlePo implements Serializable {
    @ApiModelProperty(value = "工资发放日与结算日id",name = "id")
    private Integer id;

    @ApiModelProperty(value = "部门id",name = "departId")
    private Integer departId;

    @ApiModelProperty(value = "工资发放日",name = "issueDate")
    private Integer issueDate;

    @ApiModelProperty(value = "工资结算日开始",name = "settleStart")
    private Integer settleStart;

    @ApiModelProperty(value = "工资结算日结束",name = "settleEnd")
    private Integer settleEnd;

    @ApiModelProperty(value = "急辞薪资核算截止日",name = "emergencySettleDate")
    private Integer emergencySettleDate;
//
//
//    private Integer isDel;
}
