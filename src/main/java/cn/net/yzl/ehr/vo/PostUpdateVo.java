package cn.net.yzl.ehr.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * post
 * @author 
 */
@Data
public class PostUpdateVo implements Serializable {
    @NotNull
    @Min(0)
    private Integer id;

    /**
     * 岗位名称
     */
    @NotNull
    private String name;

    /**
     * 属性code(指向字典表,post_attribute)
     */
    @NotNull
    @Min(0)
    private Integer attrCode;

    /**
     * 编制人数
     */
    private Integer staffNum;

    /**
     * 岗位职责
     */
    private String duty;

    @Min(0)
    private Integer job_num;

    /**
     * 更新人唯一标识
     */
    @NotNull
    private String updator;

    private static final long serialVersionUID = 1L;
}