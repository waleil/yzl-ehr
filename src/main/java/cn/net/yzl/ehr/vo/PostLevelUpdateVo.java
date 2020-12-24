package cn.net.yzl.ehr.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * post_level
 * @author 
 */
@Data
public class PostLevelUpdateVo implements Serializable {
    private Integer id;

    /**
     * 岗位编号
     */
    @NotNull
    private Integer postId;

    /**
     * 级别名称
     */
    @NotNull
    private String name;


    /**
     * 创建人唯一标识
     */
    private String creator;

    /**
     * 更新人唯一标识
     */
    @NotNull
    private String updator;

    private static final long serialVersionUID = 1L;
}