package cn.net.yzl.ehr.service.impl.office;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.office.OfficeSuppliesInfoFeginService;
import cn.net.yzl.ehr.service.office.OfficeSuppliesInfoService;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeSuppliesInfoServiceImpl implements OfficeSuppliesInfoService {
    @Autowired
    private OfficeSuppliesInfoFeginService officeSuppliesInfoFeginService;

    @Override
    public ComResponse<Integer> deleteById(Integer id, Integer itemRemaining, String updator) {
        return officeSuppliesInfoFeginService.deleteById(id, itemRemaining, updator);
    }

    @Override
    public ComResponse<List<OfficeSuppliesInfoDto>> queryAll() {
        return officeSuppliesInfoFeginService.queryAll();
    }

    @Override
    public ComResponse<Integer> insert(OfficeSuppliesInfoInsertPo insertPo,String staffNo) {
        insertPo.setCreator(staffNo);
        return officeSuppliesInfoFeginService.insert(insertPo,staffNo);
    }

    @Override
    public ComResponse<Integer> update(OfficeSuppliesInfoUpdatePo updatePo,String staffNo) {
        updatePo.setUpdator(staffNo);
        return officeSuppliesInfoFeginService.update(updatePo,staffNo);
    }


}
