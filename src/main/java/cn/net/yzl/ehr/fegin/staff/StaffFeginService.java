package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import cn.net.yzl.staff.dto.StaffDetailsDto;
import cn.net.yzl.staff.vo.staff.StaffInfoUpdateVO;
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
//@FeignClient(name = "yzl-staff-api")
@Repository
public interface StaffFeginService {

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

    @ApiOperation(value = "删除员工基本信息",notes = "删除员工基本信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/staff/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@RequestParam("id")  Integer id,@RequestParam("updator") String updator);


    @RequestMapping(value = "/staff/update", method = RequestMethod.POST)
    ComResponse<StaffDetailsDto> update(@RequestBody StaffInfoUpdateVO staffInfoUpdateVO);
}
