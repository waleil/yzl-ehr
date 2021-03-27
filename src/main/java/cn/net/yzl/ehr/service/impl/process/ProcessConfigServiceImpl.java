package cn.net.yzl.ehr.service.impl.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.process.ProcessConfigFeignService;
import cn.net.yzl.ehr.service.process.ProcessConfigService;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigPageVo;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessConfigServiceImpl implements ProcessConfigService {

    @Autowired
    private ProcessConfigFeignService processConfigFeignService;

    @Override
    public ComResponse<Integer> insertProcessConfig(ProcessConfigVo processConfigVo, String staffNo) {
        processConfigVo.setCreator(staffNo);
        return processConfigFeignService.insertProcessConfig(processConfigVo);
    }

    @Override
    public ComResponse<Integer> updateProcessConfig(ProcessConfigVo processConfigVo, String staffNo) {
        processConfigVo.setCreator(staffNo);
        return processConfigFeignService.updateProcessConfig(processConfigVo);
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
    public ComResponse<Integer> enableProcessConfig(Integer id, Integer processItemId, String staffNo) {
        return processConfigFeignService.enableProcessConfig(id,processItemId,staffNo);
    }

    @Override
    public ComResponse<Page<ProcessDto>> pageSelectProcessConfig(ProcessConfigPageVo processConfigPageVo) {
        return processConfigFeignService.pageSelectProcessConfig(processConfigPageVo);
    }

    @Override
    public ComResponse<ProcessConfigDetailDto> processConfigDetail(Integer id) {
        return processConfigFeignService.processConfigDetail(id);
    }

    @Override
    public ComResponse<DepartDto> processConfigDepartByProcessItemId(Integer processItemId, Integer processId) {
        return processConfigFeignService.processConfigDepartByProcessItemId(processItemId,processId);
    }

    @Override
    public ComResponse<List<StaffLevelDto>> getStaffLevelByStaffNo(String staffNo, Integer flag) {
        return processConfigFeignService.getStaffLevelByStaffNo(staffNo,flag);
    }

    @Override
    public ComResponse<StaffLevelDto> getUpStaffLevelByStaffNo(String staffNo, Integer currentDepartId) {
        return processConfigFeignService.getUpStaffLevelByStaffNo(staffNo,currentDepartId);
    }
}
