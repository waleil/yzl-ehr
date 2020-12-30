package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffBaseDto;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.pojo.DingTalkUserPo;
import cn.net.yzl.ehr.pojo.StaffDepartPostPo;
import cn.net.yzl.ehr.pojo.StaffPo;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//@FeignClient(value = "staff",url = "${fegin.api.url}")
@FeignClient(name = "yzl-staff-api")
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
    ComResponse<List<StaffDetailsDto>> getByParams(@RequestParam("params")String params);
    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/staff/getListByParams", method = RequestMethod.POST)
    ComResponse<Page<StaffListDto>> getListByParams(@RequestBody StaffParamsVO staffParamsVO);
}
