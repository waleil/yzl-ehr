package cn.net.yzl.ehr.vo;


import cn.net.yzl.ehr.pojo.DepartSocialTypePo;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * 可缴纳社保项目
 */
@Data
public class DepartSocialTypeVo implements Serializable {


    @NotEmpty
    private List<DepartSocialTypePo> departSocialTypeList;

}
