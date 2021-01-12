package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.*;

import java.util.List;

public interface StaffWorkService {

   ComResponse<StaffWorkListPo> list(StaffWorkPo staffWorkPo);

   ComResponse<Integer> deleteById(StaffWorkDeletePo staffWorkDeletePo);

   ComResponse<Integer> insert(StaffWorkInsertListPo staffWorkList);

   ComResponse<Integer> update(StaffWorkUpdatePo WorkPo);

   ComResponse<Integer> updatelist(StaffWorkUpdateListPo staffWorkUpdateListPo);

   ComResponse<Integer> saveUpDate(StaffWorkItemPo staffWorkItemPo);
}
