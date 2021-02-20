package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.process.ProcessConfigService;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigPageVo;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


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
    @RequestMapping(value = "/config/pageSelect", method = RequestMethod.POST)
    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(@RequestBody @Validated ProcessConfigPageVo processConfigPageVo) {
        return processConfigService.pageSelectProcessConfig(processConfigPageVo);
    }


    @ApiOperation(value = "审批流程配置详情",notes = "审批流程配置详情",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/config/detail", method = RequestMethod.GET)
    ComResponse<ProcessConfigDetailDto> processConfigDetail (@RequestParam("id") Integer id){
        return processConfigService.processConfigDetail(id);
    }

    @ApiOperation(value = "根据员工获取上下级信息", notes = "根据员工获取上下级信息")
    @RequestMapping(value = "/getStaffLevelByStaffNo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffNo", value = "员工工号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "flag", value = "1:上级,2:下级", required = true, dataType = "Int", paramType = "query")
    })
    ComResponse<List<StaffLevelDto>> getStaffLevelByStaffNo(@RequestParam("staffNo") String staffNo, @RequestParam("flag") Integer flag) {
        return processConfigService.getStaffLevelByStaffNo(staffNo,flag);
    }
}
