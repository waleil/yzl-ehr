package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.process.ProcessConfigFeignService;
import cn.net.yzl.ehr.service.process.ProcessConfigService;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProcessConfigServiceImpl implements ProcessConfigService {

    @Autowired
    private ProcessConfigFeignService processConfigFeignService;

    @Override
    public ComResponse<Integer> insertProcessConfig(ProcessConfigVo processConfigVo, String staffNo) {
        return processConfigFeignService.insertProcessConfig(processConfigVo,staffNo);
    }

    @Override
    public ComResponse<Integer> deleteProcessConfig(Integer id, String staffNo) {
        return processConfigFeignService.deleteProcessConfig(id,staffNo);
    }

    @Override
    public ComResponse<Integer> disableProcessConfig(Integer id, String staffNo) {
        return processConfigFeignService.disableProcessConfig(id,staffNo);
    }

    @Override
    public ComResponse<Page<ProcessDto>> pageSelectProcessConfig(String processName, Date startTime, Date endTime, Integer processType, Integer pageNum, Integer pageSize) {
        return processConfigFeignService.pageSelectProcessConfig(processName,startTime,endTime,processType,pageNum,pageSize);
    }

    @Override
    public ComResponse<ProcessConfigDetailDto> processConfigDetail(Integer id) {
        return processConfigFeignService.processConfigDetail(id);
    }
}
