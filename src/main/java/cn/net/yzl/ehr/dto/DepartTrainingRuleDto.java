package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * depart_training_rule
 * @author 
 */
@Data
public class DepartTrainingRuleDto implements Serializable {
    private Integer id;

    /**
     * 部门id
     */
    private Integer departId;

    private String departName;

    /**
     * 岗位id
     */
    private Integer postId;

    private String postName;
    /**
     * 培训方式(1:线下,2,线上)
     */
    private Byte way;

    /**
     * 培训标识(0:不培训,1:培训)
     */
    private Byte trainingFlag;

    /**
     * 是否考试(0:否,1:是)
     */
    private Byte examFlag;

    private List<DepartCoursewareDto> coursewareList;

    private static final long serialVersionUID = 1L;


}
