package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.ehr.pojo.StaffSwitchTalentPoolPo;
import cn.net.yzl.ehr.service.StaffService;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.dto.StaffInfoDto;
import cn.net.yzl.staff.dto.StatisticalStaffDto;
import cn.net.yzl.staff.vo.staff.StaffInfoSaveVO;
import cn.net.yzl.staff.vo.staff.StaffInfoUpdateVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/staff")
@Api(value = "员工服务", tags = {"员工服务"})
@Valid
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;
    @Autowired
    private StaffService staffService;



    @ApiOperation(value = "查询当前用户详情", notes = "查询当前用户详情")
    @RequestMapping(value = "/getCurrentDetails", method = RequestMethod.GET)
    public ComResponse<StaffDetailsDto> getCurrentDetails(@ApiIgnore @CurrentStaffNo String staffNo) {
        return staffService.getDetailsByNo(staffNo);
    }

    @ApiOperation(value = "根据用户工号获取详情信息", notes = "根据用户工号获取详情信息")
    @RequestMapping(value = "/getDetailsByNo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "用户工号", required = true, dataType = "String", paramType = "query")
    })
    public ComResponse<StaffDetailsDto> getDetailsByNo(@NotBlank String staffNo) {
        return staffService.getDetailsByNo(staffNo);
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
    public ComResponse<StaffBaseDto> getByIdCardNo(@NotBlank String idCardNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("idCardNo",idCardNo);
        return staffFeginService.getOneByMap(map);

    }
    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParams(@RequestBody @Validated StaffParamsVO staffParamsVO) {
        return staffService.getListByParams(staffParamsVO);
    }

    @ApiOperation(value = "将员工加入/移出人才池", notes = "将员工加入/移出人才池")
    @RequestMapping(value = "/swtichStaffTalentPoolAccount", method = RequestMethod.POST)
    ComResponse<Integer> swtichStaffTalentPoolAccount(@RequestBody StaffSwitchTalentPoolPo staffSwitchTalentPoolPo,@ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.swtichStaffTalentPoolAccount(staffSwitchTalentPoolPo,staffNo);
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

    @ApiOperation(value = "员工基本信息-保存", notes = "员工基本信息-保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> save(@RequestBody @Validated StaffInfoSaveVO staffInfoSaveVO) throws ParseException {
        return staffFeginService.save(staffInfoSaveVO);
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

    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/getStaffListByPage", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getStaffListByPage(@RequestBody @Validated StaffParamsVO staffParamsVO) throws IllegalAccessException {
        return staffFeginService.getListByParams(staffParamsVO);
    }
}