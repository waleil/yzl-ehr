package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.staff.pojo.StaffEntryPostConfirmPo;

import java.text.ParseException;
import java.util.List;

public interface StaffEntryPostService {


    ComResponse<Integer> insert(StaffEntryPostConfirmPo confirmPo) throws ParseException;

}
