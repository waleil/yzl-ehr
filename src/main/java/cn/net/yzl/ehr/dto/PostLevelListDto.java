package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PostLevelListDto {
    @ApiModelProperty(name ="岗位编号",value ="postId",required = true)
    private Integer postId;

    @ApiModelProperty(name ="岗位名称",value ="postName",required = true)
    private String postName;


    private List<PostLevelDto> postLevelList;
}
