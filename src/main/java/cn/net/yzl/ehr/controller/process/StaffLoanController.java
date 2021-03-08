package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.StaffLoanFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.vo.process.StaffLoanVo;
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
 * @date 2021/2/26 22:25
 */
@RestController
@RequestMapping("staffLoan")
@Api(value = "财务审批-借款",tags = "财务审批-借款")
public class StaffLoanController {

    @Autowired
    private StaffLoanFeignService staffLoanFeignService;

    @ApiOperation(value = "保存借款流程数据",notes = "保存借款流程数据")
    @PostMapping("v1/insertStaffLoan")
    public ComResponse<Integer> insertStaffLoan(@RequestBody StaffLoanVo staffLoanVo){
        ComResponse<Integer> integerComResponse = staffLoanFeignService.insertStaffLoan(staffLoanVo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffLoanVo.getStaffNo(),
                        staffLoanVo.getProcessNodeDTOList().get(1).getStaffNo(),
                        staffLoanVo.getProcessNodeDTOList().get(1).getProcessName());
                MessageRemandAPI.processSendMessage(staffLoanVo.getProcessNodeDTOList().get(0).getProcessId(),
                        staffLoanVo.getProcessNodeDTOList().get(1).getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }
}
