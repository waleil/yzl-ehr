package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;

import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.staff.dto.StaffTrainDto;
import cn.net.yzl.staff.pojo.AbnorRecordPo;
import cn.net.yzl.staff.pojo.RunAbnorRecordPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Repository
//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "staffAbnor",url = "${fegin.db.url}")
public interface StaffAbnorFeginService {

    @RequestMapping(value = "/abnor/updateStaffChangeStatus", method = RequestMethod.POST)
    public ComResponse<Integer> updateStaffChangeStatus(@RequestBody StaffSwitchStatePo staffSwitchStatePo) ;

    @RequestMapping(value = "/abnor/executeStaffChange", method = RequestMethod.POST)
    public ComResponse<Integer> executeStaffChange(@RequestBody StaffAbnorRecordPo staffChangePo);

    @RequestMapping(value = "/abnor/getStaffAbnorRecord", method = RequestMethod.GET)
    public ComResponse<StaffAbnorRecordListDto> getStaffAbnorRecord(@RequestParam("staffNo")  String staffNo) ;

    @RequestMapping(value = "/abnor/getStaffTrain",method = RequestMethod.GET)
    public ComResponse<List<StaffTrainDto>> find(@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/abnor/getStaffTrainPage", method = RequestMethod.GET)
    public ComResponse<List<StaffTrainDto>> findPage(@RequestParam("staffNo") String staffNo, @RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize);

    @RequestMapping(value = "/abnor/findRecordsByPageParam", method = RequestMethod.POST)
    public ComResponse<Page<StaffTrainDto>> findRecordsByPageParam(@RequestBody AbnorRecordPo abnorRecordPo) ;

    @RequestMapping(value = "/abnor/runStaffChange", method = RequestMethod.POST, consumes = "application/json")
    public ComResponse<Integer> runStaffChange(@RequestBody RunAbnorRecordPo staffChangePo) throws ParseException;

    @RequestMapping(value = "/abnor/timerUpdateStafffAbnorRecord", method = RequestMethod.GET, consumes = "application/json")
    public ComResponse<List<MsgTemplateVo>> timerUpdateStafffAbnorRecord() throws ParseException ;

    @RequestMapping(value = "/abnor/staffBatchPostLevelTimedTask", method = RequestMethod.GET)
    public ComResponse<List<MsgTemplateVo>> staffBatchPostLevelTimedTask() throws ParseException ;

    @RequestMapping(value = "/abnor/staffBatchPostLevelTimedDayTask", method = RequestMethod.GET)
    public ComResponse<List<MsgTemplateVo>> staffBatchPostLevelTimedDayTask() throws ParseException;

}
