package cn.net.yzl.ehr.service.impl;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.common.util.JsonUtil;
import cn.net.yzl.ehr.dto.*;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffService;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.pm.model.dto.MenuDTO;
import cn.net.yzl.pm.service.RoleMenuService;
import cn.net.yzl.staff.dto.StaffInfoDto;
import cn.net.yzl.staff.dto.StatisticalStaffDto;
import cn.net.yzl.staff.vo.ImportResultVo;
import cn.net.yzl.staff.vo.UpdatePasswordPo;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.vo.staff.StaffInfoSaveVO;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private StaffFeginService staffFeginService;

    @Autowired
    private DepartFeginService departFeginService;

    @Override
    public ComResponse<StaffDetailsDto> getDetailsByNo(String staffNo) {
        return staffFeginService.getDetailsByNo(staffNo);
    }

    @Override
    public ComResponse<List<StaffDetailsDto>> getDetailsListByNo(List<String> list) {
        return staffFeginService.getDetailsListByNo(list);
    }

    @Override
    public ComResponse<List<StaffBaseDto>> getByParams(String params) {
        return staffFeginService.getByParams(params);
    }

    @Override
    public ComResponse<Page<StaffListDto>> getListByParams(StaffParamsVO staffParamsVO, HttpServletRequest request) {
        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        staffParamsVO.setStaffNo(userNo);
        if(referer.contains("/trainingManagement/newTraining")){
             referer = referer.replace("/newTraining", "");
        }


        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        log.info(JsonUtil.toJsonStr(menuDTO));
        staffParamsVO.setStaffNo(userNo);
       /* menuDTO.getMenuName();//获取菜单名称
        menuDTO.getIsAdmin();//获取最高权限标识*/
        //最高权限标识
        if(menuDTO!=null && menuDTO.getIsAdmin()!=null && menuDTO.getIsAdmin()==1 ){
            //全量，只根据departId查询
            staffParamsVO.setFlag(2);
        }else{
            //会增加部门负责人限制
            staffParamsVO.setFlag(1);
        }
        return staffFeginService.getListByParams(staffParamsVO);
    }


    @Override
    public ComResponse<Page<StaffListDto>> getListByParamsForDepart(StaffParamsVO staffParamsVO, HttpServletRequest request) {
        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        staffParamsVO.setStaffNo(userNo);
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        log.info(JsonUtil.toJsonStr(menuDTO));
       /* menuDTO.getMenuName();//获取菜单名称
        menuDTO.getIsAdmin();//获取最高权限标识*/
        //最高权限标识
        if(menuDTO!=null && menuDTO.getIsAdmin()!=null && menuDTO.getIsAdmin()==1 ){
            //全量
            staffParamsVO.setFlag(2);
        }else{
            //会增加部门负责人限制
            staffParamsVO.setFlag(1);
        }
        return staffFeginService.getListByParamsForDepart(staffParamsVO);
    }

    @Override
    public ComResponse<Integer> swtichStaffTalentPoolAccount(StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,String staffNo) {
        staffSwitchTalentPoolPo.setUpdator(staffNo);
        return staffFeginService.swtichStaffTalentPoolAccount(staffSwitchTalentPoolPo);
    }

    @Override
    public ComResponse<Integer> swtichBatchStaffTalentPoolAccount(List<StaffSwitchTalentPoolPo> staffSwitchTalentPoolPos,String staffNo) {
        staffSwitchTalentPoolPos.forEach(x->{
            x.setUpdator(staffNo);
        });
        return staffFeginService.swtichBatchStaffTalentPoolAccount(staffSwitchTalentPoolPos);
    }

    @Override
    public ComResponse<Integer> switchAccount(StaffSwitchStatePo staffSwitchStatePo,String staffNo) {
        staffSwitchStatePo.setUpdator(staffNo);
        return staffFeginService.switchAccount(staffSwitchStatePo);
    }

    @Override
    public ComResponse<String> resetPassword(String userNo, String creator) {
        UpdatePasswordPo updatePasswordPo = new UpdatePasswordPo();
        updatePasswordPo.setUserNo(userNo);
        updatePasswordPo.setStaffNo(creator);
        return staffFeginService.resetPassword(updatePasswordPo);
    }



    @Override
    public ComResponse<Integer> deleteById(Integer id, String updator) {
        ComResponse<Integer> result =  staffFeginService.deleteById(id,updator);
        if (result==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return ComResponse.success();
    }

    @Override
    public ComResponse<StaffInfoDto> getInfoByNoForAbnor(String staffNo) {
        ComResponse<StaffInfoDto> infoByNoForAbnor = staffFeginService.getInfoByNoForAbnor(staffNo);
        if (infoByNoForAbnor==null){
            return ComResponse.fail(ResponseCodeEnums.API_ERROR_CODE.getCode(),ResponseCodeEnums.API_ERROR_CODE.getMessage());
        }
        return infoByNoForAbnor;
    }

    @Override
    public ComResponse<StatisticalStaffDto> getStaffTotalData() {
        return staffFeginService.getStaffTotalData();
    }

    @Override
    public ComResponse<ImportResultVo> importStaffInfo(String url) throws ParseException {
        return staffFeginService.importStaffInfo(url);
    }


    @Override
    public ComResponse<Page<StaffListDto>> getImportStaffList(StaffParamsVO staffParamsVO, HttpServletRequest request) throws ParseException {
        String userNo = request.getHeader("userNo");
        String referer = request.getHeader("Referer");
        staffParamsVO.setStaffNo(userNo);
        MenuDTO menuDTO = roleMenuService.getIsAdminByUserCodeAndMenuUrl(userNo,referer);
        log.info(JsonUtil.toJsonStr(menuDTO));
       /* menuDTO.getMenuName();//获取菜单名称
        menuDTO.getIsAdmin();//获取最高权限标识*/
        //最高权限标识
        if(menuDTO!=null && menuDTO.getIsAdmin()!=null && menuDTO.getIsAdmin()==1 ){
            //全量
            return staffFeginService.getImportStaffList(staffParamsVO);
        }else{
            //不展示
            return ComResponse.nodata();
        }


    }

    @Override
    public ComResponse<StaffListDto> getImportStaff(Integer id) throws ParseException {
        return staffFeginService.getImportStaff(id);
    }

    @Override
    public ComResponse<Integer> deleteImportStaff(Integer id) throws ParseException {
        return staffFeginService.deleteImportStaff(id);
    }

    @Override
    public ComResponse<StaffDetailsDto> completeInfo(StaffInfoSaveVO staffInfoSaveVO) throws ParseException, ApiException {
        return staffFeginService.completeInfo(staffInfoSaveVO);
    }

    @Override
    public ComResponse<String> getStaffImgUrl(Integer resumeId, String staffNo) {
        return staffFeginService.getStaffImgUrl(resumeId,staffNo);
    }


}
