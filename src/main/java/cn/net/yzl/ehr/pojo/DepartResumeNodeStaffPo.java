package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * depart_resume_node_staff
 * @author 
 */
@Data
public class DepartResumeNodeStaffPo implements Serializable {

    @ApiModelProperty(value = "面试流程id",hidden = true)
    private Integer nodeId;

    @ApiModelProperty("面试官工号")
    @NotBlank
    private String staffNo;

}