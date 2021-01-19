package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * depart_training_rule
 * @author 
 */
@Data
public class DepartTrainingRuleDto implements Serializable {
    @ApiModelProperty(value = "培训配置id")
    private Integer id;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer departId;

    @ApiModelProperty(value = "部门名称")
    private String departName;

    /**
     * 岗位id
     */
    @ApiModelProperty(value = "岗位id")
    private Integer postId;

    @ApiModelProperty(value = "岗位名称")
    private String postName;
    /**
     * 培训方式(1:线下,2,线上)
     */
    @ApiModelProperty(value = "培训方式:0线上 1线下")
    private Byte way;

    /**
     * 培训标识(0:不培训,1:培训)
     */
    @ApiModelProperty(value = "培训标识(0:不培训,1:培训)")
    private Byte trainingFlag;

    /**
     * 是否考试(0:否,1:是)
     */
    @ApiModelProperty(value = "是否考试(0:否,1:是)")
    private Byte examFlag;

    private List<TrainingCoursewareDto> coursewareList;

    private static final long serialVersionUID = 1L;


}