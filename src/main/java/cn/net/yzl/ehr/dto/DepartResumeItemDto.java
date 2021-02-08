package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DepartResumeItemDto implements Serializable {

    @ApiModelProperty("部门岗位id")
    private Integer departPostId;

    @ApiModelProperty("部门id")
    private Integer departId;

    @ApiModelProperty("部门名称")
    private String departName;

    @ApiModelProperty("岗位id")
    private Integer postId;

    @ApiModelProperty("岗位名称")
    private String postName;

    @ApiModelProperty("配置编码")
    private String resumeId;

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
