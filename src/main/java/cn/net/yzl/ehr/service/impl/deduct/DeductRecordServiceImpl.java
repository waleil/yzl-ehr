package cn.net.yzl.ehr.service.impl.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.deduct.DeductItemFeginService;
import cn.net.yzl.ehr.fegin.deduct.DeductRecordFeginService;
import cn.net.yzl.ehr.service.deduct.DeductItemService;
import cn.net.yzl.ehr.service.deduct.DeductReocrdService;
import cn.net.yzl.staff.dto.deduct.*;
import cn.net.yzl.staff.pojo.deduct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeductRecordServiceImpl implements DeductReocrdService {
    @Autowired
    private DeductRecordFeginService deductRecordFeginService;


    @Override
    public ComResponse<List<DeductRecordDto>> getList(DeductRecordListPo deductRecordListPo) {
        ComResponse<List<DeductRecordDto>> result = deductRecordFeginService.getList(deductRecordListPo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData()==null) {
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(), ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> updateStateById(DeductRecordUpdatePo deductRecordUpdatePo,String staffNo) {

        ComResponse<Integer> result = deductRecordFeginService.updateStateById(deductRecordUpdatePo);
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
    public ComResponse<Integer> insertDeductRecord(DeductProcessDTO deductProcessDTO,String staffNo) {
        deductProcessDTO.getDeductRecordDto().setCreator(staffNo);
        ComResponse<Integer> result = deductRecordFeginService.insertDeductRecord(deductProcessDTO);
        return result;
    }

    @Override
    public ComResponse<DeductStaffInfoDto> selectstaff(String noOrName) {
        ComResponse<DeductStaffInfoDto> result = deductRecordFeginService.selectstaff(noOrName);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData()==null ) {
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(), ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> updateExecuteState(DeductRecordStateUpdatePo deductRecordStateUpdatePo,String staffNo) {
        ComResponse<Integer> result = deductRecordFeginService.updateExecuteState(deductRecordStateUpdatePo);
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
    public ComResponse<ApproveDeductDto> queryById(String appNo) {
        ComResponse<ApproveDeductDto>  result = deductRecordFeginService.queryById(appNo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData()==null) {
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(), ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> insertStopDeductRecord(DeductProcessDTO deductProcessDTO ,String staffNo) {
        deductProcessDTO.getDeductRecordDto().setCreator(staffNo);
        ComResponse<Integer> result = deductRecordFeginService.insertStopDeductRecord(deductProcessDTO);
        return result;
    }
}
