package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 岗位级别表
 * 
 * @author：yangxf
 * @date： 2020-12-23 09:39:56
 */
@Data
public class PostLevelDto implements Serializable {
    @ApiModelProperty(value = "岗位级别编号", name = "id")
    private Integer id;
    
    @ApiModelProperty(value = "岗位编号", name = "postId")
    private Integer postId;

    @ApiModelProperty(value = "岗位名称", name = "postName")
    private String postName;

    @ApiModelProperty(value = "级别名称", name = "name")
    private String name;


}