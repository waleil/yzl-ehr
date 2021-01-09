package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.*;

import java.util.List;

public interface StaffGrowUpService {
    ComResponse<List<StaffUpRpPo>> findByStaffNo (String staffNO);

    ComResponse<Integer> deleteById (Integer id, String updator);

    ComResponse<Integer> insert (List<StaffUpRpInsertPo> staff);

    ComResponse<Integer> update (StaffUpRpUpdatePo staffUpRpUpdatePo);

    ComResponse<Integer> saveUpDate (StaffUpRpItemPo staffUpRpItemPo);

    ComResponse<List<StaffUpTrainPo>> find (String staffNO);

    ComResponse<Integer> deleteTrain (Integer id, String updator);

    ComResponse<Integer> addTrain (List<StaffUpTrainInsertPo> staff);

    ComResponse<Integer> updateTrain (StaffUpTrainUpdatePo staffUprainUpdatePo);

    ComResponse<Integer> saveUpDateTrain (StaffUpTrainItemPo staffUpTrainItemPo);

}
