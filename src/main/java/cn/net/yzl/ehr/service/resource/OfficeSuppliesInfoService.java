package cn.net.yzl.ehr.service.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.dto.office.OfficeTypeDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesTypePo;

import java.util.List;

public interface OfficeSuppliesInfoService {
    ComResponse<Integer> deleteById (Integer id,Integer itemRemaining ,String updator);

    ComResponse<List<OfficeSuppliesInfoDto>> queryAll();

    ComResponse<Integer> insert(OfficeSuppliesInfoInsertPo insertPo,String staffNo);

    ComResponse<Integer> update(OfficeSuppliesInfoUpdatePo updatePo,String staffNo);

    //新增/编辑办公用品类型
    ComResponse<Integer> saveUpDateOffice (List<OfficeSuppliesTypePo> officeSuppliesTypePos,String staffNo);

    ComResponse<List<OfficeTypeDto>> selectList ();

    //根据类型查物品信息
    ComResponse<List<OfficeSuppliesInfoDto>> queryByTypeId (Integer typeId);


}
