package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
//@FeignClient("yzl-staff-db")
public interface StaffWorkFeginService {

    @ApiOperation(value = "查询员工工作经历信息", notes = "查询员工工作经历信息")
    @RequestMapping(value = "/work/list", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<StaffWorkListDto> list(@RequestParam("staffNo") String staffNo);

    @ApiOperation(value = "删除工作经历信息", notes = "删除工作经历信息")
    @RequestMapping(value = "/work/deleteById", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<Integer> deleteById(@RequestParam("id") Integer id);

    @ApiOperation(value = "添加工作经历信息", notes = "添加工作经历信息")
    @RequestMapping(value = "/work/insert", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> insert(@RequestBody StaffWorkInsertListPo staffWorkList);

    @ApiOperation(value = "修改工作经历信息", notes = "修改工作经历信息")
    @RequestMapping(value = "/work/update", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> update (@RequestBody StaffWorkUpdatePo WorkPo);

    @ApiOperation(value = "批量修改工作经历信息", notes = "批量修改工作经历信息")
    @RequestMapping(value = "/work/updatelist", method = RequestMethod.GET,consumes = "application/json")
    ComResponse<Integer> updateList (@RequestBody StaffWorkUpdateListPo staffWorkUpdateListPo);

    @ApiOperation(value = "保存工作经历信息", notes = "保存工作经历信息")
    @RequestMapping(value = "/work/saveUpDate", method = RequestMethod.POST,consumes = "application/json")
    ComResponse<Integer> saveUpDate(@RequestBody StaffWorkItemPo staffWorkItemPo);

}
