package cn.net.yzl.ehr.dto;


import cn.net.yzl.ehr.pojo.DepartSocialPo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartSocialDto {
   private List<DepartSocialPo> departSocialPoList  = new ArrayList<>();
}
