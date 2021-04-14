package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.staff.dto.StaffEduListDto;

import java.util.List;

public interface StaffEduService {
    ComResponse<StaffEduListDto> findByStaffNo (String staffNO);

    ComResponse<Integer> deleteById (Integer id, String updator);

    ComResponse<Integer> add (List<StaffEduInsertPo> staff);

    ComResponse<Integer> update (StaffEduUpdatePo staffEduUpdatePo);

    ComResponse<Integer> saveUpDate (StaffEduItemPo staffEduItemPo);

}
