package cn.net.yzl.ehr.vo.attendRule;

import cn.hutool.core.util.ReUtil;
import cn.net.yzl.staff.vo.attendRule.DepartAttendRuleBaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * depart_attend_rule
 * @author 
 */

@ApiModel(value="DepartAttendRuleTimingVO",description="部门考勤定时规则实体")
@Data
public class DepartAttendRuleNormalVO extends DepartAttendRuleBaseVO {


    // 定时打卡正常
    @ApiModelProperty(value="考勤时段:上班时间",name="workStartTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String workStartTime;
    @ApiModelProperty(value="考勤时段:下班时间",name="workEndTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String workEndTime;
    @ApiModelProperty(value="中休的开始时间",name="restStartTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restStartTime;
    @ApiModelProperty(value="中休的结束时间",name="restEndTime",required = true)
//    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$")
    private String restEndTime;
    @ApiModelProperty(value="迟到规则(首次打卡时间大于上班时间,单位分钟)",name="lateTime",required = true)
    private Integer lateTime;
    @ApiModelProperty(value="早退规则(末次打卡时间小于下班时间,单位分钟)",name="leaveTime",required = true)
    private Integer leaveTime;
    @ApiModelProperty(value="是否大小周(0:否,1:是)",name="weekFlag",required = true)
    private Integer weekFlag;
    @ApiModelProperty(value="大小周字节",name="weekBit",hidden = true)
    private Integer weekBit;
    @ApiModelProperty(value="大小周字节字符串(101010)",name="weekBitStr",required = true)
//    @Pattern(regexp = "^([0-1]{7}|[0-1]{14})$")
    private String weekBitStr;


    public static void main(String[] args) {
//        System.err.println(ReUtil.isMatch("^(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])$", "23:51"));


        System.err.println(ReUtil.isMatch("^([0-1]{7}|[0-1]{14})$","10000000111111"));
    }
}