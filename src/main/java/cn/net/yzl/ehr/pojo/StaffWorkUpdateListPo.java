package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;
@Valid
@Data
public class StaffWorkUpdateListPo {
    private ValidList<StaffWorkUpdatePo> staffWorkUpdateList;
}
