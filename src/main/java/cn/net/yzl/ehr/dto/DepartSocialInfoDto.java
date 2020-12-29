package cn.net.yzl.ehr.dto;


import cn.net.yzl.ehr.pojo.AreaPo;
import cn.net.yzl.ehr.pojo.DepartSocialInfoPo;
import cn.net.yzl.ehr.pojo.DepartSocialPo;
import lombok.Data;

import java.util.List;

@Data
public class DepartSocialInfoDto extends DepartSocialPo {
    List<PostDto> postDtos;
    List<AreaPo> areaPoList;
//    private DepartSocialPo departSocialPo;
    private List<DepartSocialInfoPo> departSocialInfoPoList;
}
