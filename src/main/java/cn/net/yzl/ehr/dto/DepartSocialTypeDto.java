package cn.net.yzl.ehr.dto;


import cn.net.yzl.ehr.pojo.DepartSocialTypePo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 可缴纳社保项目
 */
@Data
public class DepartSocialTypeDto implements Serializable {


    private List<DepartSocialTypePo> departSocialTypeList;

}
