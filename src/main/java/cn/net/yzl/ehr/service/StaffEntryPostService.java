package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffEduListDto;
import cn.net.yzl.ehr.pojo.*;

import java.util.List;

public interface StaffEntryPostService {


    ComResponse<Integer> insert(String staffNo);

}
