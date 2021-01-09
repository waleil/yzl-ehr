package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;

@Data
public class StaffFamilyItemPo {

    private ValidList<StaffFamilyInsertPo> insertList;

    private ValidList<StaffFamilyUpdatePo> updateList;

    private ValidList<StaffFamilyDeletePo> deleteList;
}
