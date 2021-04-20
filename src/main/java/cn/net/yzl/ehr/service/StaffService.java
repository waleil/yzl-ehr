package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.dto.StaffListExportDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffInfoDto;
import cn.net.yzl.staff.dto.StatisticalStaffDto;
import cn.net.yzl.staff.vo.ImportResultVo;
import cn.net.yzl.staff.vo.staff.StaffInfoSaveVO;
import com.taobao.api.ApiException;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StaffService {

    ComResponse<StaffBaseDto> getStaffNoByIdCard(String idCardNo);

    // 获取用户详情
    ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo);

    ComResponse<List<StaffDetailsDto>> getDetailsListByNo(List<String> list);

    ComResponse<List<StaffBaseDto>> getByParams(String params);

    ComResponse<Page<StaffListDto>> getListByParams(StaffParamsVO staffParamsVO, HttpServletRequest request);

    ComResponse<Page<StaffListExportDto>> getListByParamsExport(StaffParamsVO staffParamsVO, HttpServletRequest request);

    ComResponse<Page<StaffListDto>> getListByParamsForDepart(StaffParamsVO staffParamsVO, HttpServletRequest request);

    ComResponse<Integer> swtichStaffTalentPoolAccount(StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,String staffNo);

    ComResponse<Integer> swtichStaffBlackList(StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,String staffNo);

    ComResponse<Integer> swtichBatchStaffTalentPoolAccount(List<StaffSwitchTalentPoolPo> staffSwitchTalentPoolPos,String staffNo);


    ComResponse<Integer> switchAccount(StaffSwitchStatePo staffSwitchStatePo,String staffNo);
    ComResponse<String> resetPassword(String userNo,String creator);
    ComResponse<Integer> deleteById (Integer id,String updator);

    ComResponse<StaffInfoDto> getInfoByNoForAbnor(String staffNo);

    ComResponse<StatisticalStaffDto> getStaffTotalData();

    ComResponse<ImportResultVo> importStaffInfo(String url) throws ParseException ;

    ComResponse<Page<StaffListDto>> getImportStaffList(StaffParamsVO staffParamsVO, HttpServletRequest request) throws ParseException ;

    ComResponse<StaffListDto> getImportStaff(Integer id) throws ParseException ;

    ComResponse<Integer> deleteImportStaff(Integer id) throws ParseException ;

    ComResponse<StaffDetailsDto> completeInfo(StaffInfoSaveVO staffInfoSaveVO) throws ParseException, ApiException;

    ComResponse<String> getStaffImgUrl(@RequestParam("resumeId") Integer resumeId,@RequestParam("staffNo") String staffNo) ;
}
