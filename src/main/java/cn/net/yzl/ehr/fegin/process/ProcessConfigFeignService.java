package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.staff.dto.process.ProcessConfigDetailDto;
import cn.net.yzl.staff.dto.process.ProcessDto;
import cn.net.yzl.staff.vo.process.ProcessConfigPageVo;
import cn.net.yzl.staff.vo.process.ProcessConfigVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}/process")
@RefreshScope
public interface ProcessConfigFeignService {

    @RequestMapping(value = "/config/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessConfig (@RequestBody @Validated ProcessConfigVo processConfigVo, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/config/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessConfig (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/config/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessConfig (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/config/pageSelect", method = RequestMethod.POST)
    ComResponse<Page<ProcessDto>> pageSelectProcessConfig(@RequestBody @Validated ProcessConfigPageVo processConfigPageVo) ;

    @RequestMapping(value = "/config/detail", method = RequestMethod.GET)
    ComResponse<ProcessConfigDetailDto> processConfigDetail (@RequestParam("id") Integer id);
}
