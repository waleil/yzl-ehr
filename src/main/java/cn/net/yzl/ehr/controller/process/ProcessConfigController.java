package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.process.ProcessConfigService;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@RestController
@RequestMapping("/process")
@Api(value = "人事管理-审批流程配置",tags = {"审批流程配置"})
public class ProcessConfigController {

    @Autowired
    private ProcessConfigService processConfigService;

    @ApiOperation(value = "审批流程配置添加",notes = "审批流程配置添加",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/config/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessConfig (@RequestBody @Validated ProcessConfigVo processConfigVo, @CurrentStaffNo @ApiIgnore String staffNo){
        return processConfigService.insertProcessConfig(processConfigVo,staffNo);
    }

    @ApiOperation(value = "审批流程配置删除",notes = "审批流程配置删除",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/config/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessConfig (@RequestParam("id") Integer id,@CurrentStaffNo @ApiIgnore String staffNo){
        return processConfigService.deleteProcessConfig(id,staffNo);
    }

    @ApiOperation(value = "审批流程配置禁用",notes = "审批流程配置禁用",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/config/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessConfig (@RequestParam("id") Integer id,@CurrentStaffNo @ApiIgnore String staffNo){
        return processConfigService.disableProcessConfig(id,staffNo);
    }


    @ApiOperation(value = "审批流程配置分页查询",notes = "审批流程配置分页查询",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/config/pageSelect", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "processName", value = "审批流程名称", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "查询开始时间(yyyy-MM-dd HH:mm:ss)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "查询结束时间(yyyy-MM-dd HH:mm:ss)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "processType", value = "审批类型", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "分页参数:页码", required = false, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页参数:每页数量", required = false, dataType = "Integer", paramType = "query"),
    })
    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(@RequestParam("processName") String processName,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                                                          @RequestParam("processType") Integer processType,
                                                          @RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
                                                          @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        return processConfigService.pageSelectProcessConfig(processName,startTime,endTime,processType,pageNum,pageSize);
    }


    @ApiOperation(value = "审批流程配置详情",notes = "审批流程配置详情",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/config/detail", method = RequestMethod.GET)
    ComResponse<ProcessConfigDetailDto> processConfigDetail (@RequestParam("id") Integer id){
        return processConfigService.processConfigDetail(id);
    }
}
