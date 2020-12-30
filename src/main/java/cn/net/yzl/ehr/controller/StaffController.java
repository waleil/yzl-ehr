package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;

import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.dto.StaffListDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.service.StaffService;
import cn.net.yzl.ehr.vo.StaffParamsVO;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/staff")
@Api(value = "员工服务", tags = {"员工服务"})
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;
    @Autowired
    private StaffService staffService;



    @ApiOperation(value = "查询当前用户详情", notes = "查询当前用户详情")
    @RequestMapping(value = "/getCurrentDetails", method = RequestMethod.GET)
    public ComResponse<StaffDetailsDto> getCurrentDetails(@ApiIgnore @CurrentStaffNo String staffNo) {
        return staffService.getDetailsByNo(staffNo);
    }
    @ApiOperation(value = "模糊查询用户信息", notes = "模糊查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "参数", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getByParams", method = RequestMethod.GET)
    public ComResponse<List<StaffDetailsDto>> getByParams(@NotBlank String params) {
        return staffService.getByParams(params);

    }

    @ApiOperation(value = "模糊查询员工列表", notes = "模糊查询员工列表")
    @RequestMapping(value = "/getListByParams", method = RequestMethod.POST)

    ComResponse<Page<StaffListDto>> getListByParams(@RequestBody @Validated StaffParamsVO staffParamsVO) {
        return staffService.getListByParams(staffParamsVO);
    }
}