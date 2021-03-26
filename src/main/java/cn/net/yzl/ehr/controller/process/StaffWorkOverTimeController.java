package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.fegin.process.StaffWorkOverTimeFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.dto.process.StaffWorkOvertimeDto;
import cn.net.yzl.staff.dto.processNode.ProcessApproveNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangxiao
 * @version 1.0
 * @date 2021/3/25 10:53
 */
@RestController
@RequestMapping("workOverTime")
@Api(value = "出勤休假-加班申请",tags = "出勤休假-加班申请")
public class StaffWorkOverTimeController {

    @Autowired
    private StaffWorkOverTimeFeignService staffWorkOverTimeFeignService;

    @ApiOperation(value = "加班流程",notes = "加班流程")
    @PostMapping("v1/insertStaffWorkOverTime")
    public ComResponse<Integer> insertStaffWorkOverTime(@RequestBody StaffWorkOvertimeDto staffWorkOvertimeDto, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<ProcessApproveNode> flag = staffWorkOverTimeFeignService.insertStaffWorkOverTime(staffWorkOvertimeDto);

        if (flag.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo,
                        flag.getData().getStaffNo(),
                        flag.getData().getProcessName());
                MessageRemandAPI.processSendMessage(flag.getData().getProcessId(),
                        staffNo,
                        flag.getData().getProcessName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ComResponse.success();
    }

}
