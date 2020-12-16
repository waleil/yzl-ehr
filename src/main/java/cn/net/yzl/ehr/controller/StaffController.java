package cn.net.yzl.ehr.controller;


import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
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

@RestController
@RequestMapping("/staff")
@Api(value = "员工服务", tags = {"员工服务"})
public class StaffController {

    @Autowired
    private StaffFeginService staffFeginService;


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

    // 服务流量控制处理，参数最后多一个 BlockException，其余与原函数一致
    public ComResponse<String> getKeyBlockHandler(int id, BlockException ex) {

        return ComResponse.success("服务流量控制处理....");
    }

    // 服务熔断降级处理，函数签名与原函数一致或加一个 Throwable 类型的参数
    public ComResponse<String> getKeyFallback(int id, Throwable throwable) {

        return ComResponse.success("服务熔断降级处理....");
    }



}
