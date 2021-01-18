package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;

import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.dto.StaffDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffService;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

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
    @ApiOperation(value = "模糊查询用户信息", notes = "模糊查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "参数", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getByParams", method = RequestMethod.GET)
    public ComResponse<List<StaffBaseDto>> getByParams(@NotBlank String params) {
        return staffService.getByParams(params);

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
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo", value = "用户工号", required = true, dataType = "String", paramType = "query")
    })
    ComResponse<String> resetPassword(@RequestParam("userNo") String userNo,@ApiIgnore @CurrentStaffNo String staffNo){
        return staffService.resetPassword(userNo,staffNo);
    }


    @ApiOperation(value = "查询员工基本信息",notes = "查询员工基本信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    ComResponse<StaffDto> find(@RequestParam("staffNO") String staffNO) {
        return staffService.find(staffNO);
    }

   /* @ApiOperation(value = "删除员工基本信息",notes = "删除员工基本信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(Integer id,String updator) {
        return staffService .deleteById(id,updator);
    }

    @ApiOperation(value = "添加员工基本信息", notes = "添加员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody List<StaffInsertPo> insertPos) {
        return staffService.insert( insertPos);
    }
    @ApiOperation(value = "修改员工基本信息", notes = "修改员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffUpdatePo updatePo) {
        return staffService.update(updatePo);
    }*/
    @ApiOperation(value = "保存员工基本信息", notes = "保存员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffItemPo itemPo){
        return staffService.saveUpDate(itemPo);
    }
}