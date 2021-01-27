package cn.net.yzl.ehr.service.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.pojo.deduct.*;

import java.util.List;

public interface DeductReocrdService {
    ComResponse<List<DeductRecordDto>> getList(DeductRecordListPo deductRecordListPo);

    //停止扣款
    ComResponse<Integer> updateStateById(DeductRecordUpdatePo deductRecordUpdatePo);

    //新建扣款申请
    ComResponse<Integer> insertDeductRecord(DeductRecordInsertPo deductRecordInsertPo);
}
