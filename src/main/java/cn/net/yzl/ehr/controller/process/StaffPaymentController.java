package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.StaffPaymentFeignService;
import cn.net.yzl.staff.vo.process.StaffPaymentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/2/24 20:32
 */
@RestController
@Api(value = "财务审批-付款流程",tags = "财务审批-付款流程")
@RequestMapping("staffPayment")
public class StaffPaymentController {

    @Autowired
    private StaffPaymentFeignService staffPaymentFeignService;

    @ApiOperation(value = "保存付款流程数据",notes = "保存付款流程数据")
    @PostMapping("v1/insertStaffPayment")
    public ComResponse<Integer> insertStaffPayment(@RequestBody StaffPaymentVo staffPaymentVo){
        return staffPaymentFeignService.insertStaffPayment(staffPaymentVo);
    }


}