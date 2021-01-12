package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffWorkItemPo {
    @Valid
    private ValidList<StaffWorkInsertPo> insertList;
    @Valid
    private ValidList<StaffWorkUpdatePo> updateList;
    @Valid
    private ValidList<StaffWorkDeletePo> deleteList;
    
}
