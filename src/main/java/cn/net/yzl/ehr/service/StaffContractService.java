package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffContartListDto;
import cn.net.yzl.ehr.pojo.*;

import java.util.List;

public interface StaffContractService {

   //根据员工表工号（staffNo）查询员工合同信息
   ComResponse<List<StaffContartListDto>> findByStringNo(String staffNo);


   //添加合同信息
   ComResponse<Integer> insert(StaffCFInsertPo staffCFInsertPo);
}
