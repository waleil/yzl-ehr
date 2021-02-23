package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.process.ProcessItemService;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import cn.net.yzl.staff.vo.process.ProcessTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/process")
@Api(value = "系统管理-流程管理",tags = {"系统管理-流程管理"})
public class ProcessItemController {

    @Autowired
    private ProcessItemService processItemService;

    @ApiOperation(value = "审批类型查询",notes = "审批类型查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/type/queryAll", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> queryProcessTypeAll(){
        return processItemService.queryProcessTypeAll();
    }

    @ApiOperation(value = "审批类型添加",notes = "审批类型添加",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/type/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessType (@RequestBody @Validated ProcessTypeVo processTypeVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.insertProcessType(processTypeVo,staffNo);
    }

    @ApiOperation(value = "审批类型删除",notes = "审批类型删除",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/type/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessType (@RequestParam("dictCode") @NotNull Integer dictCode){
        return processItemService.deleteProcessType(dictCode);
    }

    @ApiOperation(value = "审批项目添加",notes = "审批项目添加")
    @RequestMapping(value = "/item/insert", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    ComResponse<Integer> insertProcessItem (@RequestBody @Validated ProcessItemVo processItemVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.insertProcessItem(processItemVo,staffNo);
    }

    @ApiOperation(value = "审批项目修改",notes = "审批项目修改",consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    ComResponse<Integer> updateProcessItem (@RequestBody @Validated ProcessItemVo processItemVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.updateProcessItem(processItemVo,staffNo);
    }

    @ApiOperation(value = "审批项目删除",notes = "审批项目删除",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessItem (@RequestParam("id") Integer id,@CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.deleteProcessItem(id,staffNo);
    }

    @ApiOperation(value = "审批项目禁用",notes = "审批项目禁用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessItem (@RequestParam("id") Integer id,@CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.disableProcessItem(id,staffNo);
    }

    @ApiOperation(value = "审批项目启用",notes = "审批项目启用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/enable", method = RequestMethod.POST)
    ComResponse<Integer> enableProcessItem (@RequestParam("id") Integer id,@CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.enableProcessItem(id,staffNo);
    }

    @ApiOperation(value = "审批项目查询（根据审批类型id）",notes = "审批项目查询（根据审批类型id）",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/select", method = RequestMethod.GET)
    ComResponse<List<ProcessItemDto>> selectProcessItem (@RequestParam("id") Integer id){
        return processItemService.selectProcessItem(id);
    }

    @ApiOperation(value = "审批项目详情查询（根据审批项目id）",notes = "审批项目详情查询（根据审批项目id）",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/detail", method = RequestMethod.GET)
    ComResponse<ProcessItemDto> selectProcessItemDetail (@RequestParam("id") Integer id){
        return processItemService.selectProcessItemDetail(id);
    }

    @ApiOperation(value = "流程类型及项目展示(流程管理页面接口)",notes = "流程类型及项目展示(流程管理页面接口)",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/manager", method = RequestMethod.GET)
    ComResponse<List<ProcessTypeDto>> processItemDisplay (@CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.processItemDisplay(staffNo);
    }

    @ApiOperation(value = "流程类型及项目展示(发起流程页面接口)",notes = "流程类型及项目展示(发起流程页面接口)",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/item/show", method = RequestMethod.GET)
    ComResponse<List<ProcessTypeDto>> processItemDisplayByUser (@CurrentStaffNo @ApiIgnore String staffNo){
        return processItemService.processItemDisplayByUser(staffNo);
    }

}
