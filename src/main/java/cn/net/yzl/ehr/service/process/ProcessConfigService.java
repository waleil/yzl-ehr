package cn.net.yzl.ehr.service.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;

import java.util.Date;

public interface ProcessConfigService {
    ComResponse<Integer> insertProcessConfig(ProcessConfigVo processConfigVo, String staffNo);

    ComResponse<Integer> deleteProcessConfig(Integer id, String staffNo);

    ComResponse<Integer> disableProcessConfig(Integer id, String staffNo);

    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(String processName, Date startTime, Date endTime, Integer processType, Integer pageNum, Integer pageSize);

    ComResponse<ProcessConfigDetailDto> processConfigDetail(Integer id);

}
