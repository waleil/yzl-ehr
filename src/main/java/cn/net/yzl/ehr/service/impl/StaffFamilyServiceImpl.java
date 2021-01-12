package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffFamilyDto;
import cn.net.yzl.ehr.dto.StaffFamilyListDto;
import cn.net.yzl.ehr.fegin.staff.StaffFamilyFeginService;
import cn.net.yzl.ehr.pojo.StaffFamilyInsertPo;
import cn.net.yzl.ehr.pojo.StaffFamilyItemPo;
import cn.net.yzl.ehr.pojo.StaffFamilyPo;
import cn.net.yzl.ehr.pojo.StaffFamilyUpdatePo;
import cn.net.yzl.ehr.service.StaffFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StaffFamilyServiceImpl implements StaffFamilyService {

    @Autowired
    private StaffFamilyFeginService staffFamilyFeginService;


    @Override
    public ComResponse<StaffFamilyListDto> findByStaffNo(String staffNO) {
        ComResponse<StaffFamilyListDto>  result = staffFamilyFeginService.findByStaffNo(staffNO);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData() == null){
            return ComResponse.fail(ResponseCodeEnums.NO_DATA_CODE.getCode(),ResponseCodeEnums.NO_DATA_CODE.getMessage());
        }
        return result;
    }

    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator){
        ComResponse<Integer> result =  staffFamilyFeginService.deleteById(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<Integer> insert(List<StaffFamilyInsertPo> staff) {
        ComResponse<Integer> result =  staffFamilyFeginService.insert(staff);
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
    public ComResponse<Integer> update(StaffFamilyUpdatePo familyPo) {
        ComResponse<Integer> result =  staffFamilyFeginService.update(familyPo);
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
    public ComResponse<Integer> saveUpDate(StaffFamilyItemPo staffFamilyItemPo) {
        ComResponse<Integer> result =  staffFamilyFeginService.saveUpDate(staffFamilyItemPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }else if (result.getCode()==200 && result.getData()==null){
            return ComResponse.fail(ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getCode(),ResponseCodeEnums.SAVE_DATA_ERROR_CODE.getMessage());
        }if (result.getData()!=null){
            return ComResponse.success();
        }
        return result;
    }

}
