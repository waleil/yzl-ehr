package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.dto.StaffListExportDto;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.pojo.StaffSwitchTalentPoolPo;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffInfoDto;
import cn.net.yzl.staff.dto.StatisticalStaffDto;
import cn.net.yzl.staff.vo.ImportResultVo;
import cn.net.yzl.staff.vo.UpdatePasswordPo;
import cn.net.yzl.staff.vo.staff.StaffInfoSaveVO;
import cn.net.yzl.staff.vo.staff.StaffInfoUpdateVO;
import com.taobao.api.ApiException;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(value = "yzl-staff-db")
@Repository
public interface StaffFeginService {

    @RequestMapping(value = "/staff/getOneByMap", method = RequestMethod.POST, consumes = "application/json")
    ComResponse<StaffBaseDto> getOneByMap(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/staff/getStaffNoByIdCard", method = RequestMethod.GET, consumes = "application/json")
    ComResponse<StaffBaseDto> getStaffNoByIdCard(@RequestParam("idCardNo") String idCardNo);

    @ApiOperation(value = "根据staffno查询用户详情", notes = "根据UserNo查询用户详情")
    @RequestMapping(value = "/staff/getDetailsByNo", method = RequestMethod.GET)
    ComResponse<StaffDetailsDto> getDetailsByNo(@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "根据多个staffno批量查询用户详情", notes = "根据staffno批量查询用户详情")
    @RequestMapping(value = "/staff/getDetailsListByNo", method = RequestMethod.POST)
    ComResponse<List<StaffDetailsDto>> getDetailsListByNo(@RequestBody List<String> list);

    @RequestMapping(value = "/staff/getByParams", method = RequestMethod.GET)
    ComResponse<List<StaffBaseDto>> getByParams(@RequestParam("params") String params);

    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/staff/getListByParamsEHR", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParams(@RequestBody StaffParamsVO staffParamsVO);

    @ApiOperation(value = "模糊查询员工列表(导出)", notes = "模糊查询员工列表")
    @RequestMapping(value = "/staff/getListByParamsEHR", method = RequestMethod.POST)
    ComResponse<Page<StaffListExportDto>> getListByParamsExport(@RequestBody StaffParamsVO staffParamsVO);

    @ApiOperation(value = "模糊查询员工列表(部门员工查询)", notes = "模糊查询员工列表(部门员工查询)")
    @RequestMapping(value = "/staff/getListByParamsForDepart", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParamsForDepart(@RequestBody StaffParamsVO staffParamsVO);

    @RequestMapping(value = "/staff/swtichStaffTalentPoolAccount", method = RequestMethod.POST)
    ComResponse<Integer> swtichStaffTalentPoolAccount(@RequestBody StaffSwitchTalentPoolPo staffSwitchTalentPoolPo);

    @RequestMapping(value = "/staff/swtichStaffBlackList", method = RequestMethod.POST)
    ComResponse<Integer> swtichStaffBlackList(@RequestBody StaffSwitchTalentPoolPo staffSwitchTalentPoolPo);

    @RequestMapping(value = "/staff/swtichBatchStaffTalentPoolAccount", method = RequestMethod.POST)
    ComResponse<Integer> swtichBatchStaffTalentPoolAccount(@RequestBody List<StaffSwitchTalentPoolPo> staffSwitchStatePos);

    @RequestMapping(value = "/staff/switchAccount", method = RequestMethod.POST)
    ComResponse<Integer> switchAccount(@RequestBody StaffSwitchStatePo staffSwitchStatePo);

    @RequestMapping(value = "/staff/resetPasswordByNo", method = RequestMethod.POST)
    ComResponse<String> resetPassword(@RequestBody UpdatePasswordPo updatePasswordPo);

    //查询员工基本信息
    @ApiOperation(value = "删除员工基本信息", notes = "删除员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staff/deleteById", method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id, @RequestParam("updator") String updator);

    @RequestMapping(value = "/staff/update", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> update(@RequestBody StaffInfoUpdateVO staffInfoUpdateVO);

    @RequestMapping(value = "/staff/save", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> save(@RequestBody StaffInfoSaveVO staffInfoSaveVO);

    @RequestMapping(value = "/staff/getInfoByNoForAbnor", method = RequestMethod.GET)
    ComResponse<StaffInfoDto> getInfoByNoForAbnor(@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/staff/getStaffTotalData", method = RequestMethod.GET)
    ComResponse<StatisticalStaffDto> getStaffTotalData();

    @RequestMapping(value = "/staff/importStaffInfo", method = RequestMethod.GET)
    public ComResponse<ImportResultVo> importStaffInfo(@RequestParam("url") String url) throws ParseException ;

    @RequestMapping(value = "/staff/getImportStaffList", method = RequestMethod.POST)
    public ComResponse<Page<StaffListDto>> getImportStaffList(@RequestBody StaffParamsVO staffParamsVO) throws ParseException ;

    @RequestMapping(value = "/staff/getImportStaff", method = RequestMethod.GET)
    public ComResponse<StaffListDto> getImportStaff(@RequestParam("id") Integer id) throws ParseException ;

    @RequestMapping(value = "/staff/deleteImportStaff", method = RequestMethod.GET)
    public ComResponse<Integer> deleteImportStaff(@RequestParam("id") Integer id) throws ParseException ;

    @RequestMapping(value = "/staff/completeInfo", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> completeInfo(@RequestBody StaffInfoSaveVO staffInfoSaveVO) throws ParseException, ApiException;

    //办理入职时判断简历中是否有头像，无则加载默认头像，有则用之;补全信息无初始头像，直接使用默认头像
    @RequestMapping(value = "/staff/getStaffImgUrl", method = RequestMethod.GET)
    ComResponse<String> getStaffImgUrl(@RequestParam("resumeId") Integer resumeId,@RequestParam("staffNo") String staffNo);

}