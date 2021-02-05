package cn.net.yzl.ehr.service.impl.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.resource.OfficeSuppliesInfoFeginService;
import cn.net.yzl.ehr.service.resource.OfficeSuppliesInfoService;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesTypePo;
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
        return officeSuppliesInfoFeginService.insert(insertPo);
    }

    @Override
    public ComResponse<Integer> update(OfficeSuppliesInfoUpdatePo updatePo,String staffNo) {
        updatePo.setUpdator(staffNo);
        return officeSuppliesInfoFeginService.update(updatePo);
    }

    @Override
    public ComResponse<Integer> saveUpDateOffice(List<OfficeSuppliesTypePo> officeSuppliesTypePos,String staffNo) {
        for (OfficeSuppliesTypePo officeSuppliesTypePo : officeSuppliesTypePos) {
            if(officeSuppliesTypePo.getId()==null||officeSuppliesTypePo.getId()==0){
                officeSuppliesTypePo.setCreator(staffNo);
            }else {
                officeSuppliesTypePo.setUpdator(staffNo);
            }
        }
        return officeSuppliesInfoFeginService.saveUpDateOffice(officeSuppliesTypePos);
    }


}
