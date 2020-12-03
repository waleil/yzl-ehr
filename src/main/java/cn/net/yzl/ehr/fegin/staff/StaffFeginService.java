package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.pojo.DingTalkUserPo;
import cn.net.yzl.ehr.pojo.StaffDepartPostPo;
import cn.net.yzl.ehr.pojo.StaffPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yzl-staff-service"/*,fallback = StaffFeginServiceFallBack.class*/)
@Repository
public interface StaffFeginService {


    @RequestMapping(value = "/staff/getById", method = RequestMethod.GET)
    ComResponse<String> getByPrimaryKey( @RequestParam("id") int id);

    @RequestMapping(value = "/staff/create", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<StaffPo> create(@RequestBody StaffPo staffPo);

    @RequestMapping(value = "/staff/dingTalkUser/create", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Boolean> createDingTalkUser(@RequestBody DingTalkUserPo dingTalkUserPo);
    @RequestMapping(value = "/staff/insertStaffDepartList", method = RequestMethod.POST,consumes = "application/json")
    void insertStaffDepartList(@RequestBody List<StaffDepartPostPo> staffDepartList);
}
