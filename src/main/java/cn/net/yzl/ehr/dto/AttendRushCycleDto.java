package cn.net.yzl.ehr.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * attend_rush_cycle
 * @author 
 */
@ApiModel(value="AttendRushCycleDto",description="考勤周期")
public class AttendRushCycleDto implements Serializable {

    @ApiModelProperty(value="考勤周期id",name="id")
    private Integer id;

    @ApiModelProperty(value="考勤规则id",name="attendRuleId")
    private Integer attendRuleId;

    @ApiModelProperty(value="时间(年,月)",name="time")
    @JsonFormat(pattern="yyyy-MM",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date time;

    @ApiModelProperty(value="选上班日期(0表示否,1表示是,用4个字节表示)",name="crycle")
    private Integer crycle;

    // 字符创 01010101  1表示勾选,0表示不勾选
    @ApiModelProperty(value="字符创 01010101  1表示勾选,0表示不勾选",name="crycleStr")
    private String crycleStr;

    @ApiModelProperty(value="编辑标识字段010101001(1:可以,0:不可以)",name="editFlagStr")
    private String editFlagStr;


}