package cn.net.yzl.ehr.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.dto.StaffListExportDto;
import cn.net.yzl.ehr.dto.SysDictDataDto;
import cn.net.yzl.ehr.dto.resume.ResumeExportDto;
import cn.net.yzl.ehr.fegin.common.AreaFeginService;
import cn.net.yzl.ehr.fegin.common.SysDictDataFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.pojo.StaffSwitchTalentPoolPo;
import cn.net.yzl.ehr.pojo.SysDict;
import cn.net.yzl.ehr.service.StaffService;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.pm.entity.UserRole;
import cn.net.yzl.pm.model.dto.UserRoleDTO;
import cn.net.yzl.pm.model.vo.UserRoleVO;
import cn.net.yzl.pm.service.UserRoleService;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffInfoDto;
import cn.net.yzl.staff.dto.StatisticalStaffDto;
import cn.net.yzl.staff.dto.attend.StaffAttendImportResultDto;
import cn.net.yzl.staff.dto.resume.ResumeListDto;
import cn.net.yzl.staff.pojo.ImportStaffPo;
import cn.net.yzl.staff.util.DateStaffUtils;
import cn.net.yzl.staff.vo.ImportResultVo;
import cn.net.yzl.staff.vo.resume.ResumeParamsVO;
import cn.net.yzl.staff.vo.staff.StaffInfoSaveVO;
import cn.net.yzl.staff.vo.staff.StaffInfoUpdateVO;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.taobao.api.ApiException;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/staff")
@Api(value = "员工服务", tags = {"员工服务"})
@Valid
@Slf4j
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private AreaFeginService areaFeginService;
    @Autowired
    private SysDictDataFeginService sysDictDataFeginService;

    @Value("${file.prefix}")
    private String filePrefix;


    @ApiOperation(value = "查询当前用户详情", notes = "查询当前用户详情")
    @RequestMapping(value = "/getCurrentDetails", method = RequestMethod.GET)
    public ComResponse<StaffDetailsDto> getCurrentDetails(@ApiIgnore @CurrentStaffNo String staffNo) {
        ComResponse<StaffDetailsDto> detailsByNo = staffService.getDetailsByNo(staffNo);
        getUserRoleInfo(detailsByNo);
        return detailsByNo;
    }

    @ApiOperation(value = "根据用户工号获取详情信息", notes = "根据用户工号获取详情信息")
    @RequestMapping(value = "/getDetailsByNo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "用户工号", required = true, dataType = "String", paramType = "query")
    })
    public ComResponse<StaffDetailsDto> getDetailsByNo(@NotBlank String staffNo) {
        ComResponse<StaffDetailsDto> detailsByNo = staffService.getDetailsByNo(staffNo);
        getUserRoleInfo(detailsByNo);
        areaFeginService.getAllNation().getData().getItems().stream().forEach(nationDto -> {
            StaffDetailsDto data = detailsByNo.getData();
            if(data!=null ){
                Integer nationCode = data.getNationCode();
                Integer code = nationDto.getCode();

                if(nationCode.equals(code)){
                    data.setNationCodeStr(nationDto.getName());
                }
            }
        });

        return detailsByNo;
    }
    private void getUserRoleInfo(ComResponse<StaffDetailsDto> detailsByNo){
        if(detailsByNo.getData()!=null){
            StaffDetailsDto data = detailsByNo.getData();
            String staffNo = data.getStaffNo();
            List<String> userLists = Arrays.asList(staffNo);
            List<UserRoleVO> userRoleInfoByUserCodes = userRoleService.getUserRoleInfoByUserCodes(userLists);
            if(CollectionUtil.isNotEmpty(userRoleInfoByUserCodes)){
                List<String> rolesNames = userRoleInfoByUserCodes.stream().map(UserRoleVO::getRoleName).collect(Collectors.toList());
                List<String> rolesIds = userRoleInfoByUserCodes.stream().map(UserRoleVO::getRoleId).map(String::valueOf).collect(Collectors.toList());
                data.setRoleIds(String.join(",",rolesIds));
                data.setRoleNames(String.join(",",rolesNames));
            }
        }
    }


    @ApiOperation(value = "根据多个用户工号批量获取详情信息", notes = "根据多个用户工号批量获取详情信息")
    @RequestMapping(value = "/getDetailsByNo", method = RequestMethod.POST)
    public ComResponse<List<StaffDetailsDto>> getDetailsByNo(@RequestBody List<String> list) {
        return staffService.getDetailsListByNo(list);
    }
    @ApiOperation(value = "模糊查询用户信息", notes = "模糊查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "参数", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getByParams", method = RequestMethod.GET)
    public ComResponse<List<StaffBaseDto>> getByParams(@NotBlank String params) {
        return staffService.getByParams(params);

    }
    @ApiOperation(value = "根据身份证id获取用户基本信息", notes = "根据身份证id获取用户基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idCardNo", value = "身份证号", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getByIdCardNo", method = RequestMethod.GET)
    public ComResponse<StaffBaseDto> getByIdCardNo( String idCardNo) {

        if(StrUtil.isBlank(idCardNo)){
            return ComResponse.nodata();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("idCardNo",idCardNo);
        return staffFeginService.getOneByMap(map);

    }
    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParams(@RequestBody @Validated StaffParamsVO staffParamsVO,  HttpServletRequest request) {
        return staffService.getListByParams(staffParamsVO,request);
    }

    @ApiOperation(value = "模糊查询员工列表(部门员工查询)", notes = "模糊查询员工列表(部门员工查询)")
    @RequestMapping(value = "/getListByParamsForDepart", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParamsForDepart(@RequestBody @Validated StaffParamsVO staffParamsVO, HttpServletRequest request) {
        return staffService.getListByParamsForDepart(staffParamsVO,request);
    }

    @ApiOperation(value = "将员工加入/移出人才池", notes = "将员工加入/移出人才池")
    @RequestMapping(value = "/swtichStaffTalentPoolAccount", method = RequestMethod.POST)
    ComResponse<Integer> swtichStaffTalentPoolAccount(@RequestBody StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,@ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.swtichStaffTalentPoolAccount(staffSwitchTalentPoolPo,staffNo);
    }

    @ApiOperation(value = "将员工加入/移出黑名单", notes = "将员工加入/移出黑名单")
    @RequestMapping(value = "/swtichStaffBlackList", method = RequestMethod.POST)
    ComResponse<Integer> swtichStaffBlackList(@RequestBody StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,@ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.swtichStaffBlackList(staffSwitchTalentPoolPo,staffNo);
    }

    @ApiOperation(value = "批量将员工移出人才池", notes = "批量将员工移出人才池")
    @RequestMapping(value = "/swtichBatchStaffTalentPoolAccount", method = RequestMethod.POST)
    ComResponse<Integer> swtichBatchStaffTalentPoolAccount(@RequestBody List<StaffSwitchTalentPoolPo> staffSwitchTalentPoolPos,@ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.swtichBatchStaffTalentPoolAccount(staffSwitchTalentPoolPos,staffNo);
    }

    @ApiOperation(value = "停用/启用员工账号", notes = "停用/启用员工账号")
    @RequestMapping(value = "/switchAccount", method = RequestMethod.POST)
    ComResponse<Integer> switchAccount(@RequestBody StaffSwitchStatePo staffSwitchStatePo,@ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.switchAccount(staffSwitchStatePo,staffNo);
    }

    @ApiOperation(value = "重置员工密码", notes = "重置员工密码")
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    ComResponse<String> resetPassword(@RequestParam @ApiParam(name = "userNo", value = "员工工号") String userNo, @ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.resetPassword(userNo,staffNo);
    }

    @ApiOperation(value = "员工基本信息-修改", notes = "员工基本信息-修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> update(@RequestBody @Validated StaffInfoUpdateVO staffInfoUpdateVO) throws ParseException {
        return staffFeginService.update(staffInfoUpdateVO);
    }

    //@Validated
    @Autowired
    private UserRoleService userRoleService;
    @ApiOperation(value = "员工基本信息-保存", notes = "员工基本信息-保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> save(@RequestBody StaffInfoSaveVO staffInfoSaveVO,@ApiIgnore @CurrentStaffNo String currentStaffNo) throws ParseException {
        ComResponse<StaffDetailsDto> save =staffFeginService.save(staffInfoSaveVO);
        log.info("员工入职：-------------------------------");
        log.info("员工入职结果：{}",save.toString());
        if(save.getCode()==200){
            // 添加角色
            String roleIds = staffInfoSaveVO.getRoleIds();
            if(StrUtil.isNotBlank(roleIds)){
                String staffNo = save.getData().getStaffNo();
                List<UserRole> userRoles = new ArrayList<>();
                for (String s : roleIds.split(",")) {
                    UserRole userRole = new UserRole();
                    userRole.setUserCode(staffNo);
                    userRole.setRoleId(Integer.parseInt(s));
                    userRole.setCreateCode(currentStaffNo);
                    userRoles.add(userRole);
                }
                List<String> strings = new ArrayList<String>();
                strings.add(staffNo);
                UserRoleDTO userRoleDTO = new UserRoleDTO();
                userRoleDTO.setUserRoleList(userRoles);
                userRoleDTO.setUserCode(strings);
                log.info("员工新增角色数据：{}",userRoleDTO.toString());
                userRoleService.createUserRoleInfoList(userRoleDTO);
            }

        }
        return save;
    }

    @ApiOperation(value = "员工信息-员工异动需要的信息", notes = "员工信息-员工异动需要的信息")
    @RequestMapping(value = "/getInfoByNoForAbnor", method = RequestMethod.GET)
    public ComResponse<StaffInfoDto> getInfoByNoForAbnor(String staffNo){
        return staffService.getInfoByNoForAbnor(staffNo);
    }

    @ApiOperation(value = "工作台-员工统计", notes = "工作台-员工统计")
    @RequestMapping(value = "/getStaffTotalData", method = RequestMethod.GET)
    public ComResponse<StatisticalStaffDto> getStaffTotalData() {
        return staffFeginService.getStaffTotalData();
    }




    @ApiOperation(value = "员工列表-导出", notes = "员工列表-导出")
    @RequestMapping(value = "/staffListExcelExport", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "导出列表类型:1.员工列表,2.部门员工列表,3.待优化列表,4.带劝退,5.人才储备池列表,6.员工黑名单", required = true, dataType = "String", paramType = "query")
    })
    public void staffListExcelExport(@RequestBody @Validated StaffParamsVO staffParamsVO, @RequestParam("type") @NotNull @Min(1) Integer type,HttpServletRequest request,HttpServletResponse response) {
        String execName="resume_list";
        ComResponse<Page<StaffListExportDto>> listByParams=null;
        List<StaffListExportDto> list =null;
        execName="员工列表";
        try {
            ExcelWriter writer = ExcelUtil.getWriter();
            //员工列表
            switch (type){
                case 1:
                    execName="员工列表";
                    writer.renameSheet("员工列表");     //甚至sheet的名称
                    writer.addHeaderAlias("staffNo", "工号");
                    writer.addHeaderAlias("name", "姓名");
                    writer.addHeaderAlias("phone","手机号");
                    writer.addHeaderAlias("email","邮箱");
                    writer.addHeaderAlias("workplaceCodeStr","工作地点");
                    writer.addHeaderAlias("pDepartName","上级架构");
                    writer.addHeaderAlias("sexName","性别");
                    writer.addHeaderAlias("departName","部门");
                    writer.addHeaderAlias("postName","岗位名称");
                    writer.addHeaderAlias("postLevelName","岗位级别");
                    writer.addHeaderAlias("natureName","属性");
                    writer.addHeaderAlias("partnerName","合作方");
                    writer.addHeaderAlias("workCodeStr","职场");
                    writer.addHeaderAlias("postStatusCodeStr","在职状态");
                    writer.addHeaderAlias("trainingTimes","培训次数");
                    writer.addHeaderAlias("trainingGradeName","培训成绩");
                    writer.addHeaderAlias("enterStatusName","入岗状态");
                    writer.addHeaderAlias("postTime","入岗时间");
                    writer.addHeaderAlias("accountStatusStr","账号状态");
                    writer.addHeaderAlias("abnoStatusCodeStr","异动状态");
                    writer.addHeaderAlias("abnorTime","异动时间");
                    writer.addHeaderAlias("entryTimes","入司次数");
                    writer.addHeaderAlias("dimissionTime","离职时间");
                    writer.addHeaderAlias("payrollAccountingDate","薪资核算截止日");
                    writer.addHeaderAlias("isImportName","来源类型");
                    staffParamsVO.setPageNo(1);
                    staffParamsVO.setPageSize(50000);
                    listByParams = staffService.getListByParamsExport(staffParamsVO,request);
                    break;
                case 2://部门员工列表
                    execName="部门员工列表";
                    writer.renameSheet("部门员工列表");     //甚至sheet的名称
                    writer.addHeaderAlias("staffNo", "工号");
                    writer.addHeaderAlias("name", "姓名");
                    writer.addHeaderAlias("phone","手机号");
                    writer.addHeaderAlias("email","邮箱");
                    writer.addHeaderAlias("workplaceCodeStr","工作地点");
                    writer.addHeaderAlias("pDepartName","上级架构");
                    writer.addHeaderAlias("departName","部门");
                    writer.addHeaderAlias("postName","岗位名称");
                    writer.addHeaderAlias("postLevelName","岗位级别");
                    writer.addHeaderAlias("natureName","属性");
                    writer.addHeaderAlias("postStatusCodeStr","在职状态");
                    writer.addHeaderAlias("accountStatusStr","账号状态");
                    writer.addHeaderAlias("enterStatusName","入岗状态");
                    writer.addHeaderAlias("postTime","入岗时间");
                    writer.addHeaderAlias("trainingCompletion","培训完成度");
                    writer.addHeaderAlias("trainingGradeName","培训成绩");
                    writer.addHeaderAlias("abnorTime","历史异动异动时间");
                    writer.addHeaderAlias("entryTimes","入司次数");
                    staffParamsVO.setPageNo(1);
                    staffParamsVO.setPageSize(50000);
                    listByParams = staffService.getListByParamsExport(staffParamsVO,request);
                    break;
                case 3://待优化员工列表
                    execName="待优化员工列表";
                    writer.renameSheet("待优化员工列表");     //甚至sheet的名称
                    writer.addHeaderAlias("staffNo", "工号");
                    writer.addHeaderAlias("name", "姓名");
                    writer.addHeaderAlias("phone","手机号");
                    writer.addHeaderAlias("email","邮箱");
                    writer.addHeaderAlias("workplaceCodeStr","工作地点");
                    writer.addHeaderAlias("pDepartName","上级架构");
                    writer.addHeaderAlias("departName","部门");
                    writer.addHeaderAlias("postName","岗位名称");
                    writer.addHeaderAlias("postLevelName","岗位级别");
                    writer.addHeaderAlias("natureName","属性");
                    writer.addHeaderAlias("","原因");
                    staffParamsVO.setPageNo(1);
                    staffParamsVO.setPageSize(50000);
                    listByParams = staffService.getListByParamsExport(staffParamsVO,request);
                    break;
                case 4://待劝退员工列表
                    execName="待劝退员工列表";
                    writer.renameSheet("待劝退员工列表");     //甚至sheet的名称
                    writer.addHeaderAlias("staffNo", "工号");
                    writer.addHeaderAlias("name", "姓名");
                    writer.addHeaderAlias("phone","手机号");
                    writer.addHeaderAlias("email","邮箱");
                    writer.addHeaderAlias("workplaceCodeStr","工作地点");
                    writer.addHeaderAlias("pDepartName","上级架构");
                    writer.addHeaderAlias("departName","部门");
                    writer.addHeaderAlias("postName","岗位名称");
                    writer.addHeaderAlias("postLevelName","岗位级别");
                    writer.addHeaderAlias("natureName","属性");
                    writer.addHeaderAlias("","原因");
                    staffParamsVO.setPageNo(1);
                    staffParamsVO.setPageSize(50000);
                    listByParams = staffService.getListByParamsExport(staffParamsVO,request);
                    break;
                case 5://人才储备池
                    execName="人才储备池员工列表";
                    writer.renameSheet("人才储备池员工列表");     //甚至sheet的名称
                    writer.addHeaderAlias("staffNo", "工号");
                    writer.addHeaderAlias("name", "姓名");
                    writer.addHeaderAlias("phone","手机号");
                    writer.addHeaderAlias("email","邮箱");
                    writer.addHeaderAlias("workplaceCodeStr","工作地点");
                    writer.addHeaderAlias("pDepartName","上级架构");
                    writer.addHeaderAlias("departName","部门");
                    writer.addHeaderAlias("postName","岗位名称");
                    writer.addHeaderAlias("postLevelName","岗位级别");
                    writer.addHeaderAlias("natureName","属性");
                    writer.addHeaderAlias("accountStatusStr","账号状态");
                    writer.addHeaderAlias("abnorTime","历史异动时间");
                    writer.addHeaderAlias("entryTimes","入司次数");
                    staffParamsVO.setPageNo(1);
                    staffParamsVO.setPageSize(50000);
                    listByParams = staffService.getListByParamsExport(staffParamsVO,request);
                    break;
                case 6://黑名单
                    execName="员工黑名单列表";
                    writer.renameSheet("员工黑名单列表");     //甚至sheet的名称
                    writer.addHeaderAlias("staffNo", "工号");
                    writer.addHeaderAlias("name", "姓名");
                    writer.addHeaderAlias("phone","手机号");
                    writer.addHeaderAlias("postStatusCodeStr","在职状态");
                    writer.addHeaderAlias("email","邮箱");
                    writer.addHeaderAlias("workplaceCodeStr","工作地点");
                    writer.addHeaderAlias("pDepartName","上级架构");
                    writer.addHeaderAlias("departName","部门");
                    writer.addHeaderAlias("postName","岗位名称");
                    writer.addHeaderAlias("postLevelName","岗位级别");
                    writer.addHeaderAlias("natureName","属性");
                    writer.addHeaderAlias("dimissionTime","离职时间");
                    staffParamsVO.setPageNo(1);
                    staffParamsVO.setPageSize(50000);
                    listByParams = staffService.getListByParamsExport(staffParamsVO,request);
                    break;
            }
            if(listByParams!=null && listByParams.getData()!=null && listByParams.getData().getItems()!=null){
                list = listByParams.getData().getItems();
            }

            writer.setOnlyAlias(true);
            writer.write(list, true);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(execName, "UTF-8")+DateUtil.today()+".xls");   //中文名称需要特殊处理
            writer.autoSizeColumnAll();
            writer.flush(response.getOutputStream());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ApiOperation(value = "员工数据-导入", notes = "员工数据-导入", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/importStaffInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "文件路径(相对路径)", required = true, dataType = "String", paramType = "query"),
    })
    ComResponse<ImportResultVo> importStaffInfo(String url) throws ParseException {
        return staffService.importStaffInfo(url);
    }

    @ApiOperation(value = "员工数据导入模板", notes = "员工数据导入模板", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getStaffImportExcelModel", method = RequestMethod.GET)
    public ComResponse<String> getStaffImportExcelModel(){
        ComResponse<List<SysDictDataDto>> dicts = sysDictDataFeginService.getByType("staff_import_model");
        if(dicts!=null && dicts.getData()!=null){
            SysDictDataDto sysDictDataDto = dicts.getData().get(0);
            return ComResponse.success(filePrefix+"/"+sysDictDataDto.getDictValue());
        }
        return ComResponse.nodata();
    }

    @ApiOperation(value = "员工数据-查询导入员工列表", notes = "员工数据-查询导入员工列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getImportStaffList", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getImportStaffList(@RequestBody StaffParamsVO staffParamsVO, HttpServletRequest request) throws ParseException{
        return staffService.getImportStaffList(staffParamsVO,request);
    }

    @ApiOperation(value = "员工数据-用id查询导入员工详情", notes = "员工数据-用id查询导入员工详情", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getImportStaff", method = RequestMethod.GET)
    ComResponse<StaffListDto> getImportStaff(Integer id) throws ParseException {
        return staffService.getImportStaff(id);
    }

    @ApiOperation(value = "员工数据-用id删除未补全员工", notes = "员工数据-用id删除未补全员工", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteImportStaff", method = RequestMethod.GET)
    ComResponse<Integer> deleteImportStaff(Integer id) throws ParseException {
        return staffService.deleteImportStaff(id);
    }

    @ApiOperation(value = "员工数据-完善员工详情", notes = "员工数据-完善员工详情", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/completeInfo", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> completeInfo(@RequestBody @Validated StaffInfoSaveVO staffInfoSaveVO,@CurrentStaffNo @ApiIgnore String currentStaffNo) throws ParseException, ApiException{
        ComResponse<StaffDetailsDto> staffDetailsDtoComResponse = staffService.completeInfo(staffInfoSaveVO);
        if(staffDetailsDtoComResponse.getCode()==200){
            // 添加角色
            String roleIds = staffInfoSaveVO.getRoleIds();
            if(StrUtil.isNotBlank(roleIds)){
                String staffNo = staffInfoSaveVO.getStaffNo();
                List<UserRole> userRoles = new ArrayList<>();
                for (String s : roleIds.split(",")) {
                    UserRole userRole = new UserRole();
                    userRole.setUserCode(staffNo);
                    userRole.setRoleId(Integer.parseInt(s));
                    userRole.setCreateCode(currentStaffNo);
                    userRoles.add(userRole);
                }
                List<String> strings = new ArrayList<>();
                strings.add(staffNo);
                UserRoleDTO userRoleDTO = new UserRoleDTO();
                userRoleDTO.setUserRoleList(userRoles);
                userRoleDTO.setUserCode(strings);
                userRoleService.createUserRoleInfoList(userRoleDTO);
            }

        }
        return staffDetailsDtoComResponse;

    }

    @ApiOperation(value = "员工数据-查询默认头像图片路径", notes = "员工数据-查询默认头像图片路径", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getStaffImgUrl", method = RequestMethod.GET)
    public ComResponse<String> getStaffImgUrl(Integer resumeId, String staffNo) {
        return staffFeginService.getStaffImgUrl(resumeId,staffNo);
    }
}