package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffInfoDto;
import cn.net.yzl.staff.dto.StatisticalStaffDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StaffService {



    // 获取用户详情
    ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo);

    ComResponse<List<StaffDetailsDto>> getDetailsListByNo(List<String> list);

    ComResponse<List<StaffBaseDto>> getByParams(String params);

    ComResponse<Page<StaffListDto>> getListByParams(StaffParamsVO staffParamsVO);

    ComResponse<Integer> swtichStaffTalentPoolAccount(StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,String staffNo);

    ComResponse<Integer> switchAccount(StaffSwitchStatePo staffSwitchStatePo,String staffNo);
    ComResponse<String> resetPassword(String userNo,String creator);
    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<StaffInfoDto> getInfoByNoForAbnor(String staffNo);

    ComResponse<StatisticalStaffDto> getStaffTotalData();
}
