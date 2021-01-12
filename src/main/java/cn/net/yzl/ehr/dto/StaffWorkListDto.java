package cn.net.yzl.ehr.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "StaffWorkListPo", description = "员工入职经历信息")
public class StaffWorkListDto implements Serializable {
    @Valid
    private List<StaffWorkDto> preWorkList;
    @Valid
    private List<StaffWorkDto> WorkList;
}
