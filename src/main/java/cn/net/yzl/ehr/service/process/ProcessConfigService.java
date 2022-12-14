package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigPageVo;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;

import java.util.List;


public interface ProcessConfigService {
    ComResponse<Integer> insertProcessConfig(ProcessConfigVo processConfigVo, String staffNo);

    ComResponse<Integer> updateProcessConfig(ProcessConfigVo processConfigVo, String staffNo);

    ComResponse<Integer> deleteProcessConfig(Integer id, String staffNo);

    ComResponse<Integer> disableProcessConfig(Integer id, String staffNo);

    ComResponse<Integer> enableProcessConfig(Integer id, Integer processItemId, String staffNo);

    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(ProcessConfigPageVo processConfigPageVo);

    ComResponse<ProcessConfigDetailDto> processConfigDetail(Integer id);

    ComResponse<DepartDto> processConfigDepartByProcessItemId(Integer processItemId,Integer processId);

    ComResponse<List<StaffLevelDto>> getStaffLevelByStaffNo(String staffNo,Integer flag);

    ComResponse<StaffLevelDto> getUpStaffLevelByStaffNo(String staffNo,Integer currentDepartId);

}
