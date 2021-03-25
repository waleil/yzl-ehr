package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import cn.net.yzl.staff.vo.process.StaffPaymentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/24 20:32
 */
@FeignClient(value = "staffPayment",url = "${fegin.db.url}/staffPayment")
public interface StaffPaymentFeignService {


    @ApiOperation(value = "保存付款流程数据",notes = "保存付款流程数据")
    @PostMapping("v1/insertStaffPayment")
    public ComResponse<ProcessApproveNode> insertStaffPayment(@RequestBody StaffPaymentVo staffPaymentVo);


}
