package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 部门岗位面试配置表
 * 
 * @author：yangxf
 * @date： 2021-01-04 16:49:36
 */
@Data
public class DepartResumeNodeDto {

    @ApiModelProperty("noteId")
    private Integer noteId;

    @ApiModelProperty("此轮名称编号")
    private String stepId;

    @ApiModelProperty("此轮名称")
    private String stepName;

    @ApiModelProperty("面试人id")
    private String leaderNo;

    @ApiModelProperty("面试人姓名")
    private String leaderName;

    @ApiModelProperty("顺序序号")
    private Integer sortNo;



}