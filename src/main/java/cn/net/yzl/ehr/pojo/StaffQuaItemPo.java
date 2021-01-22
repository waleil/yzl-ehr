package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffQuaItemPo {

    private StaffQuaInsertPo insert;

    private StaffQuaUpdatePo update;

    private StaffQuaDeletePo delete;
}
