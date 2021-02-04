package cn.net.yzl.ehr.service.office;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;

import java.util.List;

public interface OfficeSuppliesInfoService {
    ComResponse<Integer> deleteById (Integer id,Integer itemRemaining ,String updator);

    ComResponse<List<OfficeSuppliesInfoDto>> queryAll();

    ComResponse<Integer> insert(OfficeSuppliesInfoInsertPo insertPo);

    ComResponse<Integer> update(OfficeSuppliesInfoUpdatePo updatePo);



}
