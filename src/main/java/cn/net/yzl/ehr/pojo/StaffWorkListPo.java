package cn.net.yzl.ehr.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
@Valid
@Data
@ApiModel(value = "StaffWorkListPo", description = "员工入职经历信息")
public class StaffWorkListPo implements Serializable {
    @Valid
    private List<StaffWorkPo> preWorkList;
    @Valid
    private List<StaffWorkPo> WorkList;
}
