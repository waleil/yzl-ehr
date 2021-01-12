package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffWorkListDto;
import cn.net.yzl.ehr.pojo.*;
import cn.net.yzl.ehr.service.StaffWorkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff/staffwork")
@Api(value = "员工工作经历", tags = {"员工档案"})
public class StaffWorkController {
    @Autowired
    private StaffWorkService staffWorkService;

    @ApiOperation(value = "员工档案-查询员工工作经历信息",notes = "查询员工工作经历信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ComResponse<StaffWorkListDto> list(String staffNo) {
        return staffWorkService.list(staffNo);
    }

    @ApiOperation(value = "员工档案-删除工作经历信息",notes = "删除工作经历信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(Integer id) {
        return staffWorkService .deleteById(id);
    }

    @ApiOperation(value = "员工档案-添加工作经历信息", notes = "添加工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody StaffWorkInsertListPo staffWorkList) {
        return staffWorkService.insert(staffWorkList);
    }
    @ApiOperation(value = "员工档案-修改工作经历信息", notes = "修改工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody StaffWorkUpdatePo WorkPo){
        return staffWorkService.update(WorkPo);
    }
    @ApiOperation(value = "员工档案-批量修改工作经历信息", notes = "批量修改工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/updatelist",method = RequestMethod.POST)
    ComResponse<Integer> updateList (@RequestBody StaffWorkUpdateListPo staffWorkUpdateListPo){
        return staffWorkService.updatelist(staffWorkUpdateListPo);
    }
    @ApiOperation(value = "员工档案-保存工作经历信息", notes = "保存工作经历信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(StaffWorkItemPo staffWorkItemPo){
        return staffWorkService.saveUpDate(staffWorkItemPo);
    }

}
