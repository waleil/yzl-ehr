package cn.net.yzl.ehr.vo.attendRule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * depart_attend_rule
 * @author 
 */

@ApiModel(value="DepartAttendRuleBaseVO",description="部门考勤规则base实体")
@Data
public class DepartAttendRuleBaseVO implements Serializable {

    @ApiModelProperty(value="部门id",name="departId",required = true)
    @Min(1)
    @NotNull
    protected Integer departId;
    @ApiModelProperty(value="岗位id",name="postId",required = true)
    @Min(1)
    @NotNull
    protected Integer postId;
    @ApiModelProperty(value="部门岗位id",name="departPostId",required = true)
    @Min(1)
    @NotNull
    protected Integer departPostId;
    @ApiModelProperty(value="字典类型id",name="type",required = true)
    @NotNull
    @Min(1)
    protected Integer type;

    @ApiModelProperty(value="0:否,1:是(1:也表示立即生效的)",name="enable",required = true)
    @Max(1)
    @Min(0)
    @NotNull
    private Integer enable;
    @ApiModelProperty(value="生效时间",name="effectTime",hidden = true)
    private Date effectTime;
    @ApiModelProperty(value="几日后生效(enable 为0时,必填)",name="days")
    private Integer days;

    @ApiModelProperty(value="分页的标识(1:是,0:不是)",name="pageFlag",hidden = true)
    private Integer pageFlag;



}