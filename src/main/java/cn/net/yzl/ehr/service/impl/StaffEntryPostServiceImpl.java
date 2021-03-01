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
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @ApiOperation(value = "更改自动入岗时间",notes = "更改自动入岗时间",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/entrypost/updateAutomaticEntryDays",method = RequestMethod.GET)
    public ComResponse<Integer> updateAutomaticEntryDays(@RequestParam("days") Integer days, @RequestParam("staffNo") String staffNo){
        ComResponse<Integer> result =  staffEntryPostFeginService.updateAutomaticEntryDays(days,staffNo);
        return result;
    }

}
