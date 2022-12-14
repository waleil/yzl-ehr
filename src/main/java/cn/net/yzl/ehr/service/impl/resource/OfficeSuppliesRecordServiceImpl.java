package cn.net.yzl.ehr.service.impl.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.fegin.resource.OfficeSuppliesInfoFeginService;
import cn.net.yzl.ehr.service.resource.OfficeSuppliesRecordService;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesRecordInsertPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class OfficeSuppliesRecordServiceImpl implements OfficeSuppliesRecordService {
    @Autowired
    private OfficeSuppliesInfoFeginService officeSuppliesInfoFeginService;

    @Override
    public ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(OfficeSuppliesInfoScreenPo screenPo) {
         return officeSuppliesInfoFeginService.queryPage(screenPo);
    }

    @Override
    public ComResponse<Integer> insertSelective(OfficeSuppliesRecordInsertPo screenPo) {
        return officeSuppliesInfoFeginService.insertSelective(screenPo);
    }

}
