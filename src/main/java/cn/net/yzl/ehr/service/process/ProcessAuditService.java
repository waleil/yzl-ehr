package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.ProcessAuditVo;


public interface ProcessAuditService {
    ComResponse<Integer> updateProcessAuditState(ProcessAuditVo processAuditVo, String staffNo);

}
