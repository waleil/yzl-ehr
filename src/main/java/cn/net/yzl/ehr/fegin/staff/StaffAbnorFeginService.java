package cn.net.yzl.ehr.fegin.staff;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.StaffAbnorRecordListDto;
import cn.net.yzl.ehr.dto.StaffTrainDto;
import cn.net.yzl.ehr.pojo.StaffAbnorRecordPo;
import cn.net.yzl.ehr.pojo.StaffSwitchStatePo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "staff",url = "${fegin.db.url}")
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
}
