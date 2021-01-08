package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffFamilyItemPo {
    @Valid
    private ValidList<StaffFamilyInsertPo> insertList;
    @Valid
    private ValidList<StaffFamilyUpdatePo> updateList;
    @Valid
    private ValidList<StaffFamilyDeletePo> deleteList;
}
