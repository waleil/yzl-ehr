package cn.net.yzl.ehr.service.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.pojo.deduct.DeductItemInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdatePo;

import java.util.List;

public interface DeductItemService {
    ComResponse<Integer> insert(DeductItemInsertPo insertPo,String staffNo);

    ComResponse<List<DeductItemDto>> queryAll();

    ComResponse<Integer> updateByState(DeductItemUpdatePo updatePo,String staffNo);

    ComResponse<List<DeductItemDto>> queryItem();
}
