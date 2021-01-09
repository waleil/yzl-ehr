package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class DepartResumeListPo implements Serializable {

    private ValidList<DepartResumeIPo> departResumeIPo;

    public static class DepartResumeIPo{

        @ApiModelProperty("部门id")
        @NotNull
        @Min(0)
        private Integer departId;


        @ApiModelProperty("岗位id")
        @NotNull
        @Min(0)
        private Integer postId;

        @ApiModelProperty(value = "配置编码")
        @NotNull
        @Min(0)
        private String resumeId;

        @ApiModelProperty("轮次节点编号")
        @NotNull
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
        @NotNull
        @Min(0)
        private String leaderNo;


    }




}
