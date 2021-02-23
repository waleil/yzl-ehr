package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.StaffLevelDto;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigPageVo;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}")
@RefreshScope
public interface ProcessConfigFeignService {

    @RequestMapping(value = "/process/config/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessConfig (@RequestBody @Validated ProcessConfigVo processConfigVo);

    @RequestMapping(value = "/process/config/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessConfig (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/process/config/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessConfig (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/process/config/enable", method = RequestMethod.POST)
    ComResponse<Integer> enableProcessConfig (@RequestParam("id") Integer id,@RequestParam("processItemId") Integer processItemId,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/process/config/pageSelect", method = RequestMethod.POST)
    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(@RequestBody @Validated ProcessConfigPageVo processConfigPageVo) ;

    @RequestMapping(value = "/process/config/detail", method = RequestMethod.GET)
    ComResponse<ProcessConfigDetailDto> processConfigDetail (@RequestParam("id") Integer id);

    @RequestMapping(value = "/staff/getStaffLevelByStaffNo", method = RequestMethod.GET)
    ComResponse<List<StaffLevelDto>> getStaffLevelByStaffNo(@RequestParam("staffNo") String staffNo, @RequestParam("flag") Integer flag) ;
}
