package cn.net.yzl.ehr.vo;

import cn.net.yzl.ehr.pojo.DepartSocialInfoPo;
import cn.net.yzl.ehr.pojo.DepartSocialPo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class DepartSocialVo implements Serializable {
    @NotNull
    private DepartSocialPo departSocialPo;

    @NotEmpty
    private List<DepartSocialInfoPo> departSocialInfoPoList;

}
