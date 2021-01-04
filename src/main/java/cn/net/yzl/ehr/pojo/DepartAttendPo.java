package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@ApiModel(value = "DepartAttendPojo", description = "部门假勤配置")
public class DepartAttendPo implements Serializable {

    @ApiModelProperty(value = "假勤类型id", name = "id")
//    @NotNull
//    @Min(0)
    private Integer id;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id", name = "departId")
    private Integer departId;

    @ApiModelProperty(value = "是否启用(0代表否,1代表是,1也代表立即生效)",name = "enable")
    private Integer enable;

    @ApiModelProperty(value = "生效时间",name ="effectTime" )
    private LocalDate effectTime;

    @ApiModelProperty(value = "多少日后生效",name ="effectDay" )
    private Integer effectDay;


//    /**
//     * 名称
//     */
//    @ApiModelProperty(value = "惩罚名称", name = "punishName")
////    @NotBlank
//    private String punishName;

    /**
     * 工龄左边区间
     */
    @ApiModelProperty(value = "工龄左边区间", name = "workLeft")
    private Integer workLeft;

    /**
     * 工龄右边区间
     */
    @ApiModelProperty(value = "工龄右边区间", name = "workRight")
    private Integer workRight;

    /**
     * 天数
     */
    @ApiModelProperty(value = "天数", name = "days")
    private Integer days;

    /**
     * 超过假期天数
     */
    @ApiModelProperty(value = "超过假期天数", name = "leaveDays")
    private Double leaveDays;



    @ApiModelProperty(value = "字典表id",name = "sysDictDataId")
    private Integer sysDictDataId;
    @ApiModelProperty(value ="假勤名称",name = "falseName")
    private String falseName;

    @ApiModelProperty(value = "日薪发放百分比",name = "daySalaryRate")
    private Double daySalaryRate;


    @ApiModelProperty(value = "假勤配置惩罚规则id",name = "falsePunishId")
    private Integer falsePunishId;
    /**
     * 惩罚方式：1.按旷工处理 2.扣日薪
     */
    @ApiModelProperty(value = "惩罚类型：1.按旷工处理 2.扣日薪", name = "type")
    private Integer type;
//    /**
//     * 扣日薪比例
//     */
//    @ApiModelProperty(value = "扣日薪比例", name = "rate")
//    private Double rate;


    @ApiModelProperty(value = "创建人编号",name = "creator")
    private String creator;

    @ApiModelProperty(value = "修改人编号",name = "updator")
    private String updator;

    @ApiModelProperty(value = "创建时间",name ="createTime" )
    private Date createTime;

    @ApiModelProperty(value = "修改时间",name ="updateDate" )
    private Date updateTime;



}
