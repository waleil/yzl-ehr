package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffUpRpItemPo {
    @Valid
    private ValidList<StaffUpRpInsertPo> insertList;
    @Valid
    private ValidList<StaffUpRpUpdatePo> updateList;
    @Valid
    private ValidList<StaffUpRpDeletePo> deleteList;
}
