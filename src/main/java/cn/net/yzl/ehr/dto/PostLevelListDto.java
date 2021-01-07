package cn.net.yzl.ehr.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostLevelListDto {

    private Integer postId;
    private String postName;
    private List<PostLevelDto> postLevelList;
}
