package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.fegin.staff.StaffWorkFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffWorkServiceImpl implements StaffWorkService {


    @Autowired
    private StaffWorkFeginService staffWorkFeginService;


    @Override
    public ComResponse<StaffWorkListDto> list(String staffNo) {
        ComResponse<StaffWorkListDto> comResponse = staffWorkFeginService.list(staffNo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && (comResponse.getData().getPreWorkList().size()>0||comResponse.getData().getWorkList().size()>0)){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id) {
        ComResponse<Integer> comResponse = staffWorkFeginService.deleteById(id);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> insert(StaffWorkInsertListPo staffWorkList) {
        ComResponse<Integer> comResponse = staffWorkFeginService.insert(staffWorkList);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> update(StaffWorkUpdatePo workPo) {
        ComResponse<Integer> comResponse = staffWorkFeginService.update(workPo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> updatelist(StaffWorkUpdateListPo staffWorkUpdateListPo) {
        ComResponse<Integer> comResponse = staffWorkFeginService.updateList(staffWorkUpdateListPo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> saveUpDate(StaffWorkItemPo staffWorkItemPo,String staffNo) {
        if(staffWorkItemPo.getDeleteList()!=null){
        staffWorkItemPo.getDeleteList().forEach(x->{
           x.setUpdator(staffNo);
        });
        }
        if(staffWorkItemPo.getDeleteList()!=null){
        staffWorkItemPo.getInsertList().forEach(x->{
            x.setCreator(staffNo);
        });
        }
        if(staffWorkItemPo.getDeleteList()!=null) {
        staffWorkItemPo.getUpdateList().forEach(x -> {
            x.setUpdator(staffNo);
        });
        }

        ComResponse<Integer> comResponse = staffWorkFeginService.saveUpDate(staffWorkItemPo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }
}
