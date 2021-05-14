package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainInfoDto;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.msg.model.vo.MsgTemplateVo;
import cn.net.yzl.staff.dto.StaffTrainDto;
import cn.net.yzl.staff.pojo.AbnorRecordPo;
import cn.net.yzl.staff.pojo.RunAbnorRecordPo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface StaffAbnorService {

    public ComResponse<Integer> updateStaffChangeStatus( StaffSwitchStatePo staffSwitchStatePo,String staffNo) ;

    public ComResponse<Integer> executeStaffChange(StaffAbnorRecordPo staffChangePo,String staffNo) throws ParseException;

    public ComResponse<StaffAbnorRecordListDto> getStaffAbnorRecord(String staffNo) ;

    ComResponse<List<StaffTrainInfoDto>> find (String staffNo);

    ComResponse<List<StaffTrainInfoDto>> findPage (String staffNo, Integer pageNum, Integer pageSize);

    ComResponse<Page<StaffTrainDto>> findRecordsByPageParam(AbnorRecordPo abnorRecordPo,HttpServletRequest request);

    ComResponse<Integer> runStaffChange(RunAbnorRecordPo staffChangePo,String staffNo) throws ParseException;

    ComResponse<List<MsgTemplateVo>> timerUpdateStafffAbnorRecord() throws ParseException ;

    ComResponse<List<MsgTemplateVo>> staffBatchPostLevelTimedTask() throws ParseException ;

    public ComResponse<List<MsgTemplateVo>> staffBatchPostLevelTimedDayTask() throws ParseException;

}
