package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.ProcessAuditFeignService;
import cn.net.yzl.ehr.service.process.ProcessAuditService;
import cn.net.yzl.staff.vo.process.ProcessAuditVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessAuditServiceImpl implements ProcessAuditService {

    @Autowired
    private ProcessAuditFeignService processAuditFeignService;

    @Override
    public ComResponse<Integer> updateProcessAuditState(ProcessAuditVo processAuditVo, String staffNo) {
        processAuditVo.setUpdator(staffNo);
        return processAuditFeignService.updateProcessAuditState(processAuditVo);
    }

}
