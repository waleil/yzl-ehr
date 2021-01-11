package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffEduItemPo {
    @Valid
    private ValidList<StaffEduInsertPo> insertList;
    @Valid
    private ValidList<StaffEduUpdatePo> updateList;
    @Valid
    private ValidList<StaffEduDeletePo> deleteList;
}
