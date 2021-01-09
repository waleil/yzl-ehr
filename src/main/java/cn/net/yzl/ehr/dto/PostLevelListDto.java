package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PostLevelListDto {
    @ApiModelProperty("岗位编号")
    private Integer postId;
    @ApiModelProperty("岗位名称")
    private String postName;
    private List<PostLevelDto> postLevelList;
}
