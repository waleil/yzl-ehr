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

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("级别名称")
    private String name;
    @ApiModelProperty("岗位编号")
    private Integer postId;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("级别排序")
    private Integer sort;
}