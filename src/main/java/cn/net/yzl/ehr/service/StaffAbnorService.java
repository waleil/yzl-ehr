package cn.net.yzl.ehr.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainDto;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import cn.net.yzl.staff.pojo.AbnorRecordPo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StaffAbnorService {

    public ComResponse<Integer> updateStaffChangeStatus( StaffSwitchStatePo staffSwitchStatePo,String staffNo) ;


    public ComResponse<Integer> executeStaffChange(StaffAbnorRecordPo staffChangePo,String staffNo);


    public ComResponse<StaffAbnorRecordListDto> getStaffAbnorRecord(String staffNo) ;

    ComResponse<List<StaffTrainInfoDto>> find (String staffNo);

    ComResponse<List<StaffTrainInfoDto>> findPage (String staffNo, Integer pageNum, Integer pageSize);

    ComResponse<Page<StaffTrainInfoDto>> findRecordsByPageParam(@RequestBody @Validated AbnorRecordPo abnorRecordPo);
}
