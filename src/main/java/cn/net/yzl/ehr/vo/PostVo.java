package cn.net.yzl.ehr.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * post
 * @author 
 */
@Data
public class PostVo implements Serializable {
    private Integer id;

    /**
     * 岗位名称
     */
    @NotBlank
    private String name;

    /**
     * 部门id
     */
    @Min(1)
    private Integer departId;

    /**
     * 属性code(指向字典表,post_attribute)
     */
    @Min(1)
    private Integer attrCode;

    /**
     * 编制人数
     */
    @NotNull
    @Min(1)
    private Integer staffNum;

    /**
     * 岗位职责
     */
    private String duty;

    /**
     * 在岗人数
     */
    private Integer jobNum;

    /**
     * 是否删除:0:没有删除,1:删除
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人唯一标识
     */
    @NotNull
    private String creator;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人唯一标识
     */
    private String updator;

    private static final long serialVersionUID = 1L;
}