package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.fegin.staff.StaffEduFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffEntryPostFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFamilyFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffEduService;
import cn.net.yzl.ehr.service.StaffEntryPostService;
import cn.net.yzl.ehr.service.StaffFamilyService;
import cn.net.yzl.staff.pojo.StaffEntryPostConfirmPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class StaffEntryPostServiceImpl implements StaffEntryPostService {

    @Autowired
    private StaffEntryPostFeginService staffEntryPostFeginService;


    @Override
    public ComResponse<Integer> insert(StaffEntryPostConfirmPo confirmPo) throws ParseException {
        ComResponse<Integer> result =  staffEntryPostFeginService.insert(confirmPo);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return result;
    }
}
