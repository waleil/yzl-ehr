package cn.net.yzl.ehr.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * depart_resume
 * @author 
 */
@Data
@ApiModel(value="DepartResumeVO",description="部门面试流程实体")
public class DepartResumeVO implements Serializable {


    @ApiModelProperty(value="此轮名称",name="stepName")
    private String stepName;
    /**
     * 面试人id
     */
    @ApiModelProperty(value="面试人工号",name="leaderNo")
    private String leaderNo;



}