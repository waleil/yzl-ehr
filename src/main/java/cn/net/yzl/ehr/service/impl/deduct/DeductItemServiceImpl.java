package cn.net.yzl.ehr.service.impl.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.deduct.DeductItemFeginService;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.staff.dto.deduct.DeductItemDto;
import cn.net.yzl.staff.pojo.deduct.DeductItemInsertPo;
import cn.net.yzl.staff.pojo.deduct.DeductItemUpdatePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeductItemServiceImpl implements DeductItemService {
    @Autowired
    private DeductItemFeginService  deductItemFeginService;

    @Override
    public ComResponse<Integer> insert(DeductItemInsertPo insertPo) {
        ComResponse<Integer> result = deductItemFeginService.insert(insertPo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData() < 1) {
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(), ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }
        if (result.getData() > 0) {
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<List<DeductItemDto>> queryAll() {
        ComResponse<List<DeductItemDto>> result = deductItemFeginService.queryAll();
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData()==null) {
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(), ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> updateByState(DeductItemUpdatePo updatePo) {
        ComResponse<Integer> result = deductItemFeginService.updateByState(updatePo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData() == null) {
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(), ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }
        if (result.getData() != null) {
            return ComResponse.success();
        }
        return result;
    }
}
