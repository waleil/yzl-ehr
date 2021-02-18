package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@FeignClient(value = "staff",url = "${fegin.db.url}/process")
@RefreshScope
public interface ProcessItemFeignService {

    @RequestMapping(value = "/type/queryAll", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> queryProcessTypeAll();

    @RequestMapping(value = "/type/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessType (@RequestParam("name") @NotBlank String name, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/type/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessType (@RequestParam("dictCode") @NotNull Integer dictCode);

    @RequestMapping(value = "/item/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessItem (@RequestBody @Validated ProcessItemVo processItemVo, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    ComResponse<Integer> updateProcessItem (@RequestBody @Validated ProcessItemVo processItemVo, @RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessItem (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessItem (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/select", method = RequestMethod.GET)
    ComResponse<List<ProcessItemDto>> selectProcessItem (@RequestParam("id") Integer id);

    @RequestMapping(value = "/item/display", method = RequestMethod.GET)
    ComResponse<List<ProcessTypeDto>> processItemDisplay (@RequestParam("staffNo") String staffNo);

}
