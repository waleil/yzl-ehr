package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class StaffWorkItemPo {
    @Valid
    private List<StaffWorkInsertPo> insertList;
    @Valid
    private List<StaffWorkUpdatePo> updateList;
    @Valid
    private List<StaffWorkDeletePo> deleteList;
    
}
