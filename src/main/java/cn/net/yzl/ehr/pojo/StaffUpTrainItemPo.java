package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;

import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffUpTrainItemPo {
    @Valid
    private ValidList<StaffUpTrainInsertPo> insertList;
    @Valid
    private ValidList<StaffUpTrainUpdatePo> updateList;
    @Valid
    private ValidList<StaffUpTrainDeletePo> deleteList;
}
