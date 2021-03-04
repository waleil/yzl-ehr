package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.process.StaffSponsorIntrRoyaFeignService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.vo.process.StaffSponsorIntrRoyaVo;
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
 * @date 2021/2/25 20:47
 */
@RestController
@RequestMapping("staffSponsorIntrRoya")
@Api(value = "财务审批-转介绍提成流程",tags = "财务审批-转介绍提成流程")
public class StaffSponsorIntrRoyaController {


    @Autowired
    private StaffSponsorIntrRoyaFeignService staffSponsorIntrRoyaFeignService;

    @ApiOperation(value = "保存转介绍提成流程数据",notes = "保存转介绍提成流程数据")
    @PostMapping("v1/insertStaffSponsorIntrRoya")
    public ComResponse<Integer> insertStaffSponsorIntrRoya(@RequestBody StaffSponsorIntrRoyaVo staffSponsorIntrRoyaVo){

        ComResponse<Integer> integerComResponse = staffSponsorIntrRoyaFeignService.insertStaffSponsorIntrRoya(staffSponsorIntrRoyaVo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffSponsorIntrRoyaVo.getStaffNo(),
                        staffSponsorIntrRoyaVo.getProcessNodeDTOList().get(1).getStaffNo());
                MessageRemandAPI.processSendMessage(staffSponsorIntrRoyaVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return integerComResponse;
    }



}
