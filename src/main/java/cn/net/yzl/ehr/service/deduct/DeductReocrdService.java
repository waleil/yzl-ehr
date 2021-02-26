package cn.net.yzl.ehr.service.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.deduct.*;
import cn.net.yzl.staff.pojo.deduct.*;

import java.util.List;

public interface DeductReocrdService {
    ComResponse<List<DeductRecordDto>> getList(DeductRecordListPo deductRecordListPo);

    //停止扣款
    ComResponse<Integer> updateStateById(DeductRecordUpdatePo deductRecordUpdatePo);

    //新建扣款申请
    ComResponse<Integer> insertDeductRecord(DeductProcessDTO deductProcessDTO);
    //根据员工工号或姓名查询员工信息
    ComResponse<DeductStaffInfoDto> selectstaff(String noOrName);


    //修改执行状态
    ComResponse<Integer> updateExecuteState(DeductRecordStateUpdatePo deductRecordStateUpdatePo);

    //查询扣款详情
    ComResponse<ApproveDeductDto> queryById(Integer id);

}
