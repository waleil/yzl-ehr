package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.dto.StaffDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StaffService {



    // 获取用户详情
    ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo);


    ComResponse<List<StaffBaseDto>> getByParams(String params);

    ComResponse<Page<StaffListDto>> getListByParams(StaffParamsVO staffParamsVO);

    ComResponse<Integer> swtichStaffTalentPoolAccount(StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,String staffNo);

    ComResponse<Integer> switchAccount(StaffSwitchStatePo staffSwitchStatePo,String staffNo);

    ComResponse<String> resetPassword(String userNo,String creator);

    ComResponse<StaffDto> find (String staffNO);

    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<Integer> insert (List<StaffInsertPo> insertPos);

    ComResponse<Integer> update (StaffUpdatePo updatePo);

    ComResponse<Integer> saveUpDate (StaffItemPo staffItemPo);

}
