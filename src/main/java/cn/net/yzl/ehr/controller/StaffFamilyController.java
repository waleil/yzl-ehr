package cn.net.yzl.ehr.controller;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.authorization.annotation.CurrentStaffNo;
import cn.net.yzl.ehr.pojo.StaffFamilyInsertPo;
import cn.net.yzl.ehr.pojo.StaffFamilyItemPo;
import cn.net.yzl.ehr.pojo.StaffFamilyPo;
import cn.net.yzl.ehr.pojo.StaffFamilyUpdatePo;
import cn.net.yzl.ehr.service.StaffFamilyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/staffFamily")
@Api(value = "员工家庭信息", tags = {"员工家庭信息"})
@Valid
public class StaffFamilyController {
    @Autowired
    private StaffFamilyService staffFamilyService;

    @ApiOperation(value = "查询员工家庭信息",notes = "查询员工家庭信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "StaffNo", value = "员工工号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/findByStaffNo", method = RequestMethod.GET)
    ComResponse<List<StaffFamilyPo>> findByStaffNo(@ApiIgnore @CurrentStaffNo String staffNO) {
        return staffFamilyService.findByStaffNo(staffNO);
    }
/*
    @ApiOperation(value = "删除信息",notes = "删除信息",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工家庭成员编号", required = true, paramType = "query")
    )
    @RequestMapping(value = "/deleteById",method = RequestMethod.GET)
    ComResponse<Integer> deleteById(@Min(1) Integer id, @ApiIgnore @CurrentStaffNo String updator) {
        return staffFamilyService .deleteById(id,updator);
    }

    @ApiOperation(value = "修改信息", notes = "修改信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id", value = "员工家庭成员编号", required = true, paramType = "query")
    )
    ComResponse<Integer> insert(@RequestBody @Validated List<StaffFamilyInsertPo> staffFamilyInsertList) {
        return staffFamilyService.insert(staffFamilyInsertList);
    }
    @ApiOperation(value = "添加信息", notes = "添加信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value = "/upadte",method = RequestMethod.POST)
    ComResponse<Integer> update (@RequestBody @Validated StaffFamilyUpdatePo FamilyPo){
        return staffFamilyService.update(FamilyPo);
    }*/
    @ApiOperation(value = "保存信息", notes = "保存信息", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping(value ="/saveUpDate",method = RequestMethod.POST)
    ComResponse<Integer> saveUpDate(@RequestBody @Validated StaffFamilyItemPo staffFamilyPo){
        return staffFamilyService.saveUpDate(staffFamilyPo);
    }
}
