package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.*;

import java.util.List;

public interface StaffWorkService {

   ComResponse<StaffWorkListDto> list(String staffNo);

   ComResponse<Integer> deleteById(Integer id);

   ComResponse<Integer> insert(StaffWorkInsertListPo staffWorkList);

   ComResponse<Integer> update(StaffWorkUpdatePo WorkPo);

   ComResponse<Integer> updatelist(StaffWorkUpdateListPo staffWorkUpdateListPo);

   ComResponse<Integer> saveUpDate(StaffWorkItemPo staffWorkItemPo);
}
