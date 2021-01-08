package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.StaffFamilyInsertPo;
import cn.net.yzl.ehr.pojo.StaffFamilyItemPo;
import cn.net.yzl.ehr.pojo.StaffFamilyPo;
import cn.net.yzl.ehr.pojo.StaffFamilyUpdatePo;

import java.util.List;

public interface StaffFamilyService {
    ComResponse<List<StaffFamilyPo>> findByStaffNo (String staffNO);

    ComResponse<Integer> deleteById (Integer id, String updator);

    ComResponse<Integer> insert (List<StaffFamilyInsertPo> staff);

    ComResponse<Integer> update (StaffFamilyUpdatePo familyPo);

    ComResponse<Integer> saveUpDate (StaffFamilyItemPo staffFamilyItemPo);

}
