package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainDto;
import cn.net.yzl.ehr.fegin.staff.StaffAbnorFeginService;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.service.StaffAbnorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffAbnorServiceImpl implements StaffAbnorService {

    @Autowired
    private StaffAbnorFeginService staffAbnorFeginService;

    @Override
    public ComResponse<Integer> updateStaffChangeStatus(StaffSwitchStatePo staffSwitchStatePo,String staffNo) {
        staffSwitchStatePo.setUpdator(staffNo);
        ComResponse<Integer> comResponse = staffAbnorFeginService.updateStaffChangeStatus(staffSwitchStatePo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> executeStaffChange(StaffAbnorRecordPo staffChangePo,String staffNo) {
        staffChangePo.setCreator(staffNo);
        ComResponse<Integer> comResponse = staffAbnorFeginService.executeStaffChange(staffChangePo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<StaffAbnorRecordListDto> getStaffAbnorRecord(String staffNo) {
        ComResponse<StaffAbnorRecordListDto> comResponse = staffAbnorFeginService.getStaffAbnorRecord(staffNo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()!=null){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<List<StaffTrainDto>> find(String staffNo) {
        ComResponse<List<StaffTrainDto>> listComResponse = staffAbnorFeginService.find(staffNo);
        if (listComResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (listComResponse.getData()!=null && listComResponse.getCode() == 200){
            ComResponse.success();
        }
        return listComResponse;
    }

    @Override
    public ComResponse<List<StaffTrainDto>> findPage(String staffNo, Integer pageNum, Integer pageSize) {
        ComResponse<List<StaffTrainDto>> listComResponse = staffAbnorFeginService.findPage(staffNo,pageNum,pageSize);
        if (listComResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (listComResponse.getData()!=null && listComResponse.getCode() == 200){
            ComResponse.success();
        }
        return listComResponse;
    }


}
