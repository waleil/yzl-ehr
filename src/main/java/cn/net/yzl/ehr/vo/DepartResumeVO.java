package cn.net.yzl.ehr.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * depart_resume
 * @author 
 */
@Data
public class DepartResumeVO implements Serializable {

    /**
     * 部门id
     */
    @NotBlank
    @Min(1)
    private Integer departId;
    /**
     * 岗位id
     */
    @NotBlank
    @Min(1)
    private Integer postId;
    /**
     * 此轮名称
     */
    @NotBlank
    private String stepName;
    /**
     * 面试人id
     */
    @NotBlank
    private Integer leaderNo;
    /**
     * 创建人唯一标识
     */
    private String creator;

}