package cn.net.yzl.ehr.mapper;


import cn.net.yzl.ehr.pojo.OfficeSuppliesChangeRecord;
import cn.net.yzl.ehr.vojo.OfficeSuppliesChangeRecordPageParam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OfficeSuppliesChangeRecordMapper {

    List<OfficeSuppliesChangeRecord> selectPageRecordList(OfficeSuppliesChangeRecordPageParam param);

    int insertSelective(OfficeSuppliesChangeRecord recode);
}