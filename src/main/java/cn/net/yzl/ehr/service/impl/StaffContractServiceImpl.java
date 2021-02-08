package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffContartListDto;
import cn.net.yzl.ehr.fegin.staff.StaffContractFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffContractServiceImpl implements StaffContractService {


    @Autowired
    private StaffContractFeginService staffContractFeginService;


    @Override
    public ComResponse<List<StaffContartListDto>> findByStringNo(String staffNo) {
        ComResponse<List<StaffContartListDto>> comResponse = staffContractFeginService.findByStringNo(staffNo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && (comResponse.getData().size()>0)){
            ComResponse.success();
        }
        return comResponse;
    }

    @Override
    public ComResponse<Integer> insert(StaffCFInsertPo staffCFInsertPo) {
        ComResponse<Integer> comResponse = staffContractFeginService.insert(staffCFInsertPo);
        if(comResponse==null){
            ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if(comResponse.getCode()==200 && comResponse.getData()>0){
            ComResponse.success();
        }
        return comResponse;
    }
}
