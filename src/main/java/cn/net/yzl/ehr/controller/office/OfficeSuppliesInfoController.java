package cn.net.yzl.ehr.controller.office;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.service.office.OfficeSuppliesInfoService;
import cn.net.yzl.ehr.service.office.OfficeSuppliesRecordService;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
@Api(value="办公物品管理",tags = {"公共资源管理"})
public class OfficeSuppliesInfoController {
    @Autowired
    private OfficeSuppliesInfoService officeSuppliesInfoService;

    @Autowired
    private OfficeSuppliesRecordService officeSuppliesRecordService;

    @ApiOperation(value = "查询办公物品信息", notes = "查询办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    ComResponse<List<OfficeSuppliesInfoDto>> queryAll() {
        return officeSuppliesInfoService.queryAll();
    }


    @ApiOperation(value = "添加办公物品信息", notes = "添加办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody OfficeSuppliesInfoInsertPo insertPo) {
        return officeSuppliesInfoService.insert(insertPo);
    }

    @ApiOperation(value = "修改办公物品信息", notes = "修改办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody OfficeSuppliesInfoUpdatePo updatePo) {
        return officeSuppliesInfoService.update(updatePo);
    }

    @ApiOperation(value = "删除办公物品信息", notes = "删除办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    ComResponse<Integer> deleteById (@RequestParam("id")Integer id, @RequestParam("itemRemaining")Integer itemRemaining , @RequestParam("updator") String updator) {
        return officeSuppliesInfoService.deleteById(id, itemRemaining, updator);
    }

    @ApiOperation(value ="办公物品领取记录分页" ,notes ="办公物品领取记录分页",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(@RequestBody OfficeSuppliesInfoScreenPo screenPo, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum){
        return officeSuppliesRecordService.queryPage(screenPo,pageNum,pageSize);
    }
}
