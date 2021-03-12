package cn.net.yzl.ehr.vo.attendRule;

import cn.net.yzl.staff.vo.attendRule.DepartAttendRuleBaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * depart_attend_rule
 * @author 
 */

@ApiModel(value="DepartAttendRuleElasticVO",description="部门考勤规则弹性实体")
@Data
public class DepartAttendRuleElasticVO extends DepartAttendRuleBaseVO {



    @ApiModelProperty(value="中休的开始时间",name="restStartTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restStartTime;
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    @ApiModelProperty(value="中休的结束时间",name="restEndTime",required = true)
    private String restEndTime;
    @NotNull
    @ApiModelProperty(value="迟到规则(首次打卡时间大于上班时间,单位分钟)",name="lateTime",required = true)
    private Integer lateTime;
    @NotNull
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime",required = true)
    private Integer leaveTime;

    @ApiModelProperty(value="是否大小周(0:否,1:是)",name="weekFlag",required = true)
    @Max(1)
    @Min(0)
    @NotNull
    private Integer weekFlag;
    @ApiModelProperty(value="大小周字节",name="weekBit",hidden = true)
    private Integer weekBit;
    @ApiModelProperty(value="大小周字节字符串(101010)",name="weekBitStr",required = true)
    @NotBlank
    @Pattern(regexp = "^([0-1]{7}|[0-1]{14})$")
    private String weekBitStr;



    @ApiModelProperty(value="弹性打卡:上班打卡时段开始时间",name="elasticUpStartTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String elasticUpStartTime;
    @ApiModelProperty(value="弹性打卡:上班打卡时段结束时间",name="remindTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String elasticUpEndTime;
    @ApiModelProperty(value="弹性打卡:下班打卡时段开始时间",name="remindTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String elasticDownStartTime;
    @ApiModelProperty(value="弹性打卡:下班打卡时段结束时间",name="remindTime",required = true)
    @NotBlank
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String elasticDownEndTime;



}