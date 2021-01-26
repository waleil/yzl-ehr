package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffQuaListDto;
import cn.net.yzl.ehr.pojo.StaffQuaInsertPo;
import cn.net.yzl.ehr.pojo.StaffQuaItemPo;
import cn.net.yzl.ehr.pojo.StaffQuaUpdatePo;
import cn.net.yzl.staff.dto.StaffQuaDto;

import java.util.List;

public interface StaffQuaService {
    ComResponse<StaffQuaDto> findByStaffNo (String staffNO);

    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<Integer> insert (StaffQuaInsertPo insertPo);

    ComResponse<Integer> updateQua (StaffQuaUpdatePo updatePo);

    ComResponse<Integer> saveUpDate (StaffQuaItemPo itemPo);
}
