package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.dto.StaffDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient(name = "yzl-staff-db")
@Repository
public interface StaffFeginService {




//    @RequestMapping(value = "/staff/create", method = RequestMethod.POST,consumes = "application/json")
//    ComResponse<StaffPo> create(@RequestBody StaffPo staffPo);
//
//    @RequestMapping(value = "/staff/dingTalkUser/create", method = RequestMethod.POST,consumes = "application/json")
//    ComResponse<Boolean> createDingTalkUser(@RequestBody DingTalkUserPo dingTalkUserPo);
//    @RequestMapping(value = "/staff/insertStaffDepartList", method = RequestMethod.POST,consumes = "application/json")
//    void insertStaffDepartList(@RequestBody List<StaffDepartPostPo> staffDepartList);

    @RequestMapping(value = "/staff/getOneByMap", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<StaffBaseDto> getOneByMap(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/staff/getDetailsByNo", method = RequestMethod.GET)
    ComResponse<StaffDetailsDto> getDetailsByNo(@RequestParam("staffNo") String staffNo);
    @RequestMapping(value = "/staff/getByParams", method = RequestMethod.GET)
    ComResponse<List<StaffBaseDto>> getByParams(@RequestParam("params")String params);
    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/staff/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParams(@RequestBody StaffParamsVO staffParamsVO);

    @RequestMapping(value = "/staff/swtichStaffTalentPoolAccount", method = RequestMethod.POST)
    ComResponse<Integer> swtichStaffTalentPoolAccount(@RequestBody StaffSwitchTalentPoolPo staffSwitchTalentPoolPo);

    @RequestMapping(value = "/staff/switchAccount", method = RequestMethod.POST)
    ComResponse<Integer> switchAccount(@RequestBody StaffSwitchStatePo staffSwitchStatePo);

    @RequestMapping(value = "/staff/resetPassword", method = RequestMethod.POST)
    ComResponse<String> resetPassword(@RequestParam("userNo") String userNo,@RequestParam("creator") String creator);


    //查询员工基本信息
    @ApiOperation(value = "查询员工基本信息",notes = "查询员工基本信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staff/find", method = RequestMethod.GET)
    ComResponse<StaffDto> findByStaffNo(@RequestParam("staffNO")  String staffNO);

    @ApiOperation(value = "删除员工基本信息",notes = "删除员工基本信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staff/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")  Integer id,@RequestParam("updator") String updator);

    @ApiOperation(value = "添加员工基本信息", notes = "添加员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staff/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody  List<StaffInsertPo> insertPos);

    @ApiOperation(value = "修改员工基本信息", notes = "修改员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staff/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffUpdatePo updatePo);

    @ApiOperation(value = "保存员工基本信息", notes = "保存员工基本信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/staff/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody StaffItemPo itemPo);

}
