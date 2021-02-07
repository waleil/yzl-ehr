package cn.net.yzl.ehr.controller.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.service.resource.OfficeSuppliesInfoService;
import cn.net.yzl.ehr.service.resource.OfficeSuppliesRecordService;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.dto.office.OfficeTypeDto;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesTypePo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
    ComResponse<Integer> insert(@RequestBody OfficeSuppliesInfoInsertPo insertPo, @CurrentStaffNo @ApiIgnore String staffNo) {
        return officeSuppliesInfoService.insert(insertPo,staffNo);
    }

    @ApiOperation(value = "修改办公物品信息", notes = "修改办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody OfficeSuppliesInfoUpdatePo updatePo ,@CurrentStaffNo @ApiIgnore String staffNo) {
        return officeSuppliesInfoService.update(updatePo,staffNo);
    }

    @ApiOperation(value = "删除办公物品信息", notes = "删除办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    ComResponse<Integer> deleteById (@RequestParam("id")Integer id, @RequestParam("itemRemaining")Integer itemRemaining ,@ApiIgnore @CurrentStaffNo String updator) {
        return officeSuppliesInfoService.deleteById(id, itemRemaining, updator);
    }

    @ApiOperation(value ="办公物品领取记录分页" ,notes ="办公物品领取记录分页",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(@RequestBody OfficeSuppliesInfoScreenPo screenPo, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum,@RequestParam("itemName")String itemName){
        return officeSuppliesRecordService.queryPage(screenPo,pageNum,pageSize,itemName);
    }

    @ApiOperation(value = "新增/编辑办公用品类型", notes = "新增/编辑办公用品类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/saveUpDateOffice", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDateOffice(@RequestBody List<OfficeSuppliesTypePo> officeSuppliesTypePos,@ApiIgnore @CurrentStaffNo String staffNo) {
        return officeSuppliesInfoService.saveUpDateOffice(officeSuppliesTypePos,staffNo);
    }

    @ApiOperation(value = "查询办公物品类型信息", notes = "查询办公物品类型信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    ComResponse<List<OfficeTypeDto>> selectList() {
        return officeSuppliesInfoService.selectList();
    }

}
