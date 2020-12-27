package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.pojo.StaffPo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StaffService {



    // 获取用户详情
    ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo);


    ComResponse<List<StaffDetailsDto>> getByParams(String params);
}
