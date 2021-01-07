package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 面试流程表
 * 
 * @author：yangxf
 * @date： 2021-01-04 16:49:36
 */
@Data
public class DepartResumeDto {
    @ApiModelProperty("培训配置id")
    private Integer id;

    @ApiModelProperty("部门id")
    private Integer departId;

    @ApiModelProperty("部门名称")
    private String departName;

    @ApiModelProperty("岗位id")
    private Integer postId;

    @ApiModelProperty("岗位名称")
    private String postName;

    private List<DepartResumeNodeDto> nodeList;

}