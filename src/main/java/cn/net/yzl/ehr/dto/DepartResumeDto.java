package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * depart_resume
 * @author 
 */
@Data
@ApiModel(value="DepartResumeDto",description="部门面试流程实体")
public class DepartResumeDto implements Serializable {

    @ApiModelProperty(value="id",name="id")
    private Integer id;

    /**
     * 部门id
     */
    @ApiModelProperty(value="部门id",name="departId")
    private Integer departId;
    @ApiModelProperty(value="部门名称",name="departName")
    private String departName;
    /**
     * 岗位id
     */
    @ApiModelProperty(value="岗位id",name="postId")
    private Integer postId;
    @ApiModelProperty(value="岗位名称",name="postName")
    private String postName;

    /**
     * 此轮名称
     */
    @ApiModelProperty(value="此轮名称",name="stepName")
    private String stepName;

    /**
     * 面试人id
     */
    @ApiModelProperty(value="面试人工号",name="leaderNo")
    private Integer leaderNo;
    @ApiModelProperty(value="面试名称",name="leaderName")
    private String leaderName;


}