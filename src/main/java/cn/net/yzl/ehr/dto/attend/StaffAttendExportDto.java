package cn.net.yzl.ehr.dto.attend;

import cn.net.yzl.staff.dto.attend.StaffAttendDayDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * staff_attend_statistics_month
 * @author 
 */
@Data
@ApiModel(value = "StaffAttendListDto", description = "员工考勤统计列表实体")
public class StaffAttendExportDto implements Serializable {

    @ApiModelProperty(value = "唯一标识", name = "id")
    private Integer id;
    @ApiModelProperty(value = "员工名称", name = "staffName")
    private String staffName;
    @ApiModelProperty(value = "员工工号", name = "staffNo")
    private String staffNo;
    @ApiModelProperty(value = "部门名称集合(-分隔)", name = "departNames")
    private String departNames;
    @ApiModelProperty(value = "部门id集合(,分隔)", name = "departIds")
    private String departIds;
    @ApiModelProperty(value = "部门id", name = "departId")
    private Integer departId;
    @ApiModelProperty(value = "部门名称", name = "departName")
    private String departName;
    @ApiModelProperty(value = "岗位id", name = "postId")
    private Integer postId;
    @ApiModelProperty(value = "岗位名称", name = "postName")
    private String postName;
    @ApiModelProperty(value = "岗位级别", name = "postLevelId")
    private Integer postLevelId;
    @ApiModelProperty(value = "岗位级别名称", name = "postLevelName")
    private String postLevelName;
    @ApiModelProperty(value = "部门岗位id", name = "departPostId")
    private Integer departPostId;
    @ApiModelProperty(value = "出勤天数", name = "attendDays")
    private Double attendDays;
    @ApiModelProperty(value = "考勤组名称", name = "attendGroupName")
    private String attendGroupName;
    @ApiModelProperty(value = "休息天数", name = "restDays")
    private Double restDays;
    @ApiModelProperty(value = "工作时长(单位分)", name = "workTime")
    private Integer workTime;
    @ApiModelProperty(value = "应出勤天数", name = "shouldAttendDays")
    private double shouldAttendDays;

    private String v1;
    private String v2;
    private String v3;
    private String v4;
    private String v5;
    private String v6;
    private String v7;
    private String v8;
    private String v9;
    private String v10;
    private String v11;
    private String v12;
    private String v13;
    private String v14;
    private String v15;
    private String v16;
    private String v17;
    private String v18;
    private String v19;
    private String v20;
    private String v21;
    private String v22;
    private String v23;
    private String v24;
    private String v25;
    private String v26;
    private String v27;
    private String v28;
    private String v29;
    private String v30;
    private String v31;
    private String v32;


    @ApiModelProperty(value = "每天出勤信息集合", name = "staffAttendDayDtoList")
    private List<StaffAttendDayDto> staffAttendDayDtoList;

    public void setStaffAttendDayDtoList(List<StaffAttendDayDto> staffAttendDayDtoList) {
        for (int i = 0; i < staffAttendDayDtoList.size(); i++) {
            if(i==0){v1=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==1){v2=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==2){v3=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==3){v4=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==4){v5=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==5){v6=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==6){v7=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==7){v8=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==8){v9=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==9){v10=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==10){v11=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==11){v12=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==12){v13=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==13){v14=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==14){v15=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==15){v16=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==16){v17=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==17){v18=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==18){v19=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==19){v20=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==20){v21=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==21){v22=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==22){v23=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==23){v24=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==24){v25=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==25){v26=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==26){v27=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==27){v28=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==28){v29=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==29){v30=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==30){v31=staffAttendDayDtoList.get(i).getDesc();}
            else if(i==31){v32=staffAttendDayDtoList.get(i).getDesc();}
        }

        this.staffAttendDayDtoList = staffAttendDayDtoList;
    }

    //    @ApiModelProperty(value = "迟到次数", name = "lateTimes")
//    private Byte lateTimes;
//    @ApiModelProperty(value = "迟到时长(单位分)", name = "lateTime")
//    private Integer lateTime;
//    @ApiModelProperty(value = "旷工迟到天数", name = "absenLateDays")
//    private Double absenLateDays;
//
//    @ApiModelProperty(value = "旷工迟到天数", name = "absenLateDays")
//    private Byte leaveEarlyTimes;
//    @ApiModelProperty(value = "早退时长(单位分)", name = "leaveEarlyTime")
//    private Integer leaveEarlyTime;
//    @ApiModelProperty(value = "上班缺卡次数", name = "sworkMissCardTimes")
//    private Byte sworkMissCardTimes;
//    @ApiModelProperty(value = "下班缺卡次数", name = "eworkMissCardTimes")
//    private Byte eworkMissCardTimes;
//    @ApiModelProperty(value = "旷工天数", name = "absenWorkDays")
//    private Double absenWorkDays;
//
//    @ApiModelProperty(value = "请假天数(暂定)", name = "leaveDays")
//    private Double leaveDays;
//    @ApiModelProperty(value = "加班时长(暂定)", name = "workExtraHours")
//    private Double workExtraHours;
//    @ApiModelProperty(value = "出差时长(单位分,暂定)", name = "travelTime")
//    private Integer travelTime;
//
//    @ApiModelProperty(value = "外出时长(单位分,暂定)", name = "goOutTime")
//    private Integer goOutTime;
//    @ApiModelProperty(value = "事假天数", name = "compassionateDays")
//    private Double compassionateDays;
//    @ApiModelProperty(value = "调休天数", name = "compensatoryDays")
//    private Double compensatoryDays;
//    @ApiModelProperty(value = "产假天数", name = "maternityDays")
//    private Double maternityDays;
//    @ApiModelProperty(value = "婚假天数", name = "marriageDays")
//    private Double marriageDays;
//    @ApiModelProperty(value = "丧假天数", name = "bereavementDays")
//    private Double bereavementDays;
    @ApiModelProperty(value = "时间(年,月)(yyyy-MM)", name = "time")
    @JsonFormat(pattern = "yyyy-MM")
    private Date time;
//    @ApiModelProperty(value = "标识(1:导入,2:自动获取)", name = "flag")
//    private Byte flag;
//    @ApiModelProperty(value = "应出勤天数", name = "shouldAttendDays")
//    private double shouldAttendDays;

    private static final long serialVersionUID = 1L;
}