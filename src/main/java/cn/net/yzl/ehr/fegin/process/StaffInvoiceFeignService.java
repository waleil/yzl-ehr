package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffInvoiceVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}/staffInvoice")
public interface StaffInvoiceFeignService {


    @ApiOperation(value = "保存开票流程数据", notes = "保存开票流程数据")
    @PostMapping("v1/insertStaffInvoice")
    public ComResponse<ProcessApproveNode> insertStaffInvoice(@RequestBody StaffInvoiceVo staffInvoiceVo);


}