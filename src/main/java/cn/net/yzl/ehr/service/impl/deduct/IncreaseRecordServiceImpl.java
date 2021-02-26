package cn.net.yzl.ehr.service.impl.deduct;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.deduct.DeductRecordFeginService;
import cn.net.yzl.ehr.fegin.deduct.IncreaseRecordFeginService;
import cn.net.yzl.ehr.service.deduct.DeductReocrdService;
import cn.net.yzl.ehr.service.deduct.IncreaseRecordService;
import cn.net.yzl.staff.dto.deduct.DeductRecordDto;
import cn.net.yzl.staff.dto.deduct.IncreaseRecordDto;
import cn.net.yzl.staff.pojo.deduct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncreaseRecordServiceImpl implements IncreaseRecordService {
    @Autowired
    private IncreaseRecordFeginService increaseRecordFeginService;


    @Override
    public ComResponse<List<IncreaseRecordDto>> getList(IncreaseRecordListPo increaseRecordListPo) {
        ComResponse<List<IncreaseRecordDto>> result = increaseRecordFeginService.getList(increaseRecordListPo);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData()==null) {
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(), ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<IncreaseRecordDto> selectone(Integer id) {
        ComResponse<IncreaseRecordDto> result = increaseRecordFeginService.selectone(id);
        if (result == null) {
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(), ResponseCodeEnums.API_ERROR_CODE.getMessage());
        } else if (result.getCode() == 200 && result.getData()==null) {
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(), ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> insertIncreaseRecord(IncreaseRecordInsertPo increaseRecordInsertPo) {
        ComResponse<Integer> result = increaseRecordFeginService.insertIncreaseRecord(increaseRecordInsertPo);
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
    public ComResponse<Integer> updateStateById(Integer id) {
        ComResponse<Integer> result = increaseRecordFeginService.updateStateById(id);
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
    public ComResponse<Integer> updateIncreaseStateById(Integer id) {
        ComResponse<Integer> result = increaseRecordFeginService.updateIncreaseStateById(id);
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
    public ComResponse<Integer> deleteById(Integer id ,String staffNo) {
        ComResponse<Integer> result =  increaseRecordFeginService.deleteById(id,staffNo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> updateExecuteState(IncreaseRecordPo increaseRecordPo) {
        ComResponse<Integer> result = increaseRecordFeginService.updateExecuteState(increaseRecordPo);
        return result;
    }
}
