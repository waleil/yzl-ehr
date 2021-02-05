package cn.net.yzl.ehr.fegin.resource;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.entity.Page;
import cn.net.yzl.ehr.dto.CourseWareCategoryDto;
import cn.net.yzl.staff.dto.office.OfficeSuppliesInfoDto;
import cn.net.yzl.staff.dto.office.OfficeSuppliesRecordDto;
import cn.net.yzl.staff.dto.office.OfficeTypeDto;
import cn.net.yzl.staff.pojo.CourseWareCategoryPo;
import cn.net.yzl.staff.pojo.CourseWarePo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoInsertPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoScreenPo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesInfoUpdatePo;
import cn.net.yzl.staff.pojo.office.OfficeSuppliesTypePo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
//@FeignClient(name = "yzl-staff-db")
@FeignClient(value = "staff",url = "${fegin.db.url}")
public interface OfficeSuppliesInfoFeginService {


    @ApiOperation(value = "查询办公物品信息", notes = "查询办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/queryAll", method = RequestMethod.GET)
    ComResponse<List<OfficeSuppliesInfoDto>> queryAll();


    @ApiOperation(value = "添加办公物品信息", notes = "添加办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/insert", method = RequestMethod.POST)
    ComResponse<Integer> insert(@RequestBody OfficeSuppliesInfoInsertPo insertPo);

    @ApiOperation(value = "编辑办公物品信息", notes = "编辑办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/update", method = RequestMethod.POST)
    ComResponse<Integer> update(@RequestBody OfficeSuppliesInfoUpdatePo updatePo);

    @ApiOperation(value = "删除办公物品信息", notes = "删除办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/deleteById", method = RequestMethod.POST)
    ComResponse<Integer> deleteById (@RequestParam("id")Integer id, @RequestParam("itemRemaining")Integer itemRemaining ,@RequestParam("updator") String updator);


    @ApiOperation(value ="办公物品领取记录分页" ,notes ="办公物品领取记录分页",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/queryPage",method = RequestMethod.POST)
    ComResponse<Page<OfficeSuppliesRecordDto>> queryPage(@RequestBody OfficeSuppliesInfoScreenPo screenPo, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum);

    @ApiOperation(value = "办公物品类型管理-新增/编辑办公用品类型", notes = "办公物品类型管理-新增/编辑办公用品类型", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/insert", method = RequestMethod.POST)
    ComResponse<Integer> saveUpDateOffice(@RequestBody @Validated List<OfficeSuppliesTypePo> officeSuppliesTypePos);

    @ApiOperation(value = "查询办公物品信息", notes = "查询办公物品信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/office/selectList", method = RequestMethod.GET)
    ComResponse<List<OfficeTypeDto>> selectList();
}
