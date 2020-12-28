package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * depart_resume
 * @author 
 */
@Data
@ApiModel(value="DepartResumeVO",description="部门面试流程实体")
public class DepartResumeVO implements Serializable {


    @ApiModelProperty(value="此轮名称",name="stepName")
    @NotBlank
    private String stepName;
    /**
     * 面试人id
     */
    @ApiModelProperty(value="面试人工号",name="leaderNo")
    @NotBlank
    private String leaderNo;

    @ApiModelProperty(value="顺序序号",name="sortNo")
    @NotBlank
    private Integer sortNo;


}