package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffDetailsDto;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.service.StaffService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/staff")
@Api(value = "员工服务", tags = {"员工服务"})
@Validated
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;

    @Autowired
    private StaffService staffService;



    @ApiOperation(value = "查询用户详情(根据用户工号)", notes = "查询用户详情(根据用户工号)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo", value = "用户工号", required = true, dataType = "String",paramType="query")
    })
    @RequestMapping(value = "/getDetailsByNo", method = RequestMethod.GET)
    ComResponse<StaffDetailsDto> getDetailsByNo(@NotNull(message = "userNo不能为空") @RequestParam(value = "userNo",required = false) Integer userNo) {
        return staffService.getDetailsByNo(userNo);
    }





}
