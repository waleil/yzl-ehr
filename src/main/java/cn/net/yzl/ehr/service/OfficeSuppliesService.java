package cn.net.yzl.ehr.service;

import cn.net.yzl.ehr.pojo.OfficeSupplies;
import cn.net.yzl.ehr.pojo.OfficeSuppliesChangeRecord;
import cn.net.yzl.ehr.vojo.OfficeSuppliesChangeRecordPageParam;

import java.util.List;

public interface OfficeSuppliesService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(OfficeSupplies record);

    OfficeSupplies selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OfficeSupplies record);

    int updateByPrimaryKey(OfficeSupplies record);

    List<OfficeSupplies> selectAllList();

    List<OfficeSuppliesChangeRecord> selectPageRecordList(OfficeSuppliesChangeRecordPageParam param);

    int insertRecord(OfficeSuppliesChangeRecord recode);
}
