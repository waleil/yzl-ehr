package cn.net.yzl.ehr.pojo;


import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Valid
@Data
public class DepartResumeUpdateListPo implements Serializable {
    @ApiModelProperty(value = "操作人",hidden = true)
    private String staffNo;

    private ValidList<DepartResumeNodeStaffItem> departResumeIPo;
    @Data
    public static class DepartResumeNodeStaffItem{

        @ApiModelProperty("部门id")
        @NotNull
        @Min(0)
        private Integer departId;


        @ApiModelProperty("岗位id")
        @NotNull
        @Min(0)
        private Integer postId;

        @ApiModelProperty("部门岗位id")
        @NotNull
        @Min(0)
        private Integer departPostId;

        @ApiModelProperty(value = "配置编码")
        @NotNull
        @Min(0)
        private Integer resumeId;

        @ApiModelProperty(value = "轮次节点编号",hidden = true)
        @Min(0)
        private Integer noteId;

        @ApiModelProperty("顺序序号")
        @NotNull
        @Min(0)
        private Integer sortNo;

        @ApiModelProperty("此轮名称编号")
        @NotNull
        @Min(0)
        private String stepId;

        @ApiModelProperty("面试人id")
        @NotBlank
        private String leaderNo;


    }

}

