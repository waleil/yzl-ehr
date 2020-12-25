package cn.net.yzl.ehr.pojo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * depart_training_rule
 * @author 
 */
@Data
public class DepartTrainingRuleUpdatePo implements Serializable {
    @NotNull
    @Min(0)
    private Integer id;

    /**
     * 部门id
     */
    @NotNull
    @Min(0)
    private Integer departId;

    /**
     * 岗位id
     */
    @NotNull
    @Min(0)
    private Integer postId;

    /**
     * 培训方式(1:线下,2,线上)
     */
    @NotNull
    @Min(0)
    private int way;

    /**
     * 培训标识(0:不培训,1:培训)
     */
    @NotNull
    @Min(0)
    private int trainingFlag;

    /**
     * 是否考试(0:否,1:是)
     */
    @NotNull
    @Min(0)
    private int examFlag;

    /**
     * 状态:0:未删除,1:删除
     */
    @NotNull
    @Min(0)
    private int isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人唯一标识
     */
    private String creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人唯一标识
     */
    @NotNull
    @Min(0)
    private String updator;


    private static final long serialVersionUID = 1L;


}