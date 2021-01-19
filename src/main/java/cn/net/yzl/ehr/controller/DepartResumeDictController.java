package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.DepartResumeDictDto;
import cn.net.yzl.ehr.pojo.DepartResumeDictListPo;
import cn.net.yzl.ehr.service.DepartResumeDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/resumeDict")
@Api(value = "字典配置-面试轮次", tags = {"字典配置"})
public class DepartResumeDictController {

    @Autowired
    private DepartResumeDictService dictService;

    @ApiOperation(value = "获取面试轮次名称列表", notes = "获取面试轮次名称列表", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/getDictList", method = RequestMethod.GET)
    public ComResponse<List<DepartResumeDictDto>> getDictList() {
        return dictService.getDictList();
    }

    @ApiOperation(value = "用id获取面试轮次名称", notes = "用id获取面试轮次名称", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "岗位id", required = true,  paramType = "query")
    })
    @RequestMapping(value = "/getDictById", method = RequestMethod.GET)
    public ComResponse<DepartResumeDictDto> getDictById(@NotNull @Min(0) Integer id) {
        return dictService.getDictById(id);
    }


    @ApiOperation(value = "根据名称查询轮次名称字典", notes = "根据名称查询轮次名称字典", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/selectListByName", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "轮次名称", required = true,  paramType = "query")
    })
    ComResponse<List<DepartResumeDictDto>> selectListByName(@NotBlank String name) {
        return dictService.selectListByName(name);
    }

    @ApiOperation(value = "保存轮次名称字典", notes = "保存轮次名称字典", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
    ComResponse<Integer> saveUpdate(@RequestBody  DepartResumeDictListPo listPo,@CurrentStaffNo @ApiIgnore String staffNo){
        return dictService.saveUpdate(listPo,staffNo);
    }

}
