package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffWorkUpdateListPo {
    @Valid
    private ValidList<StaffWorkUpdatePo> staffWorkUpdateList;
}
