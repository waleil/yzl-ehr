package cn.net.yzl.ehr.service.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesRecordInsertPo;
import org.springframework.web.bind.annotation.RequestParam;


public interface OfficeSuppliesRecordService {
    ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(OfficeSuppliesInfoScreenPo screenPo);

    //领用物品记录添加
    ComResponse<Integer> insertSelective (OfficeSuppliesRecordInsertPo screenPo);
}
