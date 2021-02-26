package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.vo.process.StaffInvoiceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value = "staffInvoice",url = "${fegin.db.url}/staffInvoice")
public interface StaffInvoiceFeignService {


    @ApiOperation(value = "保存开票流程数据",notes = "保存开票流程数据")
    @PostMapping("v1/insertStaffInvoice")
    public ComResponse<Integer> insertStaffInvoice(@RequestBody StaffInvoiceVo staffInvoiceVo);


}