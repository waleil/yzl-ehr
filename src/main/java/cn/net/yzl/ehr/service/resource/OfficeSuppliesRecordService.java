package cn.net.yzl.ehr.service.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import org.springframework.web.bind.annotation.RequestParam;


public interface OfficeSuppliesRecordService {
    ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(OfficeSuppliesInfoScreenPo screenPo, Integer pageNum, Integer pageSize,Integer itemId);
}
