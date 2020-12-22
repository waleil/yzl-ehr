package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;

import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/staff")
@Api(value = "员工服务", tags = {"员工服务"})
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;
    @Autowired
    private StaffService staffService;


    @ApiOperation(value = "根据id获取员工信息(通过fegin进行远程调用)", notes = "根据id获取员工信息(通过fegin进行远程调用)", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @SentinelResource(value = "getKey",
            blockHandler = "getKeyBlockHandler",
            fallback = "getKeyFallback")
    public ComResponse<String> getKey(int id) {
        return staffFeginService.getByPrimaryKey(id);
    }

    @ApiOperation(value = "查询当前用户详情", notes = "查询当前用户详情")
    @RequestMapping(value = "/getCurrentDetails", method = RequestMethod.GET)
    public ComResponse<StaffDetailsDto> getCurrentDetails(@ApiIgnore @CurrentStaffNo String staffNo) {
        return staffService.getDetailsByNo(staffNo);


    }
}