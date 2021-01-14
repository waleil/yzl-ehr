package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffQuaItemPo {
    @Valid
    private ValidList<StaffQuaInsertPo> insertList;
    @Valid
    private ValidList<StaffQuaUpdatePo> updateList;
    @Valid
    private ValidList<StaffQuaDeletePo> deleteList;
}
