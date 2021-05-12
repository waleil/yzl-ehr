package cn.net.yzl.ehr.fegin.process;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.staff.dto.SysDictDataDto;
import cn.net.yzl.staff.dto.process.ProcessItemDto;
import cn.net.yzl.staff.dto.process.ProcessTypeDto;
import cn.net.yzl.staff.vo.process.ProcessItemVo;
import cn.net.yzl.staff.vo.process.ProcessTypeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@FeignClient(value = "ProcessItemFeign",url = "${fegin.db.url}/process")
//@RefreshScope
public interface ProcessItemFeignService {

    @RequestMapping(value = "/type/queryAll", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> queryProcessTypeAll();

    @RequestMapping(value = "/type/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessType (@RequestBody  ProcessTypeVo processTypeVo);

    @RequestMapping(value = "/type/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessType (@RequestParam("dictCode") @NotNull Integer dictCode);

    @RequestMapping(value = "/item/insert", method = RequestMethod.POST)
    ComResponse<Integer> insertProcessItem (@RequestBody @Validated ProcessItemVo processItemVo);

    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    ComResponse<Integer> updateProcessItem (@RequestBody @Validated ProcessItemVo processItemVo);

    @RequestMapping(value = "/item/delete", method = RequestMethod.POST)
    ComResponse<Integer> deleteProcessItem (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/disable", method = RequestMethod.POST)
    ComResponse<Integer> disableProcessItem (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/enable", method = RequestMethod.POST)
    ComResponse<Integer> enableProcessItem (@RequestParam("id") Integer id,@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/select", method = RequestMethod.GET)
    ComResponse<List<ProcessItemDto>> selectProcessItem (@RequestParam("id") Integer id);

    @RequestMapping(value = "/item/select/all", method = RequestMethod.GET)
    ComResponse<List<ProcessItemDto>> selectProcessItemAll ();

    @RequestMapping(value = "/item/detail", method = RequestMethod.GET)
    ComResponse<ProcessItemDto> selectProcessItemDetail (@RequestParam("id") Integer id);

    @RequestMapping(value = "/item/manager", method = RequestMethod.GET)
    ComResponse<List<ProcessTypeDto>> processItemDisplay (@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/item/show", method = RequestMethod.GET)
    ComResponse<List<ProcessTypeDto>> processItemDisplayByUser (@RequestParam("staffNo") String staffNo);

    @RequestMapping(value = "/config/item/info", method = RequestMethod.GET)
    ComResponse<ProcessItemDto> selectProcessByItemCode (@RequestParam("code") String code);

    @RequestMapping(value = "/config/item/enable", method = RequestMethod.GET)
    ComResponse<Object> selectProcessByItemIdAndUser (@RequestParam("processItemId") Integer processItemId,@RequestParam("staffNo") String staffNo);

}
