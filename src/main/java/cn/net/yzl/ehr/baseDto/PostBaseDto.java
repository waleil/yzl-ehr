package cn.net.yzl.ehr.baseDto;

import cn.net.yzl.ehr.dto.PostLevelDto;
import lombok.Data;

import java.util.List;

@Data
public class PostBaseDto {

    private Integer postId;

    private String postName;

    private List<PostLevelDto> postLevelDtoList;
}
