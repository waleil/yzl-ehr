package cn.net.yzl.ehr.service.impl.office;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.office.OfficeSuppliesInfoFeginService;
import cn.net.yzl.ehr.service.office.OfficeSuppliesRecordService;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfficeSuppliesRecordServiceImpl implements OfficeSuppliesRecordService {
    @Autowired
    private OfficeSuppliesInfoFeginService officeSuppliesInfoFeginService;

    @Override
    public ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(OfficeSuppliesInfoScreenPo screenPo, Integer pageSize, Integer pageNum) {
         return officeSuppliesInfoFeginService.queryPage(screenPo,pageNum,pageSize);
    }
}
