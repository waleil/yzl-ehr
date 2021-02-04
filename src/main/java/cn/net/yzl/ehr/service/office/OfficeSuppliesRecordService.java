package cn.net.yzl.ehr.service.office;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;


public interface OfficeSuppliesRecordService {
    ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(OfficeSuppliesInfoScreenPo screenPo, Integer pageSize, Integer pageNum);
}
