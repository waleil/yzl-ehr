package cn.net.yzl.ehr.dto;

import cn.net.yzl.ehr.pojo.AreaPo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AreaPostDto implements Serializable {
    List<PostDto> postDtos;
    List<AreaPo> areaPoList;
}
