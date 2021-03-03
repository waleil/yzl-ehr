package cn.net.yzl.ehr.controller.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.process.ProcessInitiateService;
import cn.net.yzl.ehr.util.MessageRemandAPI;
import cn.net.yzl.staff.vo.process.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 流程发起
 *
 */

@RestController
@RequestMapping("/process")
@Api(value = "流程发起-(外出,出差,补卡,车位,物品领用,加班兑换)",tags = "流程发起-(外出,出差,补卡,车位,物品领用,加班兑换)")
public class ProcessInitiateController {

    @Autowired
    private ProcessInitiateService processInitiateService;

    @ApiOperation(value = "添加外出申请",notes = "添加外出申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/out/insert")
    public ComResponse<Integer> insertProcessStaffOut(@RequestBody @Validated StaffOutVo staffOutVo, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> integerComResponse = processInitiateService.insertProcessStaffOut(staffOutVo,staffNo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo);
                MessageRemandAPI.processSendMessage(staffOutVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return processInitiateService.insertProcessStaffOut(staffOutVo,staffNo);
    }

    @ApiOperation(value = "添加出差申请",notes = "添加出差申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/travel/insert")
    public ComResponse<Integer> insertProcessStaffTravel(@RequestBody @Validated StaffTravelVo staffTravelVo, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> integerComResponse = processInitiateService.insertProcessStaffTravel(staffTravelVo,staffNo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo);
                MessageRemandAPI.processSendMessage(staffTravelVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }

    @ApiOperation(value = "添加考勤补卡申请",notes = "添加考勤补卡申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/attend/approval/insert")
    public ComResponse<Integer> insertProcessStaffAttendApproval(@RequestBody @Validated StaffAttendApprovalVo staffAttendApprovalVo, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> integerComResponse = processInitiateService.insertProcessStaffAttendApproval(staffAttendApprovalVo,staffNo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo);
                MessageRemandAPI.processSendMessage(staffAttendApprovalVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }

    @ApiOperation(value = "添加车位申请",notes = "添加车位申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/parking/space/insert")
    public ComResponse<Integer> insertProcessStaffParkingSpace(@RequestBody @Validated StaffParkingSpaceVo staffParkingSpaceVo, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> integerComResponse = processInitiateService.insertProcessStaffParkingSpace(staffParkingSpaceVo,staffNo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo);
                MessageRemandAPI.processSendMessage(staffParkingSpaceVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }

    @ApiOperation(value = "添加物品领用申请",notes = "添加物品领用申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/item/requisition/insert")
    public ComResponse<Integer> insertProcessStaffItemRequisition(@RequestBody @Validated StaffItemRequisitionVo staffItemRequisitionVo, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> integerComResponse = processInitiateService.insertProcessStaffItemRequisition(staffItemRequisitionVo,staffNo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo);
                MessageRemandAPI.processSendMessage(staffItemRequisitionVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }

    @ApiOperation(value = "添加加班兑换申请",notes = "添加加班兑换申请",consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/attend/exchange/insert")
    public ComResponse<Integer> insertProcessAttendExchange(@RequestBody @Validated StaffAttendExchangeVo staffAttendExchangeVo, @CurrentStaffNo @ApiIgnore String staffNo){
        ComResponse<Integer> integerComResponse = processInitiateService.insertProcessAttendExchange(staffAttendExchangeVo,staffNo);
        if (integerComResponse.getCode().equals(200)){
            try {
                MessageRemandAPI.examine(staffNo);
                MessageRemandAPI.processSendMessage(staffAttendExchangeVo.getProcessNodeDTOList().get(0).getProcessId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return integerComResponse;
    }
}
