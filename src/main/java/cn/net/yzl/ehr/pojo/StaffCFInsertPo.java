package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffCFInsertPo {
    @Valid
    private StaffContractInsertPo staffContractInsertPo;
    @Valid
    private ValidList<StaffContractFileInsertPo> staffContractFileInsertPos;
    @Valid
    private ValidList<StaffContractFileInsertPo> staffContractPictureInsertPos;
}
