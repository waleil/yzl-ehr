package cn.net.yzl.ehr.pojo;


import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffItemPo {
    @Valid
    private ValidList<StaffInsertPo> insertList;
    @Valid
    private ValidList<StaffUpdatePo> updateList;
    @Valid
    private ValidList<StaffDeletePo> deleteList;
}
