package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.DepartDto;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigPageVo;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "yzl-staff-db", url = "${fegin.db.url}")
public interface ProcessConfigFeignService {

    @RequestMapping(value = "/process/config/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessConfig(@RequestBody @Validated ProcessConfigVo processConfigVo);

    @RequestMapping(value = "/process/config/update", method = RequestMethod.POST)
    ComResponse<Integer> updateProcessConfig(@RequestBody @Validated ProcessConfigVo processConfigVo);

    @RequestMapping(value = "/process/config/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessConfig(@RequestParam("id") Integer id, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/process/config/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessConfig(@RequestParam("id") Integer id, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/process/config/enable", method = RequestMethod.POST)
    ComResponse<Integer> enableProcessConfig(@RequestParam("id") Integer id, @RequestParam("processItemId") Integer processItemId, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/process/config/pageSelect", method = RequestMethod.POST)
    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(@RequestBody @Validated ProcessConfigPageVo processConfigPageVo);

    @RequestMapping(value = "/process/config/detail", method = RequestMethod.GET)
    ComResponse<ProcessConfigDetailDto> processConfigDetail(@RequestParam("id") Integer id);

    @RequestMapping(value = "/process/config/depart", method = RequestMethod.GET)
    ComResponse<DepartDto> processConfigDepartByProcessItemId(@RequestParam("processItemId") Integer processItemId, @RequestParam("processId") Integer processId);

    @RequestMapping(value = "/staff/getStaffLevelByStaffNo", method = RequestMethod.GET)
    ComResponse<List<StaffLevelDto>> getStaffLevelByStaffNo(@RequestParam("staffNo") String staffNo, @RequestParam("flag") Integer flag);

    /**
     * ???????????????
     *
     * @param processId
     * @return
     */
    @GetMapping("/processsInvite/v1/getPersonSend")
    ComResponse<List<StaffLevelDto>> getPersonSend(@RequestParam("processId") Integer processId);

    /**
     * ???????????????????????????????????????
     *
     * @param processAuditId
     * @return
     */
    @GetMapping("/processsInvite/v1/getStaffNodeByStaffNo")
    ComResponse<String> getStaffNodeByStaffNo(@RequestParam("processAuditId") String processAuditId,
                                              @RequestParam("stepNo") Integer stepNo);

    @RequestMapping(value = "/staff/getUpStaffLevelByStaffNo", method = RequestMethod.GET)
    ComResponse<StaffLevelDto> getUpStaffLevelByStaffNo(@RequestParam("staffNo") String staffNo, @RequestParam("currentDepartId") Integer currentDepartId);
}
