/*package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.fegin.staff.StaffGrowUpFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffGrowUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;*/

/*public class StaffGrowUpServiceImpl implements StaffGrowUpService {*/

  /*  @Autowired
    private StaffGrowUpFeginService staffGrowUpFeginService;

    @Override
    public ComResponse<List<StaffUpRpPo>> findByStaffNo(String staffNO) {
       ComResponse<List<StaffUpRpPo>> result = staffGrowUpFeginService.findByStaffNo(staffNO);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData().size()<1){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result = staffGrowUpFeginService.deleteById(id, updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> insert(List<StaffUpRpInsertPo> staff) {
        ComResponse<Integer> result = staffGrowUpFeginService.insert(staff);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()>0){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> update(StaffUpRpUpdatePo staffUpRpUpdatePo) {
        ComResponse<Integer> result = staffGrowUpFeginService.update(staffUpRpUpdatePo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> saveUpDate(StaffUpRpItemPo staffUpRpItemPo) {
        ComResponse<Integer> result = staffGrowUpFeginService.saveUpDate(staffUpRpItemPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<List<StaffUpTrainPo>> find(String staffNO) {
        ComResponse<List<StaffUpTrainPo>> result = staffGrowUpFeginService.find(staffNO);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData().size()<1){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteTrain(Integer id, String updator) {
        ComResponse<Integer> result = staffGrowUpFeginService.delectTrain(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> addTrain(List<StaffUpTrainInsertPo> staff) {
        ComResponse<Integer> result = staffGrowUpFeginService.addTrain(staff);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()<1){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()>0){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> updateTrain(StaffUpTrainUpdatePo staffUprainUpdatePo) {
        ComResponse<Integer> result = staffGrowUpFeginService.updateTrain(staffUprainUpdatePo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

    @Override
    public ComResponse<Integer> saveUpDateTrain(StaffUpTrainItemPo staffUpTrainItemPo) {
        ComResponse<Integer> result = staffGrowUpFeginService.saveUpDateTrain(staffUpTrainItemPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }*/

